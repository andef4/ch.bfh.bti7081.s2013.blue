package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ScanView extends VerticalLayout implements View, IBackButtonView{

	public ScanView() {
		
	}
	
	@Override
	public String getBackView() {
		return NavigatorUI.MAIN_VIEW;
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}