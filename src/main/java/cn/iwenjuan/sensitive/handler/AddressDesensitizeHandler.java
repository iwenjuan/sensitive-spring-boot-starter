package cn.iwenjuan.sensitive.handler;

import cn.iwenjuan.sensitive.utils.DesensitizeUtils;
import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 14:57
 */
@Component
public class AddressDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        // 地址脱敏规则：如果包含省、市、区/县等关键字，保留关键字之前的；如果不包含省、市、区/县等关键字，保留前6位
        if (origin.contains("区")) {
            String prefix = origin.substring(0, origin.indexOf("区") + 1);
            String suffix = origin.substring(origin.indexOf("区") + 1);
            return prefix.concat(DesensitizeUtils.desensitize(suffix, 0, 0));
        }
        if (origin.contains("县")) {
            String prefix = origin.substring(0, origin.indexOf("县") + 1);
            String suffix = origin.substring(origin.indexOf("县") + 1);
            return prefix.concat(DesensitizeUtils.desensitize(suffix, 0, 0));
        }
        if (origin.contains("市")) {
            String prefix = origin.substring(0, origin.indexOf("市") + 1);
            String suffix = origin.substring(origin.indexOf("市") + 1);
            return prefix.concat(DesensitizeUtils.desensitize(suffix, 0, 0));
        }
        if (origin.contains("省")) {
            String prefix = origin.substring(0, origin.indexOf("省") + 1);
            String suffix = origin.substring(origin.indexOf("省") + 1);
            return prefix.concat(DesensitizeUtils.desensitize(suffix, 0, 0));
        }
        return DesensitizeUtils.desensitize(origin, 6, 0);
    }
}
