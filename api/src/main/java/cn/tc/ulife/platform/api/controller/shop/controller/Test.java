package cn.tc.ulife.platform.api.controller.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with tcplatform.
 * </p>
 * PackageName:cn.tc.platform.cn
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/8 0008
 * </p>
 * Time: 上午 10:02
 * </p>
 * Detail:
 * </p>
 */
@Controller
@RequestMapping(value = "/test")
public class Test {


    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        String s = request.getHeader("sss");
//        try {
//            SpringContextUtil.
//            System.out.println(SpringContextUtil.containsBean("resService"));

        System.out.println("111");
//        SysConstance.ADMIN.
//            resService.test("2333");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("22");
        return "55";

    }
}
