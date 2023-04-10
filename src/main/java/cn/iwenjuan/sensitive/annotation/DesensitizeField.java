package cn.iwenjuan.sensitive.annotation;

import cn.iwenjuan.sensitive.enums.SensitiveType;
import cn.iwenjuan.sensitive.handler.DesensitizeHandler;
import cn.iwenjuan.sensitive.handler.NoDesensitizeHandler;

import java.lang.annotation.*;

/**
 * @author li1244
 * @date 2023/1/5 13:41
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DesensitizeField {

    /**
     * 脱敏数据类型
     */
    SensitiveType type();
    /**
     * 前置不需要打码的长度
     */
    int prefixLength() default 0;
    /**
     * 后置不需要打码的长度
     */
    int suffixLength() default 0;
    /**
     * 用什么打码
     */
    String symbol() default "*";
    /**
     * 自定义数据脱敏处理类
     */
    Class<? extends DesensitizeHandler> handler() default NoDesensitizeHandler.class;

}
