package com.aorkado.mocks;

import com.aorkado.pojos.Book;
import com.aorkado.managers.BookManager;
import com.aorkado.pojos.BookSaved;
import io.micronaut.context.annotation.Replaces;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Replaces(BookManager.class)
public class MockBookManager extends BookManager {

  private static Logger LOGGER = LoggerFactory.getLogger(MockBookManager.class);

  @Override
  public BookSaved saveBook(Book input) {
    LOGGER.info("saveBook... Mock!!");

    BookSaved bookSaved = new BookSaved();
    bookSaved.setIsbn("mockedIsbn");
    bookSaved.setName("mockedName");

    return bookSaved;
  }
}
