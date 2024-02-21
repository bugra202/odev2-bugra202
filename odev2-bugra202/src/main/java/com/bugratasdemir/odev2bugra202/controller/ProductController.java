package com.bugratasdemir.odev2bugra202.controller;


import com.bugratasdemir.odev2bugra202.controller.contract.ProductControllerContract;
import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.general.RestResponse;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductControllerContract productControllerContract; // servisi çağırmak yerine contract üstünden servisi çağıracağız
    public ProductController(ProductControllerContract productControllerContract) {
        this.productControllerContract = productControllerContract;
    }
    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll(){
        List<ProductDTO> allProduct = productControllerContract.getAllProducts();
        return ResponseEntity.ok(RestResponse.of(allProduct));
    }
    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequest request){
        ProductDTO productDTO = productControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
}
