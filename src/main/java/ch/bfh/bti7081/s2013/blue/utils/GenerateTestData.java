package ch.bfh.bti7081.s2013.blue.utils;

import java.sql.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.bti7081.s2013.blue.entities.Patient;

public class GenerateTestData {
	

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mhc-pms");
	    EntityManager em = factory.createEntityManager();
	    
	    em.getTransaction().begin();
	    
	    String[] firstNames = {"Fritz", "Ueli", "Peter", "Tobias", "Marcel"};
	    String[] lastNames = {"Berger", "Brügger", "Müller"};
	    
		for (String firstName : firstNames) {
			for (String lastName : lastNames) {
				Patient patient = new Patient();
				patient.setFirstName(firstName);
				patient.setLastName(lastName);
				
				Random r = new Random();
				int year = 1930 + r.nextInt(80);
				int month = 1 + r.nextInt(12);
				int day = 1 + r.nextInt(28);
				System.out.println(year);
				Date date = new Date(year, month, day);
				patient.setBirthday(date);
				em.persist(patient);
			}
		}
		em.getTransaction().commit();
		em.close();

	}

}



