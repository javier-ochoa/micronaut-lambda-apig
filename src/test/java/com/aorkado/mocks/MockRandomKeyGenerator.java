package com.aorkado.mocks;

import com.aorkado.RandomKeyGenerator;
import io.micronaut.context.annotation.Replaces;
import javax.inject.Singleton;

@Singleton
@Replaces(RandomKeyGenerator.class)
public class MockRandomKeyGenerator extends RandomKeyGenerator {

  public static final String RANDOM_KEY = "1234567890";

  @Override
  public String generate() {
    return RANDOM_KEY;
  }
}
