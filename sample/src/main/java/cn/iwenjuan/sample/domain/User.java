package cn.iwenjuan.sample.domain;

import cn.iwenjuan.sensitive.annotation.DesensitizeField;
import cn.iwenjuan.sensitive.enums.SensitiveType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author li1244
 * @date 2023/4/10 10:58
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {

    /**
     * 主键
     */
    private Long id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    @DesensitizeField(type = SensitiveType.PASSWORD)
    private String password;
    /**
     * 昵称
     */
    @DesensitizeField(type = SensitiveType.CHINESE_NAME)
    private String nickName;
    /**
     * 身份证号码
     */
    @DesensitizeField(type = SensitiveType.ID_CARD)
    private String idCard;
    /**
     * 座机号码
     */
    @DesensitizeField(type = SensitiveType.FIXED_PHONE)
    private String fixedPhone;
    /**
     * 手机号码
     */
    @DesensitizeField(type = SensitiveType.CUSTOM, prefixLength = 3, suffixLength = 4)
    private String mobilePhone;
    /**
     * 住址
     */
    @DesensitizeField(type = SensitiveType.ADDRESS)
    private String address;
    /**
     * 邮箱
     */
    @DesensitizeField(type = SensitiveType.EMAIL)
    private String email;
    /**
     * 银行卡号
     */
    @DesensitizeField(type = SensitiveType.BANK_CARD)
    private String bankCard;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
