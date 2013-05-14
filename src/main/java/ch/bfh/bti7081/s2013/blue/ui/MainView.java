package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View {

	private Navigator navigator = null;
	
	public MainView() {
		setSizeFull();
		Button button = new Button("Search Patient", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				navigator.navigateTo(NavigatorUI.PATIENT_SEARCH_VIEW);
			}
		});
		addComponent(button);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		navigator = event.getNavigator();
	}

}
