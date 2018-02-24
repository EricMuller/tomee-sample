package rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.common.collect.Lists;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class TestUtils {

    public TestUtils() {
        //nope
    }

    public static WebClient create(String path) {
        WebClient webClient = WebClient.create("http://localhost:4204", Lists.newArrayList(JacksonJaxbJsonProvider.class))
                .path(path)
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                ;

        ClientConfiguration config = WebClient.getConfig(webClient);
        config.getInInterceptors().add(new LoggingInInterceptor());
        config.getOutInterceptors().add(new LoggingOutInterceptor());
        return webClient;
    }

    public static void assertOk(Response response) {
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }


}
