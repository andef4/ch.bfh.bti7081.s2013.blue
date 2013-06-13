package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
/**
 * Start page of the application
 * @author andef4
 *
 */
@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View, IBackButtonView {

    /**
     * Default constructor
     */
    public MainView() {
        setSizeFull();
        Button patientSearchButton = new Button("Patient suchen", new NavigationClickListener(NavigatorUI.PATIENT_SEARCH_VIEW));
        Button drugSearchButton = new Button("Medikament suchen", new NavigationClickListener(NavigatorUI.DRUG_SEARCH_VIEW));
        Button reportSearchButton = new Button("Bericht suchen", new NavigationClickListener(NavigatorUI.REPORT_SEARCH_VIEW));
        
        addComponent(patientSearchButton);
        addComponent(drugSearchButton);
        addComponent(reportSearchButton);
        
        patientSearchButton.setWidth("100%");
        drugSearchButton.setWidth("100%");
        reportSearchButton.setWidth("100%");
        
        setMargin(true);
        setSpacing(true);
    }
    
    @Override
    /**
     * This method is called, when the page is loaded.
     */
    public void enter(ViewChangeEvent event) {
    }
    
    @Override
    public String getBackView() {
        return null;
    }
    
    /**
     * 
     * @author andef4
     *
     */
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
