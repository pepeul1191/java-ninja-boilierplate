package providers;

import com.typesafe.config.Config;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UbicacionesDepartamentoProvider {
  public static String listar(Config constants) {
    String urlServicio = constants.getString("servicios.ubicaciones");
    String rpta;
    try {
			rpta = Unirest.get(urlServicio + "departamento/listar")
			  .asJson().getBody().toString();
		} catch (UnirestException e) {
			//e.printStackTrace();
      rpta = e.toString();
    }
    return rpta;
  }  
}
