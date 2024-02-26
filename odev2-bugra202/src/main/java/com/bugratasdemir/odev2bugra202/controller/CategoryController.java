package com.bugratasdemir.odev2bugra202.controller;


import com.bugratasdemir.odev2bugra202.controller.contract.CategoryControllerContract;
import com.bugratasdemir.odev2bugra202.dto.CategoryDTO;
import com.bugratasdemir.odev2bugra202.general.RestResponse;
import com.bugratasdemir.odev2bugra202.request.CategorySaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryControllerContract categoryControllerContract;
    @PostMapping
    public ResponseEntity<RestResponse<CategoryDTO>> save(@RequestBody CategorySaveRequest request){
        CategoryDTO categoryDTO = categoryControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(categoryDTO));
    }
    @GetMapping
    public ResponseEntity<RestResponse<List<CategoryDTO>>> findAll(){
        List<CategoryDTO> categoryDTOList = categoryControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(categoryDTOList));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CategoryDTO>> findById(@PathVariable Long id){
        CategoryDTO categoryDTO = categoryControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(categoryDTO));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryControllerContract.delete(id);
    }

}
