package com.igo.apiDelivery.service;

import com.igo.apiDelivery.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category insertCategory(Category category);
    Category findByIdCategory(Long id);
}
