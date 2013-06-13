package ch.bfh.bti7081.s2013.blue.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
/**
 * Scans a barcode of a drug.
 * @author andef4
 *
 */
@SuppressWarnings("serial")
public class ScanView extends VerticalLayout implements View, IBackButtonView {

    private String scanUrl = null;
    private Object patientId;
    
    /**
     * Default constructor
     * @throws UnsupportedEncodingException
     */
    public ScanView() throws UnsupportedEncodingException {
        Button scanButton = new Button("Scan Medikament", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Page.getCurrent().open(scanUrl, "");
            }
        });
        addComponent(scanButton);
    }

    @Override
    /**
     * This method is called, when the page is loaded.
     */
    public void enter(ViewChangeEvent event) {
        // load drugs to scan from session
        @SuppressWarnings("unchecked")
        Map<String, ScanPrescription> drugsToScan = (Map<String, ScanPrescription>) UI.getCurrent()
            .getSession().getAttribute(NavigatorUI.DRUGS_TO_SCAN_SESSION);

        // parameter contains patientId or patientId and swissMedicNumber separated by /
        String[] splits = event.getParameters().split("/");

        if (splits.length != 1 && splits.length != 2) {
            UI.getCurrent().getNavigator().navigateTo(NavigatorUI.MAIN_VIEW);
            return;
        }

        // get patentId
        try {
            patientId = Long.parseLong(splits[0]);
        } catch (NumberFormatException e) {
            UI.getCurrent().getNavigator().navigateTo(NavigatorUI.MAIN_VIEW);
            return;
        }

        if (splits.length == 2) {
            String swissmedicId = splits[1];
            if (swissmedicId.length() != 13) {
                Notification.show("Ungültige SwissMedic Nummer");
            }
            swissmedicId = swissmedicId.substring(4, 9);
            ScanPrescription scanPrescription = drugsToScan.get(swissmedicId);
            if (scanPrescription == null) {
                Notification.show("Falsches Medikament gescannt!");
            } else if (scanPrescription.isScanned()) {
                Notification.show("Dieses Medikament wurde bereits gescannt!");
            } else {
                scanPrescription.setScanned(true);
            }
        }

        try {
            String host = "192.168.2.142";
            String returnUrl = "http://" + host + ":8080/#!scan/" + patientId + "/{CODE}";
            scanUrl = "http://zxing.appspot.com/scan?ret=" + URLEncoder.encode(returnUrl, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
        }

        for (ScanPrescription scanPrescription : drugsToScan.values()) {
            String caption;
            if (scanPrescription.isScanned()) {
                caption = "[x] ";
            } else {
                caption = "[ ] ";
            }
            caption += scanPrescription.getCount() + " x " + scanPrescription.getMedicalDrug().getName();
            Label label = new Label(caption);
            addComponent(label);
        }
    }
    
    @Override
    public String getBackView() {
        return NavigatorUI.PATIENT_DETAIL_VIEW + "/" + patientId;
    }
}
