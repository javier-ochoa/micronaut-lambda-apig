package com.aorkado;

import com.aorkado.mocks.MockRandomKeyGenerator;
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
public class ExampleLambdaRuntimeTest {

  private static ExampleLambdaRuntime runtime;

  @Inject
  @Client("/")
  private RxHttpClient client;

  @BeforeAll
  public static void setupServer() throws Exception {
    runtime = new ExampleLambdaRuntime();
  }

  @AfterAll
  public static void stopServer() {
    if (runtime != null) {
      runtime.getApplicationContext().close();
    }
  }

  @Test
  public void testHandler() {
    String result = client.toBlocking().retrieve(HttpRequest.GET("/key/"), String.class);
    Assertions.assertEquals("{\"key\":\"" + MockRandomKeyGenerator.RANDOM_KEY + "\"}", result);

    //****//

    result = client.toBlocking().retrieve(HttpRequest.GET("/key/12345"), String.class);
    Assertions.assertEquals("{\"key\":\"12345\"}", result);
  }
}
