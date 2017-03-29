/**
 * @Title: WareServiceImpl
 * @Package cn.tc.ulife.platform.server.ware.service.impl
 * @Description: 商品service实现层
 * @author cxs
 * @date 2017/2/20 14:36
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service.impl;

import cn.tc.ulife.platform.server.shop.dao.IntegralWareSortDao;
import cn.tc.ulife.platform.server.shop.dao.WareDao;
import cn.tc.ulife.platform.server.shop.dao.WareSpecDao;
import cn.tc.ulife.platform.server.shop.entity.*;
import cn.tc.ulife.platform.server.shop.model.*;
import cn.tc.ulife.platform.server.shop.page.*;
import cn.tc.ulife.platform.server.shop.service.WareService;
import cn.tc.ulife.platform.server.sys.dao.PictureDao;
import cn.tc.ulife.platform.server.sys.model.PictureEntity;
import cn.tc.ulife.platform.server.sys.model.SysAllCodeEntity;
import cn.tc.ulife.platform.server.user.model.StoreEntity;
import cn.tc.ulife.platform.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author cxs
 * @ClassName: WareServiceImpl
 * @Description: 商品service实现层
 * @date 2017/2/20 14:36
 */
@Service("WareService")
public class WareServiceImpl implements WareService {

    @Autowired
    private WareDao wareDao;

    @Autowired
    private WareSpecDao wareSpecDao;

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private IntegralWareSortDao integralWareSortDao;

    @Override
    public boolean addWareInfo(String account, String app, WarePage page) {
        List<WareSpecEntity> wareSpecEntityList = null;
        List<PictureEntity> warePicturePageList = null;
        WareEntity entity = new WareEntity();
        int lineNum = 0;
        if (page != null) {
            // 入库前组织实体对象
            BeanUtils.copyProperties(page, entity);
            // 保存商品信息
            lineNum = wareDao.addWare(entity);

            wareSpecEntityList = page.getWareSpecList();
            warePicturePageList = page.getWarePictureList();
            if (lineNum > 0 && wareSpecEntityList != null && wareSpecEntityList.size() > 0) {
                for (int i = 0; i < wareSpecEntityList.size(); i++) {
                    WareSpecEntity wareSpecTmp = wareSpecEntityList.get(i);
                    wareSpecTmp.setSpid(entity.getId());
                    // 规格默认上架
                    wareSpecTmp.setIssj("1");
                    if (StringUtils.isNotEmpty(wareSpecTmp.getGgbz())) {
                        wareSpecTmp.setGgbz(wareSpecTmp.getGgbz());
                    } else {
                        wareSpecTmp.setGgbz(wareSpecTmp.getGgsz() + wareSpecTmp.getGgdw());
                    }
                    wareSpecDao.addSpecificationPage(wareSpecTmp);
                }
                // 保存商品规格信息
//                wareSpecDao.addSpecification(wareSpecEntityList);
            }
            if (lineNum > 0 && warePicturePageList != null && warePicturePageList.size() > 0) {
                for (int i = 0; i < warePicturePageList.size(); i++) {
                    warePicturePageList.get(i).setTid(entity.getId());
                }
                // 保存商品详情图片
                pictureDao.addPictureList(warePicturePageList);
            }
        }
        return true;
    }

    @Override
    public boolean delWareInfo(String account, String app, String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("issj", "2");
        // 删除商品信息
        int lineNum = wareDao.delWare(map);
        if (lineNum > 0) {
            // 删除商品规格信息
            wareSpecDao.delSpecification(map);
            // 删除商品详情图片
            pictureDao.delPicture(map);
        }
        return true;
    }

    @Override
    public boolean updWareInfo(String account, String app, WarePage page) {
        List<WareSpecEntity> wareSpecEntityList = null;
        List<PictureEntity> warePicturePageList = null;
        WareEntity entity = new WareEntity();
        int lineNum = 0;
        if (page != null) {
            BeanUtils.copyProperties(page, entity);
            // 修改商品信息
            lineNum = wareDao.updWare(entity);
            wareSpecEntityList = page.getWareSpecList();
            warePicturePageList = page.getWarePictureList();
            if (lineNum > 0 && wareSpecEntityList != null && wareSpecEntityList.size() > 0) {
                // 保存商品规格信息
                for (WareSpecEntity specEntity : wareSpecEntityList) {
                    if (StringUtils.isNotEmpty(specEntity.getGgbz())) {
                        specEntity.setGgbz(specEntity.getGgbz());
                    } else {
                        specEntity.setGgbz(specEntity.getGgsz() + specEntity.getGgdw());
                    }
                    if (StringUtils.isNotEmpty(specEntity.getId())) {
                        wareSpecDao.updSpecificationPage(specEntity);
                    } else {
                        specEntity.setSpid(entity.getId());
                        specEntity.setIssj("1");
                        wareSpecDao.addSpecificationPage(specEntity);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public WarePage queryWareInfo(String account, String app, String id, String type) {
        WarePage page = null;
        if ("0".equals(type)) {
            page = new WarePage();
        }else if ("2".equals(type)) {
            page = new FwWarePage();
        } else if ("4".equals(type)) {
            page = new DeliveryWarePage();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        WareEntity entity = wareDao.queryWareEntity(map);
        BeanUtils.copyProperties(entity, page);


        List<WareSpecEntity> specList = wareSpecDao.listWareSpecification(map);
        page.setWareSpecList(specList);
        List<PictureEntity> picList = pictureDao.listPicture(map);
        page.setWarePictureList(picList);
        return page;
    }

    @Override
    public List<WarePage> queryAll(String account, String app, String type, String spxz, WarePage page, Integer ofset, Integer psize) {

        List pageList = new ArrayList<WarePage>();;
        List<WareEntity> entityList = new ArrayList<WareEntity>();

        Map<String, Object> map = new HashMap<>();
        String storeId = null;
        if ("0".equals(type)) {
            storeId = wareDao.listStoreId(map);
        } else if ("1".equals(type)) {
            map.put("uid", account);
            storeId = wareDao.listStoreId(map);
        } else {
            storeId = account;
        }

        map.put("storeid", storeId);
        map.put("spxz", spxz);
        map.put("spname", page.getName());
        map.put("sptype", page.getType());
        map.put("issj", page.getIssj());
        map.put("zffs", page.getZffs());
        map.put("ofset", ofset);
        map.put("psize", psize);

        entityList = wareDao.queryAll(map);
        for (WareEntity entity : entityList) {
            WarePage pageTmp = null;
            if ("0".equals(spxz)) {
                pageTmp = new WarePage();
            } else if ("2".equals(spxz)) {
                pageTmp = new FwWarePage();
            }else if ("4".equals(spxz)) {
                pageTmp = new DeliveryWarePage();
            } else if ("5".equals(spxz)) {
                pageTmp = new IntegralWarePage();
            } else {
                pageTmp = new WarePage();
            }
            BeanUtils.copyProperties(entity, pageTmp);
            map.put("id", pageTmp.getId());
            List<WareSpecEntity> specList = wareSpecDao.listWareSpecification(map);
            pageTmp.setWareSpecList(specList);
//            List<WarePicturePage> picList = wareDao.queryWarePicture(map);
//            pageTmp.setWarePictureList(picList);
            if (!"5".equals(spxz)) {
                pageTmp.setStoreName(wareDao.getWareStore(entity.getStoreid()));
                pageTmp.setTypeName(wareDao.getWareType(entity.getType()));
            } else {
                pageTmp.setStoreName(integralWareSortDao.getWareStore(entity.getStoreid()));
                pageTmp.setTypeName(integralWareSortDao.getWareType(entity.getType()));
            }
            pageList.add(pageTmp);
        }
        return pageList;
    }


    @Override
    public String countWare(String uid, String roleType, String spxz, WarePage page) {
        Map<String, Object> map = new HashMap<>();
        String storeId = null;
        if ("0".equals(roleType)) {
            storeId = wareDao.listStoreId(map);
        } else if ("1".equals(roleType)) {
            map.put("uid", uid);
            storeId = wareDao.listStoreId(map);
        } else {
            storeId = uid;
        }
        map.put("storeId", storeId);
        map.put("spxz", spxz);
        map.put("spname", page.getName());
        map.put("sptype", page.getType());
        map.put("issj", page.getIssj());
        map.put("zffs", page.getZffs());
        return wareDao.countWare(map);
    }

    @Override
    public List<StoreEntity> listStore(String uid, String app, String roleType, String sjxz, Integer ofset, Integer psize) {
        Map<String, Object> map = new HashMap<>();
        map.put("sjxz", sjxz);
        if ("0".equals(roleType)) {
            return wareDao.listStore(map);
        } else if ("1".equals(roleType)) {
            map.put("uid", uid);
            return wareDao.listStore(map);
        } else {
            return null;
        }
    }

    @Override
    public String countStore(String uid, String roleType, String sjxz) {
        Map<String, Object> map = new HashMap<>();
        String storeId = null;
        if ("0".equals(roleType)) {
            return wareDao.countStore(null, sjxz);
        } else if ("1".equals(roleType)) {
            return wareDao.countStore(uid, sjxz);
        } else {
            return null;
        }

    }

    @Override
    public List listPLine(String account, String xqid, Integer ofset, Integer psize) {
        return wareDao.listPLine(account, xqid, ofset, psize);
    }

    @Override
    public ScStoreEntity getStoreIdByUid(String account) {
        return wareDao.getStoreIdByUid(account);
    }

    @Override
    public List<?> listAgentCom(String account) {
        return wareDao.listAgentCom(account, "DLS");
    }

    @Override
    public ScAgentEntity getAgentIdByUid(String account) {
        return wareDao.getAgentIdByUid(account);
    }

    @Override
    public boolean shelveWare(String account, String app, String spid, String issj, String spxz) {
//        String[] spids = spid.split(",");
//        if (spids.length > 0) {
//        // 上架批量商品
//            List<WareEntity> entityList = new ArrayList<WareEntity>();
//            Map<String, Object> map = new HashMap<>();
//            map.put("id", spid);
//            List<WareEntity> wareEntityList = wareDao.queryAll(map);
//            for (WareEntity entity : wareEntityList) {
//                entity.setIssj(issj);
//                entityList.add(entity);
//            }
//            if (entityList != null && entityList.size() > 0) {
//                wareDao.updWareList(entityList);
//                return true;
//            }
//        } else {
        // 上架单个商品
        Map<String, Object> map = new HashMap<>();
        map.put("id", spid);
        // 生鲜、拼团、服务、宅配商品
        if ("0".equals(spxz) || "1".equals(spxz) || "2".equals(spxz) || "4".equals(spxz)) {
            WareEntity entity = new WareEntity();
            entity = wareDao.queryWareEntity(map);
            if (entity != null) {
                // 1：上架，0：下架
                entity.setIssj(issj);
                wareDao.updWare(entity);
                return true;
            }
        }
        // 充值商品
        if ("3".equals(spxz)) {
            RechargeEntity entity = new RechargeEntity();
            entity = wareDao.getRechargeByKey(map);
            if (entity != null) {
                entity.setZt(issj);
                wareDao.updRecharge(entity);
                return true;
            }
        }
//        }
    return false;
}

    @Override
    public boolean delPicture(String account, String app, String id) {
        int lineNum = pictureDao.delPictureByKey(id);
        if (lineNum > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean shelveSpecification(String account, String app, String ggid, String issj, String spxz) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", ggid);
        // 生鲜、拼团、服务、宅配商品
        if ("0".equals(spxz) || "1".equals(spxz) || "2".equals(spxz) || "4".equals(spxz)) {
            WareSpecEntity entity = new WareSpecEntity();
            entity = wareSpecDao.getWareSpecification(map);
            if (entity != null) {
                // 1：上架，0：下架
                entity.setIssj(issj);
                wareSpecDao.updSpecificationPage(entity);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean auditWare(String account, String app, String spid) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", spid);
        WareEntity entity = new WareEntity();
        entity = wareDao.queryWareEntity(map);
        if (entity != null) {
            // 1：审核通过，0：审核不通过
            entity.setIssh("1");
            wareDao.updWare(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean syncRecharge(String uid) {
        String url = ConfigUtil.getProperties("RECHARGE_PRODQUERY");//地址
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("agentid", ConfigUtil.getProperties("AGENTID"));
        paraMap.put("source", ConfigUtil.getProperties("SOURCE"));
        paraMap.put("merchantKey", ConfigUtil.getProperties("MERCHANTKEY"));
        KeyedDigestMD5.getVerifyParams(paraMap, 2);
        String result = null;
        try {
            result = HttpUtil.sendHttpPost(url, paraMap);
            List<RechareDTO> list = (List<RechareDTO>) XmlUtil.parseXml(result, RechareDTO.class, "UTF8");
            if (list != null) {
                this.saveRecharge(list, uid);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<RechargePage> listRecharge(String uid, String recsprice, Integer ofset, Integer psize) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("recsprice", recsprice);
        map.put("ofset", ofset);
        map.put("psize", psize);
        return wareDao.listRecharge(map);
    }

    @Transactional
    @Override
    public boolean saveRecharge(List<RechareDTO> rechareList, String uid) {

        List<RechargeEntity> list = new ArrayList<RechargeEntity>(10000000);
        BigDecimal sprice = new BigDecimal(0);
        SysAllCodeEntity entity = wareDao.getRechargeFloat();
        String rechargeFloat = entity.getCodeValue();
        for (RechareDTO p : rechareList) {
            if (Integer.parseInt(p.getProdContent()) >= 10 && "移动电话".equals(p.getProdType())) {
                RechargeEntity recharge = new RechargeEntity();
                if (rechargeFloat != null) {
                    recharge.setFloatvalue(rechargeFloat);
                } else {
                    recharge.setFloatvalue("0");
                    rechargeFloat = "0";
                }
                sprice = new BigDecimal(p.getProdPrice()).multiply(new BigDecimal(1).add(new BigDecimal(rechargeFloat).divide(new BigDecimal(100))));
                recharge.setSprice(String.valueOf(sprice.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                recharge.setProdid(p.getProdId());
                recharge.setDlsprice(p.getProdPrice());
                recharge.setProddelaytimes(p.getProdDelaytimes());
                recharge.setProdisptype(p.getProdIsptype());
                recharge.setProdprovinceid(p.getProdProvinceid());
                recharge.setProdtype(p.getProdType());
                recharge.setRecsprice(p.getProdContent());
                recharge.setZt("1");
                recharge.setCid(uid);
                list.add(recharge);
            }
        }

        // 清除充值产品数据
        wareDao.delRechargeAll();
        wareDao.addRechargeList(list);
        wareDao.addRechargeLogList(list);
        // 批量插入充值产品数据，每次1000条
//        for (int i = 0; i < list.size(); i += 2000) {
//            List l = null;
//            if (i + 2000 > list.size()) {
//                l = list.subList(i, list.size());
//            } else {
//                l = list.subList(i, i + 2000);
//            }
//        wareDao.addRechargeList(l);
//        wareDao.addRechargeLogList(l);
//        }

        return true;
    }

    @Override
    public String countRecharge(String recsprice) {
        Map<String, Object> map = new HashMap<>();
        map.put("recsprice", recsprice);
        return wareDao.countRecharge(map);
    }

    @Override
    public boolean saveRechargeFloat(String uid, String floatValue) {
        SysAllCodeEntity entity = wareDao.getRechargeFloat();
        if (entity != null) {
            wareDao.updRechargeFloat(floatValue);
        } else {
            SysAllCodeEntity entityTmp = new SysAllCodeEntity();
            entityTmp.setCodeCode("RECHARGEFLOAT");
            entityTmp.setCodeName("充值商品浮动值");
            entityTmp.setCodeType("RECHARGE");
            entityTmp.setCodeValue(floatValue);
            entityTmp.setCodeDesc("充值商品浮动值");
            entityTmp.setValidStatus("1");
            wareDao.addRechargeFloat(entityTmp);
        }
        return true;
    }
}
