package com.ankit.service;

import com.ankit.model.Characteristic;
import com.ankit.model.Product;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  public Product getProduct(String productId) {
    return fetchProduct(productId, "testCharacteristicId", "testCharacteristicName");
  }

  public List<Product> getProducts() {
    Product product1 = fetchProduct("testProduct1", "testCharacteristicId1",
        "testCharacteristicName1");
    Product product2 = fetchProduct("testProduct2", "testCharacteristicId2",
        "testCharacteristicName2");

    return List.of(product1, product2);
  }

  private static Product fetchProduct(String productId, String characteristicId,
      String characteristicName) {
    Product product = new Product();
    product.setId(productId);
    Characteristic ch = new Characteristic();
    ch.setId(characteristicId);
    ch.setName(characteristicName);
    product.setCharacteristics(List.of(ch));
    return product;
  }
}
