package com.emu.apps.sample.tomee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Document {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Document() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String director) {
        this.name = director;
    }


}