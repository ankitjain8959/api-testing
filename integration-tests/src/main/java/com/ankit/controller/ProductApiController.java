package com.ankit.controller;

import com.ankit.model.Product;
import com.ankit.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductApiController {

  @Autowired
  ProductService productService;

  @GetMapping("/products/{id}")
  public Product getProduct(@PathVariable("id") String id) {
    return productService.getProduct(id);
  }

  @GetMapping("/products")
  public List<Product> getProducts() {
    return productService.getProducts();
  }
}
