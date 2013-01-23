/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.jpa.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since
 */
@Entity(name = "GROUPS")
public class Group {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ID",nullable=false)
    private Integer id;
    @Column(name="NAME",nullable=false)
    private String name;
    
    //Mapeamepnto muitos para muitos
    //TargetEntity: Classe a qual o mapeamento se refere;
    @ManyToMany(targetEntity=People.class)
    @JoinTable(name="PEOPLE_GROUPS",//informar o nome da tabela que faz a relação NxN
               joinColumns=@JoinColumn(name="ID_PEOPLE"),//informar coluna que faz referencia a outra classe mapeada
               inverseJoinColumns=@JoinColumn(name="ID_GROUP"))//informar a coluna que faz referencia a essa classe
    private List<People> peoples;
    /**
     *
     * @author Daniel
     */
   
    public Group() {
    }

    public Group(Integer id) {
        this.id = id;
    }

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Group other = (Group) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
