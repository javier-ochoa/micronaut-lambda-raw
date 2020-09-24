package com.aorkado;

import io.micronaut.core.annotation.Introspected;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.commons.lang3.StringUtils;

@Introspected
@Singleton
public class ExampleRequestHandlerExecuter {

  private RandomKeyGenerator randomKeyGenerator;

  @Inject
  public void setRandomKeyGenerator(RandomKeyGenerator randomKeyGenerator) {
    this.randomKeyGenerator = randomKeyGenerator;
  }

  public String execute(String input) {
    if (StringUtils.isBlank(input)) {
      return "key == " + randomKeyGenerator.generate();
    }
    return "key == " + input;
  }
}
