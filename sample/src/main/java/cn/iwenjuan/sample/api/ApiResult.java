package cn.iwenjuan.sample.api;

import cn.iwenjuan.sensitive.annotation.Desensitize;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author danli
 * @date 2023/5/22 16:18
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApiResult {

    private int code;

    private String msg;

    @Desensitize
    private Object data;
}
