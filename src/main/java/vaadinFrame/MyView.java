package vaadinFrame;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by uck1 on 14.05.2016.
 */
public class MyView extends VerticalLayout {
    TextField entry = new TextField("Enter this");
    Label   display = new Label("See this");
    Button    click = new Button("Click This");

    //constructor
    public MyView() {
        addComponent(entry);
        addComponent(display);
        addComponent(click);

        //configuring
        setSizeFull();
        addStyleName("MyView");
    }
}
