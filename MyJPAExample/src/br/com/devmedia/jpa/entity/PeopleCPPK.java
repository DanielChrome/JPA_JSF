/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since
 */
//Usa ao invés de Entity para referenciar uma classe que
// é utilizada por outra já setada como Entity;
//No caso, a PeopleCPPK é uma classe que representa a chave composta da Tabela PeopleCP
@Embeddable
public class PeopleCPPK implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @Column(nullable = false, name = "ID")
    private Integer id;
    @Column(nullable = false, name = "SEQ")
    private Integer seq;

    /**
     *
     * @author Daniel
     */
    public PeopleCPPK() {
    }

    public PeopleCPPK(Integer id, Integer seq) {
        this.id = id;
        this.seq = seq;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 31 * hash + (this.seq != null ? this.seq.hashCode() : 0);
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
        final PeopleCPPK other = (PeopleCPPK) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.seq != other.seq && (this.seq == null || !this.seq.equals(other.seq))) {
            return false;
        }
        return true;
    }
    
    
}
