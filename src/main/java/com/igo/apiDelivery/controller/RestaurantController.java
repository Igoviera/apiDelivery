package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public Restaurant insertRestaurant(@RequestBody Restaurant restaurantEntity){
        return restaurantService.insertRestaurant(restaurantEntity);
    }
    @GetMapping("/{id}")
    public Restaurant findByIdRestaurant(@PathVariable("id") Long id){
        return restaurantService.findByIdRestaurant(id);
    }
}
