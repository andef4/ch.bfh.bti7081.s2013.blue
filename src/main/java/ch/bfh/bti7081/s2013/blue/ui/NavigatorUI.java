package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class NavigatorUI extends UI {
	
	private Navigator navigator;
	
	public static String MAIN_VIEW = ""; // this is the initial view, it must be blank
	public static String PATIENT_SEARCH_VIEW = "patient_search";
	public static String PATIENT_DETAIL_VIEW = "patient_detail";
	
	@Override
	protected void init(VaadinRequest request) {
		// initialize UI
		VerticalLayout layout = new VerticalLayout();
		final Panel panel = new Panel();
		final Button button = new Button("Zurück", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if (panel.getContent() instanceof IBackButtonView) {
					System.out.println("navigate!!!");
					IBackButtonView currentView = (IBackButtonView) panel.getContent();
					getNavigator().navigateTo(currentView.getBackView());
				}
			}
		});
		layout.addComponent(button);
		layout.addComponent(panel);
		setContent(layout);
		
		// initialize Navigator
		navigator = new Navigator(this, panel);
		
		navigator.addView(MAIN_VIEW, MainView.class);
		navigator.addView(PATIENT_SEARCH_VIEW, PatientSearchView.class);
		navigator.addView(PATIENT_DETAIL_VIEW, PatientDetailView.class);
		
		navigator.addViewChangeListener(new ViewChangeListener() {
			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {
				return true;
			}
			@Override
			public void afterViewChange(ViewChangeEvent event) {
				event.getNewView();
				if (event.getNewView() instanceof IBackButtonView) {
					IBackButtonView currentView = (IBackButtonView) event.getNewView();
					button.setVisible(currentView.getBackView() != null);
				}
			}
		});
		
	}

}
