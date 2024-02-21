package com.bugratasdemir.odev2bugra202.controller;


import com.bugratasdemir.odev2bugra202.controller.contract.ProductControllerContract;
import com.bugratasdemir.odev2bugra202.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductControllerContract productControllerContract; // servisi çağırmak yerine contract üstünden servisi çağıracağız
    public ProductController(ProductControllerContract productControllerContract) {
        this.productControllerContract = productControllerContract;
    }
    @GetMapping
    public List<Product> findAll(){
        List<Product> allProduct = productControllerContract.getAllProducts();
        return allProduct;
    }
}
