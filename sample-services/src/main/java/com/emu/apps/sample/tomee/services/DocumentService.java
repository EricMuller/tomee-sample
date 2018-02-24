package com.emu.apps.sample.tomee.services;


import com.emu.apps.sample.dao.DocumentDao;
import com.emu.apps.sample.tomee.model.Document;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


/**
 * Created by eric on 04/02/2017.
 */
@Stateless
public class DocumentService {

    @Inject
    private DocumentDao documentDao;

    public List<Document> getAll() {
        return documentDao.getAll();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Document save(Document document) {
        documentDao.persist(document);
        return document;
    }



}
