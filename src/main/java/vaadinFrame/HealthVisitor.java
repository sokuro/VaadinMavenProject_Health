package vaadinFrame;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

/**
 * Created by uck1 on 14.05.2016.
 */
public class HealthVisitor extends FormLayout {
    TextField name = new TextField("Enter a name");
    Button ok = new Button("OK");

    public HealthVisitor() {

        configureComponents();
        buildLayout();
    }

    private void configureComponents() {

    }

    private void buildLayout() {
        setMargin(true);

        Layout layout = new FormLayout();
//        name.setIcon(new ThemeResource("icons/user.png"));
        layout.addComponent(name);

//        ok.setIcon(new ThemeResource(""));
        layout.addComponent(ok);

//        addStyleName("HealthVisitor");
    }
}
