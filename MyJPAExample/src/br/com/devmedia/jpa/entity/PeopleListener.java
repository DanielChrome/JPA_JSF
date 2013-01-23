/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.jpa.entity;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since 
 */
public class PeopleListener {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @author Daniel
     */

     public PeopleListener(){

     }
     
     @PrePersist
     //Executa algum código antes da persistencia do  objeto no banco de dados
     //Pode ser utilizado para fazer validações por exemplo.
     public void PrePersist(People pl){
         if (pl.getAge() < 18){
             throw new IllegalAccessError("Idade menor que 18 anos!");//Executa uma exceção e executa um ROLLBACK na persistencia
         }
         else{
             System.out.println("Persistencia permitida!");
         }
             
     }
     
     @PostPersist
     //Executa algum código depos da persistencia do  objeto no banco de dados
     //Pode ser utilizado para fazer validações por exemplo.
     public void PostPersist(People pl){
         System.out.println(pl.getName()+" persistido com sucesso!");
     }
     
     @PreUpdate
     //Executa algum código antes da atualização do objeto no banco de dados
     //Funciona também com o State Detected.
     public void PreUpdate(People pl){
         System.out.println(pl.getName()+" Será atualizado agora!");
     }
     
     @PostUpdate
     //Executa algum código depois da atualização do objeto no banco de dados
     //Funciona também com o State Detected.
     public void PostUpdate(People pl){
         System.out.println(pl.getName()+" Atualizado com sucesso!");
     }
}
