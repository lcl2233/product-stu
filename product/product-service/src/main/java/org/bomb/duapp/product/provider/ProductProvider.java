package org.bomb.duapp.product.provider;

import org.bomb.duapp.product.api.ProductAPI;
import org.bomb.duapp.product.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductProvider implements ProductAPI {

    @Override
    public List<ProductDto> getProductsByUserId(String userId) {
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setTitle("麻辣小龙虾");
        productDto.setPrice(new BigDecimal(200));
        return new ArrayList<ProductDto>(){{add(productDto);}};
    }
}
