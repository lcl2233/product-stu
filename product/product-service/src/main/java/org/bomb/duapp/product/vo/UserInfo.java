package org.bomb.duapp.product.vo;

import org.bomb.duapp.product.dto.ProductDto;
import org.bomb.duapp.user.dto.UserDto;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    private UserDto userDto;
    private List<ProductDto> productDtoList;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }
}
