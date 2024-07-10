package com.igo.apiDelivery.dto.mapper;

import com.igo.apiDelivery.dto.ProductDTO;
import com.igo.apiDelivery.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        if (product == null){
            return null;
        }
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImgURL(),
                product.isAvaliable(),
                product.getRestaurant() != null ? product.getRestaurant().getId() : null
        );
    }

    public Product toEntity(ProductDTO productDTO){
        if (productDTO == null){
            return null;
        }

        Product product = new Product();

        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        product.setImgURL(productDTO.imgURL());


        return product;
    }
}
