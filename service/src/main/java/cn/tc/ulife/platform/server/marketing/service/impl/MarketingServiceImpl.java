/**
 * 
 */
package cn.tc.ulife.platform.server.marketing.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import cn.tc.ulife.platform.server.marketing.dao.MarketingDao;
import cn.tc.ulife.platform.server.marketing.model.ComCodeBean;
import cn.tc.ulife.platform.server.marketing.model.CouponBean;
import cn.tc.ulife.platform.server.marketing.model.CouponuUserBean;
import cn.tc.ulife.platform.server.marketing.model.MarketBean;
import cn.tc.ulife.platform.server.marketing.model.MarketingCategoryBean;
import cn.tc.ulife.platform.server.marketing.model.MspBean;
import cn.tc.ulife.platform.server.marketing.model.PromotionRulesBean;
import cn.tc.ulife.platform.server.marketing.model.PromotionRulesVo;
import cn.tc.ulife.platform.server.marketing.model.SelectShopBean;
import cn.tc.ulife.platform.server.marketing.model.YxGtypeGoods;
import cn.tc.ulife.platform.server.marketing.model.YxStyleBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewBean;
import cn.tc.ulife.platform.server.marketing.model.YxViewPos;
import cn.tc.ulife.platform.server.marketing.service.MarketingService;
import cn.tc.ulife.platform.server.tree.model.TreeNode;
import cn.tc.ulife.platform.server.utils.dao.UtileDao;
import cn.tc.ulife.platform.server.utils.model.UploadBean;
import cn.tc.ulife.platform.server.utils.model.UtileBean;
import cn.tc.ulife.platform.server.utils.service.UtileService;
import cn.tc.ulife.platform.util.CRMUtil;
import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.Constants;
import cn.tc.ulife.platform.util.JsonUtil;

/**
 * 营销管理业务逻辑层实现类
 * @author lcc
 * 
 */
@Service("marketingServer")
public class MarketingServiceImpl implements MarketingService
{
	@Autowired
	private MarketingDao marketingDao;

	@Autowired
	private UtileDao utileDao;
	@Autowired
	UtileService utileService;


	@Override
	public List<PromotionRulesVo> getPromotionRules(PromotionRulesBean specBean) {
		List<PromotionRulesVo> promotionRules = this.marketingDao.getPromotionRules(specBean);
		return promotionRules;
	}

	/**
	 * 保存营销规则
	 * 日期 2017年2月24日
	 * 时间 上午11:17:30
	 * 创建者Lcc
	 */
	@Override
	public JSONObject savePromotionRules(PromotionRulesBean specBean) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT T.ID,T.CODE NAME FROM T_YX_MARKETGZ T WHERE T.CODE='").append(specBean.getCode()).append("'");
		List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(StringUtils.isNotEmpty(specBean.getId())){//修改
			if(list.size()<2){
				marketingDao.updatePromotionRules(specBean);
				return JsonUtil.formatJsonResult("更新成功!", true);
			}else{
				return JsonUtil.formatJsonResult(specBean.getCode()+"编码已存在!", true);
				/*if(CollectionUtils.isNotEmpty(list) && !specBean.getId().equals(list.get(0).getID())){
					return 1;
				}else{
					marketingDao.updatePromotionRules(specBean);
					return 0;
				}*/
			}
		}else{//新增
			if(CollectionUtils.isNotEmpty(list)){
				return JsonUtil.formatJsonResult(specBean.getCode()+"编码已存在!", true);
			}else{
				marketingDao.savePromotionRules(specBean);
				return JsonUtil.formatJsonResult("新增成功!", true);
			}
		}
	}

	@Override
	public int removePromotionRules(PromotionRulesBean bean) {
		return this.marketingDao.removePromotionRules(bean);
	}

	@Override
	public List<MarketingCategoryBean> getYxTypeList(MarketingCategoryBean bean) {
		return marketingDao.getYxTypeList(bean);
	}
	
	/**
	 * 包括admin登录的类目审核,agent登录的新增修改停用启用
	 * 日期 2017年3月1日
	 * 时间 上午10:36:50
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@Override
	@Transactional
	public JSONObject saveOrUpYxGtype(MarketingCategoryBean bean) {
		JSONObject json= new JSONObject();
		try {
			StringBuffer sql=new StringBuffer();
		    if(bean.getId()!=null&&bean.getId()!=""){
		    	//判断是否子节点
				if(!"0".equals(bean.getPid())){
							bean.setIsleaf("1");
				}
				//修改操作
				marketingDao.editYxGtype(bean);
				json = JsonUtil.formatJsonResult("修改成功!",true);
			}else{
				//新增操作,首先判断是否存在
				sql.append("SELECT S.ID,S.NAME  FROM  t_yx_gtype S where S.NAME='"+bean.getName()+"'").append(" and s.CID='"+bean.getCid()+"'");
				bean.setIssh("0");
				bean.setZt("2");
				if(!"".equals(bean.getPid())){ //子节点
					sql.append("AND S.PID='"+bean.getPid()+"'");
					bean.setIsleaf("1");
				}else{
					//父节点
					bean.setPid("0");
					bean.setIsleaf("0");
				}
				List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
				if(list!=null && list.size()>0 ){
					json = JsonUtil.formatJsonResult("同级下分类名称已存在！",false);
				}else{
					marketingDao.insertYxGtype(bean);
					json = JsonUtil.formatJsonResult("添加成功!",true);
				}
			}
		} catch (Exception e) {
		    e.printStackTrace();
		    json = JsonUtil.formatJsonResult("操作失败!"+e.getMessage(),false);
		}
		return json;
	}
	
	/**
	 * 停用启用营销类目
	 * 日期 2017年3月1日
	 * 时间 下午6:00:30
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	@Override
	public JSONObject updYxGtype(MarketingCategoryBean bean) {
		JSONObject json= new JSONObject();
		try {
			marketingDao.editYxGtype(bean);
			json=JsonUtil.formatJsonResult("操作成功！", true);
		} catch (Exception e) {
			e.printStackTrace();
			json=JsonUtil.formatJsonResult("操作失败！"+e.getMessage(), false);
		}
		return json;
	}
	
	
	/**
	 * 获取产品线绑定的分类
	 * 日期 2016-10-31
	 * 时间 下午2:32:28
	 * 创建者 lcc
	 * @param node
	 * @return
	 */
	public List<TreeNode> getProductLineFl(TreeNode node){
		return this.marketingDao.getProductLineFl(node);
	}
	
	/**
	 * 关联产品线的分类
	 * 日期 2016-10-31
	 * 时间 下午3:36:48
	 * 创建者 lcc
	 * @param gids
	 * @param gtid
	 * @return
	 */
	public boolean saveMaketingCategoryByProductLine(String[] gids,String gtid,String uid){
		//获取该角色账号已下发分类
		StringBuffer sql=new StringBuffer();
		sql.append("select ID,gid NAME from T_YX_GTYPEGOODS WHERE GTID= ").append(gtid);
		List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(CollectionUtils.isNotEmpty(list)){//存在则对比数据
			//新增资源map
			Map <String, String> add=new HashMap<String, String>();
			//删除分类下发ids
			StringBuffer del=new StringBuffer();
			//已存在的list转map
			Map<String, String> map=new HashMap<String, String>();
			//当前分类数据转map
			Map<String, String> newmap=new HashMap<String, String>();
			for(UtileBean b:list){
				map.put(b.getNAME(), b.getNAME());
			}
			//对比当前与数据库中的资源数据
			for(String s:gids){
				newmap.put(s, s);
				if(!map.containsKey(s)){
					add.put(s, s);
				}
			}
			//对比数据库中与当前分类数据
			for(UtileBean b:list){
				if(!newmap.containsKey(b.getNAME())){
					del.append(b.getID()).append(",");
				}
			}
			//新增分类下发
			if(add.size()>0){
				sql=new StringBuffer();
				sql.append("INSERT INTO T_YX_GTYPEGOODS(GID,GTID,CID,CTIME)VALUES");
				for(Map.Entry<String, String> entry : add.entrySet()){
					sql.append("(").append(entry.getValue()).append(",").append(gtid);
					sql.append(",").append(uid);
					sql.append(",now()").append("),");
				}
				sql.deleteCharAt(sql.length()-1);
				utileDao.addData(CRMUtil.getMap(sql.toString()));
			}
			//取消分类下发
			if(del.length()>0){
				sql=new StringBuffer();
				del.deleteCharAt(del.length()-1);
				sql.append("DELETE FROM T_YX_GTYPEGOODS WHERE ID IN(").append(del.toString()).append(")");
				utileDao.delData(CRMUtil.getMap(sql.toString()));
			}
		}else{//没有则全部新增
			sql=new StringBuffer();
			sql.append("INSERT INTO T_YX_GTYPEGOODS(GID,GTID,CID,CTIME)VALUES");
			for(String s:gids){
				sql.append("(").append(s).append(",").append(gtid);
				sql.append(",").append(uid);
				sql.append(",now()").append("),");
			}
			sql.deleteCharAt(sql.length()-1);
			utileDao.addData(CRMUtil.getMap(sql.toString()));
		}
		return true;
	}
	
	
	/**
	 * 添加商品与类目关系
	 * 日期 2017年2月24日
	 * 时间 下午2:55:57
	 * 创建者Lcc
	 */
	@Override
	public boolean insertGtypeGoods(String gtid,String gsid,String type,String url,String userid) {
		try {
			YxGtypeGoods bean = new YxGtypeGoods();
			if(gsid!=null && gsid!=""){//判断修改或者添加url
				bean.setId(gsid);
				bean.setType(type);
				bean.setUrl(url);
				marketingDao.updGtypeGoods(bean);
			}else{
				bean.setCid(userid);
				bean.setGtid(gtid);
				bean.setType(type);
				bean.setUrl(url);
				marketingDao.insertGtypeGoods(bean);//绑定url
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	
	/**
	 * 删除营销主题
	 * 日期 2017年2月24日
	 * 时间 下午4:08:57
	 * 创建者 Lcc
	 * @param id
	 * @return
	 */
	@Transactional
	public boolean delYxStyle(String id){
		StringBuffer sql=new StringBuffer();
		sql.append("DELETE FROM T_YX_COMDITY WHERE COMDITY_ID IN (").append(id).append(") AND CTYPE=2");
		utileDao.delData(CRMUtil.getMap(sql.toString()));
		sql=new StringBuffer();
		sql.append("DELETE FROM T_YX_STYLE WHERE ID IN (").append(id).append(")");
		utileDao.delData(CRMUtil.getMap(sql.toString()));
		return true;
	}
	
	/**
	 * 复制联版/营销主题
	 * 日期 2016-7-11
	 * 时间 下午3:57:54
	 * 创建者 lcc
	 * @param id
	 * @param commids
	 * @param userid
	 * @return
	 */
	@Transactional
	public JSONObject addCopyTheme(String vid,String[] commids){
		if(null!=commids && commids.length>0 && StringUtils.isNotEmpty(vid)){
			StringBuffer sql=new StringBuffer();
			YxStyleBean view;//营销主题对象
			for(String id:commids){//多个小区
				view=new YxStyleBean();
				view.setYxid(vid);
				view.setXqid(id);
				//复制营销主题
				marketingDao.addCopyTheme(view);
				//复制营销主题关联商品数据
				sql=new StringBuffer();
				sql.append("INSERT INTO T_YX_COMDITY(COMDITY_ID,SID,CTIME,CID,CTYPE)");
				sql.append(" SELECT ").append(view.getId()).append(",SID,NOW(),CID,CTYPE FROM T_YX_COMDITY WHERE COMDITY_ID =");
				sql.append(vid).append(" AND CTYPE=2");
				utileDao.addData(CRMUtil.getMap(sql.toString()));
			}
			return JsonUtil.formatJsonResult("操作成功",true);
		}else{
			return JsonUtil.formatJsonResult("参数错误",false);
		}
	}
	/**
	 * 复制楼层
	 * 日期 2016-7-11
	 * 时间 下午3:57:54
	 * 创建者 lcc
	 * @param id
	 * @param commids
	 * @param userid
	 * @return
	 */
	@Transactional
	public JSONObject addCopyYxView(String vid,String[] commids){
		if(null!=commids && commids.length>0 && StringUtils.isNotEmpty(vid)){
			StringBuffer sql=new StringBuffer();
			//获取要复制的数据
			sql.append("SELECT C.ID,V.ID NAME FROM T_YX_COMDITY C ");
			sql.append("RIGHT JOIN T_YX_VIEWPOS V ON C.COMDITY_ID=V.ID AND C.CTYPE=1 WHERE V.VID=").append(vid);
			List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
			Map<String, String> map=new HashMap<String, String>();//封装复制的数据,已位置数据id为key
			if(CollectionUtils.isNotEmpty(list) && null !=list.get(0) && StringUtils.isNotEmpty(list.get(0).getNAME())){
				for(UtileBean b:list){
					if(map.containsKey(b.getNAME())){
						map.put(b.getNAME(), map.get(b.getNAME())+","+b.getID());
					}else{
						map.put(b.getNAME(), b.getID());
					}
				}
			}
			YxViewBean view;//楼层对象
			YxViewPos pos;//楼层位置对象
			for(String id:commids){//多个小区
				view=new YxViewBean();
				view.setGroupId(vid);
				view.setXqid(id);
				//复制楼层
				marketingDao.addCopyView(view);
				//复制楼层位置及营销商品关系
				if(map.size()>0){
					for(Map.Entry<String, String> entry : map.entrySet()){
						pos=new YxViewPos();
						pos.setVid(view.getId());
						pos.setCid(entry.getKey());
						//复制楼层位置数据
						marketingDao.addCopyViewPos(pos);
						//复制楼层位置关联商品数据
						if(StringUtils.isNotEmpty(entry.getValue())){
							sql=new StringBuffer();
							sql.append("INSERT INTO T_YX_COMDITY(COMDITY_ID,SID,CTIME,CID,CTYPE)");
							sql.append(" SELECT ").append(pos.getId()).append(",SID,NOW(),CID,CTYPE FROM T_YX_COMDITY WHERE ID IN (");
							sql.append(entry.getValue()).append(")");
							utileDao.addData(CRMUtil.getMap(sql.toString()));
						}
					}
				}
			}
			return JsonUtil.formatJsonResult("操作成功",true);
		}else{
			return JsonUtil.formatJsonResult("参数错误",false);
		}
	}
	/**
	 * 删除营销展示层 位置信息
	 * 日期 2016-7-11
	 * 时间 下午2:04:58
	 * 创建者 lcc
	 * @param id
	 * @return
	 */
	@Transactional
	public JSONObject delYxViewPos(String id){
		//1删除营销商品关系表(T_YX_COMDITY)
		StringBuffer sql=new StringBuffer();
		sql.append("DELETE FROM T_YX_COMDITY WHERE COMDITY_ID IN  (").append(id).append(") AND CTYPE=1");
		utileDao.delData(CRMUtil.getMap(sql.toString()));
		//2删除营销展示层位置信息表(T_YX_VIEWPOS)
		sql=new StringBuffer();
		sql.append("DELETE FROM T_YX_VIEWPOS WHERE ID IN (").append(id).append(")");
		utileDao.delData(CRMUtil.getMap(sql.toString()));
		return JsonUtil.formatJsonResult("操作成功",true);
	}
	
	/**
	 * 删除营销展示层 
	 * 日期 2016-7-11
	 * 时间 下午2:04:58
	 * 创建者 lcc
	 * @param id
	 * @return
	 */
	@Transactional
	public JSONObject delYxView(String id){
		//1删除营销商品关系表(T_YX_COMDITY)
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT GROUP_CONCAT(C.ID) ID FROM T_YX_VIEWPOS V  INNER JOIN T_YX_COMDITY C ON V.ID=C.COMDITY_ID AND CTYPE=1 WHERE  V.VID= ").append(id);
		List<UtileBean>list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(CollectionUtils.isNotEmpty(list) && null !=list.get(0) && StringUtils.isNotEmpty(list.get(0).getID())){
			sql=new StringBuffer();
			sql.append("DELETE FROM T_YX_COMDITY WHERE ID IN (");
			sql.append(list.get(0).getID()).append(")");
			utileDao.delData(CRMUtil.getMap(sql.toString()));
		}
		//2删除营销展示层位置信息表(T_YX_VIEWPOS)
		sql=new StringBuffer();
		sql.append("DELETE FROM T_YX_VIEWPOS WHERE VID=").append(id);
		utileDao.delData(CRMUtil.getMap(sql.toString()));
		//3删除营销展示层(T_YX_VIEW)
		sql=new StringBuffer();
		sql.append("DELETE FROM T_YX_VIEW WHERE ID=").append(id);
		utileDao.delData(CRMUtil.getMap(sql.toString()));
		return JsonUtil.formatJsonResult("操作成功",true);
	}
	/**
	 * 营销展示层 列表
	 * 日期 2016-5-9
	 * 时间 下午3:59:22
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<YxViewBean> getShowFloorList(YxViewBean bean)
	{
		return marketingDao.getShowFloorList(bean);
	}
	/**
	 * 营销展示层 
	 * 日期 2016-5-9
	 * 时间 下午3:59:35
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public int getShowFloorListCount(YxViewBean bean)
	{
		return marketingDao.getShowFloorListCount(bean);
	}
	
	/**
	 * 营销展示层位置信息
	 * 日期 2016-5-10
	 * 时间 下午7:27:16
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<YxViewPos> getShowFloorPlaceList(YxViewPos bean)
	{
		return marketingDao.getShowFloorPlaceList(bean);
	}
	public int getShowFloorPlaceCount(YxViewPos bean)
	{
		return marketingDao.getShowFloorPlaceCount(bean);
	}
	
	/**
	 * 位置组
	 * 日期 2016-5-10
	 * 时间 下午1:58:15
	 * 创建者lcc
	 */
	public List<ComCodeBean> getSeoFloor()
	{
		return marketingDao.getSeoFloor();
	}
	
	
	/**
	 * 营销楼层位置
	 * 日期 2016-5-10
	 * 时间 上午9:47:07
	 * 创建者lcc
	 */
	public List<ComCodeBean> getSeoFloorPlace(ComCodeBean bean)
	{
		return marketingDao.getSeoFloorPlace(bean);
	}
	
	/**
	 * 保存活动楼层
	 * 日期 2016-5-10
	 * 时间 上午10:18:13
	 * 创建者lcc
	 */
	@Transactional
	public JSONObject saveYxView(YxViewBean bean)
	{ 
		JSONObject	json = new JSONObject();	
		if(StringUtils.isEmpty(bean.getId()))	
		{			
			StringBuffer sql1=new StringBuffer();
			sql1.append("SELECT V.ID,V.TITLE NAME FROM `t_yx_view`  V  WHERE V.TITLE='"+bean.getTitle().trim()+"'  AND V.COMID="+bean.getXqid()+"");			
			List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql1.toString()));
			if(CollectionUtils.isNotEmpty(list)){//存在则对比数据
				 json = JsonUtil.formatJsonResult("营销楼层已存在,无效操作！", false);	
			}else
			{							
				marketingDao.addYxView(bean);			
				json = JsonUtil.formatJsonResult("操作成功！", true);				
			}
		}else
		{
		 marketingDao.updateYxView(bean);	
		 json = JsonUtil.formatJsonResult("操作成功！", true);	
		}				
		return json;		
	}
	/**
	 * 活动位管理  是否显示名称
	 * 日期 2016-6-2
	 * 时间 下午4:42:12
	 * 创建者 lcc
	 * @param id
	 * @param zt
	 * @param type
	 * @return
	 */
	public JSONObject editIsShow(String id,String zt,String type)
	{
		//0 营销展示层T_YX_VIEW  1营销展示层位置信息表T_YX_VIEWPOS 2营销主题T_YX_STYLE
		JSONObject	json = new JSONObject();
		StringBuffer sql1=new StringBuffer();		
		if("0".equals(type))
		{
			sql1.append("UPDATE t_yx_view SET IS_SHOW='"+zt+"' WHERE ID="+id+" ");		
		}else if("1".equals(type)) {
			sql1.append("UPDATE t_yx_viewpos SET  ISZS='"+zt+"'  WHERE ID="+id+" ");	
		}else
		{
			sql1.append("UPDATE t_yx_style  SET  ISZS='"+zt+"'   WHERE  ID="+id+" ");	
		}
		utileDao.editData(CRMUtil.getMap(sql1.toString()));
		json=JsonUtil.formatJsonResult("操作成功",true);
		return json;
	}
	
	/**
	 * 修改 营销活动楼层 状态
	 * 日期 2017年3月6日
	 * 时间 上午10:26:18
	 * 创建者Lcc
	 */
	public JSONObject editYxView(String id,String zt)
	{ 
		JSONObject	json = new JSONObject();			
		StringBuffer sql1=new StringBuffer();
		sql1.append(" UPDATE t_yx_view  SET ZT="+zt+",CTIME=now()   WHERE ID="+id+"");					
		utileDao.editData(CRMUtil.getMap(sql1.toString()));	
		json=JsonUtil.formatJsonResult("操作成功",true);
		return json;
	}
	
	@Transactional
	@Override
	public String saveAttachment(InputStream inputStream, YxViewBean bean,String fileta)
			throws FileNotFoundException, IOException
	{
		// 动态生成系统唯一附件名
		String name = getFileExtName(bean.getIcon(),bean.getIcon());
		String filetab =fileta;//"T_YX_VIEW";// uploadBean.getFILETAB();
		
		String path = ConfigUtil.getProperties("FILE_PATH_ROOT")+ ConfigUtil.getProperties("T_YX_VIEW");
		File file = new File(path);
		if (!file.exists())
		{
			file.mkdirs();
		}
		path = path + name;
		String url = ConfigUtil.getProperties("T_YX_VIEW") + name;
		bean.setIcon(url);
		
		// 保存数据
		if("T_YX_VIEW".equals(filetab))
		{
		  this.saveUploadYxViewFile(bean);
		}
		
		if("T_YX_VIEWPOS".equals(filetab)){
			this.saveYxViewPosFile(bean);
		}
		
		if("T_YX_STYLE".equals(filetab))
		{
			this.saveYxStyleFile(bean);
		}
		
		File uploadFile = new File(path);
		FileCopyUtils.copy(inputStream, new FileOutputStream(uploadFile));
		return url;
	}
	
	/**
	 * 获取系统唯一附件名
	 * 
	 * @param bizid
	 *            业务id
	 * @param fileName
	 *            附件后缀名
	 * @return 附件名
	 */
	protected String getFileExtName(String bizid, String fileName)
	{
		fileName = bizid + "_"
				+ CRMUtil.getSysTime(new SimpleDateFormat("yyyyMMddHHmmssSSS"))
				+ "." + fileName;
		return fileName.trim();
	}
	
	protected String getFileExtName(String fileName) {
		if (fileName != null
				&& (fileName.lastIndexOf(".") != -1 && fileName
						.lastIndexOf(".") != 0)) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		return "";
	}
	
	/**
	 * 营销展示层    保存图标
	 * 日期 2016-5-10
	 * 时间 下午5:38:52
	 * 创建者 lcc
	 * @param bean
	 */
	protected void saveUploadYxViewFile(YxViewBean bean)
	{
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE t_yx_view  SET ICON='"+bean.getIcon()+"',CTIME=now()   WHERE ID="+bean.getId()+"");		
		utileDao.editData(CRMUtil.getMap(sql.toString().trim()));
	}
	/**
	 * 保存 营销展示层位置 图标
	 * 日期 2016-5-12
	 * 时间 下午2:55:04
	 * 创建者 lcc
	 * @param bean
	 */
	protected void saveYxViewPosFile(YxViewBean bean)
	{
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE t_yx_viewpos  SET URL='"+bean.getIcon()+"',CTIME=now()   WHERE ID="+bean.getId()+"");		
		utileDao.editData(CRMUtil.getMap(sql.toString().trim()));
	}
	/**
	 * 保存 营销主题  展示图片
	 * 日期 2016-5-12
	 * 时间 下午7:07:43
	 * 创建者 lcc
	 * @param bean
	 */
	protected void saveYxStyleFile(YxViewBean bean)
	{
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE t_yx_style  SET TABLE_URL='"+bean.getIcon()+"',CTIME=now()   WHERE ID="+bean.getId()+"");		
		utileDao.editData(CRMUtil.getMap(sql.toString().trim()));
	}
	
	/**
	 * 展示层位置  选择商品列表
	 * 日期 2016-5-11
	 * 时间 下午4:17:36
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getShowFloorSelectSp(SelectShopBean bean)
	{
		return marketingDao.getShowFloorSelectSp(bean);
	}
	public int getShowFloorSelectSpCount(SelectShopBean bean)
	{
		return marketingDao.getShowFloorSelectSpCount(bean);
	}
	
	/**
	 * 获取商家
	 */
	public List<ComCodeBean> getSellCom(ComCodeBean bean)
	{
		return marketingDao.getSellCom(bean);
	}
	
	/**
	 * 保存 营销展示层 位置信息
	 * 日期 2016-5-12
	 * 时间 上午10:15:04
	 * 创建者 lcc
	 * @param ids
	 * @param gzcodes
	 * @param xqId
	 * @param groupId
	 * @param bean
	 * @return
	 */
	@Transactional
	public JSONObject saveFloorPlace(String[] ids,String[] gzcodes,String vid,String groupId,YxViewPos bean)
	{
		JSONObject	json = new JSONObject();		
		if(StringUtils.isEmpty(bean.getId()))	
		{	//新增		
			StringBuffer sql1=new StringBuffer();
			sql1.append("SELECT ID,TITLE  NAME  FROM t_yx_viewpos where VID="+vid+" and GROUP_ID="+groupId+" and LOCID="+bean.getLocid().trim()+" and ZT=0 and (now() BETWEEN KTIME and JTIME)");			
			List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql1.toString()));
			if(CollectionUtils.isNotEmpty(list)){//存在则对比数据
				 json = JsonUtil.formatJsonResult("该营销楼层位置已存在有效活动,无效操作！", false);	
			}else
			{	
				if(ids.length>0)
				{				
					//单品或商品列表
					String sqlCode="";
					Map<String, String> idmap=new HashMap<String, String>();
					Map<String, String> strmap=new HashMap<String, String>();
					
					for(String s:ids){								
						if(!idmap.containsKey(s)){
							idmap.put(s,s);		
						}
					}
					if(null != null && gzcodes.length>0)
					{
						for(String s:gzcodes){														
							if(!strmap.containsKey(s)){
								strmap.put(s,s);
								sqlCode+=s+",";	
							}
						}					
						if(sqlCode.length()>0)
						{
							sqlCode=sqlCode.substring(0,sqlCode.length()-1);					
							bean.setYxid(sqlCode);
						}
					}
					marketingDao.addYxViewPos(bean);					
					StringBuffer sql2=new StringBuffer();
					sql2.append("INSERT INTO t_yx_comdity ( COMDITY_ID, SID, CTIME, CID, CTYPE) VALUES ");					
					for(Map.Entry<String, String> entry : idmap.entrySet()){						
				      sql2.append("(").append(bean.getId()+",").append(entry.getValue()+",").append("now(),")
				      .append(bean.getCid()+",1").append(")").append(",");				
				    }
					sql2.deleteCharAt(sql2.length()-1);				   
					utileDao.addData(CRMUtil.getMap(sql2.toString()));	
				}else
				{							
					//第三方链接
					marketingDao.addYxViewPos(bean);					
				}							
				json = JsonUtil.formatJsonResult("操作成功！", true);				
			}
		}else
		{
		  //修改					
		 json = JsonUtil.formatJsonResult("操作成功！", true);	
		}			
		return json;
	}
	
	
	/**
	 * 获取代理商下的有效优惠券
	 * 日期 2017年3月6日
	 * 时间 下午2:43:58
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public List<CouponBean> getCouponDlsList(CouponBean bean){
		return marketingDao.getCouponDlsList(bean);
	}
	
	/**
	 * 获取代理商下的有效优惠券总数
	 * 日期 2017年3月6日
	 * 时间 下午2:43:58
	 * 创建者 Lcc
	 * @param bean
	 * @return
	 */
	public int getCouponDlsTotalCount(CouponBean bean){
		return marketingDao.getCouponDlsTotalCount(bean);
	}

	/**
	 * 修改  营销展示层 位置信息
	 * 日期 2016-7-4
	 * 时间 下午5:58:13
	 * 创建者lcc
	 */
	@Transactional
	public JSONObject saveUpdateFloorPlace(String[] ids,String[] gzcodes,String vid,String groupId,YxViewPos bean,String lid)
	{
		JSONObject	json = new JSONObject();
		if(!StringUtils.isEmpty(bean.getId()))	
		{	//修改		
			StringBuffer sql1=new StringBuffer();
			sql1.append("SELECT ID,TITLE  NAME  FROM t_yx_viewpos where VID=").append(vid).append(" and GROUP_ID=");
			sql1.append(groupId).append(" and LOCID=").append(lid).append(" and ZT=0 and (now() BETWEEN KTIME and JTIME)");			
			List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql1.toString()));
			if(CollectionUtils.isNotEmpty(list)){//存在则对比数据
				if(!bean.getId().equals(list.get(0).getID())){
					return JsonUtil.formatJsonResult("该营销楼层位置已存在有效活动,无效操作！", false);	
				}
			}
			if(ids.length>0)
			{				
				//单品或商品列表
				String sqlCode="";
				Map<String, String> idmap=new HashMap<String, String>();
				Map<String, String> strmap=new HashMap<String, String>();
				
				for(String s:ids){								
					if(!idmap.containsKey(s)){
						idmap.put(s,s);		
					}
				}
				if(null != gzcodes && gzcodes.length>0)
				{
					for(String s:gzcodes){														
						if(!strmap.containsKey(s)){
							strmap.put(s,s);
							sqlCode+=s+",";	
						}
					}					
					if(sqlCode.length()>0)
					{
						sqlCode=sqlCode.substring(0,sqlCode.length()-1);					
						bean.setYxid(sqlCode);
					}
				}
				marketingDao.updateYxViewPos(bean);
				//1.先删除
				StringBuffer sql3=new StringBuffer();
				sql3.append("DELETE FROM  t_yx_comdity  WHERE COMDITY_ID=").append(bean.getId()).append(" and CTYPE=1");													   
				utileDao.delData(CRMUtil.getMap(sql3.toString()));	
				
				//2.再保存				
				StringBuffer sql2=new StringBuffer();
				sql2.append("INSERT INTO t_yx_comdity ( COMDITY_ID, SID, CTIME, CID, CTYPE) VALUES ");					
				for(Map.Entry<String, String> entry : idmap.entrySet()){						
			      sql2.append("(").append(bean.getId()).append(",").append(entry.getValue()).append(",now(),")
			      .append(bean.getCid()).append(",1)").append(",");				
			    }
				sql2.deleteCharAt(sql2.length()-1);				   
				utileDao.addData(CRMUtil.getMap(sql2.toString()));					
			}else
			{							
				//第三方链接
				marketingDao.updateYxViewPos(bean);				
			}							
			json = JsonUtil.formatJsonResult("操作成功！", true);				
		}else
		{				
		 json = JsonUtil.formatJsonResult("参数为空！", false);	
		}						
		return json;
	}
	
	/**
	 * 编辑营销展示层位置 状态
	 * 日期 2016-5-12
	 * 时间 下午2:14:31
	 * 创建者lcc
	 */
	public JSONObject editYxViewPos(String id,String zt,String vid,String  groupId,String locid)
	{
		JSONObject	json = new JSONObject();	
		if("0".equals(zt))//启用状态
		{
			StringBuffer sql=new StringBuffer();
			sql.append("SELECT ID,TITLE  NAME  FROM t_yx_viewpos where VID="+vid+" and GROUP_ID="+groupId+" and LOCID="+locid+" and ZT=0 and (now() BETWEEN KTIME and JTIME)");			
			List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
			if(CollectionUtils.isNotEmpty(list)){//存在则对比数据
				 json = JsonUtil.formatJsonResult("该营销楼层位置已存在有效活动,请检查！", false);	
			}else
			{
				StringBuffer sql1=new StringBuffer();
				sql1.append("UPDATE t_yx_viewpos SET  ZT="+zt+" WHERE ID="+id+" ");					
				utileDao.editData(CRMUtil.getMap(sql1.toString()));		
				json = JsonUtil.formatJsonResult("操作成功！", true);								
			}			
		}else
		{
			StringBuffer sql1=new StringBuffer();
			sql1.append("UPDATE t_yx_viewpos SET  ZT="+zt+" WHERE ID="+id+" ");					
			utileDao.editData(CRMUtil.getMap(sql1.toString()));		
			json = JsonUtil.formatJsonResult("操作成功！", true);				
		}		
		return json;		
	}
	
	/**
	 * 营销主题
	 * 日期 2016-5-12
	 * 时间 下午4:15:32
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public Map<String, Object> getMarketThemeList(YxStyleBean   bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("list",marketingDao.getMarketThemeList(bean));
		map.put("count", marketingDao.getMarketThemeListCount(bean));
		return map;
	}
		
	/**
	 *  保存营销主题
	 * 日期 2017年2月24日
	 * 时间 下午4:17:06
	 * 创建者Lcc
	 */
	@Transactional
	public JSONObject saveYxStyle(String[] ids,String[] gzcodes,YxStyleBean bean)
	{
		JSONObject	json = new JSONObject();
		if(StringUtils.isEmpty(bean.getId()))	
		{	//新增		
			StringBuffer sql1=new StringBuffer();
			sql1.append("SELECT s.ID,s.TABLE_NAME Name  FROM t_yx_style s ");
			sql1.append(" where  S.COMID=").append(bean.getXqid()).append(" and s.SORT=").append(bean.getSort()).append(" and s.zt=0 and ( now() BETWEEN s.KTIME and s.JTIME )");
			List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql1.toString()));
			if(CollectionUtils.isNotEmpty(list)){//存在则对比数据
				 json = JsonUtil.formatJsonResult("该联版位置已有生效的活动,请检查！", false);	
			}else
			{	
				if(StringUtils.isEmpty(bean.getLinkUrl()))
				{				
					//单品或商品列表
					String sqlCode="";
					Map<String, String> idmap=new HashMap<String, String>();
					Map<String, String> strmap=new HashMap<String, String>();
					
					for(String s:ids){								
						if(!idmap.containsKey(s)){
							idmap.put(s,s);		
						}
					}
					if(null != gzcodes && gzcodes.length>0)
					{											
						for(String s:gzcodes){														
							if(!strmap.containsKey(s)){
								strmap.put(s,s);
								sqlCode+=s+",";	
							}
						}					
						if(!sqlCode.isEmpty())
						{
							sqlCode=sqlCode.substring(0,sqlCode.length()-1);					
							bean.setYxid(sqlCode);
						}	
					}				
					bean.setStype("0");
					marketingDao.addYxStyle(bean);					
					//营销商品关系
					StringBuffer sql2=new StringBuffer();
					sql2.append("INSERT INTO t_yx_comdity ( COMDITY_ID, SID, CTIME, CID, CTYPE) VALUES ");					
					for(Map.Entry<String, String> entry : idmap.entrySet()){						
				      sql2.append("(").append(bean.getId()+",").append(entry.getValue()+",").append("now(),")
				      .append(bean.getCid()+",2").append(")").append(",");				
				    }
					sql2.deleteCharAt(sql2.length()-1);
					utileDao.addData(CRMUtil.getMap(sql2.toString()));	
					
															
				}else
				{					
					//第三方链接
					bean.setStype("1");
					marketingDao.addYxStyle(bean);	
				}							
				json = JsonUtil.formatJsonResult("操作成功！", true);				
			}
		}else
		{
			StringBuffer sql=new StringBuffer();
			sql.append("UPDATE  T_YX_STYLE SET KTIME= '").append(bean.getKtime()).append("',");
			sql.append("JTIME='").append(bean.getJtime()).append("',");
			sql.append("ACTIVITY_DESC='").append(CRMUtil.filterDangerString(bean.getDepict())).append("',");
			sql.append("TABLE_NAME='").append(CRMUtil.filterDangerString(bean.getTableName())).append("',");
			sql.append("ISZS='").append(bean.getIszs()).append("',");
			sql.append("LINK_URL='").append(bean.getLinkUrl()).append("'");
			sql.append(" WHERE ID=").append(bean.getId());
			utileDao.editData(CRMUtil.getMap(sql.toString()));
		  //修改					
		 json = JsonUtil.formatJsonResult("操作成功！", true);	
		}			
		return json;		
	}
	
	/**
	 *编辑营销主题 状态
	 * 日期 2016-5-12
	 * 时间 下午2:14:31
	 * 创建者lcc
	 */
	@Transactional
	public JSONObject editYxStyle(String id,String zt,String xqid,String sort)
	{
		JSONObject	json = new JSONObject();		
		if("0".equals(zt))
		{
			StringBuffer sql=new StringBuffer();
			sql.append("SELECT s.ID,s.TABLE_NAME Name  FROM t_yx_style s ");
			sql.append(" where S.COMID="+xqid+" and s.SORT="+sort+" and s.zt=0 and ( now() BETWEEN s.KTIME and s.JTIME )");
			List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
			if(CollectionUtils.isNotEmpty(list)){//存在则对比数据
				 json = JsonUtil.formatJsonResult("该联版位置已有生效的活动,请检查！", false);	
			}else
			{				
				StringBuffer sql1=new StringBuffer();
				sql1.append("UPDATE t_yx_style SET  ZT="+zt+" WHERE ID="+id+" ");					
				utileDao.editData(CRMUtil.getMap(sql1.toString()));		
				json = JsonUtil.formatJsonResult("操作成功！", true);				
			}			
		}else
		{
		   StringBuffer sql1=new StringBuffer();
		   sql1.append("UPDATE t_yx_style SET  ZT="+zt+" WHERE ID="+id+" ");					
		   utileDao.editData(CRMUtil.getMap(sql1.toString()));		
		   json = JsonUtil.formatJsonResult("操作成功！", true);
		}		
		return json;		
	}
	
	public JSONObject uploadMarketThemeImage(HttpServletRequest request,HttpServletResponse response,String id, String Fw, String Fh,String filetab){
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			if (!StringUtils.isNotEmpty(id)) {
				return JsonUtil.formatJsonResult("上传失败，业务ID为空！", false);
			}
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096);// 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
			// dfif.setRepository(new
			// File(uploadFileService.getTempSavePath()));//设置附件临时保存路径
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setSizeMax(4 * 1024 * 1024);// 文件最大4MB;
			List<?> files = fileUpload.parseRequest(request);
			// 没有文件上传
			if (files == null || files.size() == 0) {
				return JsonUtil.formatJsonResult("上传失败，请选择图片！", false);
			}
			FileItem file = (FileItem) files.get(0);
			if (StringUtils.isNotEmpty(Fh)) {
				int h = Integer.parseInt(Fh);
				BufferedImage img = javax.imageio.ImageIO.read(file
						.getInputStream());
				int heigth = img.getHeight();
				if (h < heigth) {
					return JsonUtil.formatJsonResult("上传失败，文件高超度出最大值！最高为" + h, false);
				}
			}
			if (StringUtils.isNotEmpty(Fw)) {
				int w = Integer.parseInt(Fw);
				BufferedImage img = javax.imageio.ImageIO.read(file
						.getInputStream());
				int width = img.getWidth();
				if (w < width) {
					return JsonUtil.formatJsonResult("上传失败，文件宽，高超出最大值！最宽为" + w, false);
				}
			}
			long fileSize = file.getSize();
			// 获取文件大小
			long size = Long.parseLong(ConfigUtil.getProperties("FILE_SIZE")) * 1024;
			if (fileSize > size) {
				return JsonUtil.formatJsonResult("上传失败，文件太大！", false);
			}

			String fileName = file.getName();
			
			String extName = null ;
			if (fileName != null && (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)) {
				extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			}
			// 获取文件后缀名
			if (!extName.equalsIgnoreCase("jpg") && !extName.equalsIgnoreCase("png") && !extName.equalsIgnoreCase("gif")) {
				return JsonUtil.formatJsonResult("上传失败，文件名不符合格式！", false);
			}			
			YxViewBean uploadBean=new YxViewBean();
					
			uploadBean.setId(id);
			uploadBean.setIcon(extName);			
		    saveAttachment(file.getInputStream(), uploadBean,filetab);						
		} catch (Exception e) {
			out.println(JsonUtil.formatJsonResult("上传失败！" + e.getMessage(), false));
			out.close();
			e.printStackTrace();
		} finally {
			out.close();
		}
		return JsonUtil.formatJsonResult("上传成功！", true);
	}
	/**
	 * 营销主题参与的商品
	 * 日期 2016-5-13
	 * 时间 上午9:34:26
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getThemeSelectedSp(SelectShopBean bean)
	{
		return marketingDao.getThemeSelectedSp(bean);
	}
	
	
	/**
	 * 营销展示层位置信息   选中的商品
	 * 日期 2016-5-13
	 * 时间 上午10:00:29
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<SelectShopBean> getShowPlaceSelectedSp(SelectShopBean bean)
	{
		return marketingDao.getShowPlaceSelectedSp(bean);
	}
	/**
	 * 营销展示层位置信息   选中的优惠券
	 * 日期 2016-6-14
	 * 时间 下午5:35:34
	 * 创建者 lcc
	 * @param bean
	 * @return
	 */
	public List<CouponBean>getShowPlaceSelectedYhj (CouponBean bean)
	{
		return marketingDao.getShowPlaceSelectedYhj(bean);
	}
	
	/**
	 * 获取优惠券列表
	 * 日期 2017年2月27日
	 * 时间 下午5:52:00
	 * 创建者Lcc
	 */
	public List<CouponBean> getCouponList(CouponBean coupon){
		return marketingDao.getCouponList(coupon);
	}
	
	/**
	 * 获取优惠券总记录条数
	 * 日期 2017年3月1日
	 * 时间 下午1:28:02
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	public int getCouponTotalCount(CouponBean coupon){
		return marketingDao.getCouponTotalCount(coupon);
	}
	
	/**
	 * 根据id查询商家id
	 * 日期 2017年3月20日
	 * 时间 下午2:58:55
	 * 创建者 Lcc
	 * @param uid
	 * @return
	 */
	public JSONObject getStoreId(String uid){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT s.ID FROM `t_sc_store` s INNER JOIN t_u_baseuser b ON s.ACCOUNT = b.Account WHERE b.ID = ").append(uid);
		List<UtileBean> listData = utileDao.getListData(CRMUtil.getMap(sql.toString().trim()));
		if(listData.size()>0){
			return JsonUtil.formatJsonResult("查询成功",true,listData.get(0).getID());
		}else{
			return JsonUtil.formatJsonResult("没有查到相关商家", false);
		}
	}
	
	/**
	 * 保存优惠券
	 * 日期 2017年2月28日
	 * 时间 上午10:58:09
	 * 创建者 Lcc
	 * @param coupon
	 * @return
	 */
	@Transactional
	public JSONObject saveCoupon(CouponBean coupon){
		if(StringUtils.isNotEmpty(coupon.getType()) && "mzyhq".equals(coupon.getType())){//买赠优惠券 默认赠品券 立即领取 不同享
			coupon.setIsearlier("1");
			coupon.setYhxz("9");
			coupon.setIsenjoy("0");
			coupon.setIsfb("0");
		}else{
			coupon.setYhxz("0");
		}
		StringBuffer sql= new StringBuffer();
		String type=coupon.getYtype();
		coupon.setSjid(coupon.getSjid());
		marketingDao.saveCoupon(coupon);
		if(StringUtils.isNotEmpty(coupon.getId()) && "0".equals(type)){
			//优惠券与商品关联表
			 String[] ids=coupon.getIds();
			 if(null!=ids && ids.length>0 && StringUtils.isNotEmpty(ids[0])){
				 sql = new StringBuffer();
				 sql.append("INSERT INTO T_YX_YHJSP (SPID,YHJID,CTIME)VALUES ");
				 for(String id:ids){
					 sql.append("(").append(id).append(",").append(coupon.getId()).append(",now())");
					 sql.append(",");
				 }
				 sql.deleteCharAt(sql.length()-1);
				 utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
			 }
		}
		return JsonUtil.formatJsonResult("保存成功!", true);
	}
	
	/**
	 * 更新商家是否显示优惠标识
	 * 日期 2016-12-30
	 * 时间 下午5:27:03
	 * 创建者lcc
	 */
	public void updateStore(MarketBean market){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ID FROM `t_yx_yhj` WHERE ISFB = 0 AND JTIME >= NOW() AND ISYHQ=0 AND SJID = ").append(market.getStoreid());//是否有有效优惠券
		List<UtileBean> yhqs = utileDao.getListData(CRMUtil.getMap(sql.toString().trim()));
		sql =  new StringBuffer();
		sql.append("SELECT ID FROM `t_sc_dispoint` WHERE ZT = 1 AND JTIME >= NOW() AND STOREID = ").append(market.getStoreid());//是否有有效折扣
		List<UtileBean> zks = utileDao.getListData(CRMUtil.getMap(sql.toString().trim()));
		sql = new StringBuffer();
		sql.append("SELECT ID FROM t_yx_market WHERE ZT=1 AND JTIME>=NOW() AND SJID=").append(market.getStoreid());//是否有有效活动
		List<UtileBean> mzs = utileDao.getListData(CRMUtil.getMap(sql.toString().trim()));
		if(yhqs.size()==0 && zks.size()==0 && mzs.size()==0){
			sql = new StringBuffer();
			sql.append("UPDATE t_sc_store SET ISYHFLAG = '0' WHERE ID=").append(market.getStoreid());
			utileDao.editData(CRMUtil.getMap(sql.toString().trim()));
		}
	}
	
	
	
	/**
	 * 删除优惠券
	 * 日期 2017年2月28日
	 * 时间 下午1:40:42
	 * 创建者Lcc
	 */
	@Transactional
	public void delCoupon(String ids){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ID FROM T_YX_YHJ WHERE ID IN (").append(ids).append(") AND ISFB='1' AND YTYPE='0' ");
		List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(CollectionUtils.isNotEmpty(list)){
			sql=new StringBuffer();
			//删除优惠券商品信息
			sql.append("DELETE FROM T_YX_YHJSP WHERE YHJID IN (");
			for(UtileBean b: list){
				sql.append(b.getID()).append(",");
			}
			sql.deleteCharAt(sql.length()-1);
			sql.append(")");
			//删除优惠券商品信息
			utileDao.delData(CRMUtil.getMap(sql.toString()));
		}
		sql=new StringBuffer();
		//删除优惠券
		sql.append("DELETE FROM T_YX_YHJ WHERE ID IN (").append(ids).append(") AND ISFB='1' ");
		utileDao.delData(CRMUtil.getMap(sql.toString()));
	}
	
	/**
	 * 获取促销活动小区选择
	 * 日期 2017年2月28日
	 * 时间 下午1:57:51
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getProCommList(MarketBean market){
		return marketingDao.getProCommList(market);
	}
	
	public List<MarketBean> getProCommListTotal(MarketBean market){
		return marketingDao.getProCommListTotal(market);
	}
	
	
	/**
	 * 优惠券绑定小区
	 * 日期 2016-12-29
	 * 时间 下午4:30:30
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	@Transactional
	public JSONObject addYhqComm(MarketBean market){
		String  ids=market.getXQID();
		StringBuffer sql= new StringBuffer();
		sql.append("SELECT CID ID FROM t_community ");
		sql.append(" WHERE CID IN (").append(ids).append(")");
		sql.append(" AND CID NOT IN (SELECT XQID FROM T_YX_MXQXX WHERE TJLX=2 AND CXID=").append(market.getID()).append(")");
		List <UtileBean>list= utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(CollectionUtils.isNotEmpty(list)){
			sql = new StringBuffer();
			sql.append("INSERT INTO T_YX_MXQXX(XQID,CXID,CTIME,TJLX)VALUES ");
			for(UtileBean id:list){
				sql.append("(").append(id.getID()).append(",").append(market.getID()).append(",now(),'2')");
				sql.append(",");
			}
			sql.deleteCharAt(sql.length()-1);
			utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
		}
		return JsonUtil.formatJsonResult("绑定成功!", true);
	}
	
	/**
	 * 获取促销活动的商品选择
	 * 日期 2016-5-4
	 * 时间 下午4:00:20
	 * 创建者 lcc
	 * @param mspBean
	 * @return
	 */
	public List<MspBean> getSpList(MspBean mspBean){
		return marketingDao.getSpList(mspBean);
	}

	/**
	 * 获取促销活动的商品选择总数
	 * 日期 2017年3月2日
	 * 时间 下午6:22:27
	 * 创建者Lcc
	 */
	@Override
	public int getSpTotalCount(MspBean mspBean) {
		return marketingDao.getSpTotalCount(mspBean);
	}
	
	
	/**
	 * 获取优惠券使用详情
	 * 日期 2016-12-20
	 * 时间 下午1:17:52
	 * 创建者 lcc
	 * @param coupon
	 * @return
	 */
	public List<CouponuUserBean> getCouponInfo(CouponuUserBean coupon){
		return marketingDao.getCouponInfo(coupon);
	}
	/**
	 * 获取优惠券使用详情 总记录
	 * 日期 2016-12-20
	 * 时间 下午1:17:55
	 * 创建者 lcc
	 * @param coupon
	 * @return
	 */
	public int getCouponInfoTotalCount(CouponuUserBean coupon){
		return marketingDao.getCouponInfoTotalCount(coupon);
	}
	
	
	/**
	 * 获取商品促销列表
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public List<CouponBean> getGoodsProList(MarketBean market){
		return marketingDao.getGoodsProList(market);
	}
	
	
	public int getGoodsProTotalCount(MarketBean market){
		return marketingDao.getGoodsProTotalCount(market);
	}
	
	
	/**
	 * 保存商品促销
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject saveGoodsPro(MarketBean market){
		marketingDao.saveGoodsPro(market);
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	/**
	 * 修改商品促销
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	@Transactional
	public JSONObject editGoodsPro(MarketBean market){
		int result = marketingDao.getIsRepeat(market);
		if(result > 0){
			return JsonUtil.formatJsonResult("当前商品是否已经在已发布的活动中", false);//已存在
		}
		StringBuffer sql= new StringBuffer();
		sql.append(" UPDATE  T_YX_MARKET SET ZT=").append(market.getZT()).append(",MTIME=now() ").append(" WHERE  ID= ").append(market.getID());
		utileDao.editData(CRMUtil.getMap(sql.toString()));
		//修改促销活动与商品明细状态
		sql= new StringBuffer();
		sql.append(" UPDATE  T_YX_MARKETSPMX SET ZT=").append(market.getZT()).append(" WHERE  CXID= ").append(market.getID());
		utileDao.editData(CRMUtil.getMap(sql.toString()));
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	/**
	 * 删除商品促销
	 * 日期 2016-5-3
	 * 时间 下午1:56:45
	 * 创建者 lcc
	 * @param ids
	 */
	@Transactional
	public void delGoodsPro(String ids){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ID FROM T_YX_MARKET WHERE ID IN (").append(ids).append(") AND ZT='0' ");
		List<UtileBean> list=utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(CollectionUtils.isNotEmpty(list)){
			sql=new StringBuffer();
			//删除商品促销商品信息
			sql.append("DELETE FROM T_YX_MARKETSPMX WHERE CXID IN (");
			for(UtileBean b: list){
				sql.append(b.getID()).append(",");
			}
			sql.deleteCharAt(sql.length()-1);
			sql.append(")");
			utileDao.delData(CRMUtil.getMap(sql.toString()));
			
			sql=new StringBuffer();
			//删除商品促销小区信息
			sql.append("DELETE FROM T_YX_MXQXX WHERE CXID IN (");
			for(UtileBean b: list){
				sql.append(b.getID()).append(",");
			}
			sql.deleteCharAt(sql.length()-1);
			sql.append(")");
			utileDao.delData(CRMUtil.getMap(sql.toString()));
		}
		sql=new StringBuffer();
		//删除商品促销
		sql.append("DELETE FROM T_YX_MARKET WHERE ID IN (").append(ids).append(") AND ZT='0' ");
		utileDao.delData(CRMUtil.getMap(sql.toString()));
	}
	
	/**
	 * 保存商品促销与小区信息
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject addProComm(MarketBean market){
		String  ids=market.getXQID();
		StringBuffer sql= new StringBuffer();
		//判断除了绑定的小区
		sql.append("SELECT CID ID FROM t_community ");
		sql.append(" WHERE CID IN (").append(ids).append(")");
		sql.append(" AND CID NOT IN (SELECT XQID FROM T_YX_MXQXX WHERE TJLX!=2 AND CXID=").append(market.getID()).append(")");
		List <UtileBean>list= utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(CollectionUtils.isNotEmpty(list)){
			 sql = new StringBuffer();
			 sql.append("INSERT INTO T_YX_MXQXX(XQID,CXID,CTIME)VALUES ");
			 for(UtileBean id:list){
				 sql.append("(").append(id.getID()).append(",").append(market.getID()).append(",now())");
				 sql.append(",");
			 }
			 sql.deleteCharAt(sql.length()-1);
			 utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
		}
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	/**
	 * 获取商品促销商品选择
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getProGoodsList(MarketBean market){
		return marketingDao.getProGoodsList(market);
	}
	/**
	 * 获取商品促销列表总记录条数
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public int getProGoodsTotalCount(MarketBean market){
		return marketingDao.getProGoodsTotalCount(market);
	}
	
	
	/**
	 * 保存商品促销与商品信息
	 * 日期 2016-4-28
	 * 时间 下午1:36:11
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public JSONObject addProGoods(MarketBean market,Map<String, String> map){
		String  ids=market.getSPID();
		StringBuffer sql= new StringBuffer();
		sql.append("SELECT CONCAT(S.ID,'_',G.ID) ID FROM T_SC_SPXX S INNER JOIN T_SC_SPGG G ON S.ID=G.SPID ");
		sql.append(" WHERE S.ID IN (").append(ids).append(")");
		sql.append("AND G.ID IN (").append(market.getGZID()).append(")");
		List <UtileBean>list= utileDao.getListData(CRMUtil.getMap(sql.toString()));
		if(CollectionUtils.isNotEmpty(list)){
			Map<String, String> res=new HashMap<String, String>();
			for(UtileBean id:list){
				if(map.containsKey(id.getID())){//获取已新增的
					res.put(id.getID(),map.get(id.getID()));
				}
			}
			if(res.size()>0){
				sql = new StringBuffer();
				 sql.append("INSERT INTO T_YX_MARKETSPMX(SPID,CXID,CTIME,KTIME,JTIME,ZT,GGID,HDSL)VALUES ");
				 for (Map.Entry<String, String> entry : res.entrySet()) {
					 sql.append("(").append(entry.getKey().split("_")[0]).append(",").append(market.getID()).append(",now(),");
					 sql.append("(SELECT KTIME FROM t_yx_market WHERE ID=").append(market.getID()).append("),");
					 sql.append("(SELECT JTIME FROM t_yx_market WHERE ID=").append(market.getID()).append("),");
					 sql.append("(SELECT ZT FROM t_yx_market WHERE ID=").append(market.getID()).append("),");
					 sql.append(entry.getKey().split("_")[1]).append(",").append(entry.getValue());
					 sql.append("),");
				 }
				 sql.deleteCharAt(sql.length()-1);
				 utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
			}
		}
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	public JSONObject addTqProGoods(MarketBean market,Map<String, String> map){
		if(StringUtils.isNotEmpty(market.getCXID())){
			 StringBuffer sql = new StringBuffer();
			 sql.append("INSERT INTO T_YX_MARKETSPMX(CXID,SPID,GGID,MSJG,HDSL,CTIME,KTIME,JTIME)VALUES ");
			 for(Map.Entry<String, String> s : map.entrySet()){
				 sql.append("(").append(market.getCXID()).append(",").append(s.getKey().split("_")[0]).append(",").append(s.getKey().split("_")[1]);
				 sql.append(",").append(s.getKey().split("_")[2]).append(",").append(s.getValue()).append(",now(),");
				 sql.append("(SELECT KTIME FROM t_yx_market WHERE ID=").append(market.getCXID()).append(")").append(",").append("(SELECT JTIME FROM t_yx_market WHERE ID=").append(market.getCXID()).append(")").append("),");
			 }
			 sql.deleteCharAt(sql.length()-1);
			 utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
		}
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	public JSONObject saveTuangou(MarketBean market){
		marketingDao.saveTuangou(market);
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	@Override
	public List<MarketBean> getGoodsMzList(MarketBean market) {
		market.setGZCODE(Constants.YX_CXGZ_MAIZENG);
		return marketingDao.getGoodsMzList(market);
	}
	
	
	@Override
	public int getGoodsMzListCount(MarketBean market) {
		market.setGZCODE(Constants.YX_CXGZ_MAIZENG);
		return marketingDao.getGoodsMzListCount(market);
	}
	
	@Override
	public List<MspBean> getMzGoods(MspBean mspBean) {
		return marketingDao.getMzGoods(mspBean);
	}
	@Override
	public int getMzGoodsTotalCount(MspBean mspBean) {
		return marketingDao.getMzGoodsTotalCount(mspBean);
	}
	
	/**
	 * 
	 * 日期 2016-12-20
	 * 时间 上午11:01:42
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	@Override
	public JSONObject saveMz(MarketBean market) {
		market.setGZCODE(Constants.YX_CXGZ_MAIZENG);//买赠规则
		marketingDao.saveMz(market);
		/*String id = market.getID();
		if (StringUtils.isNotEmpty(id)) {
			String[] ids = market.getYHJIDS();
			sql = new StringBuffer();
			sql.append("INSERT INTO T_YX_MARKETSPMX(CXID,SPID,GGID,MSJG,HDSL,CTIME,KTIME,JTIME,ZT,ISZT)VALUES ");
			for (String s : ids) {
				sql.append("(").append(id).append(",").append(s.split("_")[0])
						.append(",").append(s.split("_")[1]);
				sql.append(",").append(s.split("_")[2]).append(",")
						.append(s.split("_")[3]).append(",now(),");
				sql.append("(SELECT KTIME FROM t_yx_market WHERE ID=")
				.append(market.getID()).append("),");
				sql.append("(SELECT JTIME FROM t_yx_market WHERE ID=")
						.append(market.getID()).append("),");
				sql.append("(SELECT ZT FROM t_yx_market WHERE ID=")
				.append(market.getID()).append("),");
				sql.append(s.split("_")[4]).append("),");
			}
			sql.deleteCharAt(sql.length() - 1);
			utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
		}*/
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	public JSONObject addMzProGoods(MarketBean market,Map<String, String> map){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT T.ID FROM T_YX_MARKET T INNER JOIN T_YX_MARKETSPMX M ON t.ID=m.CXID AND m.ISZT = 0 WHERE t.ID = ").append(market.getCXID()).append(" AND T.SJID =").append(market.getSJID());
		 List<UtileBean> listData = utileDao.getListData(CRMUtil.getMap(sql.toString().trim()));
		 if(listData.size()>=1){
			 return JsonUtil.formatJsonResult("已经绑定主体商品！", false);
		 }
		if(StringUtils.isNotEmpty(market.getCXID())){
			 sql = new StringBuffer();
			 sql.append("INSERT INTO T_YX_MARKETSPMX(CXID,SPID,GGID,MSJG,HDSL,CTIME,KTIME,JTIME,ZT,ISZT)VALUES ");
			 for(Map.Entry<String, String> s : map.entrySet()){
				 sql.append("(").append(market.getCXID()).append(",").append(s.getKey().split("_")[0]).append(",").append(s.getKey().split("_")[1]);
				 sql.append(",").append(s.getKey().split("_")[2]).append(",").append(s.getValue()).append(",now(),");
				 sql.append("(SELECT KTIME FROM t_yx_market WHERE ID=").append(market.getCXID()).append(")").append(",").append("(SELECT JTIME FROM t_yx_market WHERE ID=").append(market.getCXID()).append("),");
				 sql.append("(SELECT ZT FROM t_yx_market WHERE ID=")
					.append(market.getCXID()).append("),");
				 sql.append(s.getKey().split("_")[3]).append("),");
			 }
			 sql.deleteCharAt(sql.length()-1);
			 utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
		}
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	@Override
	public List<MspBean> getMzBandingYhqs(MspBean bean) {
		return marketingDao.getMzBandingYhqs(bean);
	}
	@Override
	public List<MspBean> getMzBandingGoods(MspBean bean) {
		return marketingDao.getMzBandingGoods(bean);
	}
	
	/**
	 * 保存优惠券和赠品
	 * 日期 2016-12-20
	 * 时间 下午2:32:49
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	@Transactional
	public JSONObject saveSetYh(MarketBean market) {
		StringBuffer sql = new StringBuffer();
		String id = market.getID();
		if (StringUtils.isNotEmpty(id)) {
			//保存赠品
			String[] ids = market.getYHJIDS();
			if (ids.length>0) {
				
				Map<String, String> nowmap = new HashMap<String, String>();//已经选择的列表
				StringBuffer concatspidggids = new StringBuffer();
				for (int i = 0; i < ids.length; i++) {//选择的数据
					nowmap.put(ids[i], ids[i]);
					concatspidggids.append(ids[i].split("_")[0]).append(",").append(ids[i].split("_")[1]).append(",");
				}
				concatspidggids.deleteCharAt(concatspidggids.length() - 1);
				//删除不在已选择的列表中数据
				sql = new StringBuffer();
				sql.append("DELETE FROM t_yx_marketspmx WHERE CXID =").append(id).append(" and ISZT='1' and CONCAT(SPID,GGID) NOT in (").append(concatspidggids).append(")");
				utileDao.delData(CRMUtil.getMap(sql.toString().trim()));
				
				MspBean bean = new MspBean();
				bean.setCXID(id);
				List<MspBean> list = marketingDao.getMzBandingGoods(bean);//已绑定的商品
				Map<String, String> map = new HashMap<String, String>();// 已商品id和规格id组合为key
				if (CollectionUtils.isNotEmpty(list)) {//库里已有数据
					for (int i = 0; i < list.size(); i++) {
						map.put(list.get(i).getMSPID() + "_" + list.get(i).getSPGZID()+"_"+list.get(i).getSPRICE()+"_"+list.get(i).getMSJG()+"_1",list.get(i).getMSPID());
					}
				}
				
				
				Map<String, String> res = new HashMap<String, String>();
				for (Map.Entry<String, String> entry : nowmap.entrySet()) {
					if (!map.containsKey(entry.getKey())) {// 获取已新增的
						res.put(entry.getKey(),entry.getKey());
					}
				}
				
				if (res.size()>0) {
					sql = new StringBuffer();
					sql.append("INSERT INTO T_YX_MARKETSPMX(CXID,SPID,GGID,MSJG,HDSL,CTIME,KTIME,JTIME,ZT,ISZT)VALUES ");
					for (Map.Entry<String, String> s : res.entrySet()) {
						sql.append("(").append(id).append(",")
								.append(s.getKey().split("_")[0]).append(",")
								.append(s.getKey().split("_")[1]);
						sql.append(",").append(s.getKey().split("_")[2]).append(",")
								.append(s.getKey().split("_")[3]).append(",now(),");
						sql.append("(SELECT KTIME FROM t_yx_market WHERE ID=")
								.append(market.getID()).append("),");
						sql.append("(SELECT JTIME FROM t_yx_market WHERE ID=")
								.append(market.getID()).append("),");
						sql.append("(SELECT ZT FROM t_yx_market WHERE ID=")
								.append(market.getID()).append("),");
						sql.append(s.getKey().split("_")[4]).append("),");
					}
					sql.deleteCharAt(sql.length() - 1);
					utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
				}
				/*else{//删除减少的选项
					sql = new StringBuffer();
					StringBuffer spids=new StringBuffer();
					StringBuffer spgzids=new StringBuffer();
					for (String s : ids) {
						spids.append(s.split("_")[0]+","+s.split("_")[1]);
						spgzids.append(s.split("_")[1]+",");
					}
					spids.deleteCharAt(spids.length() - 1);
					spgzids.deleteCharAt(spgzids.length() - 1);
					sql.append("DELETE from t_yx_marketspmx WHERE ID in (SELECT ID FROM (SELECT ID FROM t_yx_marketspmx WHERE CXID =").append(id).append(" and ISZT='1'");
					sql.append(" and CONCAT(SPID,ggid) not in (").append(spids).append(")) t)");
					utileDao.delData(CRMUtil.getMap(sql.toString().trim()));
				}*/
			}else{
				//选择列表为空的时候删除该活动的所有赠品
				sql = new StringBuffer();
				sql.append("DELETE FROM t_yx_marketspmx WHERE CXID =").append(id).append(" and ISZT='1'");
				utileDao.delData(CRMUtil.getMap(sql.toString().trim()));
			}
			//保存优惠券
			String[] yhids = market.getYHZPIDS();
			if (yhids.length>0) {
				
				Map<String, String> nowmap = new HashMap<String, String>();//已经选择的列表
				StringBuffer concatspidggids = new StringBuffer();
				for (int i = 0; i < yhids.length; i++) {
					nowmap.put(yhids[i], yhids[i]);
					concatspidggids.append(yhids[i].split("_")[0]).append(",").append(yhids[i].split("_")[1]).append(",");
				}
				concatspidggids.deleteCharAt(concatspidggids.length() - 1);
				sql = new StringBuffer();
				//删除不在已选择的列表中数据
				sql.append("DELETE FROM t_yx_marketspmx WHERE CXID =").append(id).append(" and ISZT='2' and CONCAT(SPID,GGID) NOT in (").append(concatspidggids).append(")");
				utileDao.delData(CRMUtil.getMap(sql.toString().trim()));
				
				
				MspBean bean = new MspBean();
				bean.setCXID(id);
				List<MspBean> list = marketingDao.getMzBandingYhqs(bean);//已绑定的优惠券
				Map<String, String> map = new HashMap<String, String>();// 已商品id和规格id组合为key
				if (CollectionUtils.isNotEmpty(list)) {
					for (int i = 0; i < list.size(); i++) {
						map.put(list.get(i).getMSPID() + "_" + list.get(i).getSPGZ()+"_"+list.get(i).getMSJG()+"_2",list.get(i).getMSPID());
					}
				}
				
				Map<String, String> res = new HashMap<String, String>();
					for (Map.Entry<String, String> entry : nowmap.entrySet()) {
						if (!map.containsKey(entry.getKey())) {// 获取已新增的
							res.put(entry.getKey(),entry.getKey());
						}
					}
				
				if (res.size()>0) {
					sql = new StringBuffer();
					sql.append("INSERT INTO T_YX_MARKETSPMX(CXID,SPID,GGID,HDSL,CTIME,KTIME,JTIME,ZT,ISZT)VALUES ");
					for (Map.Entry<String, String> s : res.entrySet()) {
						sql.append("(").append(id).append(",")
								.append(s.getKey().split("_")[0]).append(",")
								.append(s.getKey().split("_")[1]).append(",");
						sql.append(s.getKey().split("_")[2]).append(",now(),");
						sql.append("(SELECT KTIME FROM t_yx_market WHERE ID=")
								.append(market.getID()).append("),");
						sql.append("(SELECT JTIME FROM t_yx_market WHERE ID=")
								.append(market.getID()).append("),");
						sql.append("(SELECT ZT FROM t_yx_market WHERE ID=")
								.append(market.getID()).append("),");
						sql.append(s.getKey().split("_")[3]).append("),");
					}
					sql.deleteCharAt(sql.length() - 1);
					utileDao.addData(CRMUtil.getMap(sql.toString().trim()));
				}
				/*else{//删除减少的选项
					sql = new StringBuffer();
					StringBuffer spids=new StringBuffer();
					StringBuffer spgzids=new StringBuffer();
					for (String s : yhids) {
						spids.append(s.split("_")[0]+",");
						spgzids.append(s.split("_")[1]+",");
					}
					spids.deleteCharAt(spids.length() - 1);
					spgzids.deleteCharAt(spgzids.length() - 1);
					sql.append("DELETE from t_yx_marketspmx WHERE ID in (SELECT ID FROM (SELECT ID FROM t_yx_marketspmx WHERE CXID =").append(id).append(" and ISZT='2'");
					sql.append(" and SPID not in (").append(spids).append(") and ggid not in (").append(spgzids).append(")) t)");
					utileDao.delData(CRMUtil.getMap(sql.toString().trim()));
				}*/
			}else{
				//选择列表为空的时候删除该活动的所有优惠券
				sql = new StringBuffer();
				sql.append("DELETE FROM t_yx_marketspmx WHERE CXID =").append(id).append(" and ISZT='2'");
				utileDao.delData(CRMUtil.getMap(sql.toString().trim()));
			}
		}
		return JsonUtil.formatJsonResult("操作成功！", true);
	}
	
	
	/**
	 * 查看促销详情-小区信息
	 * 日期 2016-4-28
	 * 时间 下午1:35:15
	 * 创建者 lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getViewProComm(MarketBean market){
		return marketingDao.getViewProComm(market);
	}
	
	/**
	 * 买赠赠品商品
	 * 日期 2017年3月22日
	 * 时间 下午6:06:17
	 * 创建者 Lcc
	 * @param market
	 * @return
	 */
	public List<MarketBean> getMzGoodsList(MarketBean market){
		return marketingDao.getMzGoodsList(market);
	}
	
	public int getMzGoodsListTotal(MarketBean market){
		return marketingDao.getMzGoodsListTotal(market);
	}
	
	/**
	 * 获取文件路径
	 * 日期 2017年3月23日
	 * 时间 下午4:51:53
	 * 创建者 Lcc
	 * @param configName
	 * @return
	 */
	public Map<String, String> getRootPath(String configName,String fileName){
		Map<String, String> map = new HashMap<>();
		String path = ConfigUtil.getProperties("FILE_PATH_ROOT")+ ConfigUtil.getProperties(configName);
		File file = new File(path);
		if (!file.exists())
		{
			file.mkdirs();
		}
		map.put("root", path+fileName);
		map.put("saveroot",ConfigUtil.getProperties(configName)+fileName);
		return map;
	}
	
	public void checkTypeOfImage(UploadBean bean){
		if(StringUtils.isNotBlank(bean.getType())){
			switch (bean.getType()) {
			case "t_yx_gtype":
				bean.setCols("LOGO");
				break;
			case "t_yx_style":
				bean.setCols("TABLE_URL");
				break;
			case "T_YX_VIEW":
				bean.setCols("ICON");
				break;
			case "T_YX_VIEWPOS":
				bean.setCols("URL");
				break;
			default:
				break;
			}
			bean.setTableName(bean.getType());
			utileService.saveFileData(bean);
		}
	}
	
	
	public JSONObject saveUploadFile(HttpServletRequest request,HttpServletResponse response,UploadBean bean) {
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096);// 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			
			fileUpload.setSizeMax(4 * 1024 * 1024);// 文件最大4MB;
			List<?> files = fileUpload.parseRequest(request);
			// 没有文件上传
			if (files == null || files.size() == 0) {
				return JsonUtil.formatJsonResult("上传失败，请选择图片！", false);
			}
			FileItem file = (FileItem) files.get(0);
			long fileSize = file.getSize();
			// 获取文件大小
			long size = Long.parseLong(ConfigUtil.getProperties("FILE_SIZE")) * 1024;
			if (fileSize > size) {
				return JsonUtil.formatJsonResult("上传失败，文件太大！", false);
			}

			String fileName = file.getName();
			// 获取文件后缀名
			String extName = getFileExtName(fileName);
			if (!extName.equalsIgnoreCase("jpg")
					&& !extName.equalsIgnoreCase("png")
					&& !extName.equalsIgnoreCase("gif")) {
				return JsonUtil.formatJsonResult("上传失败，文件名不符合格式！", false);
			}
			Map<String, String> map = getRootPath(bean.getType(),fileName);
			bean.setPath(map.get("saveroot"));
			File uploadFile = new File(map.get("root"));
			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(uploadFile));
			checkTypeOfImage(bean);
			
			return JsonUtil.formatJsonResult("上传成功！", true);

		} catch (Exception e) {
			return JsonUtil.formatJsonResult("上传失败！" + e.getMessage(), false);
		} finally {
			out.close();
		}
	}
	
}
