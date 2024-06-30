package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.repository.RestaurantRepository;
import com.igo.apiDelivery.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantServiceImp implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant insertRestaurant(Restaurant restaurant) {
       return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findByIdRestaurant(Long id) {
        return null;
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return null;
    }

    @Override
    public Restaurant updateProduct(Restaurant restaurant, Long id) {
        return null;
    }

    @Override
    public void deleteRestaurant(Long id) {

    }
}
