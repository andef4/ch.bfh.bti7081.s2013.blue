package ch.bfh.bti7081.s2013.blue.service;

import ch.bfh.bti7081.s2013.blue.entities.Patient;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class PatientService implements IService {

	public static JPAContainer<Patient> createContainer() {
		return JPAContainerFactory.make(Patient.class, PERSISTENCE_UNIT_NAME);
	}
	

}
