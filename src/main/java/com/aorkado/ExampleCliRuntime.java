package com.aorkado;

import io.micronaut.runtime.Micronaut;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleCliRuntime {

  private static Logger LOGGER = LoggerFactory.getLogger(ExampleCliRuntime.class);

  public static void main(String[] args) {
    try {
      Micronaut.run(ExampleCliRuntime.class);
    } catch (Exception e) {
      LOGGER.error(ExceptionUtils.getStackTrace(e));
      throw e;
    }
  }
}