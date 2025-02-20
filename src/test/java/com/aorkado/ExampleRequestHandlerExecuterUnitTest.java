package com.aorkado;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
public class ExampleRequestHandlerExecuterUnitTest {

  private static final String RANDOM_KEY = "12345";

  private RandomKeyGenerator randomKeyGenerator;
  private ExampleRequestHandlerExecuter executer;

  @BeforeEach
  public void beforeEach() {
    randomKeyGenerator = mock(RandomKeyGenerator.class);
    doReturn(RANDOM_KEY).when(randomKeyGenerator).generate();

    executer = new ExampleRequestHandlerExecuter();
    executer.setRandomKeyGenerator(randomKeyGenerator);
  }

  @AfterEach
  public void afterEach() {
  }

  @Test
  public void execute_When_NoInput_Then_GenerateRandomKey() {
    String result = executer.execute(null);

    //****//

    String expectedResult = "key == " + RANDOM_KEY;
    Assertions.assertEquals(expectedResult, result);

    verify(randomKeyGenerator).generate();
    verifyNoMoreInteractions(randomKeyGenerator);
  }

  @Test
  public void execute_When_Input_Then_ReturnInputAsKey() {
    String inputStr = "foobar";

    String result = executer.execute(inputStr);

    //****//

    String expectedResult = "key == foobar";
    Assertions.assertEquals(expectedResult, result);

    verifyNoInteractions(randomKeyGenerator);
  }
}
