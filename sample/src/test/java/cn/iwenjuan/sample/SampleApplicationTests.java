package cn.iwenjuan.sample;

import cn.iwenjuan.sample.api.ApiResult;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import javax.annotation.Resource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleApplicationTests {

    @Resource
    private TestRestTemplate testRestTemplate;

    @Test
    void contextLoads() {

        ApiResult result = testRestTemplate.getForObject("/user", ApiResult.class);
        System.out.println("接口返回结果：" + JSONObject.toJSONString(result));
    }

}
