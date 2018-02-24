package com.emu.apps.sample.tomee.services;


import com.emu.apps.sample.tomee.model.Document;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


public class BatchDocumentService {

    @Inject
    private DocumentService documentService;

    @Transactional(Transactional.TxType.NEVER)
    public List<Document> saveAll(List<Document> documents) {

        for (Document document : documents) {
            documentService.save(document);
        }

        return documentService.getAll();
    }
}
