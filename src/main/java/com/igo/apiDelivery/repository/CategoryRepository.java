package com.igo.apiDelivery.repository;

import com.igo.apiDelivery.model.Category;
import com.igo.apiDelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}