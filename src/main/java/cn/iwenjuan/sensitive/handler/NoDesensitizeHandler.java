package cn.iwenjuan.sensitive.handler;

import org.springframework.stereotype.Component;

/**
 * @author li1244
 * @date 2023/1/30 15:58
 */
@Component
public class NoDesensitizeHandler implements DesensitizeHandler {

    @Override
    public String desensitize(String origin) {
        return origin;
    }
}
