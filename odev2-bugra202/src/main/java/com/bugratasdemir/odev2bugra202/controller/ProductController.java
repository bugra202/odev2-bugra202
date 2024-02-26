package com.bugratasdemir.odev2bugra202.controller;


import com.bugratasdemir.odev2bugra202.controller.contract.ProductControllerContract;
import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.general.RestResponse;
import com.bugratasdemir.odev2bugra202.request.ProductBatchUpdatePriceRequest;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;
import com.bugratasdemir.odev2bugra202.request.ProductUpdatePriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;
    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequest request){
        ProductDTO productDTO = productControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll() {
        List<ProductDTO> allProduct = productControllerContract.findAll();
        if (allProduct != null){
            return ResponseEntity.ok(RestResponse.of(allProduct));
        }else
            return ResponseEntity.ok(RestResponse.empty());
    }
    @GetMapping("/with-expirationdate")
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAllByExpirationDateLE(@RequestParam("expirationDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime expirationDate) {
        List<ProductDTO> allProduct = productControllerContract.findAllByExpirationDateLE(expirationDate);
        if (allProduct != null){
            return ResponseEntity.ok(RestResponse.of(allProduct));
        }else
            return ResponseEntity.ok(RestResponse.empty());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.findById(id);
        if (productDTO != null){
            return ResponseEntity.ok(RestResponse.of(productDTO));
        }else
            return ResponseEntity.ok(RestResponse.empty());
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findByCategoryId(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.findByCategoryId(id);
        if (productDTO != null){
            return ResponseEntity.ok(RestResponse.of(productDTO));
        }else
            return ResponseEntity.ok(RestResponse.empty());
    }
    @PatchMapping("/{id}/price")
    public ResponseEntity<RestResponse<ProductDTO>> updatePrice(@PathVariable Long id, @RequestBody ProductUpdatePriceRequest request){
        ProductDTO productDTO = productControllerContract.updatePrice(id,request);
        if (productDTO != null){
            return ResponseEntity.ok(RestResponse.of(productDTO));
        }else
            return ResponseEntity.ok(RestResponse.empty());
    }
    @PatchMapping("/{id}/batchPrice")
    public ResponseEntity<RestResponse<List<ProductDTO>>> updateBatchPrice(@RequestBody ProductBatchUpdatePriceRequest request){
        List<ProductDTO> productDTO = productControllerContract.batchUpdatePrice(request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @PatchMapping("/{id}/activate")
    public ResponseEntity<RestResponse<ProductDTO>> activate(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.activate(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<RestResponse<ProductDTO>> deactivate(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.deactivate(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

}
