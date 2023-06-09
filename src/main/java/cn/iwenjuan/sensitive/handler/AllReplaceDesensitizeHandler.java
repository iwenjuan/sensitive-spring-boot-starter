package cn.iwenjuan.sensitive.handler;

import cn.iwenjuan.sensitive.utils.DesensitizeUtils;
import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/5 15:31
 */
@Component
public class AllReplaceDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        return DesensitizeUtils.desensitize(origin, 0, 0);
    }
}
