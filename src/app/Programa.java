package app;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        Pessoa matheus = new Pessoa(null,"Matheus", "Barros de Sousa", 23);
        System.out.println(matheus.toString());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoSpringPersistence");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(matheus);
        em.getTransaction().commit();
        System.out.println("Conexão Finalizada");
    }
}
