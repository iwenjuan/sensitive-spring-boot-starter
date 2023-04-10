package cn.iwenjuan.sensitive.handler;

import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 15:04
 */
@Component
public class PasswordDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        // 密码脱敏规则：返回空
        return null;
    }
}
