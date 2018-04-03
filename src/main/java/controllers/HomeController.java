package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;

@Singleton
public class HomeController extends ApplicationController {
  public Result index() {
    Result result = Results.html().template("/views/home/index.ftl.html");
    result.render("id", Integer.toString(1234));
    result.render("constants", this.constants);
    return result;
  }    
}
