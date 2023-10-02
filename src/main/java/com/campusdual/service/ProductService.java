package com.campusdual.service;

import com.campusdual.api.IProductService;
import com.campusdual.model.Product;
import com.campusdual.model.dao.ProductDao;
import com.campusdual.model.dto.ProductDto;
import com.campusdual.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Service("ProductService")
@Lazy
public class ProductService implements IProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public ProductDto queryProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        Product productResult= productDao.getReferenceById(product.getId());
        ProductDto resultado = ProductMapper.INSTANCE.toDto(productResult);
        return resultado;
    }

    @Override
    public List<ProductDto> queryAllProducts() {
        List<Product> productList = productDao.findAll();
        List<ProductDto> result = ProductMapper.INSTANCE.toDtoList(productList);
        return result;
    }

    @Override
    public int insertProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        productDao.saveAndFlush(product);
        return product.getId();
    }

    @Override
    public int updateProduct(ProductDto productDto) {

        return insertProduct(productDto);
    }

    @Override
    public int deleteProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        productDao.delete(product);
        return productDto.getId();
    }


    public List<ProductDto> queryProductBYNameEquals(ProductDto productDto) {
        String name = productDto.getName();
        List<Product> productList = productDao.findByNameEquals(name);
        return ProductMapper.INSTANCE.toDtoList(productList);
    }


    public List<ProductDto> queryProductByStockLessThan(ProductDto productDto) {
        Integer stock = productDto.getStock();
        List<Product> productList = productDao.findByStockLessThan(stock);
        return ProductMapper.INSTANCE.toDtoList(productList);
    }


    public List<ProductDto> queryProductByActive(ProductDto productDto) {
        Boolean active = productDto.getActive();
        List<Product> productList = productDao.findByActiveIs(active);
        return ProductMapper.INSTANCE.toDtoList(productList);
    }


}
