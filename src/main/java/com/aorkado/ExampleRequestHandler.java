package com.aorkado;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import javax.inject.Inject;

@Introspected
public class ExampleRequestHandler extends MicronautRequestHandler<String, String> {

  private ExampleRequestHandlerExecuter executer;

  @Inject
  public void setExecuter(ExampleRequestHandlerExecuter executer) {
    this.executer = executer;
  }

  @Override
  public String execute(String input) {
    return executer.execute(input);
  }
}
