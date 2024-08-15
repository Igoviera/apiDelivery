package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.dto.RestaurantDTO;
import com.igo.apiDelivery.dto.mapper.RestaurantMapper;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.repository.ProductRepository;
import com.igo.apiDelivery.repository.RestaurantRepository;
import com.igo.apiDelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImp implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
//    private final ProductRepository productRepository;
    private final RestaurantMapper restaurantMapper;
    @Override
    public RestaurantDTO insertRestaurant(RestaurantDTO restaurantDTO) {
        return restaurantMapper.toDTO(restaurantRepository.save(restaurantMapper.toEntity(restaurantDTO)));
    }
    @Override
    public RestaurantDTO findByIdRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .map(restaurant -> restaurantMapper.toDTO(restaurant))
                .orElseThrow(() -> new RecordNotFoundException(id));
    }
    @Override
    public List<RestaurantDTO> findAllRestaurant() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurant -> restaurantMapper.toDTO(restaurant))
                .collect(Collectors.toList());
    }
    @Override
    public RestaurantDTO updateRestaurant(Long id, RestaurantDTO restaurantDTO) {
       return restaurantRepository.findById(id)
               .map(recordFound -> {
                   Restaurant updateRestaurant = restaurantMapper.toEntity(restaurantDTO);
                   recordFound.setName(updateRestaurant.getName());
                   recordFound.setAddress(updateRestaurant.getAddress());
                   recordFound.setProducts(updateRestaurant.getProducts());
                   return restaurantMapper.toDTO(restaurantRepository.save(recordFound));
               }).orElseThrow(() -> new RecordNotFoundException(id));
    }
    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.delete(restaurantRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
