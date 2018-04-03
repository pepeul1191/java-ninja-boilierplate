package helpers;

import com.typesafe.config.Config;

public class LoginHelper {
  public static String[] indexCSS(Config constants) {
    switch(constants.getString("ambiente")) {
      case "desarrollo":
        return new String[] {
          "bower_components/bootstrap/dist/css/bootstrap.min",
          "bower_components/font-awesome/css/font-awesome.min",
        };
      case "produccion":
        return new String[] {
          "dist/login.min"
        };
      default:
        return new String[] {};
    }
  }  
  
  public static String[] indexJS(Config constants) {
    switch(constants.getString("ambiente")) {
      case "desarrollo":
        return new String[] {
          "bower_components/jquery/dist/jquery.min",
				  "bower_components/bootstrap/dist/js/bootstrap.min",
        };
      case "produccion":
        return new String[] {
          "dist/login.min"
        };
      default:
        return new String[] {};
    }
  }  
}
