package rest;


import rest.json.DocumentJson;
import rest.mappers.DocumentMapper;
import com.emu.apps.sample.tomee.model.Document;
import com.emu.apps.sample.tomee.services.BatchDocumentService;
import com.emu.apps.sample.tomee.services.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Api(value = "/document", tags = "document")
@Path("/document")
@Produces(MediaType.APPLICATION_JSON)
public class DocumentRest {

    @Inject
    private DocumentService documentService;

    @Inject
    private DocumentMapper documentMapper;

    @Inject
    private BatchDocumentService batchDocumentService;

    @GET
    @ApiOperation("Returns all the best document.")
    public Response findAll() {
        List<DocumentJson> documentJsons = documentMapper.entitiesToDtos(documentService.getAll());
        return Response.ok().entity(documentJsons).build();
    }

    @POST
    @ApiOperation("Save a document")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveDocument(DocumentJson documentJson) {
        Document document = documentMapper.DtoToEntity(documentJson);
        return Response.ok().entity( documentMapper.entityToDto(documentService.save(document))).build();
    }

    @Path("/dummy")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response dummy() {
        Document document = new Document();
        document.setName("Test");
        document.setDateCreation(new Date());
        DocumentJson fileJson = documentMapper.entityToDto(documentService.save(document));
        return Response.ok().entity(fileJson).build();
    }

    @Path("/bulkTest")
    @GET
    public Response bulkTest() {

        Supplier<Document> supplier = () -> {
            int i = new Random().nextInt(1000);
            return new Document("Document " + String.valueOf(i), new Date());
        };

        List<Document> documents = Stream.generate(supplier)
                .parallel()
                .limit(100)
                .collect(Collectors.toList());

        List<Document> docs = batchDocumentService.saveAll(documents);


        return Response.ok().entity(documentMapper.entitiesToDtos(docs)).build();
    }

}
