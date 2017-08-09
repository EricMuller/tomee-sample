package com.emu.apps.sample.dao;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DocumentMapper {
 
    DocumentMapper INSTANCE = Mappers.getMapper( DocumentMapper.class );
 
    //@Mapping(source = "numberOfSeats", target = "seatCount")

    DocumentJson entityToDto(Document file);

    List<DocumentJson> entitiesToDtos(List<Document> files);

}