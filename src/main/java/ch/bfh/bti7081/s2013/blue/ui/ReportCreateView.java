package ch.bfh.bti7081.s2013.blue.ui;

import java.util.List;

import ch.bfh.bti7081.s2013.blue.entities.Patient;
import ch.bfh.bti7081.s2013.blue.entities.PrescriptionItem;
import ch.bfh.bti7081.s2013.blue.entities.Report;
import ch.bfh.bti7081.s2013.blue.service.PatientService;
import ch.bfh.bti7081.s2013.blue.service.PrescriptionService;
import ch.bfh.bti7081.s2013.blue.service.ReportService;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;
/**
 * This view creates a report with the values: Report-text, prescriptionitemid
 * @author gassm9
 *
 */
@SuppressWarnings("serial")
public class ReportCreateView extends VerticalLayout implements View, IBackButtonView {

    private FormLayout formLayout;
    private Label firstNameLabel;
    private Label lastNameLabel;
    private ComboBox comboboxDrug;
    private RichTextArea rtReport;
    private Long id;
    
    /**
     * Default constructor
     */
    public ReportCreateView() {
        setSizeFull();
        
        formLayout = new FormLayout();
        firstNameLabel = new Label();
        lastNameLabel = new Label();
        comboboxDrug = new ComboBox();
        rtReport = new RichTextArea();
        firstNameLabel.setCaption("Vorname:");
        lastNameLabel.setCaption("Nachname:");
        rtReport.setCaption("Report:");
        comboboxDrug.setCaption("Medikament:");
        formLayout.addComponent(firstNameLabel);
        formLayout.addComponent(lastNameLabel);
        formLayout.addComponent(comboboxDrug);
        formLayout.addComponent(rtReport);
        addComponent(formLayout);
        
        Button saveButton = new Button("Report speichern", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            
                //save report
                Report report = new Report();
                //report.setUser(user);
                report.setText(rtReport.getValue());
                report.setPrescriptionItem((PrescriptionItem) comboboxDrug.getValue());
                ReportService.getInstance().createContainer().addEntity(report);
                
                Notification.show("Report wurde erfolgreich gespeichert.");
            }
        });
        
        addComponent(saveButton);
    }

    @Override
    /**
     * This method is called, when the page is loaded.
     */
    public void enter(ViewChangeEvent event) {
        this.id = Long.parseLong(event.getParameters());
        Patient patient = PatientService.getInstance().createContainer().getItem(id).getEntity();
        firstNameLabel.setValue(patient.getFirstName());
        lastNameLabel.setValue(patient.getLastName());
        
        List<PrescriptionItem> prescriptionItems = PrescriptionService.getInstance().getPrescriptions(patient);
    
        for (PrescriptionItem prescriptionItem : prescriptionItems) {
        
            comboboxDrug.addItem(prescriptionItem);
            comboboxDrug.setItemCaption(prescriptionItem, prescriptionItem.getMedicalDrug().getName());
        }
    }

    @Override
    public String getBackView() {
        return NavigatorUI.PATIENT_DETAIL_VIEW + "/" + this.id;
    }

}
