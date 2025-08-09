package integration.controller;

import integration.ProductApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class ProductApiControllerTest extends ProductApplicationTest {

  @Test
  void testRetrieveProduct_ValidRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
        .andExpectAll(
            MockMvcResultMatchers.status().isOk(),
            MockMvcResultMatchers.jsonPath("$").exists(),

            MockMvcResultMatchers.jsonPath("$.id").value("1"),
            MockMvcResultMatchers.jsonPath("$.characteristics[0].id").value("testCharacteristicId"),
            MockMvcResultMatchers.jsonPath("$.characteristics[0].name").value("testCharacteristicName")
        );
  }

  @Test
  void testRetrieveProduct_InvalidRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/products/null"))
        .andExpectAll(
            MockMvcResultMatchers.status().isOk(),
            MockMvcResultMatchers.jsonPath("$.id").value("null")
        );
  }


  @Test
  void testListProducts_ValidRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/products"))
        .andExpectAll(
            MockMvcResultMatchers.status().isOk(),

            MockMvcResultMatchers.jsonPath("$[0]").exists(),
            MockMvcResultMatchers.jsonPath("$[1]").exists(),
            MockMvcResultMatchers.jsonPath("$[2]").doesNotExist(),

            MockMvcResultMatchers.jsonPath("$[0].id").value("testProduct1"),
            MockMvcResultMatchers.jsonPath("$[0].characteristics[0].id").value("testCharacteristicId1"),
            MockMvcResultMatchers.jsonPath("$[0].characteristics[0].name").value("testCharacteristicName1"),

            MockMvcResultMatchers.jsonPath("$[1].id").value("testProduct2"),
            MockMvcResultMatchers.jsonPath("$[1].characteristics[0].id").value("testCharacteristicId2"),
            MockMvcResultMatchers.jsonPath("$[1].characteristics[0].name").value("testCharacteristicName2")
        );
  }
}