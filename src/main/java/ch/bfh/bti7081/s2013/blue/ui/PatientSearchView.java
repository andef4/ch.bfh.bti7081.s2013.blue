package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.Patient;
import ch.bfh.bti7081.s2013.blue.service.PatientService;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
/**
 * In this view, you can search for patients.
 * Search criterias: Patient (firstname, lastname) 
 * @author andef4
 *
 */
public class PatientSearchView extends VerticalLayout implements View, IBackButtonView {

    private TextField firstNameField;
    private TextField lastNameField;
    private Button searchButton;
    private JPAContainer<Patient> patientContainer;
    private Table table;

    /**
     * Default constructor
     */
    public PatientSearchView() {
        setSizeFull();
        
        FormLayout formLayout = new FormLayout();
        firstNameField = new TextField("Vorname");
        lastNameField = new TextField("Nachname");
        searchButton = new Button("Search");
        formLayout.addComponent(firstNameField);
        formLayout.addComponent(lastNameField);
        formLayout.addComponent(searchButton);
        addComponent(formLayout);
        
        patientContainer = PatientService.getInstance().createContainer();

        table = new Table("Patients");
        table.setContainerDataSource(patientContainer);
        table.setVisibleColumns(new String[]{"firstName", "lastName", "birthday"});
        table.setSelectable(true);
        addComponent(table);
        
        initButton();
        initTable();
    }
    
    /**
     * Initialize the search button
     */
    private void initButton() {
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                patientContainer.removeContainerFilters("firstName");
                patientContainer.removeContainerFilters("lastName");
                
                String firstName = firstNameField.getValue().trim();
                String lastName = lastNameField.getValue().trim();
                if (firstName.length() > 0) {
                    patientContainer.addContainerFilter("firstName", firstNameField.getValue(), true, true);
                }
                if (lastName.length() > 0) {
                    patientContainer.addContainerFilter("lastName", lastNameField.getValue(), true, true);
                }
            }
        });
    }
    
    /**
     * Initializes a table with the search results
     */
    private void initTable() {
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {
                Long id = (Long) event.getItemId();
                UI.getCurrent().getNavigator().navigateTo(NavigatorUI.PATIENT_DETAIL_VIEW + "/" + id);
            }
        });   
    }
    
    @Override
    /**
     * This method is called, when the page is loaded.
     */
    public void enter(ViewChangeEvent event) {
        
    }

    @Override
    public String getBackView() {
        return NavigatorUI.MAIN_VIEW;
    }

}
