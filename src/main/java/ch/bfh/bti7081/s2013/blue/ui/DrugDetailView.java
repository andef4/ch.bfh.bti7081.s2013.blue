package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DrugDetailView extends VerticalLayout implements View, IBackButtonView {
	private Label firstNameLabel;
	private Label lastNameLabel;
	
	
	public DrugDetailView() {
		setSizeFull();
		
		// information form
		FormLayout formLayout = new FormLayout();
		firstNameLabel = new Label();
		lastNameLabel = new Label();
		firstNameLabel.setCaption("Name:");
		lastNameLabel.setCaption("Manufacturer:");
		formLayout.addComponent(firstNameLabel);
		formLayout.addComponent(lastNameLabel);
		addComponent(formLayout);
		
			}


	@Override
	public String getBackView() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
		
	

//	@Override
	//public String getBackView() {
		//return NavigatorUI.DRUG_SEARCH_VIEW;
	}

	//@Override
	//public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
//	}

//}
