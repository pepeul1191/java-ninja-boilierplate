package filters;

import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import ninja.session.*;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class CsrfViewPost implements Filter {
	@Override
	public Result filter(FilterChain filterChain, Context context) {
		Result result = filterChain.next(context);
    Config constants = ConfigFactory.parseResources("conf/application.conf");
    String csrfFormParameter = context.getParameter(constants.getString("application.secret_name"));
    if(constants.getString("application.secret").equals(csrfFormParameter)){
      return result;
    }else{
      return result.redirect("/error/access/505");
    }
	}
}