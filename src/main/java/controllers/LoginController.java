package controllers;

import ninja.Context;
import ninja.Result;
import ninja.Results;
import providers.AccesosUsuarioProvider;

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
  
  public Result acceder(Context context) {
    String usuario = context.getParameter("usuario");
    String contrasenia = context.getParameter("contrasenia");
    String rpta = AccesosUsuarioProvider.acceder(this.constants, usuario, contrasenia);
    Result result;
    if(rpta.equalsIgnoreCase("1")){
      result = Results.redirect("/home");
    }else{
      result = Results.html().template("/views/login/index.ftl.html");
      result.render("title", "Bienvenido");
      result.render("constants", this.constants);
      result.render("mensaje", true);
      result.render("load_css", ViewHelper.loadCSS(this.constants, LoginHelper.indexCSS(this.constants)));
      result.render("load_js", ViewHelper.loadJS(this.constants, LoginHelper.indexJS(this.constants)));
    }
    return result;
  }  
}
