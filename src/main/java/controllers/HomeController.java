package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;

import helpers.ViewHelper;

@Singleton
public class HomeController extends ApplicationController {
  public Result index() {
    Result result = Results.html().template("/views/home/index.ftl.html");
    result.render("id", Integer.toString(1234));
    result.render("title", "Home");
    result.render("constants", this.constants);
    result.render("load_css", ViewHelper.loadCSS(this.constants, new String[]{
        "bower_components/bootstrap/dist/css/bootstrap.min",
			  "bower_components/font-awesome/css/font-awesome.min",
      })
    );
    result.render("load_js", ViewHelper.loadJS(this.constants, new String[]{
      "bower_components/jquery/dist/jquery.min",
			"bower_components/bootstrap/dist/js/bootstrap.min",
    })
  );
    return result;
  }    
}
