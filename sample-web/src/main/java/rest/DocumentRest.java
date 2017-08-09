package rest;

import com.emu.apps.sample.dao.DocumentJson;
import com.emu.apps.sample.tomee.services.DocumentService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/files")
public class DocumentRest {

	@Inject
	private DocumentService fileService;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response files() {
		List<DocumentJson> documentJsons = fileService.getAll();
		return Response.ok().entity(documentJsons).build();
	}

	@Path("/create")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response create() {

		DocumentJson fileJson = fileService.createFile();

		return Response.ok().entity(fileJson).build();
	}

}
