package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class ReportCreateView extends FormLayout implements View,
		IBackButtonView {

	private TextField medicalDrugField;
	private TextField patientField;
	private TextArea textField;

	public ReportCreateView() {
		medicalDrugField = new TextField("Medikament");
		patientField = new TextField("Patient");
		textField = new TextArea("Text");
		addComponent(medicalDrugField);
		addComponent(patientField);
		addComponent(textField);
	}
	
	@Override
	public String getBackView() {
		return NavigatorUI.MAIN_VIEW;
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
