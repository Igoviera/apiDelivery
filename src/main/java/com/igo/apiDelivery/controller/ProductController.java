package com.igo.apiDelivery.controller;

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
    public Product insertProduct(@Valid @RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @GetMapping("/{id}")
    public Product findProdut(@PathVariable("id") Long id) {
        return productService.findByIdProduct(id);
    }

    @GetMapping
    public List<Product> findAllProduct() {
        return productService.findAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@Valid @PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProdut(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
