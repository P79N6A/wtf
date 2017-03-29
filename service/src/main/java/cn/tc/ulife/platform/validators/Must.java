package cn.tc.ulife.platform.validators;
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;

/**
 * 必须的 
 * 日期 2017年2月23日
 * 时间 上午10:10:55
 * @author lwy
 *
 */
@Target(ElementType.FIELD)  
@Retention(RetentionPolicy.RUNTIME) 
public @interface Must {
    public boolean isMust() default true;  
}
