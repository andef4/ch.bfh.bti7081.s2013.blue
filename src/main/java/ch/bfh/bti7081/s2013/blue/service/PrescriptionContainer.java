package ch.bfh.bti7081.s2013.blue.service;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;
import ch.bfh.bti7081.s2013.blue.entities.Patient;

import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;

@SuppressWarnings({"serial", "unchecked"})
public class PrescriptionContainer extends HierarchicalContainer {
	
	public PrescriptionContainer(Patient patient) {
		addContainerProperty("caption", String.class, "");
		
		List<DailyPrescription> dailyPrescriptions = PrescriptionService.getInstance().getDailyPrescriptions(patient);
		for (DailyPrescription dailyPrescription : dailyPrescriptions) {
			String date = DateFormat.getInstance().format(dailyPrescription.getDate());
			Item dateItem = addItem(date);
			dateItem.getItemProperty("caption").setValue(date);
			
			addDailyPrescription("Morgens", date, dailyPrescription.getMorningDrugs());
			addDailyPrescription("Mittags", date, dailyPrescription.getNoonDrugs());
			addDailyPrescription("Abends", date, dailyPrescription.getEveningDrugs());
			addDailyPrescription("Nachts", date, dailyPrescription.getNightDrugs());	
		}
	}
	
	private void addDailyPrescription(String name, Object parentId, Map<MedicalDrug, Integer> drugs) {
		if (drugs.size() == 0) {
			return;
		}
		Object id = addItem();
		getItem(id).getItemProperty("caption").setValue(name);
		setParent(id, parentId);
		for (Entry<MedicalDrug, Integer> drug : drugs.entrySet()) {
			Object entryId = addItem();
			getItem(entryId).getItemProperty("caption").setValue(drug.getValue().toString() + " " + drug.getKey().getName());
			setChildrenAllowed(entryId, false);
			setParent(entryId, id);
		}
	}
}
