package classes;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Libro;
import model.Utente;



public class UtenteDAO {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("GestioneBiblioteca");
	static EntityManager em = emf.createEntityManager();
	
	public static void save(Utente u) throws SQLException {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Prestito inserito nel db");
	}
	
	public static Utente getById(int id) {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, id);
		em.getTransaction().commit();
		return u;

	}

}
