package cn.tc.ulife.platform.validators;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验注解 
 * 日期 2017年2月23日
 * 时间 上午10:11:08
 * @author lwy
 *
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    public boolean isValidate() default true;  
    public boolean isForm() default false;  
}
