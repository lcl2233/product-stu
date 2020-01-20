package org.bomb.duapp.user.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

@Configuration
@Endpoint(id="breathe")
public class BreatheEndPoint{

    @ReadOperation
    public String invoker() {
        return "I am live";
    }
}
