package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.Report;
import ch.bfh.bti7081.s2013.blue.service.ReportService;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ReportDetailView extends VerticalLayout implements View, IBackButtonView {
	private Label reportPatientFirstName;
	private Label reportPatientLastName;
	private Label reportPatientDOB;
	private Label reportDrugName;
	private Label reportDoctor;
	private Label reportText;
	private Label reportDrugStartDate;
	private Label reportDrugEndDate;
	private Label seperator;
	private Label seperator2;

	
	public ReportDetailView() {
		setSizeFull();
	
	    //information form
		FormLayout formLayout = new FormLayout();
		reportPatientFirstName = new Label();
		reportPatientLastName = new Label();
		reportPatientDOB = new Label();
		reportDrugName = new Label();
		reportDoctor = new Label();
		reportText = new Label();
		reportDrugStartDate = new Label();
		reportDrugEndDate = new Label();
		seperator = new Label("<hr/>", ContentMode.HTML);
		seperator2 = new Label("<hr/>", ContentMode.HTML);
		
		reportPatientFirstName.setCaption("Vorname:");
		reportPatientLastName.setCaption("Nachname:");
		reportPatientDOB.setCaption("Geburtsdatum:");
		reportDrugName.setCaption("Medikament:");
		reportDoctor.setCaption("Behandelnder Arzt:");
		reportDrugStartDate.setCaption("Behandlung Anfang:");
		reportDrugEndDate.setCaption("Behandlung Ende:");
		reportText.setCaption("Report:");
		
		formLayout.addComponent(reportPatientFirstName);
		formLayout.addComponent(reportPatientLastName);
		formLayout.addComponent(reportPatientDOB);
		formLayout.addComponent(seperator);
		formLayout.addComponent(reportDrugName);
		formLayout.addComponent(reportDoctor);
		formLayout.addComponent(reportDrugStartDate);
		formLayout.addComponent(reportDrugEndDate);
		formLayout.addComponent(seperator2);
		formLayout.addComponent(reportText);
		
		addComponent(formLayout);	
	}
	
	public void enter (ViewChangeEvent event) {
		Long id = Long.parseLong(event.getParameters());
		
		Report report = ReportService.getInstance().createContainer().getItem(id).getEntity();
		
		reportPatientFirstName.setValue(report.getPrescriptionItem().getPrescription().getPatient().getFirstName());
		reportPatientLastName.setValue(report.getPrescriptionItem().getPrescription().getPatient().getLastName());
		reportPatientDOB.setValue(report.getPrescriptionItem().getPrescription().getPatient().getBirthday().toString());
		reportDrugName.setValue(report.getPrescriptionItem().getMedicalDrug().getName());
		reportDoctor.setValue(report.getPrescriptionItem().getPrescription().getDoctor());
		reportDrugStartDate.setValue(report.getPrescriptionItem().getStartDate().toString());
		reportDrugEndDate.setValue(report.getPrescriptionItem().getEndDate().toString());
		reportText.setValue(report.getText());
	}

	@Override
	public String getBackView() {
		return NavigatorUI.REPORT_SEARCH_VIEW;
	}
}

	
