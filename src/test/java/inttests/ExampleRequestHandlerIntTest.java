package inttests;

import com.aorkado.ExampleRequestHandler;
import inttests.mocks.MockRandomKeyGenerator;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MicronautTest
public class ExampleRequestHandlerIntTest {

  private static Logger LOGGER = LoggerFactory.getLogger(ExampleRequestHandlerIntTest.class);

  private static ExampleRequestHandler requestHandler;

  @BeforeAll
  public static void beforeAll() {
    LOGGER.info("beforeAll");

    requestHandler = new ExampleRequestHandler();
  }

  @AfterAll
  public static void afterAll() {
    LOGGER.info("afterAll");

    if (requestHandler != null) {
      requestHandler.getApplicationContext().close();
    }
  }

  @Test
  public void when_NoInput_Then_GenerateRandomKey() {
    LOGGER.info("when_NoInput_Then_GenerateRandomKey");

    String result = requestHandler.execute(null);

    String expectedResult = "key == " + MockRandomKeyGenerator.RANDOM_KEY;
    Assertions.assertEquals(expectedResult, result);
  }

  @Test
  public void when_Input_Then_ReturnInputAsKey() {
    LOGGER.info("when_Input_Then_ReturnInputAsKey");

    String input = "foobar";

    String result = requestHandler.execute(input);

    String expectedResult = "key == foobar";
    Assertions.assertEquals(expectedResult, result);
  }
}
