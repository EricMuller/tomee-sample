package com.emu.apps.sample.tomee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Document  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private Date dateCreation;

    public Document() {
    }

    public Document(String name, Date dateCreation) {
        this.name = name;
        this.dateCreation = dateCreation;
    }

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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}