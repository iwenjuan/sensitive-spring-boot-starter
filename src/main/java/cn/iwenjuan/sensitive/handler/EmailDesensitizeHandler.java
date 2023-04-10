package cn.iwenjuan.sensitive.handler;

import cn.iwenjuan.sensitive.utils.DataMaskUtils;
import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 14:58
 */
@Component
public class EmailDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        // 邮箱脱敏规则：保留”@“之后的所有；保留”@“之前的前3位
        String prefix = origin.substring(0, origin.lastIndexOf("@"));
        String suffix = origin.substring(origin.lastIndexOf("@"));
        return DataMaskUtils.desensitize(prefix, 3, 0).concat(suffix);
    }

}
