package ch.bfh.bti7081.s2013.blue.service;

import javax.persistence.EntityManager;

import ch.bfh.bti7081.s2013.blue.entities.Report;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class ReportService implements IService {
    
    private static ReportService reportService = null;

    /* 
     * @return returns a new Vaadin JPAContainer instance for the Patient entity
     */
    public JPAContainer<Report> createContainer() {
        return JPAContainerFactory.make(Report.class, PERSISTENCE_UNIT_NAME);
    }
    
    public EntityManager getEntityManager() {
        return JPAContainerFactory.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT_NAME);
    }

    /* singleton accessor method */
    public static ReportService getInstance() {
        if (reportService == null) {
            reportService = new ReportService();
        }
        return reportService;
    }
    
    
    /* private constructor for singleton */
    private ReportService() {
    }


}
