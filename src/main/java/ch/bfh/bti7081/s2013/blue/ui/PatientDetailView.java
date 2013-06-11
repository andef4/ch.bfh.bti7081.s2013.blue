package ch.bfh.bti7081.s2013.blue.ui;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;
import ch.bfh.bti7081.s2013.blue.entities.Patient;
import ch.bfh.bti7081.s2013.blue.service.DailyPrescription;
import ch.bfh.bti7081.s2013.blue.service.PatientService;
import ch.bfh.bti7081.s2013.blue.service.PrescriptionService;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PatientDetailView extends VerticalLayout implements View, IBackButtonView {
	private Label firstNameLabel;
	private Label lastNameLabel;
	private TreeTable prescriptionTable;

	public PatientDetailView() {
		setSizeFull();
		
		// information form
		FormLayout formLayout = new FormLayout();
		firstNameLabel = new Label();
		lastNameLabel = new Label();
		firstNameLabel.setCaption("Vorname:");
		lastNameLabel.setCaption("Nachname:");
		formLayout.addComponent(firstNameLabel);
		formLayout.addComponent(lastNameLabel);
		addComponent(formLayout);
	
		// prescriptions
		Button scanButton = new Button("Scan Medikamente", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo(NavigatorUI.SCAN_VIEW);
			}
		});
		

		addComponent(scanButton); {
		prescriptionTable = new TreeTable();
		prescriptionTable.setWidth("400px");
		addComponent(prescriptionTable);
		prescriptionTable.setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
		prescriptionTable.addContainerProperty("checkbox", CheckBox.class, "");
	}
		
}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Long id = Long.parseLong(event.getParameters());
		Patient patient = PatientService.getInstance().createContainer().getItem(id).getEntity();
    	firstNameLabel.setValue(patient.getFirstName());
		lastNameLabel.setValue(patient.getLastName());
			
		List<DailyPrescription> dailyPrescriptions = PrescriptionService.getInstance().getDailyPrescriptions(patient);
		for (DailyPrescription dailyPrescription : dailyPrescriptions) {
			String date = DateFormat.getInstance().format(dailyPrescription.getDate());
			Object dateId = prescriptionTable.addItem(new Object[] {new CheckBox(date, false)}, date);

			addDailyPrescription("Morgens", dateId, dailyPrescription.getMorningDrugs());
			addDailyPrescription("Mittags", dateId, dailyPrescription.getNoonDrugs());
			addDailyPrescription("Abends", dateId, dailyPrescription.getEveningDrugs());
			addDailyPrescription("Nachts", dateId, dailyPrescription.getNightDrugs());
		}
	}
	
	 private void addDailyPrescription(String name, Object parentId, Map<MedicalDrug, Integer> drugs) {
		if (drugs.size() == 0) {
			return;
		}
		Object id = prescriptionTable.addItem(new Object[] {new CheckBox(name)}, null);
		prescriptionTable.setParent(id, parentId);
		
		for (Entry<MedicalDrug, Integer> drug : drugs.entrySet()) {
			String value = drug.getValue().toString() + " " + drug.getKey().getName();
			Object entryId = prescriptionTable.addItem(new Object[] {new CheckBox(value, false)}, null);
			
			prescriptionTable.setParent(entryId, id);
			prescriptionTable.setChildrenAllowed(entryId, false);
		}
	}

	@Override
	public String getBackView() {
		return NavigatorUI.PATIENT_SEARCH_VIEW;
	}
}
