package com.aorkado;

import com.aorkado.controllers.BookController;
import com.aorkado.managers.BookManager;
import com.aorkado.pojos.Book;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@MicronautTest
public class BookRequestHandlerTest {

  private static BookLambdaRuntime bookLambdaRuntime;

  @Inject
  private ApplicationContext context;

  @Inject
  @Client("/")
  private RxHttpClient client;

  @BeforeAll
  public static void setupServer() throws Exception {
    bookLambdaRuntime = new BookLambdaRuntime();
  }

  @AfterAll
  public static void stopServer() {
    if (bookLambdaRuntime != null) {
      bookLambdaRuntime.getApplicationContext().close();
    }
  }

  @Test
  public void testHandler() {
    Assertions.assertNotNull(context.getBean(BookController.class));
    Assertions.assertNotNull(context.getBean(BookManager.class));

    Book book = new Book();
    book.setName("abc");
    context.getBean(BookManager.class).saveBook(book);

    String result = client.toBlocking().retrieve(HttpRequest.GET("/book/"), String.class);
    Assertions.assertEquals("great scott!", result);
  }
}
