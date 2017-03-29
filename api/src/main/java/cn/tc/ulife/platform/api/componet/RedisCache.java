package cn.tc.ulife.platform.api.componet;


import java.lang.annotation.*;

/**
 * Created with ULife.
 * </p>
 * PackageName:cn.tc.ulife.componet
 * </p>
 * User: wangyue
 * </p>
 * Date: 2016/4/19 0019
 * </p>
 * Time: 下午 3:09
 * </p>
 * Detail:
 * </p>
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {

    String key();

    /**
     * key 组合策略  0:单独key ，1：一级组合key,类推
     *
     * @return
     */
    int level() default 0;


    /**
     * 数据级别
     *
     * @return 0 单个对象 ， 1 list
     */
    int dataType() default 0;

    int expireTime() default -1;
}
