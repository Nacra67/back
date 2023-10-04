package com.campusdual.api;

import com.campusdual.model.dto.ProductDto;

import java.util.List;

public interface IProductService {
    ProductDto queryProduct(ProductDto productDto);
    List<ProductDto> queryAllProducts();
    int insertProduct(ProductDto productDto);
    int updateProduct(ProductDto productDto);
    int deleteProduct(ProductDto productDto);
    List<ProductDto> queryProductByStockLessThan(ProductDto productDto);
    List<ProductDto> queryProductBYNameEquals (ProductDto productDto);
    List<ProductDto> queryProductByActive (ProductDto productDto);

}
