package vaadinFrame;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

/**
 * Created by uck1 on 14.05.2016.
 */
public class HealthVisitor extends CustomComponent {

    Image picture = new Image(null, new ThemeResource("C:/Users/uck1/Dropbox/Info_stuff/IntelliJ_Projects/vaadinOne/src/main/resources/icons/Guy.png"));
    TextField name = new TextField("Name: ");
    TextField address = new TextField("Address: ");
    TextField city = new TextField("City: ");
    Component birthday = new PopupDateField("Birthday");
    CheckBox checkbox = new CheckBox("Free");
    Button ok = new Button("OK");

    public HealthVisitor() {

        configureComponents();
        buildLayout();
    }

    private void configureComponents() {

    }

    private void buildLayout() {
        Panel entryPanel = new Panel("Health Visitor");

        entryPanel.setStyleName("Health Visitor");
        entryPanel.setWidth(10, Unit.CM);
//        entryPanel.setHeight(10, Unit.CM);

        Layout layout = new FormLayout();
//       VerticalLayout layout = new VerticalLayout();
//        picture = new ThemeResource("C:/Users/uck1/Dropbox/Info_stuff/IntelliJ_Projects/vaadinOne/src/main/resources/icons/Guy.png");
        //name.setIcon(new ThemeResource("icons/user.png"));
        layout.addStyleName("outlined");
        layout.setSizeFull();

        layout.addComponent(picture);
//        layout.setComponentAlignment(picture, Alignment.MIDDLE_RIGHT);
        layout.addComponent(name);
//        layout.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
        layout.addComponent(address);
//        layout.setComponentAlignment(address, Alignment.MIDDLE_CENTER);
        layout.addComponent(city);
//        layout.setComponentAlignment(city, Alignment.MIDDLE_CENTER);

        layout.addComponent(birthday);
//        layout.setComponentAlignment(birthday, Alignment.MIDDLE_CENTER);

//        ok.setIcon(new ThemeResource(""));
        layout.addComponent(checkbox);
//        layout.setComponentAlignment(checkbox, Alignment.MIDDLE_CENTER);
        layout.addComponent(ok);
//        layout.setComponentAlignment(ok, Alignment.MIDDLE_CENTER);

        entryPanel.setContent(layout);
        setCompositionRoot(entryPanel);
    }
}
