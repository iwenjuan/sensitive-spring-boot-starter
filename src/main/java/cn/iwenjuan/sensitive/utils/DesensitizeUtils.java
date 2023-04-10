package cn.iwenjuan.sensitive.utils;

/**
 * @author li1244
 * @date 2023/1/5 14:15
 */
public class DesensitizeUtils {

    /**
     * 对字符串进行脱敏操作
     *
     * @param origin       原始字符串
     * @param prefixLength 左侧需要保留几位明文字段
     * @param suffixLength 右侧需要保留几位明文字段
     * @return 脱敏后结果
     */
    public static String desensitize(String origin, int prefixLength, int suffixLength) {
        return desensitize(origin, prefixLength, suffixLength, "*");
    }

    /**
     * 对字符串进行脱敏操作
     *
     * @param origin       原始字符串
     * @param prefixLength 左侧需要保留几位明文字段
     * @param suffixLength 右侧需要保留几位明文字段
     * @param maskStr      用于遮罩的字符串, 如'*'
     * @return 脱敏后结果
     */
    public static String desensitize(String origin, int prefixLength, int suffixLength, String maskStr) {
        if (origin == null || origin.trim().length() == 0) {
            return origin;
        }
        if (maskStr == null) {
            maskStr = "";
        }
        StringBuilder builder = new StringBuilder();
        char[] charArray = origin.toCharArray();
        for (int i = 0, length = charArray.length; i < length; i++) {
            if (i < prefixLength) {
                builder.append(charArray[i]);
                continue;
            }
            if (i > (length - suffixLength - 1)) {
                builder.append(charArray[i]);
                continue;
            }
            builder.append(maskStr);
        }
        return builder.toString();
    }

}
