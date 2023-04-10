package cn.iwenjuan.sensitive.aspect;

import cn.iwenjuan.sensitive.annotation.Desensitize;
import cn.iwenjuan.sensitive.annotation.DesensitizeField;
import cn.iwenjuan.sensitive.context.SpringApplicationContext;
import cn.iwenjuan.sensitive.enums.SensitiveType;
import cn.iwenjuan.sensitive.handler.DesensitizeHandler;
import cn.iwenjuan.sensitive.handler.NoDesensitizeHandler;
import cn.iwenjuan.sensitive.utils.BeanUtils;
import cn.iwenjuan.sensitive.utils.DesensitizeUtils;
import cn.iwenjuan.sensitive.utils.ObjectUtils;
import cn.iwenjuan.sensitive.utils.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author li1244
 * @date 2023/2/16 16:00
 */
@Aspect
@Component
public class DesensitizeAspect {

    @Pointcut("@annotation(cn.iwenjuan.sensitive.annotation.Desensitize)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object object = joinPoint.proceed();
        // 脱敏处理
        desensitize(object);
        return object;
    }

    /**
     * 脱敏处理
     * @param object
     */
    private void desensitize(Object object) {
        if (object == null) {
            return;
        }
        // 集合处理
        if (object instanceof Collection) {
            Collection<Object> objectList = (Collection<Object>) object;
            for (Object o : objectList) {
                desensitize(o);
            }
            return;
        }
        // 数组处理
        if (ObjectUtils.isArray(object)) {
            Object[] objectArray = ObjectUtils.toObjectArray(object);
            for (Object o : objectArray) {
                desensitize(o);
            }
            return;
        }
        Class<?> beanClass = object.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();
            // 字段名首字母变大写，例如：userName --> UserName，后续获取getter/setter方法名
            String changeFirstCharacterCase = StringUtils.firstCharacterToUpperCase(fieldName);
            String getterMethodName = "get".concat(changeFirstCharacterCase);
            String setterMethodName = "set".concat(changeFirstCharacterCase);
            Desensitize desensitize = field.getAnnotation(Desensitize.class);
            if (desensitize != null) {
                desensitize(invokeGetterMethod(object, getterMethodName));
                continue;
            }
            DesensitizeField desensitizeField = field.getAnnotation(DesensitizeField.class);
            if (desensitizeField != null && fieldType == String.class) {
                String origin = (String) invokeGetterMethod(object, getterMethodName);
                invokeSetterMethod(object, setterMethodName, fieldType, desensitize(origin, desensitizeField));
            }
        }
    }

    /**
     * 执行get方法
     * @param object
     * @param getterMethodName
     * @return
     */
    private Object invokeGetterMethod(Object object, String getterMethodName) {
        try {
            Method getterMethod = BeanUtils.getMethod(object, getterMethodName);
            return getterMethod.invoke(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 执行set方法
     * @param object
     * @param setterMethodName
     * @param parameterType
     * @param value
     */
    private void invokeSetterMethod(Object object, String setterMethodName, Class<?> parameterType,  String value) {
        try {
            Method setterMethod = BeanUtils.getMethod(object, setterMethodName, parameterType);
            setterMethod.invoke(object, value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符串脱敏处理
     * @param origin
     * @param desensitizeField
     * @return
     */
    private String desensitize(String origin, DesensitizeField desensitizeField) {
        if (StringUtils.isBlank(origin)) {
            return origin;
        }
        // 先按照已有的脱敏类型处理
        SensitiveType sensitiveType = desensitizeField.type();
        if (sensitiveType != null && sensitiveType != SensitiveType.CUSTOM) {
            DesensitizeHandler handler = SpringApplicationContext.getBean(sensitiveType.getHandlerBeanClass());
            return handler.desensitize(origin);
        }
        // 自定义脱敏类型处理
        Class<? extends DesensitizeHandler> handlerBeanClass = desensitizeField.handler();
        if (handlerBeanClass != null && handlerBeanClass != NoDesensitizeHandler.class) {
            DesensitizeHandler handler = SpringApplicationContext.getBean(handlerBeanClass);
            return handler.desensitize(origin);
        }
        // 按照DataMaskField配置的脱敏规则处理
        return DesensitizeUtils.desensitize(origin, desensitizeField.prefixLength(), desensitizeField.suffixLength(), desensitizeField.symbol());
    }
}
