package classes;

import java.sql.SQLException;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Libro;
import model.Rivista;

public class RivistaDAO {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("GestioneBiblioteca");
	static EntityManager em = emf.createEntityManager();
	
	public static void save(Rivista r) throws SQLException {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		System.out.println("Rivista inserita nel db");
	}
	
	public static Rivista ricercaPerIsbn(String isbn) {
	    boolean trovato = true;
	    Query query = em.createNamedQuery("ricercaRPerIsbn");
	    query.setParameter("codiceISBN", isbn);

	    try {
	        return (Rivista) query.getSingleResult();
	    } catch (NoResultException e) {
	        trovato = false;
	    }

	    if (!trovato) {
	        System.out.println("Nessun risultato trovato per l'ISBN: " + isbn);
	    }

	    return null;
	}
	
	
	public static Rivista ricercaPerAnno(int anno) {
		
	    boolean trovato = true;
	    Query query = em.createNamedQuery("ricercaRPerAnno");
	    query.setParameter("anno", anno);

	    try {
	        return (Rivista) query.getSingleResult();
	    } catch (NoResultException e) {
	        trovato = false;
	    }

	    if (!trovato) {
	        System.out.println("Nessun risultato trovato per l'anno " + anno);
	    }
		return null;
	}
	
	
	public static Rivista ricercaPerTitolo(String titolo) {
	    boolean trovato = true;
	    Query query = em.createNamedQuery("ricercaRPerTitolo");
	    query.setParameter("titolo", "%"+titolo+"%");

	    try {
	        return (Rivista) query.getSingleResult();
	    } catch (NoResultException e) {
	        trovato = false;
	    }

	    if (!trovato) {
	        System.out.println("Nessun risultato trovato per il titolo: " + titolo);
	    }

	    return null;
	}
	
	public static void cancellaRivista(Rivista r) throws SQLException {
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		
	}

}
