package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PatientSearchView extends VerticalLayout implements View {

	
	public PatientSearchView() {
		setSizeFull();
		Label label = new Label("Patient search");
		addComponent(label);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
