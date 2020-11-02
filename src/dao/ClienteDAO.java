package dao;

import cliente.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO {
   private EntityManagerFactory emf = null;
   private EntityManager em = null;
   
   public void iniciar(){
       emf=Persistence.createEntityManagerFactory("ClientesPU");
       em=emf.createEntityManager();
       em.getTransaction().begin();
   }
   
   public void encerrar(){
       em.close();
   }
   
   public void inserir(Cliente cliente){
       em.persist(cliente);
       em.getTransaction().commit();
   }
   
   public Cliente consultarId(Long id){
       Cliente cliente;
       cliente = em.find(Cliente.class, id);
       return cliente;
       
   }
   
   public void atualizar(Long id, String email){
       Cliente cliente;
       cliente = consultarId(id);
       cliente.setEmail(email);
       em.getTransaction().commit();
   }
   
   public void remover(Long id){
       Cliente cliente;
       cliente = consultarId(id);
       em.remove(cliente);
       em.getTransaction().commit();
   }
}
