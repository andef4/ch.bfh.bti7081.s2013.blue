package ch.bfh.bti7081.s2013.blue.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private PrescriptionItem prescriptionItem;
	
	private String text;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PrescriptionItem getPrescriptionItem() {
		return prescriptionItem;
	}
	public void setPrescriptionItem(PrescriptionItem prescriptionItem) {
		this.prescriptionItem = prescriptionItem;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
