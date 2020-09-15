package com.aorkado;

import com.aorkado.mocks.MockRandomKeyGenerator;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@MicronautTest
public class ExampleRequestHandlerTest {

  private static ExampleRequestHandler requestHandler;

  @BeforeAll
  public static void beforeAll() {
    requestHandler = new ExampleRequestHandler();
  }

  @AfterAll
  public static void afterAll() {
    if (requestHandler != null) {
      requestHandler.getApplicationContext().close();
    }
  }

  @Test
  public void testHandler() {
    String input = "foobar";

    String result = requestHandler.execute(input);

    String expectedResult = "key == foobar";
    Assertions.assertEquals(expectedResult, result);

    //****//

    result = requestHandler.execute(null);

    expectedResult = "key == " + MockRandomKeyGenerator.RANDOM_KEY;
    Assertions.assertEquals(expectedResult, result);
  }
}
