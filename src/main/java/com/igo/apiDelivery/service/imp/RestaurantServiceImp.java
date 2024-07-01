package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Address;
import com.igo.apiDelivery.model.Product;
import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.repository.ProductRepository;
import com.igo.apiDelivery.repository.RestaurantRepository;
import com.igo.apiDelivery.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImp implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ProductRepository productRepository;

    @Override
    public Restaurant insertRestaurant(Restaurant restaurantEntity) {
        return restaurantRepository.save(restaurantEntity);
    }

    @Override
    public Restaurant findByIdRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
       return restaurantRepository.findById(id)
               .map(recordFound -> {
                   recordFound.setName(restaurant.getName());
                   recordFound.setAddress(restaurant.getAddress());
                   recordFound.setProducts(restaurant.getProducts());
                   return restaurantRepository.save(recordFound);

               }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.delete(restaurantRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
