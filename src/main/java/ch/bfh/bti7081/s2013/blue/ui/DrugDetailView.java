package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DrugDetailView extends VerticalLayout implements View,
		IBackButtonView {

	public void enter(ViewChangeEvent event) {
		setSizeFull();
		Label label = new Label("Drug detail view");
		addComponent(label);
		
	}
	
	@Override
	public String getBackView() {
		return NavigatorUI.DRUG_SEARCH_VIEW;
	}

}
