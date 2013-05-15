package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.Patient;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PatientSearchView extends VerticalLayout implements View, IBackButtonView {

	public PatientSearchView() {
		setSizeFull();
		Label label = new Label("Patient search");
		addComponent(label);
		
        JPAContainer<Patient> patientContainer = JPAContainerFactory.make(Patient.class, "mhc-pms");

		Table table = new Table("Patients", patientContainer);
		table.setVisibleColumns(new String[]{"firstName", "lastName", "birthday"});
		table.setImmediate(true);
		addComponent(table);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}

	@Override
	public String getBackView() {
		return NavigatorUI.MAIN_VIEW;
	}

}
