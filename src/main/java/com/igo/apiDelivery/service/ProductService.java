package com.igo.apiDelivery.service;

import com.igo.apiDelivery.model.Product;

import java.util.List;

public interface ProductService {
   Product insertProduct(Product product);
   Product findByIdProduct(Long id);
   List<Product> findAllProducts();
   Product updateProduct(Long id, Product product);

   void deleteProduct(Long id);
}
