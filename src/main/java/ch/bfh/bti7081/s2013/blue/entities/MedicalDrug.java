package ch.bfh.bti7081.s2013.blue.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSwissmedicNumber() {
		return swissmedicNumber;
	}
	public void setSwissmedicNumber(String swissmedicNumber) {
		this.swissmedicNumber = swissmedicNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Distributor getDistributor() {
		return distributor;
	}
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
	public int getDailyDemand() {
		return dailyDemand;
	}
	public void setDailyDemand(int dailyDemand) {
		this.dailyDemand = dailyDemand;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public List<ActiveSubstance> getActiveSubstances() {
		return activeSubstances;
	}
}
