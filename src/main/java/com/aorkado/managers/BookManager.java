package com.aorkado.managers;

import com.aorkado.pojos.Book;
import com.aorkado.pojos.BookSaved;
import io.micronaut.core.annotation.Introspected;
import java.util.UUID;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Introspected
@Singleton
public class BookManager {

  private static Logger LOGGER = LoggerFactory.getLogger(BookManager.class);

  public BookSaved saveBook(Book input) {
    LOGGER.info("saveBook!!");
    BookSaved bookSaved = new BookSaved();
    bookSaved.setName(input.getName());
    bookSaved.setIsbn(UUID.randomUUID().toString());
    return bookSaved;
  }
}
