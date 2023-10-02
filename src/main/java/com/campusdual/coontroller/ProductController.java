package com.campusdual.coontroller;

import com.campusdual.api.IProductService;
import com.campusdual.model.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/test")
    public String testController() {
        return "no quedan aceitunas";
    }

    @PostMapping("/test")
    public String testController(@RequestBody String name) {
        return "hello " + name + " volvemos a tener aceitunas";
    }

    @PostMapping("/get")
    public ProductDto queryProduct(@RequestBody ProductDto productDto) {
        return productService.queryProduct(productDto);
    }

    @GetMapping("/getAll")
    public List<ProductDto> queryAllProducts() {
        return productService.queryAllProducts();
    }

    @PostMapping("/add")
    public int addProduct(@RequestBody ProductDto productDto) {
        return productService.insertProduct(productDto);
    }

    @PostMapping("/update")
    public int updateProdduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct((productDto));
    }

    @PostMapping("/delete")
    public int deleteProduct(@RequestBody ProductDto productDto) {
        return productService.deleteProduct(productDto);
    }

    @PostMapping("/active")
    public List<ProductDto> activeProducts(@RequestBody ProductDto productDto) {
        return productService.queryProductByActive(productDto);
    }

    @PostMapping("/lowStock")
    public List<ProductDto> lowStockProducts(@RequestBody ProductDto productDto) {
        return productService.queryProductByStockLessThan(productDto);
    }

    @PostMapping("/name")
    public List<ProductDto> nameProducts(@RequestBody ProductDto productDto) {
        return productService.queryProductBYNameEquals(productDto);
    }
}
