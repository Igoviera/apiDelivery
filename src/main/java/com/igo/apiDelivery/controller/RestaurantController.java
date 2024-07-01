package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public Restaurant insertRestaurant(@RequestBody Restaurant restaurantEntity){
        return restaurantService.insertRestaurant(restaurantEntity);
    }
    @GetMapping
    public List<Restaurant> findAllRestaurant(){
        return restaurantService.findAllRestaurant();
    }
    @GetMapping("/{id}")
    public Restaurant findByIdRestaurant(@PathVariable("id") Long id){
        return restaurantService.findByIdRestaurant(id);
    }
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable("id") Long id, @RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurant(id, restaurant);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRestaurante(@PathVariable("id") Long id){
        restaurantService.deleteRestaurant(id);
    }
}
