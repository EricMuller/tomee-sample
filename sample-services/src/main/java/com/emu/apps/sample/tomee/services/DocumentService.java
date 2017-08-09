package com.emu.apps.sample.tomee.services;

import com.emu.apps.sample.dao.Document;
import com.emu.apps.sample.dao.DocumentDao;
import com.emu.apps.sample.dao.DocumentJson;
import com.emu.apps.sample.dao.DocumentMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;


/**
 * Created by eric on 04/02/2017.
 */
@Stateless
public class DocumentService {

    @Inject
    private DocumentDao documentDao;

    @Inject
    private DocumentMapper fileMapper;


    public List<DocumentJson> getAll() {

        return fileMapper.entitiesToDtos(documentDao.getAll());

    }


    public DocumentJson createFile() {

        Document file = new Document();
        file.setName("Test");
        file.setDateCreation(new Date());

        documentDao.persist(file);

        return fileMapper.entityToDto(file);
    }


}
