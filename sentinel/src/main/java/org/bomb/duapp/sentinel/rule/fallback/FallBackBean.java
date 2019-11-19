package org.bomb.duapp.sentinel.rule.fallback;

/**
 * 标准熔断降级配置
 */
public class FallBackBean {
    public static String sayHello(String name) {
        return "fall back sayHello";
    }
}
