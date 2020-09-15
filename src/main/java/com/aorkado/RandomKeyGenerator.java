package com.aorkado;

import io.micronaut.core.annotation.Introspected;
import javax.inject.Singleton;
import org.apache.commons.lang3.RandomStringUtils;

@Introspected
@Singleton
public class RandomKeyGenerator {

  public String generate() {
    return RandomStringUtils.randomAlphabetic(5);
  }
}
