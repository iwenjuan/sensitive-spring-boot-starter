package cn.iwenjuan.sensitive.handler;

/**
 * @author li1244
 * @date 2023/4/10 10:43
 */
public interface DesensitizeHandler {

    /**
     * 数据脱敏处理
     *
     * @param origin
     * @return
     */
    String desensitize(String origin);
}
