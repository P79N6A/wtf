/**
 *
 */
package cn.tc.ulife.platform.agent.componet;

import java.lang.annotation.*;

/**
 * @author wy
 */
@Target(
        {ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    /**
     * 方法描述
     *
     * @return ""
     */
    String description() default "";

    /**
     * 方法类型
     *
     * @return ""
     */
    String ozt() default "";
}
