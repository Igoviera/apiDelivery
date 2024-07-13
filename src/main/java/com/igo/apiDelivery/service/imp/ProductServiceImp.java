package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.dto.ProductDTO;
import com.igo.apiDelivery.dto.mapper.ProductMapper;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Category;
import com.igo.apiDelivery.model.Product;
import com.igo.apiDelivery.model.Restaurant;
import com.igo.apiDelivery.repository.CategoryRepository;
import com.igo.apiDelivery.repository.ProductRepository;
import com.igo.apiDelivery.repository.RestaurantRepository;
import com.igo.apiDelivery.service.CategoryService;
import com.igo.apiDelivery.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;

    private  final ProductMapper productMapper;

    @Override
    public ProductDTO insertProduct(ProductDTO productDTO) {
        Product newProduct = new Product();

        newProduct.setName(productDTO.name());
        newProduct.setDescription(productDTO.description());
        newProduct.setPrice(productDTO.price());
        newProduct.setImgURL(productDTO.imgURL());
        newProduct.setAvaliable(productDTO.avaliable());

        Long restauranteId = productDTO.restaurantId();
        Restaurant restaurant = restaurantRepository.findById(restauranteId)
                .orElseThrow(() -> new RecordNotFoundException(restauranteId));

        Long categoryId = productDTO.categoryId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RecordNotFoundException(categoryId));


        newProduct.setRestaurant(restaurant);
        restaurant.getProducts().add(newProduct);

        newProduct.setCategory(category);
        category.getProducts().add(newProduct);

        Product savadProduct = productRepository.save(newProduct);

        return productMapper.toDTO(savadProduct);
    }

    @Override
    public ProductDTO findByIdProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> productMapper.toDTO(product))
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.toDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setPrice(productDTO.price());
                    recordFound.setName(productDTO.name());
                    recordFound.setDescription(productDTO.description());
                    recordFound.setImgURL(productDTO.imgURL());

                    return productMapper.toDTO(productRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(productRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
