package cn.iwenjuan.sensitive.handler;

import cn.iwenjuan.sensitive.utils.DesensitizeUtils;
import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 14:37
 */
@Component
public class ChineseNameDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        // 中文姓名脱敏规则：保留第一位
        return DesensitizeUtils.desensitize(origin, 1, 0);
    }

}
