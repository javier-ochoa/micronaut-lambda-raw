package com.aorkado;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

@Introspected
public class ExampleRequestHandler extends MicronautRequestHandler<String, String> {

  private RandomKeyGenerator randomKeyGenerator;

  @Inject
  public void setRandomKeyGenerator(RandomKeyGenerator randomKeyGenerator) {
    this.randomKeyGenerator = randomKeyGenerator;
  }

  @Override
  public String execute(String input) {
    if (StringUtils.isBlank(input)) {
      return "key == " + randomKeyGenerator.generate();
    }
    return "key == " + input;
  }
}
