package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;
//import ninja.FilterWith;
//import filters.BeforeAllFilter;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

@Singleton
public class ApplicationController {
  //@FilterWith(BeforeAllFilter.class)
  protected Config constants;
  public ApplicationController(){
    this.constants = ConfigFactory.parseResources("conf/application.conf");
  }

  public Result index() {
    return Results.html();
  }

  public Result test() {
    return Results.text().render("Conexión OK");
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
