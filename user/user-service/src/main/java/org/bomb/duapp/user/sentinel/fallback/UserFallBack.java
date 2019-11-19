package org.bomb.duapp.user.sentinel.fallback;

public class UserFallBack {

    public static String login(String username, String password) {
        return "网络开小差了，请稍后重试！";
    }
}
