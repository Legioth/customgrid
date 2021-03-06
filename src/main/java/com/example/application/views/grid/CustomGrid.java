package com.example.application.views.grid;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.internal.JsonUtils;

import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

@NpmPackage(value = "@vaadin/vaadin-grid", version = "5.7.13")
@JsModule("@vaadin/vaadin-grid")
@JsModule("./grid.ts")
@Tag("vaadin-grid")
public class CustomGrid extends Component {
    @DomEvent("active-item-changed")
    public static class ActiveItemChangedEvent extends ComponentEvent<CustomGrid> {
        private Integer id;

        public ActiveItemChangedEvent(CustomGrid source, boolean fromClient,
                @EventData("event.detail.value?.id") Integer id) {
            super(source, fromClient);
            this.id = id;
        }
    }

    public CustomGrid() {
        Arrays.asList("id", "value").forEach(path -> {
            Element col = new Element("vaadin-grid-column");
            col.setAttribute("path", path);
            getElement().appendChild(col);
        });

        ComponentUtil.addListener(this, ActiveItemChangedEvent.class, event -> {
            if (event.id == null) {
                Notification.show("Deselect");
            } else {
                Notification.show("Select " + event.id);
            }
        });

        addAttachListener(attachEvent -> {
            getElement().executeJs("window.initGrid(this)");
        });
    }

    @ClientCallable
    JsonArray requestRows(int page, int pageSize) {
        int start = page * pageSize;
        JsonArray items = IntStream.range(start, start + pageSize).mapToObj(index -> {
            JsonObject row = Json.createObject();
            row.put("id", index);
            row.put("value", "Value " + index);
            return row;
        }).collect(JsonUtils.asArray());
        return items;
    }
}