package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class NavigatorUI extends UI {


	private Navigator navigator;
	
	public static String MAIN_VIEW = "";
	public static String PATIENT_SEARCH_VIEW = "patient_search";
	public static String PATIENT_DETAIL_VIEW = "patient_detail";
	
	
	@Override
	protected void init(VaadinRequest request) {
		navigator = new Navigator(this, this);
		navigator.addView(MAIN_VIEW, MainView.class);
		navigator.addView(PATIENT_SEARCH_VIEW, PatientSearchView.class);
		navigator.addView(PATIENT_DETAIL_VIEW, PatientDetailView.class);
	}

}
