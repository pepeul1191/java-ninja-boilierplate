package filters;

import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;

public class CorsHeadersFilter implements Filter {
	@Override
	public Result filter(FilterChain filterChain, Context context) {
    Result result = filterChain.next(context);
		result.addHeader("Access-Control-Allow-Origin", "*");
    result.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		return result;
	}
}
