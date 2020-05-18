package org.bomb.duapp.mp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnSingleCandidate(PerBean.class)
public class CustomizeConfig {

    private PerBean perBean;

    public void setPerBean(PerBean perBean) {
        System.out.println("=======> CustomizeConfig.setPerBean");
        this.perBean = perBean;
    }

    @Bean
    public AfterBean afterBean() {
        AfterBean afterBean = new AfterBean();
        afterBean.setName("afterBean");
        afterBean.setType("single");

        System.out.println(afterBean.toString());
        return afterBean;
    }
}
