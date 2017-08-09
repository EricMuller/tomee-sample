package com.emu.apps.sample.dao;

import com.emu.apps.sample.tomee.model.QDocument;
import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;

/**
 * Created by eric on 04/02/2017.
 */

public class DocumentDao extends GenericDao<Document> {

    public final List<Document> getAll() {

        final QDocument qDocument = QDocument.document;
        final JPAQuery jpaQuery = new JPAQuery(entityManager);

        return jpaQuery.from(qDocument).fetch() ;
    }
}
