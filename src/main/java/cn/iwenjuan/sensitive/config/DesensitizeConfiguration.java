package cn.iwenjuan.sensitive.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author li1244
 * @date 2023/4/10 10:45
 */
@Configuration
@ComponentScan(basePackages = {
        "cn.iwenjuan.sensitive.aspect",
        "cn.iwenjuan.sensitive.context",
        "cn.iwenjuan.sensitive.handler"
})
public class DesensitizeConfiguration {
}
