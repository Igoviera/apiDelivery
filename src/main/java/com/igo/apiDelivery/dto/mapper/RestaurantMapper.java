package com.igo.apiDelivery.dto.mapper;

import com.igo.apiDelivery.dto.AddressDTO;
import com.igo.apiDelivery.dto.ProductDTO;
import com.igo.apiDelivery.dto.RestaurantDTO;
import com.igo.apiDelivery.model.Address;
import com.igo.apiDelivery.model.Product;
import com.igo.apiDelivery.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {

    public RestaurantDTO toDTO(Restaurant restaurant){
        if (restaurant == null){
            return null;
        }

        AddressDTO addressDTO = new AddressDTO(
               restaurant.getAddress().getCep(),
               restaurant.getAddress().getComplemento()
        );

        Set<ProductDTO> productDTOS = restaurant.getProducts()
                .stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImgURL())).collect(Collectors.toSet());

        return new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                addressDTO,
                productDTOS
        );
    }

    public Restaurant toEntity(RestaurantDTO restaurantDTO) {

        if (restaurantDTO == null) {
            return null;
        }

        Restaurant restaurant = new Restaurant();
        if (restaurantDTO.id() != null) {
            restaurant.setId(restaurantDTO.id());
        }

        Address address = new Address();
        address.setCep(restaurantDTO.address().cep());
        address.setComplemento(restaurantDTO.address().complemento());

        restaurant.setName(restaurantDTO.name());
        restaurant.setAddress(address);

        Set<Product> productList = restaurantDTO.products()
                .stream()
                .map(productDTO -> {
                    var product = new Product();
                    product.setId(productDTO.id());
                    product.setName(productDTO.name());
                    product.setDescription(productDTO.description());
                    product.setPrice(productDTO.price());
                    product.setImgURL(productDTO.imgURL());
                    return product;
                }).collect(Collectors.toSet());
                restaurant.setProducts(productList);

                return restaurant;
    }
}
