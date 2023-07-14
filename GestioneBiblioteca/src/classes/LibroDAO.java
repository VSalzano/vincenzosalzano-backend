package classes;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Libro;
import model.Rivista;

public class LibroDAO {
	

	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("GestioneBiblioteca");
	static EntityManager em = emf.createEntityManager();
	
	public static void save(Libro e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("libro inserito nel db");
	}
	
	public static Libro getById(int id) {
		em.getTransaction().begin();
		Libro l = em.find(Libro.class, id);
		em.getTransaction().commit();
		return l;

	}
	
	public static Libro ricercaPerIsbn(String isbn) {
	    boolean trovato = true;
	    Query query = em.createNamedQuery("ricercaLPerIsbn");
	    query.setParameter("codiceISBN", isbn);

	    try {
	        return (Libro) query.getSingleResult();
	    } catch (NoResultException e) {
	        trovato = false;
	    }

	    if (!trovato) {
	        System.out.println("Nessun risultato trovato per l'ISBN: " + isbn);
	    }

	    return null;
	}
	
	
	public static Libro ricercaPerAutore(String autore) {
	    boolean trovato = true;
	    Query query = em.createNamedQuery("ricercaLPerAutore");
	    query.setParameter("autore", autore);

	    try {
	        return (Libro) query.getSingleResult();
	    } catch (NoResultException e) {
	        trovato = false;
	    }

	    if (!trovato) {
	        System.out.println("Nessun risultato trovato per l'autore: " + autore);
	    }

	    return null;
	}
	
	public static Libro ricercaPerAnno(int anno) {
	    boolean trovato = true;
	    Query query = em.createNamedQuery("ricercaLPerAnno");
	    query.setParameter("anno", anno);

	    try {
	        return (Libro) query.getSingleResult();
	    } catch (NoResultException e) {
	        trovato = false;
	    }

	    if (!trovato) {
	        System.out.println("Nessun risultato trovato per l'anno: " + anno);
	    }

	    return null;
	}
	
	public static Libro ricercaPerTitolo(String titolo) {
	    boolean trovato = true;
	    Query query = em.createNamedQuery("ricercaLPerTitolo");
	    query.setParameter("titolo", titolo);

	    try {
	        return (Libro) query.getSingleResult();
	    } catch (NoResultException e) {
	        trovato = false;
	    }

	    if (!trovato) {
	        System.out.println("Nessun risultato trovato per il titolo: " + "%"+titolo+"%");
	    }

	    return null;
	}
	
	public static void cancellaLibro(Libro l) throws SQLException {
		em.getTransaction().begin();
		em.remove(l);
		em.getTransaction().commit();
		
	}
	
	
	


}
