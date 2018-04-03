package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;
import helpers.HomeHelper;
import helpers.ViewHelper;

@Singleton
public class HomeController extends ApplicationController {
  public Result index() {
    Result result = Results.html().template("/views/home/index.ftl.html");
    result.render("id", Integer.toString(1234));
    result.render("title", "Home");
    result.render("constants", this.constants);
    result.render("load_css", ViewHelper.loadCSS(this.constants, HomeHelper.indexCSS(this.constants)));
    result.render("load_js", ViewHelper.loadJS(this.constants, HomeHelper.indexJS(this.constants)));
    return result;
  }    
}
