package providers;

import com.typesafe.config.Config;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AccesosUsuarioProvider {
  public static String acceder(Config constants, String usuario, String contrasenia) {
    String urlServicio = constants.getString("servicios.accesos");
    String rpta;
    try {
		  rpta = Unirest.post(urlServicio + "usuario/validar")
        .queryString("usuario", usuario)
        .queryString("contrasenia", contrasenia)
			  .asString().getBody().toString();
		} catch (UnirestException e) {
			e.printStackTrace();
      rpta = e.toString();
    }
    return rpta;
  }  
}
