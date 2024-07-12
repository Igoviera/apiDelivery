package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Category;
import com.igo.apiDelivery.service.CategoryService;
import com.igo.apiDelivery.service.imp.CategoryServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/categorys")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAllCaterory(){
        return categoryService.findAllCategory();
    }
    @PostMapping
    public Category insertCategory(@RequestBody Category category){
        return categoryService.insertCategory(category);
    }
}
