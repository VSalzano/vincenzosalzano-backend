package Main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.LibroDAO;
import classes.Periodicita;
import classes.PrestitoDAO;
import classes.RivistaDAO;
import classes.UtenteDAO;
import model.Libro;
import model.Prestito;
import model.Rivista;
import model.Utente;

public class GestioneBiblioteca {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("GestioneBiblioteca");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		Libro l1 = new Libro("978-0123456789", "Il nome del vento", 2007, 662, "Patrick Rothfuss", "Fantasy");
		Rivista r1 = new Rivista("123456789", "La Rivista", 2023, 50, Periodicita.MENSILE);
		Utente u1 = new Utente("Mario", "Rossi", LocalDate.of(1990, 5, 15), 12345);

		
		/* try {
			LibroDAO.save(l1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			RivistaDAO.save(r1);
		} catch (SQLException e) {
			e.printStackTrace();
		} */
		
		
		Prestito p1 = new Prestito(UtenteDAO.getById(1), LibroDAO.getById(4), LocalDate.now());
		
		/* try {
			PrestitoDAO.save(p1);
		} catch (SQLException e) {
			e.printStackTrace();
		} */
		
		
	
		
		System.out.println(RivistaDAO.ricercaPerIsbn("123456789"));
		System.out.println(RivistaDAO.ricercaPerAnno(2023));
		System.out.println(RivistaDAO.ricercaPerTitolo("La Rivista"));

		
		System.out.println(LibroDAO.ricercaPerIsbn("978-0123456789"));
		System.out.println(LibroDAO.ricercaPerAnno(2007));
		System.out.println(LibroDAO.ricercaPerAnno(2300));
		System.out.println(LibroDAO.ricercaPerTitolo("Il nome del vento"));
		System.out.println(LibroDAO.ricercaPerAutore("Patrick Rothfuss"));
		
		System.out.println(PrestitoDAO.elementiInPrestito(1));
		
		System.out.println(PrestitoDAO.prestitiScaduti());
		

	}

}