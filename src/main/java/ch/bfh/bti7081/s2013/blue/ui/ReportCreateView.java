package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class ReportCreateView extends VerticalLayout implements View, IBackButtonView {

	private Label firstNameLabel;
	private Label lastNameLabel;
	private Long id;
	
	public ReportCreateView() {
		setSizeFull();
		
		FormLayout formLayout = new FormLayout();
		firstNameLabel = new Label();
		lastNameLabel = new Label();
		firstNameLabel.setCaption("Vorname:");
		lastNameLabel.setCaption("Nachname:");
		formLayout.addComponent(firstNameLabel);
		formLayout.addComponent(lastNameLabel);
		addComponent(formLayout);
		
		// prescriptions
		Button scanButton = new Button("Bericht speichern", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				
			
			}
		});
		
		addComponent(scanButton);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		this.id = Long.parseLong(event.getParameters());

		
		
	}


	@Override
	public String getBackView() {
		// TODO Auto-generated method stub
		return NavigatorUI.PATIENT_DETAIL_VIEW + "/" + this.id;
	}

}
