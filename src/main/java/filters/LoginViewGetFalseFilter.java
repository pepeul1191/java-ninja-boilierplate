package filters;

import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import ninja.session.*;

public class LoginViewGetFalseFilter implements Filter {
	@Override
	public Result filter(FilterChain filterChain, Context context) {
		Result result = filterChain.next(context);
		try{
			switch(context.getSession().get("estado")) {
				case "activo":
					return result.redirect("/");
				default:
					return result.redirect("/");
			}
		}catch(NullPointerException exception){
			return result;
		} 
	}
}
