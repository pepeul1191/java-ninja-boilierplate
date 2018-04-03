package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;

@Singleton
public class DepartamentoController extends ApplicationController{
  public Result index() {
    return Results.html();
  }
  
  public Result listar() {      
    SimplePojo simplePojo = new SimplePojo();
    simplePojo.content = "Listar departamentos - " + this.constants.getString("servicios.accesos");
    return Results.json().render(simplePojo);
  }
  
  public static class SimplePojo {
    public String content;
  }
}
