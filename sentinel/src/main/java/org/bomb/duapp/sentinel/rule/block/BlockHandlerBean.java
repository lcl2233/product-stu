package org.bomb.duapp.sentinel.rule.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 流控标准配置：static方法、参数相同、BlockException
 */
public class BlockHandlerBean {
    public static String sayHello(String name, BlockException e) {
        return "block hand sayHello";
    }
}
