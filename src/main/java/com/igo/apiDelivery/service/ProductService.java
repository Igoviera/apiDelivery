package com.igo.apiDelivery.service;

import com.igo.apiDelivery.dto.ProductDTO;
import com.igo.apiDelivery.model.Product;

import java.util.List;

public interface ProductService {
   ProductDTO insertProduct(ProductDTO productDTO);
   ProductDTO findByIdProduct(Long id);
   List<ProductDTO> findAllProducts();
   ProductDTO updateProduct(Long id, ProductDTO productDTO);
   void deleteProduct(Long id);
}
