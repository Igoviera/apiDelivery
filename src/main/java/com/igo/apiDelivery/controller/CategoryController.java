package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Category;
import com.igo.apiDelivery.service.CategoryService;
import com.igo.apiDelivery.service.imp.CategoryServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
