package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.Patient;
import ch.bfh.bti7081.s2013.blue.service.PatientService;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PatientDetailView extends VerticalLayout implements View, IBackButtonView {
	private Label firstNameLabel;
	private Label lastNameLabel;

	public PatientDetailView() {
		setSizeFull();
		
		FormLayout formLayout = new FormLayout();
		firstNameLabel = new Label();
		lastNameLabel = new Label();
		firstNameLabel.setCaption("Vorname:");
		lastNameLabel.setCaption("Nachname:");
		formLayout.addComponent(firstNameLabel);
		formLayout.addComponent(lastNameLabel);
		addComponent(formLayout);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Long id = Long.parseLong(event.getParameters());
		Patient patient = PatientService.createContainer().getItem(id).getEntity();
		firstNameLabel.setValue(patient.getFirstName());
		lastNameLabel.setValue(patient.getLastName());
	}

	@Override
	public String getBackView() {
		return NavigatorUI.PATIENT_SEARCH_VIEW;
	}

}
