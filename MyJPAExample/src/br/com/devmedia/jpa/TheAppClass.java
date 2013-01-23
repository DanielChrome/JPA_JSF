/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.jpa;

import br.com.devmedia.jpa.entity.Address;
import br.com.devmedia.jpa.entity.Group;
import br.com.devmedia.jpa.entity.People;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 * @version 1.0
 * @since
 */
public class TheAppClass {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @author Daniel
     */
    public TheAppClass() {
    }

    public static void main(String[] args) {
        //Criando fabrica de EM.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevMediaPersistenceUnit");
        //Criando EM e pegando objeto da fabrica criada
        EntityManager em = emf.createEntityManager();
        //Iniciando controle de transação.
        em.getTransaction().begin();


        //Gravando novo registro
        //People newP = new People();
        //newP.setName("Carlos Moro");
        //newP.setAge(20);
        //em.persist(newP);
        //----------------------------------------------------------------------

        // LEITURA
        //People p = em.find(People.class, 1);
        //System.out.println("The People name is "+p.getName());

        //DETECÇÃO AUTOMaTICA DE ESTADO
        //p.setName("Kate Santos");
        //System.out.println("The New People name is "+p.getName());

        //FORÇA A GRAVAÇÃO DAS ATUALIZAÇÕES
        //em.merge(p);
        
        //----------------------------------------------------------------------

        //GRAVANDO MAPEAMENTO DE CHAVE COMPOSTA;
        //PeopleCP compositePeople = new PeopleCP();
        //PeopleCPPK pcpPK = new PeopleCPPK(1,2);
        //compositePeople.setId(pcpPK);
        //compositePeople.setName("The Name 2!");
        //em.persist(compositePeople);
        
        //----------------------------------------------------------------------

        //RECUPERANDO DADOS COM CHAVE COMPOSTA
        //PeopleCPPK pk = new PeopleCPPK(1,2);
        //PeopleCP cp = em.find(PeopleCP.class, pk);
        //System.out.println("PeopleCP Name: "+cp.getName());
        
        //----------------------------------------------------------------------

        //BUSCANDO CLASSE MAPEADA ONETOONE e Adicionando uma nova Info, utilizando detecção automatica de estado.
        //People p = em.find(People.class, 2);
        //System.out.println("The info is "+p.getInfo());
        //PeopleInfo pinfo = new PeopleInfo();
        //pinfo.setId(2);
        //pinfo.setPeople(p);
        //pinfo.setObs("The OBS");
        //pinfo.setNameOfPet("TOTO");
        //pinfo.setTipeOfPet("Worm");
        //p.setInfo(pinfo);
        //----------------------------------------------------------------------


        //MAPEAMENTO MUITOS PRA UM - Pessoa 1-N Endereços
        //People p = em.find(People.class,2);
        //System.out.println("Hey "+p.getName()+"... The Address is ");

        //for(Address address : p.getAddresses()){
        //    System.out.println("Address "+address.getId()+" is "+address.getAddress());
        //}

        //Address addr = new Address();
        //addr.setId(6);
        //addr.setAddress("Address Six");
        //addr.setPeople(p);
        //addr.setNumber(67); //Para inserir o endereço utilizando persistindo a classe pessoa, o mesmo deve estar configurado.
                             //com cascata, ou para inserção ou para Tudo.(ALL)
        //em.persist(addr);
        //p.addAddress(addr);

        //for(Address address : p.getAddresses()){
        //    System.out.println("Address "+address.getId()+" is "+address.getAddress());
        //}
        
        //----------------------------------------------------------------------
        
        
        //MAPEAMENTO MUITOS PARA MUITOS PEOPLES x GROUPS
        //Group gp = em.find(Group.class, 1);
        //System.out.println("The Group "+gp.getName()+ ":");
        //for(People peoples : gp.getPeoples()){
        //    System.out.println(peoples.getId()+" - "+peoples.getName());
        //}

        //PERSISTINDO COM CALLBACK LISTENER
        //Chama a classe listener e executa os metodos mapeados.
        People p = em.find(People.class, 4);
        p.setName("Teste UPDATE");
        
        
        //COMMITANDO TRANSAÇÃO
        em.getTransaction().commit();

        //Fechando conexões do EM e da fabrica.
        em.close();
        emf.close();
    }
}
