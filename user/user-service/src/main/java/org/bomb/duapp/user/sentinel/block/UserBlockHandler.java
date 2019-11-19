package org.bomb.duapp.user.sentinel.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class UserBlockHandler {
    public static String login(String username, String password, BlockException e) {
        return "登陆接口限流啦..";
    }
}
