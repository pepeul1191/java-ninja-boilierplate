package controllers;

import ninja.Result;
import ninja.Results;
import com.google.inject.Singleton;

@Singleton
public class DepartamentoController {
    public Result index() {
        return Results.html();
    }
    
    public Result listar() {      
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Listar departamentos";
        return Results.json().render(simplePojo);
    }
    
    public static class SimplePojo {
        public String content;
    }
}
