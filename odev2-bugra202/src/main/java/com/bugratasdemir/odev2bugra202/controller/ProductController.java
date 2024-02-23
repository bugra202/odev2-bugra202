package com.bugratasdemir.odev2bugra202.controller;


import com.bugratasdemir.odev2bugra202.controller.contract.ProductControllerContract;
import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.general.RestResponse;
import com.bugratasdemir.odev2bugra202.request.ProductActivateRequest;
import com.bugratasdemir.odev2bugra202.request.ProductDeactivateRequest;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;
import com.bugratasdemir.odev2bugra202.request.ProductUpdatePriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll() {
        List<ProductDTO> allProduct = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(allProduct));
    }
    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequest request){
        ProductDTO productDTO = productControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findByCategoryId(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.findByCategoryId(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @PatchMapping("/{id}/price")
    public ResponseEntity<RestResponse<ProductDTO>> updatePrice(@PathVariable Long id, @RequestBody ProductUpdatePriceRequest request){
        ProductDTO productDTO = productControllerContract.updatePrice(id,request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @PatchMapping("/{id}/activate")
    public ResponseEntity<RestResponse<ProductDTO>> activate(@PathVariable Long id, @RequestBody ProductActivateRequest request){
        ProductDTO productDTO = productControllerContract.activate(id,request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<RestResponse<ProductDTO>> deactivate(@PathVariable Long id, @RequestBody ProductDeactivateRequest request){
        ProductDTO productDTO = productControllerContract.deactivate(id,request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
}

