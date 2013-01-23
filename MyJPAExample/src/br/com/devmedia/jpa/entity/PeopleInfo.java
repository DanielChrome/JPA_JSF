/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since
 */
@Entity(name="PEOPLEINFO")
public class PeopleInfo {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable=false,name="id")
    private Integer id;
    
    //MAPEAMENTO 1:1 (Conferir classe PEOPLE para mapeamento inverso.
    @OneToOne
    //Especifica a coluna usada na tabela PeopleINFO para identificar a PEOPLE.
    @JoinColumn(name="ID_PEOPLE",nullable=false)
    private People people;
    @Column(name="OBS")
    private String obs;
    @Column(name="NAMEOFPET")
    private String nameOfPet;
    @Column(name="TIPEOFPET")
    private String tipeOfPet;
    
    
    /**
     *
     * @author Daniel
     */
    public PeopleInfo() {
    }

    public PeopleInfo(Integer id) {
        this.id = id;
    }

    public PeopleInfo(Integer id, People people, String obs, String nameOfPet, String tipeOfPet) {
        this.id = id;
        this.people = people;
        this.obs = obs;
        this.nameOfPet = nameOfPet;
        this.tipeOfPet = tipeOfPet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getNameOfPet() {
        return nameOfPet;
    }

    public void setNameOfPet(String nameOfPet) {
        this.nameOfPet = nameOfPet;
    }

    public String getTipeOfPet() {
        return tipeOfPet;
    }

    public void setTipeOfPet(String typeOfPet) {
        this.tipeOfPet = typeOfPet;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PeopleInfo other = (PeopleInfo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
