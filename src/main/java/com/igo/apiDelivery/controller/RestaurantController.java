package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public Restaurant insertRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.insertRestaurant(restaurant);
    }
}
