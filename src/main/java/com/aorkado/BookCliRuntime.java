package com.aorkado;

import io.micronaut.runtime.Micronaut;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookCliRuntime {

  private static Logger LOGGER = LoggerFactory.getLogger(BookCliRuntime.class);

  public static void main(String[] args) {
    try {
      Micronaut.run(BookCliRuntime.class);

      Flyway flyway = Flyway.configure()
          .dataSource("jdbc:h2:mem:foo;DB_CLOSE_DELAY=-1", "sa", "")
          .load();
      flyway.migrate();
    } catch (Exception e) {
      LOGGER.error(ExceptionUtils.getStackTrace(e));
      throw e;
    }
  }
}