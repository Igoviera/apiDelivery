package com.igo.apiDelivery.service;

import com.igo.apiDelivery.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant insertRestaurant(Restaurant restaurant);
    Restaurant findByIdRestaurant(Long id);
    List<Restaurant> findAllRestaurant();
    Restaurant updateProduct(Restaurant restaurant, Long id);
    void deleteRestaurant(Long id);
}
