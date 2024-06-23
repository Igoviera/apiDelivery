package com.igo.apiDelivery.repository;

import com.igo.apiDelivery.model.Client;
import com.igo.apiDelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
