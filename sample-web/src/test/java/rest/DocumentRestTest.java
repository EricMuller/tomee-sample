package rest;

import com.emu.apps.sample.dao.DocumentDao;
import com.emu.apps.sample.tomee.services.BatchDocumentService;
import com.emu.apps.sample.tomee.services.DocumentService;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import org.junit.runner.RunWith;
import rest.json.DocumentJson;
import rest.mappers.DocumentMapper;
import rest.mappers.DocumentMapperImpl;

import javax.ws.rs.core.Response;
import java.io.IOException;

import static org.junit.Assert.*;


@EnableServices(value = "jax-rs", httpDebug = true)

@RunWith(ApplicationComposer.class)
public class DocumentRestTest extends ModuleConfig {

    @org.junit.Test
    public void saveDocument() {
    }

    @Module
    @Classes(cdi = true, value = {DocumentRest.class, DocumentService.class, DocumentMapper.class, DocumentDao.class, DocumentMapperImpl.class, BatchDocumentService.class})
    public WebApp app() {
        return new WebApp().contextRoot("test");
    }

    @Test
    public void getDocument() throws IOException {

        WebClient webClient = TestUtils.create("/test/document/");

        Response response = webClient.get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        //
        DocumentJson[] documentJsons = response.readEntity(DocumentJson[].class);

        assertNotNull(documentJsons);
        assertTrue(documentJsons.length == 0);
    }

    @Test
    public void postDocument() throws IOException {

        WebClient webClient = TestUtils.create("/test/document/");

        DocumentJson documentJson = new DocumentJson();
        documentJson.setName("Test");

        Response response =  webClient.post(documentJson);

        TestUtils.assertOk(response);

        DocumentJson document = response.readEntity(DocumentJson.class);

        assertEquals("Test", document.getName());
    }

}