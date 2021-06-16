package com.example.application.views.grid;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class GridView extends Div {
    public GridView() {
        CustomGrid grid = new CustomGrid();
        add(grid);

        add(new Button("Toggle", click -> {
            if (grid.getParent().isPresent()) {
                remove(grid);
            } else {
                addComponentAsFirst(grid);
            }
        }));

        add(new Button("Scroll to 42", click -> {
            grid.getElement().callJsFunction("scrollToIndex", 42);
        }));

        add(new Button("Get width", click -> {
            PendingJavaScriptResult result = grid.getElement()
                    .executeJs("return this.offsetWidth");
            result.then(Double.class, width -> {
                Notification.show("Width: " + width);
            });
        }));

        Element input = new Element("input");
        getElement().appendChild(input);
        input.addPropertyChangeListener("value", "change", event -> {
            Notification.show("Event: " + input.getProperty("value"));
        });
    }
}
