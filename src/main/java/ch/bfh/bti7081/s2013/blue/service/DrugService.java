package ch.bfh.bti7081.s2013.blue.service;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class DrugService implements IService {
	
	private static DrugService drugService = null;

	public static JPAContainer<MedicalDrug> createContainer() {
		return JPAContainerFactory.make(MedicalDrug.class, PERSISTENCE_UNIT_NAME);
	}
	

	/* singleton accessor method */
	public static DrugService getInstance() {
		if (drugService == null) {
			drugService = new DrugService();
		}
		return drugService;
	}
	
	
	/* private constructor for singleton */
	private DrugService() {
	}

}