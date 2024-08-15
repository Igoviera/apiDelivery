package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Category;
import com.igo.apiDelivery.service.CategoryService;
import com.igo.apiDelivery.service.imp.CategoryServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/categorys")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAllCategory(){
        return categoryService.findAllCategory();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Category insertCategory(@RequestBody Category category){
        return categoryService.insertCategory(category);
    }
    @GetMapping("/{id}")
    public Category findByIdCategory(@PathVariable("id") Long id){
        return categoryService.findByIdCategory(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable("id") Long id, Category category){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }
}
