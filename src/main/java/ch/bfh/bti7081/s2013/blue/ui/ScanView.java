package ch.bfh.bti7081.s2013.blue.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ScanView extends VerticalLayout implements View, IBackButtonView{

	private Label label;

	public ScanView() throws UnsupportedEncodingException {
		label = new Label("scan");
		addComponent(label);
		String host = "192.168.43.223:8080";
		String url = "http://" + host + "/#!scan/{CODE}";
		url = URLEncoder.encode(url, "UTF-8");
		Link link = new Link("scan", new ExternalResource("http://zxing.appspot.com/scan?ret=" + url));
		addComponent(link);
	}
	
	@Override
	public String getBackView() {
		return NavigatorUI.MAIN_VIEW;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		String parameters = event.getParameters();
		if (parameters != "") {
			Long id = Long.parseLong(event.getParameters());
			label.setCaption(id.toString());
		}
	}

}
