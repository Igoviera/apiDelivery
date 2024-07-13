package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Category;
import com.igo.apiDelivery.repository.CategoryRepository;
import com.igo.apiDelivery.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category insertCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findByIdCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return categoryRepository.findById(id).map(categoryFound -> {
                    categoryFound.setName(category.getName());
                    return categoryRepository.save(categoryFound);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void deleteCategory(Long id) {
       categoryRepository.delete(categoryRepository.findById(id)
               .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
