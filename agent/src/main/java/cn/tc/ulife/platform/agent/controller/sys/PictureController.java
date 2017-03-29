/**
 * @Title: PictureController
 * @Package cn.tc.ulife.platform.agent.controller.sys
 * @Description: 业务图片信息controller层
 * @author alliswell
 * @date 2017/2/27 14:17
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.tc.ulife.platform.agent.controller.sys;

import cn.tc.ulife.platform.agent.msg.AppResponseMsg;
import cn.tc.ulife.platform.agent.msg.ReturnMsg;
import cn.tc.ulife.platform.server.sys.service.PictureService;
import cn.tc.ulife.platform.server.user.model.UserFront;
import cn.tc.ulife.platform.server.user.service.BaseUserService;
import cn.tc.ulife.platform.util.ConfigUtil;
import cn.tc.ulife.platform.util.UploadFileUtil;
import cn.tc.ulife.platform.util.constance.SysConstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alliswell
 * @Title: PictureController
 * @Package cn.tc.ulife.platform.agent.controller.sys
 * @Description: 业务图片信息controller层
 * @date 2017/2/27 14:17
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @Autowired
    private BaseUserService baseUserService;

    /**
     * 删除图片
     * @param id 图片id
     * @return
     */
    @RequestMapping("delPic")
    @ResponseBody
    public ReturnMsg delPicture(String id)
    {
        pictureService.delPictureByKey(id);
        return AppResponseMsg.success();
    }

    /**
     * 统一上传图片接口
     *
     * @param account 用户账号
     * @param app app类型
     * @param type 1：其他文件，2：社交文件，3：商城文件
     * @param fileNames 数组格式， 图片名称 将图片文件以文件流的形式传给接口
     * @param request
     * @return
     */
    @RequestMapping("/uploadPic")
    @ResponseBody
    public ReturnMsg uploadPic(@RequestParam String account, @RequestParam String app, @RequestParam String type, @RequestParam(value = "fileNames") String fileNames,
                               HttpServletRequest request) {
        // 拒绝未登录用户 上传图片
        UserFront userFront = baseUserService.getUserFront(account);

        if (userFront == null) {
            return AppResponseMsg.userFaild();
        }

        String[] fileNamesArr = fileNames.split(",");
        String[] paths = new String[fileNamesArr.length];
        if ("1".equals(type)) {//其他文件路径
            for (int i = 0; i < fileNamesArr.length; i++) {
                paths[i] = UploadFileUtil.upload(request, fileNamesArr[i],
                                                 ConfigUtil.getProperties(
                                                         "FILE_PATH"),
                                                 SysConstance.UploadPath.OTHER_PATH
                                                         .getValue());
            }
        } else if ("2".equals(type)) {//社交文件路径
            for (int i = 0; i < fileNamesArr.length; i++) {
                paths[i] = UploadFileUtil.upload(request, fileNamesArr[i],
                                                 ConfigUtil.getProperties("FILE_PATH"),
                                                 SysConstance.UploadPath.SOCIAL_PATH.getValue());
            }
        }else if ("3".equals(type)) {//商城文件路径
            for (int i = 0; i < fileNamesArr.length; i++) {
                paths[i] = UploadFileUtil.upload(request, fileNamesArr[i],
                                                 ConfigUtil.getProperties("FILE_PATH"),
                                                 SysConstance.UploadPath.MALL_PATH.getValue());
            }
        }
        if (null == paths || paths.length < 1) {
            return AppResponseMsg.faild("上传失败");
        }
        return AppResponseMsg.success(paths);
    }
}
