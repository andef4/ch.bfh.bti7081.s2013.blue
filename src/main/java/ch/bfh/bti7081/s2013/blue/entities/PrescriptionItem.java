package ch.bfh.bti7081.s2013.blue.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public MedicalDrug getMedicalDrug() {
		return medicalDrug;
	}
	public void setMedicalDrug(MedicalDrug medicalDrug) {
		this.medicalDrug = medicalDrug;
	}
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	public int getNight() {
		return night;
	}
	public void setNight(int night) {
		this.night = night;
	}
	public int getMorning() {
		return morning;
	}
	public void setMorning(int morning) {
		this.morning = morning;
	}
	public int getNoon() {
		return noon;
	}
	public void setNoon(int noon) {
		this.noon = noon;
	}
	public int getEvening() {
		return evening;
	}
	public void setEvening(int evening) {
		this.evening = evening;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
