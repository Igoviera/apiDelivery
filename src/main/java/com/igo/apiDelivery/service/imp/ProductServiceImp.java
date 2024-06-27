package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Product;
import com.igo.apiDelivery.repository.ProductRepository;
import com.igo.apiDelivery.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product insertProduct(Product product) {
        Product newProduct = new Product();

        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());

        return productRepository.save(newProduct);
    }

    @Override
    public Product findByIdProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setPrice(product.getPrice());
                    recordFound.setName(product.getName());
                    recordFound.setDescription(product.getDescription());
                    recordFound.setImgURL(product.getImgURL());
                    return productRepository.save(recordFound);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(productRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
