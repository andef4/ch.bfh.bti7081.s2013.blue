package ch.bfh.bti7081.s2013.blue.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;

public class DailyPrescription {
    private Date date;
    
    private Map<MedicalDrug, Integer> morningDrugs = new HashMap<MedicalDrug, Integer>();
    private Map<MedicalDrug, Integer> noonDrugs = new HashMap<MedicalDrug, Integer>();
    private Map<MedicalDrug, Integer> eveningDrugs = new HashMap<MedicalDrug, Integer>();
    private Map<MedicalDrug, Integer> nightDrugs = new HashMap<MedicalDrug, Integer>();
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Map<MedicalDrug, Integer> getMorningDrugs() {
        return morningDrugs;
    }
    
    public Map<MedicalDrug, Integer> getNoonDrugs() {
        return noonDrugs;
    }
    
    public Map<MedicalDrug, Integer> getEveningDrugs() {
        return eveningDrugs;
    }
    
    public Map<MedicalDrug, Integer> getNightDrugs() {
        return nightDrugs;
    }
}