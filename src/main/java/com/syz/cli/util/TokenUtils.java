package com.syz.cli.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.syz.cli.entity.User;

/**
 * @author syz
 * @date 2019/8/9$ 13:59$
 */
public class TokenUtils {

    public static String getToken(User user) {
        String token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
