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
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("GestioneEventi");
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
		
		
		
		}

	}

