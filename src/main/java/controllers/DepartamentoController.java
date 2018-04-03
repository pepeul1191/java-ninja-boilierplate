package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import ninja.FilterWith;
import filters.CorsHeaders;;

@Singleton
public class DepartamentoController extends ApplicationController{
  public Result index() {
    return Results.html();
  }
  
  @FilterWith(CorsHeaders.class)
  public Result listar() {      
    String rpta;
    try {
			rpta = Unirest.get(this.constants.getString("servicios.ubicaciones") + "departamento/listar")
			  .asJson().getBody().toString();
		} catch (UnirestException e) {
			//e.printStackTrace();
      rpta = e.toString();
    }
    return Results.text().render(rpta);
  }
  
  public static class SimplePojo {
    public String content;
  }
}
