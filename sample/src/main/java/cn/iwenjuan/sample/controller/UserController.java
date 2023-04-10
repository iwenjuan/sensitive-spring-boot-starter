package cn.iwenjuan.sample.controller;

import cn.iwenjuan.sample.domain.User;
import cn.iwenjuan.sample.service.IUserService;
import cn.iwenjuan.sensitive.annotation.Desensitize;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author li1244
 * @date 2023/4/10 11:07
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("")
    @Desensitize
    public User getUser() {

        User user = userService.getUser();
        log.info("脱敏前：{}", JSON.toJSONString(user));
        return user;
    }
}
