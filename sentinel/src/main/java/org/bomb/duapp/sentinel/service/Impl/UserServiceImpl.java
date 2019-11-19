package org.bomb.duapp.sentinel.service.Impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.bomb.duapp.sentinel.rule.block.BlockHandlerBean;
import org.bomb.duapp.sentinel.rule.fallback.FallBackBean;
import org.bomb.duapp.sentinel.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Override
    @SentinelResource(value = "hello",
            blockHandlerClass = BlockHandlerBean.class, blockHandler = "sayHello",
            fallbackClass = FallBackBean.class, fallback = "sayHello")
    public String sayHello(String name) {
        if (StringUtils.isEmpty(name)) throw new IllegalArgumentException(" params[name] is null");
        return "hello " + name;
    }

}
