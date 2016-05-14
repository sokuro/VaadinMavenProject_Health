package vaadinFrame;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;

/**
 * Created by uck1 on 14.05.2016.
 */
public class MyView extends CustomComponent {

    TextField entry = new TextField("Enter this");
    Label display = new Label("Health Visitor");
    Button click = new Button("Click This");
    Button disabledClick = new Button("Click Disabled");

    Button openVisitor = new Button("Open visitor");
//    HealthVisitor visitor = new HealthVisitor();

    //constructor
    public MyView() {
//        HorizontalLayout actions = new HorizontalLayout(openVisitor);

        Layout layout = new FormLayout();
        layout.addComponent(display);

        entry.setCaption("Entry some text:");
        layout.addComponent(entry);

        click.setWidth(10, Unit.CM);
        click.setEnabled(true);
        click.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + entry.getValue()
            + ", it works!"));
        });
        layout.addComponent(click);

        disabledClick.setEnabled(false);
        layout.addComponent(disabledClick);

        openVisitor.addClickListener(e -> {
            HealthVisitor visitor = new HealthVisitor();
        });
        layout.addComponent(openVisitor);

        setCompositionRoot(layout);
//        setSizeFull();
        addStyleName("MyView");
    }
}
