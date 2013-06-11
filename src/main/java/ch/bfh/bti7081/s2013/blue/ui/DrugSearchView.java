package ch.bfh.bti7081.s2013.blue.ui;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;
import ch.bfh.bti7081.s2013.blue.service.DrugService;

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
	//private TextField idNameField;
	private Button searchButton;
	private JPAContainer<MedicalDrug> drugContainer;
	private Table table;

	public DrugSearchView() {
		setSizeFull();
		
		FormLayout formLayout = new FormLayout();
		drugNameField = new TextField("Name");
		//idNameField = new TextField("Manufacturer");
		searchButton = new Button("Search");
		formLayout.addComponent(drugNameField);
		//formLayout.addComponent(idNameField);
		formLayout.addComponent(searchButton);
		addComponent(formLayout);
		
        DrugService.getInstance();
		drugContainer = DrugService.createContainer();

		table = new Table("Medikamente");
		table.setContainerDataSource(drugContainer);
		//drugContainer.addNestedContainerProperty("manufacturer.name");
		table.setVisibleColumns(new String[]{"name","stock"});
		//table.setColumnHeader("manufacturer.name", "manufacturer");
		
		table.setImmediate(true);
		addComponent(table);
		
		initButton();
		initTable();
	}
	
	private void initButton() {
		searchButton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				//drugContainer.removeContainerFilters("id");
				drugContainer.removeContainerFilters("name");
				//drugContainer.removeContainerFilters("swissmedicNumber");
				//drugContainer.removeContainerFilters("manufacturer");
				//drugContainer.removeContainerFilters("stock");
				
				String firstName = drugNameField.getValue().trim();
				//String lastName = idNameField.getValue().trim();
				if (firstName.length() > 0) {
					drugContainer.addContainerFilter("name", drugNameField.getValue(), true, true);
				}
				//if (lastName.length() > 0) {
					//drugContainer.addContainerFilter("manufacturer.name", idNameField.getValue(), true, true);
				//}
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

	public void enter(ViewChangeEvent event) {
	}

	@Override
	public String getBackView() {
		return NavigatorUI.MAIN_VIEW;
	}

}
