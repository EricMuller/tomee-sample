package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Created by eric on 29/05/2017.
 */
@ApplicationPath("/rest")
public class RestApplication extends Application{
    private Set<Class<?>> classes;



    @Override
    public Set<Class<?>> getClasses() { // explicitely listing classes we exclude io.swagger.jaxrs.listing.ApiListingResource
        if (classes == null) {
            classes = new HashSet<>(asList(DocumentRest.class));
        }
        return classes;
    }

    @Override
    public Map<String, Object> getProperties() {
        return super.getProperties();
    }
}
