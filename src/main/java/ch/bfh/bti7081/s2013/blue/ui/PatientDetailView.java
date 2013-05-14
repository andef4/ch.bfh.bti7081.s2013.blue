package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PatientDetailView extends VerticalLayout implements View, IBackButtonView {
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public String getBackView() {
		return NavigatorUI.PATIENT_SEARCH_VIEW;
	}

}
