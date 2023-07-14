package classes;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Prestito;



public class PrestitoDAO {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("GestioneBiblioteca");
	static EntityManager em = emf.createEntityManager();
	
	public static void save(Prestito p) throws SQLException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Prestito inserito nel db");
	}

}
