package com.example.application.views.grid;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;

@Route(value = "", layout = MainView.class)
@PageTitle("Grid")
public class GridView extends Div {

    public GridView() {
        addClassName("grid-view");
        add(new Text("Content placeholder"));
    }

}
