package org.bomb.duapp.sharding.common;

import org.bomb.duapp.sharding.entity.User;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigCommon implements EnvironmentAware {

    public ConfigCommon() {
        System.out.println("=====> this ConfigCommon construct");
    }

    @Bean
    public User auth(){
        System.out.println("=====> auto config auth user");
        return new User();
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("=====> this ConfigCommon setEnvironment");
    }
}
