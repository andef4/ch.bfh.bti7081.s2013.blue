package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;
/**
 * 
 * @author andef4
 *
 */
public class ScanPrescription {
    private MedicalDrug medicalDrug = null;
    private boolean scanned = false;
    private int count = 0;

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
     * @return the scanned
     */
    public boolean isScanned() {
        return scanned;
    }
    /**
     * @param scanned the scanned to set
     */
    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }
    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
}
