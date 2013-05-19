package ch.bfh.bti7081.s2013.blue.utils;

import java.sql.Date;
import java.util.Calendar;
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
				
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 1930 + r.nextInt(80));
				calendar.set(Calendar.MONTH,  + r.nextInt(12));
				calendar.set(Calendar.DAY_OF_MONTH, 1 + r.nextInt(28));
				Date date = new Date(calendar.getTime().getTime());
				patient.setBirthday(date);
				em.persist(patient);
			}
		}
		em.getTransaction().commit();
		em.close();

	}

}



