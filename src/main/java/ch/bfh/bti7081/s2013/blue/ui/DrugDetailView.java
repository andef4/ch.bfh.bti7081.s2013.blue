package ch.bfh.bti7081.s2013.blue.ui;


import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;
import ch.bfh.bti7081.s2013.blue.service.MedicalDrugService;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public  class DrugDetailView extends VerticalLayout implements View, IBackButtonView {
	private Label drugNameLabel;
	private Label idNameLabel;
	private Label swissNameLabel;
	

	public DrugDetailView() {
		setSizeFull();
	
	    //information form
		FormLayout formLayout = new FormLayout();
		drugNameLabel = new Label();
		swissNameLabel = new Label();
		idNameLabel = new Label();
		drugNameLabel.setCaption("Name:");
		swissNameLabel.setCaption("MedicNumber:");
		idNameLabel.setCaption("Manufacturer:");	
		formLayout.addComponent(drugNameLabel);
		formLayout.addComponent(swissNameLabel);
		formLayout.addComponent(idNameLabel);		
		addComponent(formLayout);
				
		
	}
		
	
	public void enter (ViewChangeEvent event) {
		Long id = Long.parseLong(event.getParameters());
		MedicalDrug medicaldrug = MedicalDrugService.getInstance().createContainer().getItem(id).getEntity();
		drugNameLabel.setValue(medicaldrug.getName());
		swissNameLabel.setValue(medicaldrug.getSwissmedicNumber());
		idNameLabel.setValue(medicaldrug.getManufacturer().getName());
		
		
		
		
	}
	

	

	@Override
	public String getBackView() {
		return NavigatorUI.DRUG_SEARCH_VIEW;
	}


	
}

	
