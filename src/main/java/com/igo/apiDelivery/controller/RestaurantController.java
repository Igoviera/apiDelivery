package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.dto.RestaurantDTO;
import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.service.RestaurantService;
import jakarta.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO insertRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.insertRestaurant(restaurantDTO);
    }
    @GetMapping
    public List<RestaurantDTO> findAllRestaurant(){
        return restaurantService.findAllRestaurant();
    }
    @GetMapping("/{id}")
    public RestaurantDTO findByIdRestaurant(@PathVariable("id") Long id){
        return restaurantService.findByIdRestaurant(id);
    }
    @PutMapping("/{id}")
    public RestaurantDTO updateRestaurant(@Valid @PathVariable("id") Long id, @RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.updateRestaurant(id, restaurantDTO);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id){
        restaurantService.deleteRestaurant(id);
    }
}
