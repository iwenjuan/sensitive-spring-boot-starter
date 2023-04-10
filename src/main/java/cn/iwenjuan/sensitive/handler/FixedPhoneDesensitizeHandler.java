package cn.iwenjuan.sensitive.handler;

import cn.iwenjuan.sensitive.utils.DataMaskUtils;
import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 14:46
 */
@Component
public class FixedPhoneDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        // 座机脱敏规则：保留前4、后2
        return DataMaskUtils.desensitize(origin, 4, 2);
    }
}
