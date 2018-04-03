package controllers;

import ninja.Result;
import ninja.Results;
import providers.UbicacionesDepartamentoProvider;

import com.google.inject.Singleton;
import ninja.FilterWith;
import filters.CorsHeaders;;

@Singleton
public class DepartamentoController extends ApplicationController{
  public Result index() {
    return Results.html();
  }
  
  @FilterWith(CorsHeaders.class)
  public Result listar() {      
    String rpta = UbicacionesDepartamentoProvider.listar(this.constants);
    return Results.text().render(rpta);
  }
  
  public static class SimplePojo {
    public String content;
  }
}
