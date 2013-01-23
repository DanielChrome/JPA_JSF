/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.jpa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since
 */
@Entity(name = "PEOPLECP")
public class PeopleCP implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    //Usado para referenciar uma classe que representa a chave composta.
    @EmbeddedId
    private PeopleCPPK id;
    @Column(nullable = false, name = "NAME")
    private String name;

    /**
     *
     * @author Daniel
     */
    public PeopleCP() {
    }

    public PeopleCP(PeopleCPPK id) {
        this.id = id;
    }

    public PeopleCP(PeopleCPPK id, String name) {
        this.id = id;
        this.name = name;
    }

    public PeopleCPPK getId() {
        return id;
    }

    public void setId(PeopleCPPK id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PeopleCP other = (PeopleCP) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    

}
