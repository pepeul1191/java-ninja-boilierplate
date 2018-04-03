package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;
import ninja.FilterWith;
import filters.BeforeAllFilter;

@Singleton
public class ApplicationController {
  @FilterWith(BeforeAllFilter.class)
  public Result index() {
    return Results.html();
  }
    
  public Result helloWorldJson() {      
    SimplePojo simplePojo = new SimplePojo();
    simplePojo.content = "Hello World! Hello Json!";
    return Results.json().render(simplePojo);
  }

  public static class SimplePojo {
    public String content;
  }
}
