package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.dto.ProductDTO;
import com.igo.apiDelivery.model.Product;
import com.igo.apiDelivery.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO insertProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.insertProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO findProduct(@PathVariable("id") Long id) {
        return productService.findByIdProduct(id);
    }

    @GetMapping
    public List<ProductDTO> findAllProduct() {
        return productService.findAllProducts();
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@Valid @PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
