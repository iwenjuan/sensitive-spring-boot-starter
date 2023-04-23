package cn.iwenjuan.sensitive.enums;

import cn.iwenjuan.sensitive.handler.*;

/**
 * @author li1244
 * @date 2023/4/10 10:42
 */
public enum SensitiveType {

    /**
     * 中文名
     */
    CHINESE_NAME(ChineseNameDesensitizeHandler.class),
    /**
     * 身份证号
     */
    ID_CARD(IdCardDesensitizeHandler.class),
    /**
     * 电话
     */
    FIXED_PHONE(FixedPhoneDesensitizeHandler.class),
    /**
     * 手机
     */
    MOBILE_PHONE(MobilePhoneDesensitizeHandler.class),
    /**
     * 地址
     */
    ADDRESS(AddressDesensitizeHandler.class),
    /**
     * 邮箱
     */
    EMAIL(EmailDesensitizeHandler.class),
    /**
     * 银行卡号
     */
    BANK_CARD(BankCardDesensitizeHandler.class),
    /**
     * 密码
     */
    PASSWORD(PasswordDesensitizeHandler.class),
    /**
     * 全部脱敏
     */
    ALL_REPLACE(AllReplaceDesensitizeHandler.class),
    /**
     * 自定义
     */
    CUSTOM(null);

    private Class<? extends DesensitizeHandler> handlerBeanClass;

    SensitiveType(Class<? extends DesensitizeHandler> handlerBeanClass) {
        this.handlerBeanClass = handlerBeanClass;
    }

    public Class<? extends DesensitizeHandler> getHandlerBeanClass() {
        return handlerBeanClass;
    }
}
