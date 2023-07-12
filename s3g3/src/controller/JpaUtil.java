package controller;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.TipoEvento;
import model.Evento;
import model.Location;

public class JpaUtil {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("s3g3");
	static EntityManager em = emf.createEntityManager();
	
	public static void save(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println(e);
	}
	
	public static Evento getById(long id) throws SQLException {
		em.getTransaction().begin();
		Evento e = em.find(Evento.class, id);
		em.getTransaction().commit();
		return e;
	}
	
	public static void delete(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		
        Evento e1 = new Evento("Evento 1", LocalDate.of(2023, 7, 15), "Descrizione evento 1", TipoEvento.PUBBLICO, 100, new Location("Luogo 1", "Roma"));
        Evento e2 = new Evento("Evento 2", LocalDate.of(2023, 8, 1), "Descrizione evento 2", TipoEvento.PRIVATO, 50, new Location("Luogo 2", "Napoli"));
        

        try {
			save(e1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
