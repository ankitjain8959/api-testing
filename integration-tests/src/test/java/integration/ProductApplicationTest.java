package integration;

import com.ankit.ProductApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = ProductApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
public class ProductApplicationTest {

  @Autowired
  public MockMvc mockMvc;

  @Test
  void contextLoads() {}

  /* Key annotations used:
  * @SpringBootTest: Starts the full application context for testing. If Spring Boot cannot find your main application class annotated with @SpringBootApplication or @SpringBootConfiguration; Explicitly specify your main application class in the @SpringBootTest annotation with `classes`
  * @AutoConfigureMockMvc: Auto-configures `MockMvc` to test controllers without starting a real server
  * @ActiveProfiles({"test"}): Activates the test profile, so beans and properties specific to the test environment are used during testing.
  *
  * If using MongoDB,
  * @AutoConfigureDataMongo: Automatically configures Spring Data MongoDB for tests, enabling MongoDB-related beans and repositories.
  * */
}
