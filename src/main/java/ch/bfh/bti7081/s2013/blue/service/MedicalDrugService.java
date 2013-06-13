package ch.bfh.bti7081.s2013.blue.service;

import javax.persistence.EntityManager;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class MedicalDrugService implements IService {

    private static MedicalDrugService medicalDrugService = null;

    /* 
     * @return returns a new Vaadin JPAContainer instance for the Patient entity
     */
    public JPAContainer<MedicalDrug> createContainer() {
        return JPAContainerFactory.make(MedicalDrug.class, PERSISTENCE_UNIT_NAME);
    }
    
    public EntityManager getEntityManager() {
        return JPAContainerFactory.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT_NAME);
    }

    /* singleton accessor method */
    public static MedicalDrugService getInstance() {
        if (medicalDrugService == null) {
            medicalDrugService = new MedicalDrugService();
        }
        return medicalDrugService;
    }
    
    /* private constructor for singleton */
    private MedicalDrugService() {
    }

}
