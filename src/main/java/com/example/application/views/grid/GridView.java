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
    }
}
