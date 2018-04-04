package controllers;

import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.session.*;
import ninja.FilterWith;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.google.inject.Singleton;
import helpers.LoginHelper;
import helpers.ViewHelper;
import providers.AccesosUsuarioProvider;
import filters.LoginViewGetFalseFilter;

@Singleton
public class LoginController extends ApplicationController {
  @FilterWith(LoginViewGetFalseFilter.class)
  public Result index() {
    Result result = Results.html().template("/views/login/index.ftl.html");
    result.render("title", "Bienvenido");
    result.render("constants", this.constants);
    result.render("mensaje", false);
    result.render("load_css", ViewHelper.loadCSS(this.constants, LoginHelper.indexCSS(this.constants)));
    result.render("load_js", ViewHelper.loadJS(this.constants, LoginHelper.indexJS(this.constants)));
    return result;
  }  
  
  public Result acceder(Context context, Session session) {
    String usuario = context.getParameter("usuario");
    String contrasenia = context.getParameter("contrasenia");
    String rpta = AccesosUsuarioProvider.acceder(this.constants, usuario, contrasenia);
    Result result;
    if(rpta.equalsIgnoreCase("1")){
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Date date = new Date();
      session.put("usuario", usuario);
      session.put("estado", "activo");
      session.put("tiempo", dateFormat.format(date));
      result = Results.redirect("/");
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
  
  public Result ver(Session session){
    String rpta = "<h1>Usuario Logeado</h1><ul><li>" + session.get("usuario") + "</li><li>" +  session.get("tiempo") + "</li><li>" + session.get("estado") + "</li></ul>";
    return Results.text().render(rpta);
  }

  public Result salir(Session session){
    session.clear();
    return Results.redirect("/login");
  }
}
