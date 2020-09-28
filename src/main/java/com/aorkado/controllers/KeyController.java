package com.aorkado.controllers;

import com.aorkado.tools.RandomKeyGenerator;
import com.google.gson.JsonObject;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Produces;
import javax.inject.Inject;

@Introspected
@Controller("/key")
public class KeyController {

  private RandomKeyGenerator randomKeyGenerator;

  @Inject
  public void setRandomKeyGenerator(RandomKeyGenerator randomKeyGenerator) {
    this.randomKeyGenerator = randomKeyGenerator;
  }

  @Get("/")
  @Produces(MediaType.APPLICATION_JSON)
  public String get() {
    String key = randomKeyGenerator.generate();
    return buildJson(key);
  }

  @Get("/{key}")
  @Produces(MediaType.APPLICATION_JSON)
  public String get(@PathVariable String key) {
    return buildJson(key);
  }

  private String buildJson(String key) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("key", key);
    return jsonObject.toString();
  }
}
