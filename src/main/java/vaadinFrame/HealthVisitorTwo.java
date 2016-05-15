package vaadinFrame;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

/**
 * Created by uck1 on 14.05.2016.
 */
public class HealthVisitorTwo extends CustomComponent {

    Image picture = new Image(null, new ThemeResource("icons/Guy.png"));
    Label name = new Label("Name: ");
    Label age = new Label("Age: ");
//    TextField address = new TextField("Address: ");
//    TextField city = new TextField("City: ");
//    Component birthday = new PopupDateField("Birthday");
    CheckBox checkbox = new CheckBox("Free");
    Button butOne = new Button();
    Button butTwo = new Button();
    Button butThree = new Button();
    Button butFour = new Button();
    Button ok = new Button("OK");

    public HealthVisitorTwo() {

        configureComponents();
        buildLayout();
    }

    private void configureComponents() {

    }

    private void buildLayout() {

        Panel panel = new Panel("Health Visitor");
        panel.setSizeFull();
        HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
        hsplit.setHeight(24, Unit.CM);
        hsplit.setSplitPosition(45, Unit.PERCENTAGE);

        VerticalLayout left = new VerticalLayout();
        left.addComponent(picture);
        left.setMargin(true);

        left.addComponent(name);
        left.addComponent(age);
        hsplit.setFirstComponent(left);

        VerticalLayout right = new VerticalLayout();
        right.addComponent(butOne);
        right.addComponent(butTwo);
        right.addComponent(butThree);
        right.addComponent(butFour);
        right.addComponent(checkbox);
        right.addComponent(ok);
        hsplit.setSecondComponent(right);

        panel.setContent(hsplit);
        setCompositionRoot(panel);
    }

}