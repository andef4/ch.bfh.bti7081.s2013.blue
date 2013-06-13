package ch.bfh.bti7081.s2013.blue.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
/**
 * This is the main and only UI used. We use a com.vaadin.navigator.Navigator
 * to navigate between different views.
 * author andef4
 *
 */
@SuppressWarnings("serial")
public class NavigatorUI extends UI {
    
    private Navigator navigator;
    
    // view names
    public static String MAIN_VIEW = ""; // this is the initial view, it must be blank
    public static String PATIENT_SEARCH_VIEW = "patient_search";
    public static String PATIENT_DETAIL_VIEW = "patient_detail";
    public static String SCAN_VIEW = "scan";
    public static String DRUG_SEARCH_VIEW = "drug_search";
    public static String DRUG_DETAIL_VIEW = "drug_detail";
    public static String REPORT_CREATE_VIEW = "report_create_view";
    public static String REPORT_SEARCH_VIEW = "report_search_view";
    public static String REPORT_DETAIL_VIEW = "report_detail_view";
    
    // session variable names
    public static final String DRUGS_TO_SCAN_SESSION = "drugsToScan";
    
    @Override
    protected void init(VaadinRequest request) {
        // initialize UI
        VerticalLayout layout = new VerticalLayout();
        final Panel panel = new Panel();
        final Button button = new Button("Zurück", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                if (panel.getContent() instanceof IBackButtonView) {
                    // get current displayed view
                    IBackButtonView currentView = (IBackButtonView) panel.getContent();
                    // go back to the view defined on the current View
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
        navigator.addView(SCAN_VIEW, ScanView.class);
        
        navigator.addView(DRUG_SEARCH_VIEW, DrugSearchView.class);
        navigator.addView(DRUG_DETAIL_VIEW, DrugDetailView.class);
        
        navigator.addView(REPORT_CREATE_VIEW, ReportCreateView.class);
        navigator.addView(REPORT_SEARCH_VIEW, ReportSearchView.class);
        navigator.addView(REPORT_DETAIL_VIEW, ReportDetailView.class);
        
        navigator.addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                return true; // always change view
            }
            @Override
            public void afterViewChange(ViewChangeEvent event) {
                if (event.getNewView() instanceof IBackButtonView) {
                    // hide back button if getBackView() returns null
                    IBackButtonView currentView = (IBackButtonView) event.getNewView();
                    button.setVisible(currentView.getBackView() != null);
                }
            }
        });
        
    }

}
