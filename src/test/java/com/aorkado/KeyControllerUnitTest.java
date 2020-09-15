package com.aorkado;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
public class KeyControllerUnitTest {

  private static final String RANDOM_KEY = "12345";

  private RandomKeyGenerator randomKeyGenerator;
  private KeyController controller;

  @BeforeEach
  public void beforeEach() {
    randomKeyGenerator = mock(RandomKeyGenerator.class);
    doReturn(RANDOM_KEY).when(randomKeyGenerator).generate();

    controller = new KeyController();
    controller.setRandomKeyGenerator(randomKeyGenerator);
  }

  @AfterEach
  public void afterEach() {
  }

  @Test
  public void get_When_NoKey_Then_GenerateRandomKey() {
    String result = controller.get();

    //****//

    String expectedResult = "{\"key\":\"" + RANDOM_KEY + "\"}";
    Assertions.assertEquals(expectedResult, result);

    verify(randomKeyGenerator).generate();
    verifyNoMoreInteractions(randomKeyGenerator);
  }

  @Test
  public void get_When_KeyAsPathVariable_Then_ReturnGivenKey() {
    String key = "foobar";

    String result = controller.get(key);

    //****//

    String expectedResult = "{\"key\":\"foobar\"}";
    Assertions.assertEquals(expectedResult, result);

    verifyNoInteractions(randomKeyGenerator);
  }
}
