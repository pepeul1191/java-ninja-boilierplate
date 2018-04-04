package conf;

import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;
import controllers.HomeController;
import controllers.DepartamentoController;
import controllers.LoginController;

public class Routes implements ApplicationRoutes {
  @Override
  public void init(Router router) {  
    router.GET().route("/").with(HomeController::index);
    router.GET().route("/hello_world.json").with(ApplicationController::helloWorldJson);
    router.GET().route("/departamento/listar").with(DepartamentoController::listar);
    router.GET().route("/departamento/listar/db").with(DepartamentoController::listarDB);
    router.GET().route("/login").with(LoginController::index);
    router.POST().route("/login/acceder").with(LoginController::acceder);
    router.GET().route("/usuario/ver").with(LoginController::ver);
    router.GET().route("/usuario/salir").with(LoginController::salir);
    ///////////////////////////////////////////////////////////////////////
    // Assets (pictures / javascript)
    ///////////////////////////////////////////////////////////////////////    
    router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController::serveWebJars);
    router.GET().route("/assets/{fileName: .*}").with(AssetsController::serveStatic);
    ///////////////////////////////////////////////////////////////////////
    // Index / Catchall shows index page
    ///////////////////////////////////////////////////////////////////////
    router.GET().route("/.*").with(ApplicationController::index);
  }
}