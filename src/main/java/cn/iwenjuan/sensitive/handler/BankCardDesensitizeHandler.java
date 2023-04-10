package cn.iwenjuan.sensitive.handler;

import cn.iwenjuan.sensitive.utils.DesensitizeUtils;
import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 15:01
 */
@Component
public class BankCardDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        // 银行卡号脱敏规则：保留前6、后4
        return DesensitizeUtils.desensitize(origin, 6, 4);
    }
}
