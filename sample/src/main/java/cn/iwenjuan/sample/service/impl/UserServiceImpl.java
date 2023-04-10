package cn.iwenjuan.sample.service.impl;

import cn.iwenjuan.sample.domain.User;
import cn.iwenjuan.sample.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author li1244
 * @date 2023/4/10 11:01
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Override
    public User getUser() {
        User user = new User()
                .setId(1L)
                .setUsername("zhangsan")
                .setPassword("123456")
                .setNickName("张星星")
                .setIdCard("110101199003078689")
                .setFixedPhone("051380661158")
                .setMobilePhone("13925872803")
                .setAddress("江苏省苏州市吴中区木渎镇云山诗意14-1203")
                .setEmail("13925872803@163.com")
                .setBankCard("6212264100043510829");
        return user;
    }
}
