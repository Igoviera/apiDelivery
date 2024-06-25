package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.model.Product;
import com.igo.apiDelivery.repository.ProductRepository;
import com.igo.apiDelivery.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImp implements ProductService {

    private  final ProductRepository productRepository;

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
        return productRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Produto não encontrado");
                });
    }

    @Override
    public List<Product> findAllProducts() {
       return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product product1 = findByIdProduct(id);

        product1.setPrice(product.getPrice());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setImgURL(product.getImgURL());

       return productRepository.save(product1);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product1 = findByIdProduct(id);
        productRepository.delete(product1);
    }
}
