package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View, IBackButtonView {

	
	public MainView() {
		setSizeFull();
		Button patientSearchButton = new Button("Patient suchen", new NavigationClickListener(NavigatorUI.PATIENT_SEARCH_VIEW));
		Button drugSearchButton = new Button("Medikament suchen", new NavigationClickListener(NavigatorUI.DRUG_SEARCH_VIEW));
		Button reportCreateButton = new Button("Bericht erstellen", new NavigationClickListener(NavigatorUI.REPORT_CREATE_VIEW));
		Button reportSearchButton = new Button("Bericht suchen", new NavigationClickListener(NavigatorUI.REPORT_SEARCH_VIEW));
		
		addComponent(patientSearchButton);
		addComponent(drugSearchButton);
		addComponent(reportCreateButton);
		addComponent(reportSearchButton);
		
		patientSearchButton.setWidth("100%");
		drugSearchButton.setWidth("100%");
		reportCreateButton.setWidth("100%");
		reportSearchButton.setWidth("100%");
		
		setMargin(true);
		setSpacing(true);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}
	
	@Override
	public String getBackView() {
		return null;
	}
	
	class NavigationClickListener implements ClickListener {
		private String view;
		public NavigationClickListener(String view) {
			this.view = view;
		}
		@Override
		public void buttonClick(ClickEvent event) {
			UI.getCurrent().getNavigator().navigateTo(view);
		}
	};
}
