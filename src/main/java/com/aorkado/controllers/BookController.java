package com.aorkado.controllers;

import com.aorkado.managers.BookManager;
import com.aorkado.pojos.Book;
import com.aorkado.pojos.BookSaved;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import javax.inject.Inject;

@Introspected
@Controller("/book")
public class BookController {

  @Inject
  private BookManager bookManager;

  @Get("/")
  @Produces(MediaType.TEXT_PLAIN)
  public String index() {
    return "great scott!";
  }

  @Get("/save")
  @Produces(MediaType.APPLICATION_JSON)
  public String save() {
    Book book = new Book();
    book.setName("randomName:" + System.currentTimeMillis());
    BookSaved bookSaved = bookManager.saveBook(book);
    return bookSaved.getIsbn();
  }
}
