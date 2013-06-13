package ch.bfh.bti7081.s2013.blue.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
/**
 * 
 * @author kampf1
 *
 */
@Entity
public class MedicalDrug {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String swissmedicNumber;
    private String name;
    private int dailyDemand;
    private int stock;
    
    @ManyToOne
    private Manufacturer manufacturer;
    
    @ManyToOne
    private Distributor distributor;
    
    @ManyToMany
    private List<ActiveSubstance> activeSubstances = new ArrayList<ActiveSubstance>();
    
       public List<ActiveSubstance> getActiveSubstances() {
        return activeSubstances;
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the swissmedicNumber
     */
    public String getSwissmedicNumber() {
        return swissmedicNumber;
    }

    /**
     * @param swissmedicNumber the swissmedicNumber to set
     */
    public void setSwissmedicNumber(String swissmedicNumber) {
        this.swissmedicNumber = swissmedicNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dailyDemand
     */
    public int getDailyDemand() {
        return dailyDemand;
    }

    /**
     * @param dailyDemand the dailyDemand to set
     */
    public void setDailyDemand(int dailyDemand) {
        this.dailyDemand = dailyDemand;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the manufacturer
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the distributor
     */
    public Distributor getDistributor() {
        return distributor;
    }

    /**
     * @param distributor the distributor to set
     */
    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    /**
     * @param activeSubstances the activeSubstances to set
     */
    public void setActiveSubstances(List<ActiveSubstance> activeSubstances) {
        this.activeSubstances = activeSubstances;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MedicalDrug other = (MedicalDrug) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
