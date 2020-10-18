package ru.cetelem.supplier.ui.component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.function.SerializableRunnable;

import elemental.json.JsonValue;
import ru.cetelem.supplier.domain.Car;
import ru.cetelem.supplier.service.CarService;

@HtmlImport("frontend://styles/general-styles13.html")
@HtmlImport("frontend://styles/vaadin-grid-custom13.html")
//@CssImport(value = "./styles/shared-styles.css") 14+npm
//@CssImport(value = "./styles/vaadin-grid-custom13.css",  themeFor = "vaadin-grid") 14+npm
public class MyComponent  extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(MyComponent.class); 

	private Grid<Car> crudGrid ;
	
    private String captionText = "Default";

	Label caption = new Label();
	
	private CarService carService;
	
	private JsonValue jsonValueClick;

    private List<SerializableRunnable> onButtonClick =
	            new CopyOnWriteArrayList<>();

	
	@Autowired
	public MyComponent(CarService carService) {
		log.info("MyComponent started");
		
		this.carService = carService;


		caption.setText("My Component - " + captionText);
		caption.addClassName("splitter");
		
		crudGrid = new Grid<Car>(Car.class);
	
		
		crudGrid.setItems(carService.getCars());
		

		
		crudGrid.setColumns("vin", "model");
		
		
		crudGrid.setSizeFull();	
		
		Button button = new Button();
		button.setText("Push me");
		button.addClickListener(b->{
			buttonClickFire();

	    });
		
		add(caption, crudGrid, button);
		
		
		setHeight("400px");
		setWidth("400px");
	}


	private void buttonClickFire() {
		log.info("MyComponent buttonClickFire" );
		onButtonClick.forEach(SerializableRunnable::run);
		
		Page page = UI.getCurrent().getPage();
		Optional.ofNullable(jsonValueClick).ifPresent(js->page.executeJs(js.asString()));
		
	}


	public String getCaptionText() {
		return captionText;
	}


	public void setCaptionText(String captionText) {
		log.info("MyComponent setCaptionText " + captionText );
		this.captionText = captionText ;
		caption.setText("My Component - " + captionText);
	}


	public void addButtonClickListener( SerializableRunnable buttonCLickRunnable) {

		onButtonClick.add(buttonCLickRunnable);
	}

	public void  setOnButtonClick(JsonValue jsonValue) {
		this.jsonValueClick = jsonValue;

	}


	
}
