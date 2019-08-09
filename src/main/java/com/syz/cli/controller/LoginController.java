package com.syz.cli.controller;

import com.alibaba.fastjson.JSONObject;
import com.syz.cli.entity.User;
import com.syz.cli.init.jwt.PassToken;
import com.syz.cli.init.jwt.UserLoginToken;
import com.syz.cli.service.UserService;
import com.syz.cli.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author syz
 * @date 2019/8/9$ 14:09$
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    @PassToken
    public Object login(@RequestParam("id") String id) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.selectById(id);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        }
        String token = TokenUtils.getToken(userForBase);
        jsonObject.put("token", token);
        jsonObject.put("user", userForBase);
        return jsonObject;
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

}
