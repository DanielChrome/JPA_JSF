/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since
 */
@Entity(name="ADDRESS")
public class Address implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable=false,name="ID")
    private Integer id;
    @ManyToOne //MApeamento Um para muitos. Na classe que te o ID que repete usa o ManyToOne, 
    //Observar mapeamento OneToMany na classe People, para referencia reversa
    @JoinColumn(name="ID_PEOPLE")
    private People people;
    @Column(nullable=false,name="ADDRESS")
    private String address;
    @Column(nullable=true,name="NUMBER")
    private Integer number;
    
    /**
     *
     * @author Daniel
     */
    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, People people, String address, Integer number) {
        this.id = id;
        this.people = people;
        this.address = address;
        this.number = number;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Address other = (Address) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
