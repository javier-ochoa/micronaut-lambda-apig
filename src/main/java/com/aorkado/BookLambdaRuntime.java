package com.aorkado;

import io.micronaut.function.aws.proxy.MicronautLambdaHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookLambdaRuntime extends MicronautLambdaHandler {

  private static Logger LOGGER = LoggerFactory.getLogger(BookLambdaRuntime.class);

  public BookLambdaRuntime() throws Exception {
    try {

    } catch (Exception e) {
      LOGGER.error(ExceptionUtils.getStackTrace(e));
      throw e;
    }
  }
}