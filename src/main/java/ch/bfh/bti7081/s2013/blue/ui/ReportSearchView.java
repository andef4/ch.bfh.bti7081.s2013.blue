package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.Report;
import ch.bfh.bti7081.s2013.blue.service.ReportService;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class ReportSearchView extends VerticalLayout implements View, IBackButtonView {

    private TextField firstNameField;
    private TextField lastNameField;
    private TextField drugNameField;
    private Button searchButton;
    private JPAContainer<Report> reportContainer;
    private Table table;
    
    public ReportSearchView() {
        setSizeFull(); 
                
        FormLayout formLayout = new FormLayout();
        firstNameField = new TextField("Vorname");
        lastNameField = new TextField("Nachname");
        drugNameField = new TextField("Medikament");
        searchButton = new Button("Search");
        formLayout.addComponent(firstNameField);
        formLayout.addComponent(lastNameField);
        formLayout.addComponent(drugNameField);
        formLayout.addComponent(searchButton);
        addComponent(formLayout);
        
        reportContainer = ReportService.getInstance().createContainer();
        reportContainer.addNestedContainerProperty("prescriptionItem.medicalDrug.name");
        reportContainer.addNestedContainerProperty("prescriptionItem.prescription.patient.firstName");
        reportContainer.addNestedContainerProperty("prescriptionItem.prescription.patient.lastName");
        table = new Table("Reports");
        table.setContainerDataSource(reportContainer);
        table.setVisibleColumns(new String[]{"prescriptionItem.medicalDrug.name", "prescriptionItem.prescription.patient.firstName", "prescriptionItem.prescription.patient.lastName"});
        table.setColumnHeader("prescriptionItem.medicalDrug.name", "Medikament");
        table.setColumnHeader("prescriptionItem.prescription.patient.firstName", "Vorname");
        table.setColumnHeader("prescriptionItem.prescription.patient.lastName", "Nachname");
        table.setSelectable(true);
        addComponent(table);
        
        initButton();
        initTable();
    }
    
    private void initButton() {
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                reportContainer.removeContainerFilters("prescriptionItem.prescription.patient.firstName");
                reportContainer.removeContainerFilters("prescriptionItem.prescription.patient.lastName");
                reportContainer.removeContainerFilters("prescriptionItem.medicalDrug.name");

                String firstName = firstNameField.getValue().trim();
                String lastName = lastNameField.getValue().trim();
                String drugName = drugNameField.getValue().trim();
                if (firstName.length() > 0) {
                    reportContainer.addContainerFilter("prescriptionItem.prescription.patient.firstName", firstNameField.getValue(), true, true);
                }
                if (lastName.length() > 0) {
                    reportContainer.addContainerFilter("prescriptionItem.prescription.patient.lastName", lastNameField.getValue(), true, true);
                }
                if (drugName.length() > 0) {
                    reportContainer.addContainerFilter("prescriptionItem.medicalDrug.name", drugNameField.getValue(), true, true);
                }
            }
        });
    }

    private void initTable() {
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {
                Long id = (Long) event.getItemId();
                UI.getCurrent().getNavigator().navigateTo(NavigatorUI.REPORT_DETAIL_VIEW + "/" + id);
            }
        });    
    }
    
    @Override
    public String getBackView() {
        return NavigatorUI.MAIN_VIEW;
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
