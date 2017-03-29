package cn.tc.ulife.platform.agent.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with platform.
 * </p>
 * PackageName:cn.tc.ulife.platform.agent.web
 * </p>
 * User: wangyue
 * </p>
 * Date: 2017/2/9 0009
 * </p>
 * Time: 下午 4:43
 * </p>
 * Detail:
 * </p>
 */

//@Configuration
//@EnableWebMvc
public class WebConfig  extends WebMvcConfigurerAdapter{

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**");
    }
}
