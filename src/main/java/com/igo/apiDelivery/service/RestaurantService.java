package com.igo.apiDelivery.service;

import com.igo.apiDelivery.dto.RestaurantDTO;
import com.igo.apiDelivery.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO insertRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO findByIdRestaurant(Long id);
    List<RestaurantDTO> findAllRestaurant();
    RestaurantDTO updateRestaurant(Long id, RestaurantDTO restaurantDTO);
    void deleteRestaurant(Long id);
}
