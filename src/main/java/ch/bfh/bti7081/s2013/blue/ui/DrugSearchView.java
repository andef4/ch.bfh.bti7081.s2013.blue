package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;
import ch.bfh.bti7081.s2013.blue.service.MedicalDrugService;

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
public class DrugSearchView extends VerticalLayout implements View, IBackButtonView {

	private TextField drugNameField;
	//private TextField manufacturerNameField;
	private Button searchButton;
	private JPAContainer<MedicalDrug> drugContainer;
	private Table table;

	public DrugSearchView() {
		setSizeFull();
		
		FormLayout formLayout = new FormLayout();
		drugNameField = new TextField("Name");
		//manufacturerNameField = new TextField("ID");
		searchButton = new Button("Search");
		formLayout.addComponent(drugNameField);
		//formLayout.addComponent(manufacturerNameField);
		formLayout.addComponent(searchButton);
		addComponent(formLayout);
		
		drugContainer = MedicalDrugService.getInstance().createContainer();
		
		table = new Table("Medikamente");
		table.setContainerDataSource(drugContainer);
		//drugContainer.addNestedContainerProperty("manufacturer.name");
		table.setVisibleColumns(new String[]{"name","stock"});
		//table.setColumnHeader("manufacturer.name", "manufacturer");
		table.setSelectable(true);
		addComponent(table);
		
		initButton();
		initTable();
	}
	
	private void initButton() {
		searchButton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				drugContainer.removeContainerFilters("name");
				//drugContainer.removeContainerFilters("swissmedicNumber");
				//drugContainer.removeContainerFilters("manufacturer");
				//drugContainer.removeContainerFilters("stock");
				//drugContainer.removeContainerFilters("swissmedicNumber");
				//drugContainer.removeContainerFilters("manufacturer");
					
				String name = drugNameField.getValue().trim();
				//String manufacturer = manufacturerNameField.getValue().trim();
				if (name.length() > 0) {
					drugContainer.addContainerFilter("name", drugNameField.getValue(), true, true);
				}
				
			}
		});
	}


	private void initTable() {
		table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				Long id = (Long) event.getItemId();
				UI.getCurrent().getNavigator().navigateTo(NavigatorUI.DRUG_DETAIL_VIEW + "/" + id);

			
		}
	});
}
		

	@Override
	public String getBackView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}