package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DrugDetailView extends VerticalLayout implements View,
		IBackButtonView {

	@Override
	public String getBackView() {
		return NavigatorUI.DRUG_SEARCH_VIEW;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
