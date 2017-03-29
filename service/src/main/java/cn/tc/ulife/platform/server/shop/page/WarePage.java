/**
 * @Title: ware
 * @Package cn.tc.ulife.platform.server.ware.model
 * @Description: TODO(用一句话来说明)
 * @author cxs
 * @date 2017/2/20 14:14
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.page;

import cn.tc.ulife.platform.server.shop.entity.WareSpecEntity;
import cn.tc.ulife.platform.server.sys.model.PictureEntity;
import cn.tc.ulife.platform.util.UtilToString;

import java.util.List;

/**
 * @author cxs
 * @ClassName: ware
 * @Description: TODO(用一句话来说明)
 * @date 2017/2/20 14:14
 */
public class WarePage {
    /**
     * 主键
     */
    private String id;

    /**
     * 商品编号
     */
    private String spcode;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 简称
     */
    private String jc;

    /**
     * 所属商家
     */
    private String storeid;

    /**
     * 所属商家
     */
    private String storeName;

    /**
     * 海报
     */
    private String logo;
    /**
     * 海报2
     */
    private String logo2;
    /**
     * 海报3
     */
    private String logo3;

    /**
     * 商品分类
     */
    private String type;

    /**
     * 商品分类
     */
    private String typeName;

    /**
     * 商品分类父级id
     */
    private String flpid;

    /**
     * 描述
     */
    private String remark;

    /**
     * 商品品牌
     */
    private String brand;

    /**
     * 是否上架
     */
    private String issj;

    /**
     * 是否参与平台活动
     */
    private String ispthd;

    /**
     * 参与活动或优惠券
     */
    private String ishd;

    /**
     * 支付方式
     */
    private String zffs;

    /**
     * 是否参与会员折扣
     */
    private String isvip;

    /**
     * 是否包邮 免运费
     */
    private String ismyf;

    /**
     * 是否支持七天退货
     */
    private String isqtth;

    /**
     * 新增时间
     */
    private String ctime;

    /**
     * 修改时间
     */
    private String mtime;

    /**
     * 修改IP
     */
    private String mip;

    /**
     * 修改用户
     */
    private String muid;

    /**
     * 是否推荐
     */
    private String istj;

    /**
     * 是否爆品
     */
    private String isbh;

    /**
     * 是否热搜
     */
    private String isrs;

    /**
     * 序号
     */
    private String xh;

    /**
     * 预警值
     */
    private String yjz;

    /**
     * 是否预警
     */
    private String isyj;

    /**
     * 系统管理员审核
     */
    private String issh;

    /**
     * 采购抛锚率
     */
    private String cgpml;
    /**
     * 是否拼团
     */
    private String ispt;

    /**
     * 开始页数
     */
    private int start;

    /**
     * 每页条数
     */
    private int limit;

    /**
     * 0 正常 1删除
     */
    private String zt;

    /**
     * 商品性质 0生鲜;1拼团;2服务;4宅配;5积分
     */
    private String isst;

    /**
     * 规格属性
     */
    private List<WareSpecEntity> wareSpecList;

    /**
     * 文件列表
     */
    private List<PictureEntity> warePictureList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpcode() {
        return spcode;
    }

    public void setSpcode(String spcode) {
        this.spcode = spcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo2() {
        return logo2;
    }

    public void setLogo2(String logo2) {
        this.logo2 = logo2;
    }

    public String getLogo3() {
        return logo3;
    }

    public void setLogo3(String logo3) {
        this.logo3 = logo3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlpid() {
        return flpid;
    }

    public void setFlpid(String flpid) {
        this.flpid = flpid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIssj() {
        return issj;
    }

    public void setIssj(String issj) {
        this.issj = issj;
    }

    public String getIspthd() {
        return ispthd;
    }

    public void setIspthd(String ispthd) {
        this.ispthd = ispthd;
    }

    public String getIshd() {
        return ishd;
    }

    public void setIshd(String ishd) {
        this.ishd = ishd;
    }

    public String getZffs() {
        return zffs;
    }

    public void setZffs(String zffs) {
        this.zffs = zffs;
    }

    public String getIsvip() {
        return isvip;
    }

    public void setIsvip(String isvip) {
        this.isvip = isvip;
    }

    public String getIsmyf() {
        return ismyf;
    }

    public void setIsmyf(String ismyf) {
        this.ismyf = ismyf;
    }

    public String getIsqtth() {
        return isqtth;
    }

    public void setIsqtth(String isqtth) {
        this.isqtth = isqtth;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getMip() {
        return mip;
    }

    public void setMip(String mip) {
        this.mip = mip;
    }

    public String getMuid() {
        return muid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
    }

    public String getIstj() {
        return istj;
    }

    public void setIstj(String istj) {
        this.istj = istj;
    }

    public String getIsbh() {
        return isbh;
    }

    public void setIsbh(String isbh) {
        this.isbh = isbh;
    }

    public String getIsrs() {
        return isrs;
    }

    public void setIsrs(String isrs) {
        this.isrs = isrs;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getYjz() {
        return yjz;
    }

    public void setYjz(String yjz) {
        this.yjz = yjz;
    }

    public String getIsyj() {
        return isyj;
    }

    public void setIsyj(String isyj) {
        this.isyj = isyj;
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh;
    }

    public String getCgpml() {
        return cgpml;
    }

    public void setCgpml(String cgpml) {
        this.cgpml = cgpml;
    }

    public String getIspt() {
        return ispt;
    }

    public void setIspt(String ispt) {
        this.ispt = ispt;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getIsst() {
        return isst;
    }

    public void setIsst(String isst) {
        this.isst = isst;
    }

    public List<WareSpecEntity> getWareSpecList()
    {
        return wareSpecList;
    }

    public void setWareSpecList(List<WareSpecEntity> wareSpecList)
    {
        this.wareSpecList = wareSpecList;
    }

    public List<PictureEntity> getWarePictureList()
    {
        return warePictureList;
    }

    public void setWarePictureList(List<PictureEntity> warePictureList)
    {
        this.warePictureList = warePictureList;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
