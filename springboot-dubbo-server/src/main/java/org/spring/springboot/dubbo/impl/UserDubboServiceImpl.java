package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.spring.springboot.domain.User;
import org.spring.springboot.dubbo.UserDubboService;

@Service(version = "1.0.0")
public class UserDubboServiceImpl implements UserDubboService {



    public User saveUser(User user) {
        user.setId(1);
        System.out.println(user.toString());
        return user;
    }
}
