package cn.iwenjuan.sensitive.annotation;

import java.lang.annotation.*;

/**
 * @author li1244
 * @date 2023/2/16 16:01
 */
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Desensitize {
}
