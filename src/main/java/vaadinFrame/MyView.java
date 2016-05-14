package vaadinFrame;

import com.vaadin.ui.*;

/**
 * Created by uck1 on 14.05.2016.
 */
public class MyView extends CustomComponent {
    TextField entry = new TextField("Enter this");
    Label display = new Label("See this");
    Button click = new Button("Click This");
    Button disabledClick = new Button("Click Disabled");

    //constructor
    public MyView() {
        Layout layout = new FormLayout();
        layout.addComponent(entry);
        layout.addComponent(display);
        layout.addComponent(click);
        layout.addComponent(disabledClick);

        //configuring
        entry.setCaption("Entry some text:");
        click.setEnabled(true);
        click.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + entry.getValue()
            + ", it works!"));
        });
        click.setDescription("This is a click");
        disabledClick.setEnabled(false);

        setCompositionRoot(layout);
//        setSizeFull();
        addStyleName("MyView");
    }
}
