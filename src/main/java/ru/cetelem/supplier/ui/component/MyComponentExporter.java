package ru.cetelem.supplier.ui.component;

import com.vaadin.flow.component.WebComponentExporter;
import com.vaadin.flow.component.webcomponent.WebComponent;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;

import elemental.json.JsonValue;

@Theme(value = Material.class, variant = Material.DARK)
 public class MyComponentExporter extends WebComponentExporter<MyComponent> {
	public MyComponentExporter() {
		super("my-component");
		//The component properties (attributes) definition
		addProperty("caption-text", "xxx").onChange(MyComponent::setCaptionText);
		addProperty("on-button-click", (JsonValue)null).onChange((mc, js)-> mc.setOnButtonClick(js));
		
	
	}

	@Override
	protected void configureInstance(WebComponent<MyComponent> webComponent, MyComponent component) {
		//The component event definition for addEventListener
		component.addButtonClickListener(() ->
        	webComponent.fireEvent("button-click"));
	}
}