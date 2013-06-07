package ch.bfh.bti7081.s2013.blue.service;

import javax.persistence.EntityManager;

import ch.bfh.bti7081.s2013.blue.entities.Patient;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class PatientService implements IService {

	private static PatientService patientService = null;

	/* 
	 * @return returns a new Vaadin JPAContainer instance for the Patient entity
	 */
	public JPAContainer<Patient> createContainer() {
		return JPAContainerFactory.make(Patient.class, PERSISTENCE_UNIT_NAME);
	}
	
	public EntityManager getEntityManager() {
		return JPAContainerFactory.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT_NAME);
	}

	/* singleton accessor method */
	public static PatientService getInstance() {
		if (patientService == null) {
			patientService = new PatientService();
		}
		return patientService;
	}
	
	
	/* private constructor for singleton */
	private PatientService() {
	}

}
