package com.ankit.model;


import java.util.ArrayList;
import java.util.List;

public class Product {
  String id;
  List<Characteristic> characteristics = new ArrayList<>();

  public Product() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }
}
