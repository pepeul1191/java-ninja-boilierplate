package filters;

import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import ninja.session.*;

public class LoginViewGetFilter implements Filter {
	@Override
	public Result filter(FilterChain filterChain, Context context) {
		Result result = filterChain.next(context);
		try{
			switch(context.getSession().get("estado")) {
				case "activo":
					return result;
				case "inactivo":
					return result.redirect("/login");
				default:
					System.out.println("DEFAULT");
					return result;
			}
		}catch(NullPointerException exception){
			return result.redirect("/login");
		} 
	}
}
