package providers;

import com.typesafe.config.Config;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UbicacionesDepartamentoProvider {
  public static String listar(Config constants) {
    String rpta;
    try {
			rpta = Unirest.get(constants.getString("servicios.ubicaciones") + "departamento/listar")
			  .asJson().getBody().toString();
		} catch (UnirestException e) {
			//e.printStackTrace();
      rpta = e.toString();
    }
    return rpta;
  }  
}
