package controllers;

import ninja.Result;
import ninja.Results;
import ninja.FilterWith;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import org.json.JSONObject;
import providers.UbicacionesDepartamentoProvider;
import filters.CorsHeadersFilter;
import models.Departamento;
import conf.Database;

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
    String rpta = "";
    try {
      Database conexion = new Database();
      ConnectionSource connectionSource = conexion.getConnectionSource();
      List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
      Dao<Departamento, String> departamentoDao = DaoManager.createDao(connectionSource, Departamento.class);
      QueryBuilder<Departamento, String> queryBuilder = departamentoDao.queryBuilder();
      PreparedQuery<Departamento> preparedQuery = queryBuilder.prepare();
      List<Departamento> departamentoList = departamentoDao.query(preparedQuery);
      for (Departamento departamento : departamentoList) {
        JSONObject obj = new JSONObject();
        obj.put("id", departamento.getId());
        obj.put("nombre", departamento.getNombre());
        rptaTemp.add(obj);
      }
      rpta = rptaTemp.toString();
    } catch (Exception e) {
      //e.printStackTrace();
      String[] error = {"Se ha producido un error en  listar los sistemas registrado", e.toString()};
      JSONObject rptaTry = new JSONObject();
      rptaTry.put("tipo_mensaje", "error");
      rptaTry.put("mensaje", error);
      rpta = rptaTry.toString();
    }
    return Results.text().render(rpta);
  }
  
  public static class SimplePojo {
    public String content;
  }
}
