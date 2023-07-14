package classes;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public static List<Prestito> elementiInPrestito(int utenteId) {
	    TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.id = :utenteId", Prestito.class);
	    query.setParameter("utenteId", utenteId);

	    List<Prestito> risultati = query.getResultList();

	    if (risultati.isEmpty()) {
	        System.out.println("Nessun elemento in prestito per l'ID utente: " + utenteId);
	    }

	    return risultati;
	}
	
	public static List<Prestito> prestitiScaduti() {
	    TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.restituzioneEffettiva IS NULL AND p.restituzionePrevista < CURRENT_DATE", Prestito.class);
	    
	    List<Prestito> risultati = query.getResultList();

	    if (risultati.isEmpty()) {
	        System.out.println("Nessun prestito scaduto non restituito trovato.");
	    }

	    return risultati;
	}

}
