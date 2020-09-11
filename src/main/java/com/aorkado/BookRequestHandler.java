package com.aorkado;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import javax.inject.Inject;

@Introspected
public class BookRequestHandler extends MicronautRequestHandler<Book, BookSaved> {

  @Inject
  private BookManager bookManager;

  @Override
  public BookSaved execute(Book input) {
    return bookManager.saveBook(input);
  }
}
