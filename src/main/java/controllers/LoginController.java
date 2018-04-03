package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;
import helpers.LoginHelper;
import helpers.ViewHelper;

@Singleton
public class LoginController extends ApplicationController {
  public Result index() {
    Result result = Results.html().template("/views/login/index.ftl.html");
    result.render("title", "Bienvenido");
    result.render("constants", this.constants);
    result.render("mensaje", false);
    result.render("load_css", ViewHelper.loadCSS(this.constants, LoginHelper.indexCSS(this.constants)));
    result.render("load_js", ViewHelper.loadJS(this.constants, LoginHelper.indexJS(this.constants)));
    return result;
  }  
  
  public Result acceder() {
    Result result = Results.html().template("/views/login/index.ftl.html");
    result.render("title", "Bienvenido");
    result.render("constants", this.constants);
    result.render("mensaje", true);
    result.render("load_css", ViewHelper.loadCSS(this.constants, LoginHelper.indexCSS(this.constants)));
    result.render("load_js", ViewHelper.loadJS(this.constants, LoginHelper.indexJS(this.constants)));
    return result;
  }  
}
