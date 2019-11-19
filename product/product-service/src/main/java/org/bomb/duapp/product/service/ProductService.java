package org.bomb.duapp.product.service;

import org.bomb.duapp.product.api.ProductAPI;
import org.bomb.duapp.product.dto.ProductDto;
import org.bomb.duapp.product.vo.UserInfo;
import org.bomb.duapp.user.dto.UserDto;
import org.bomb.duapp.user.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RestController
public class ProductService  {

    @Autowired
    ProductAPI productAPI;

    @Autowired
    UserClient userClient;

    @GetMapping("/product/user/{userId}")
    public UserInfo getProductByUsersId(@PathVariable("userId") String userId) {
        UserInfo userInfo = new UserInfo();
        UserDto userDto = userClient.getByUserId(userId);
        List<ProductDto> productDtos = productAPI.getProductsByUserId(userId);
        userInfo.setUserDto(userDto);
        userInfo.setProductDtoList(productDtos);
        return userInfo;
    }

    @Autowired
    DiscoveryClient discoveryClient;

//    @Autowired
//    RestTemplate restTemplate;

    //    @Autowired
    //    LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/getServices")
    public Object consulClient() {
        List<ServiceInstance> list = discoveryClient.getInstances("user");
        return list;
    }

//    @GetMapping(value = "/ribbon-call")
//    public String ribbonCall() {
//        String result = restTemplate.getForEntity("http://user/user/1", String.class).getBody();
//        return result;
//    }

//    @GetMapping(value = "/chooseService")
//    public Object chooseService() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("user-8081");
//        return serviceInstance;
//    }

}
