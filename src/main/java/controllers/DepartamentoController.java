package controllers;

import ninja.Result;
import ninja.Results;
import ninja.FilterWith;
import com.google.inject.Singleton;
import daos.DepartamentoDao;
import filters.CorsHeadersFilter;
import providers.UbicacionesDepartamentoProvider;

@Singleton
public class DepartamentoController extends ApplicationController{
  public Result index() {
    return Results.html();
  }
  
  @FilterWith(CorsHeadersFilter.class)
  public Result listar() {      
    String rpta = UbicacionesDepartamentoProvider.listar(this.constants);
    return Results.text().render(rpta);
  }
  
  @FilterWith(CorsHeadersFilter.class)
  public Result listarDB() {      
    DepartamentoDao departamentoDao = new DepartamentoDao();
    String rpta = departamentoDao.listar();
    return Results.text().render(rpta);
  }
  
  public static class SimplePojo {
    public String content;
  }
}
