/**
 * @Title: SysController
 * @Package cn.tc.ulife.platform.agent.controller.sys
 * @Description: 系统公共模块controller层
 * @author cxs
 * @date 2017/2/14 13:48
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.agent.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tc.ulife.platform.agent.base.BaseController;
import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.msg.send.SmsFactory;
import cn.tc.ulife.platform.msg.send.bean.SmsBean;
import cn.tc.ulife.platform.server.sys.model.AppSignedEntity;
import cn.tc.ulife.platform.server.sys.model.FwMsgEntity;
import cn.tc.ulife.platform.server.sys.model.SmsCodeBean;
import cn.tc.ulife.platform.server.sys.service.SmsService;
import cn.tc.ulife.platform.server.sys.service.SysService;
import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.StringUtil;
import cn.tc.ulife.platform.util.UtilToString;
import cn.tc.ulife.platform.util.constance.Constance;
import cn.tc.ulife.platform.util.constance.SysConstance;

/**
 * @author cxs
 * @ClassName: SysController
 * @Description: 系统公共模块controller层
 * @date 2017/2/14 13:48
 */
@Controller
@RequestMapping("/sys")
public class SysController extends BaseController {

	@Autowired
	private SysService sysService;

	@Autowired
	private SmsService smsService;

	/**
	 * 获取系统公告
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            来源
	 * @param type
	 *            1：系统最新通告消息，2：用户通告消息列表
	 * @param ofset
	 *            页数
	 * @param psize
	 *            条数
	 * @return
	 */
	@RequestMapping("/getNotice")
	@ResponseBody
	public ReturnMsg getSysNotice(String account, String app, String type, String ofset, String psize) {
		Map<String, Object> pageMap = checkPage(ofset, psize);
		List<FwMsgEntity> list = sysService.querySysNotice(type, (Integer) pageMap.get("ofset"),
				(Integer) pageMap.get("psize"));

		pageMap.clear();
		pageMap.put("totalCount", sysService.getSysNoticeTotal());
		pageMap.put("notice", list);
		if (list == null || list.size() <= 0) {
			logger.info("无系统通告");
			return AppResponseMsg.faild();
		} else {
			logger.info("查询系统通告成功");
			return AppResponseMsg.success(list, sysService.getSysNoticeTotal());
		}
	}

	/**
	 * 添加系统公告
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            来源
	 * @param title
	 *            公告标题
	 * @param msg
	 *            公告内容
	 * @return
	 */
	@RequestMapping("/addNotice")
	@ResponseBody
	public ReturnMsg addSysNotice(String account, String app, String title, String msg) {
		String uid = account;
		int num = sysService.addSysNotice(uid, title, msg);
		if (num == 0) {
			logger.info("添加系统公告失败");
			return AppResponseMsg.faild();
		} else {
			logger.info("添加系统公告成功");
			return AppResponseMsg.success();
		}
	}

	/**
	 * 修改系统公告
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            来源
	 * @param id
	 *            公告id
	 * @param zt
	 *            1：发布生效，2：停用无效， 3：删除
	 * @return
	 */
	@RequestMapping("/updNotice")
	@ResponseBody
	public ReturnMsg updateSysNotice(String account, String app, String id, String zt) {
		int num = sysService.updateSysNotice(id, zt);
		if (num == 0) {
			logger.info("修改系统公告失败");
			return AppResponseMsg.faild();
		} else {
			logger.info("修改系统公告成功");
			return AppResponseMsg.success();
		}
	}

	/**
	 * 获取系统积分规则
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            来源
	 * @return
	 */
	@RequestMapping("/getIntegralRules")
	@ResponseBody
	public ReturnMsg getIntegralRules(String account, String app) {
		List<AppSignedEntity> list = sysService.queryIntegralRules();

		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("totalCount", sysService.getIntegralRuleTotal());
		pageMap.put("integralRule", list);

		if (list == null || list.size() <= 0) {
			logger.info("获取系统积分规则失败");
			return AppResponseMsg.faild();
		} else {
			logger.info("获取系统积分规则成功");
			return AppResponseMsg.success(list, sysService.getIntegralRuleTotal());
		}
	}

	/**
	 * 修改系统积分规则
	 *
	 * @param account
	 *            用户账号
	 * @param app
	 *            来源
	 * @param id
	 *            积分规则id
	 * @param integral
	 *            积分
	 * @return
	 */
	@RequestMapping("/updIntegralRule")
	@ResponseBody
	public ReturnMsg updateIntegralRule(String account, String app, String id, String integral) {
		int num = sysService.updateIntegralRule(id, integral);
		if (num == 0) {
			logger.info("修改系统积分规则失败");
			return AppResponseMsg.faild();
		} else {
			logger.info("修改系统积分规则成功");
			return AppResponseMsg.success();
		}
	}

	/**
	 * 验证码短信发送接口
	 * 
	 * @param mobile
	 *            接收方号码
	 * @param type
	 *            发送类型 0 注册 1 修改 ， 2 群发类型 ， 3 带内容
	 * @param text
	 *            带内容
	 * @param account
	 *            用户ID
	 * @return
	 */
	@RequestMapping("/sendSms")
	@ResponseBody
	public ReturnMsg sendSms(String account, String mobile, String type, String text) {

		if (!StringUtil.isEmpty(mobile) && !StringUtil.isEmpty(type)) {
			// 注册 普通短信验证码， 需要做以下判断， 当天最多发送三次 ， 同时需要判断手机号是否已经注册
			if (Constance.DEFAULT_ZERO.equals(type)) {

				List<SmsCodeBean> smsCodes = smsService.querySmscode(mobile);
				// 未注册 可以发送验证码
				if (null == smsCodes || smsCodes.isEmpty()) {

					int rcode = sendCode(mobile, account);
					if (rcode > 0) {
						// "发送成功";
						return AppResponseMsg.success("发送成功" + rcode);
					}

				}
				// 达到当天最大量，不能再发送
				else if (smsCodes.size() >= Integer.valueOf(ConfigUtil.getProperties("MAX_SMS"))) {
					return AppResponseMsg.faild("短信发送"+ConfigUtil.getProperties("MAX_SMS")+"次了，不能再发了");
				} else {
					SmsCodeBean scode = smsCodes.get(0);

					// 可以发送短信
					if (StringUtil.isEmpty(scode.getMOBILE())) {

						int rcode = sendCode(mobile, account);
						if (rcode > 0) {
							// "发送成功";
							return AppResponseMsg.success("发送成功" + rcode);
						}
					}
					// 已经注册，不能发送
					else {
						return AppResponseMsg.faild("该用户已经注册了");
					}

				}

			}

			// 群发短信， 暂定不处理
			// if (Constance.DEFAULT_ONE.equals(type)) {
			//
			// }

			// 带内容短信 站定不处理
			// if (Constance.DEFAULT_THREE.equals(type)) {
			//
			// }
		}

		return AppResponseMsg.faild("发送失败");
	}

	/**
	 * 合并发送验证码方法
	 * 
	 * @param mobile
	 * @param account
	 * @return
	 */
	private int sendCode(String mobile, String account) {
		int code = UtilToString.getSms();
		
		SmsBean sb = new SmsBean();
		if (1 == sb.getSms_type()) {
			// ali
			Map<String, String> txt = new HashMap<String, String>();
			txt.put("code", code+"");
			 
			String contxt = JSONObject.valueToString(txt);
			sb.setSignName(ConfigUtil.getMsgProperties("SMS_ALI_SIGNNAME_1"));
			sb.setTempCode(ConfigUtil.getMsgProperties("SMS_ALI_REGIST_CODE"));
			sb.setTxt(contxt);

		} else if (2 == sb.getSms_type()) {
			// sm
			StringBuffer contxt = new StringBuffer();
			contxt.append("@1@=").append(code);			 
			sb.setTempCode(ConfigUtil.getMsgProperties("SMS_SM_TEMPID"));
			sb.setTxt(contxt.toString());

		}
		sb.setRecNum(mobile);
		
		String rmsg  = SmsFactory.send(sb);
		
		//String rmsg = SendSMS.sendTemplateSms(mobile, ConfigUtil.getProperties("TEMPID"), "@1@=" + code);
		int rcode = 0;
		if (Constance.RESP_TRUE.equals(rmsg)) {
			SmsCodeBean smsCode = new SmsCodeBean();
			smsCode.setAPP(SysConstance.RequestOly.CRM.getValue() + "");
			smsCode.setCODE(code + "");
			smsCode.setMOBILE(mobile);
			smsCode.setSEND_TYPE(SysConstance.SmsCodeGet.REGIST.getValue() + "");
			smsCode.setUID(account);
			smsCode.setMAXTIME(ConfigUtil.getProperties("MAX_TIME"));
			rcode = smsService.insertSmscode(smsCode);
		}
		return rcode;
	}
}
