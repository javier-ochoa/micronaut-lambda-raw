package com.aorkado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@MicronautTest
public class BookRequestHandlerTest {

  private static BookRequestHandler bookRequestHandler;

  @Inject
  private ApplicationContext context;

  @BeforeAll
  public static void setupServer() {
    bookRequestHandler = new BookRequestHandler();
  }

  @AfterAll
  public static void stopServer() {
    if (bookRequestHandler != null) {
      bookRequestHandler.getApplicationContext().close();
    }
  }

  @Test
  public void testHandler() {
    System.out.println(context.getBean(BookManager.class));

    Book book = new Book();
    book.setName("Building Microservices");
    BookSaved bookSaved = bookRequestHandler.execute(book);

    assertEquals("mockedName", bookSaved.getName());
    assertNotNull(bookSaved.getIsbn());
  }
}
