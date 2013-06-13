package ch.bfh.bti7081.s2013.blue.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * 
 * @author andef4
 *
 */
@Entity
public class PrescriptionItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private MedicalDrug medicalDrug;
    
    @ManyToOne
    private Prescription prescription;
    
    private int night;
    private int morning;
    private int noon;
    private int evening;
    private Date startDate;
    private Date endDate;
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
     * @return the medicalDrug
     */
    public MedicalDrug getMedicalDrug() {
        return medicalDrug;
    }
    /**
     * @param medicalDrug the medicalDrug to set
     */
    public void setMedicalDrug(MedicalDrug medicalDrug) {
        this.medicalDrug = medicalDrug;
    }
    /**
     * @return the prescription
     */
    public Prescription getPrescription() {
        return prescription;
    }
    /**
     * @param prescription the prescription to set
     */
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    /**
     * @return the night
     */
    public int getNight() {
        return night;
    }
    /**
     * @param night the night to set
     */
    public void setNight(int night) {
        this.night = night;
    }
    /**
     * @return the morning
     */
    public int getMorning() {
        return morning;
    }
    /**
     * @param morning the morning to set
     */
    public void setMorning(int morning) {
        this.morning = morning;
    }
    /**
     * @return the noon
     */
    public int getNoon() {
        return noon;
    }
    /**
     * @param noon the noon to set
     */
    public void setNoon(int noon) {
        this.noon = noon;
    }
    /**
     * @return the evening
     */
    public int getEvening() {
        return evening;
    }
    /**
     * @param evening the evening to set
     */
    public void setEvening(int evening) {
        this.evening = evening;
    }
    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
