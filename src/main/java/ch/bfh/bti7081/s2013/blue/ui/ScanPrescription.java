package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;

public class ScanPrescription {
    private MedicalDrug medicalDrug = null;
    private boolean scanned = false;
    private int count = 0;
    
    public MedicalDrug getMedicalDrug() {
        return medicalDrug;
    }
    public void setMedicalDrug(MedicalDrug medicalDrug) {
        this.medicalDrug = medicalDrug;
    }
    public boolean isScanned() {
        return scanned;
    }
    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

}
