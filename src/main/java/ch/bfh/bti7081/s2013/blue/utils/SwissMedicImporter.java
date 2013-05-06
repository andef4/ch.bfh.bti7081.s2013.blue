package ch.bfh.bti7081.s2013.blue.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.bti7081.s2013.blue.entities.ActiveSubstance;
import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;

public class SwissMedicImporter {
	
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mhc-pms");
	    EntityManager em = factory.createEntityManager();
	    
	    em.getTransaction().begin();
	    
	    ActiveSubstance activeSubstance1 = new ActiveSubstance();
	    activeSubstance1.setName("Substance1");

	    ActiveSubstance activeSubstance2 = new ActiveSubstance();
	    activeSubstance2.setName("Substance2");
	    
	    em.persist(activeSubstance1);
	    em.persist(activeSubstance2);
	    
	    MedicalDrug drug = new MedicalDrug();
	    drug.setName("Dafalgan");
	    drug.getActiveSubstances().add(activeSubstance1);
	    drug.getActiveSubstances().add(activeSubstance2);
	    em.persist(drug);
	    
	    
	    
	    em.getTransaction().commit();
	    em.close();
	    
	}

}
