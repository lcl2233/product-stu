package org.bomb.duapp.product.api;

import org.bomb.duapp.product.dto.ProductDto;

import java.util.List;

public interface ProductAPI {
    List<ProductDto> getProductsByUserId(String userId);
}
