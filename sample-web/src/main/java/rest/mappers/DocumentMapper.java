package rest.mappers;

import rest.json.DocumentJson;
import com.emu.apps.sample.tomee.model.Document;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper
public interface DocumentMapper {

    DocumentJson entityToDto(Document document);
    List<DocumentJson> entitiesToDtos(List<Document> files);
    Document DtoToEntity(DocumentJson json);

}