package conf;

import java.util.List;
import ninja.Filter;
import filters.BeforeAllFilter;

public class Filters implements ninja.application.ApplicationFilters {
  @Override
  public void addFilters(List<Class<? extends Filter>> filters) {
    // Add your application - wide filters here
    //filters.add(filters.BeforeAllFilter.class);
  }
}
