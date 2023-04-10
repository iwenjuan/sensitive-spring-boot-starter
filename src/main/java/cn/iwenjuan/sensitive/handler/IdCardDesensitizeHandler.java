package cn.iwenjuan.sensitive.handler;

import cn.iwenjuan.sensitive.utils.DataMaskUtils;
import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 14:44
 */
@Component
public class IdCardDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        // 身份证号码脱敏规则：保留前3、后4
        return DataMaskUtils.desensitize(origin, 3, 4);
    }
}
