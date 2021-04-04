package com.strr.mall.system;

import com.strr.mall.system.entity.User;
import com.strr.mall.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("abc123"));
        user.setNickname("管理员");
        user.setEmail("admin@example.com");
        //user.setAvatar("");
        //user.setRemark("");
        user.setStatus(1);
        userService.save(user);
    }
}
