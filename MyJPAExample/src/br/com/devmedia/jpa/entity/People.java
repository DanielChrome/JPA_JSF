/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.jpa.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since 
 */
@Entity(name="PEOPLE")
@EntityListeners(PeopleListener.class)
public class People implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable=false,name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false,name="NAME")
    private String name;
    @Column(nullable=true)
    private Integer age;
    
    @OneToOne(cascade= CascadeType.ALL)//Cascade ALL para o sistema movimentar outras tabelas como a PeopleInfo 
    @JoinColumn(name="ID_PEOPLEINFO")
    private PeopleInfo info;
    
    //Mapeamento Muitos pra um reverso. Uma lista dos objetos N
    //MappedBy: recebe o nome do atributo da classe mapeada (Address) que referencia pessoa
    //Fetch: Recebe Eager para buscar os endereços mesmo que ele não seja explicitamente chamado. Alta carga no servidor
    //       Recebe Lazy para buscar os endereços somente se for necessário (GetAddresses) 
    @OneToMany(mappedBy="people",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Address> addresses = new LinkedList<Address>();
    
    
    //Mapeamento Muitos para Muitos (Grupos X Pessoas)
    //TargetEntity: Classe a qual o mapeamento faz referencia;
    //MappedBy: recebe o nome do atributo da classe mapeada (People) que referencia a lista de pessoas
    @ManyToMany(targetEntity=Group.class,mappedBy="peoples")
    @JoinTable(name="PEOPLE_GROUPS")//informar o nome da tabela que faz a relação NxN
    private List<Group> groups;
    /**
     *
     * @author Daniel
     */
    public People(){

    }

    public People(Integer id) {
        this.id = id;
    }

    public People(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public PeopleInfo getInfo() {
        return info;
    }

    public void setInfo(PeopleInfo info) {
        this.info = info;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    /**
     * Método que insere um novo endereço a pessoa, já setando a pessoa ao endereço.
     * @param addr 
     */
    public void addAddress(Address addr){
        addr.setPeople(this);
        getAddresses().add(addr);
    }
    
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final People other = (People) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
     
     
}
