package com.emu.apps.sample.dao;

import javax.persistence.Column;

/**
 * Created by eric on 04/02/2017.
 */
public class DocumentJson {

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
