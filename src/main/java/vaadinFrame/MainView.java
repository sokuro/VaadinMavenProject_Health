package vaadinFrame;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

import static vaadinFrame.MyUI.MAINVIEW;

/**
 * Created by uck1 on 16.05.2016.
 */
@DesignRoot
public class MainView extends VerticalLayout  {

    // Menu navigation button listener
    class ButtonListener implements Button.ClickListener {
        String menuitem;

        public ButtonListener(String menuitem) {
            this.menuitem = menuitem;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            MyUI.navigator.navigateTo(MAINVIEW + "/" + menuitem);
        }

    }
    VerticalLayout menuContent;
    Panel equalPanel;
    Button logout;

    public MainView() {
        Design.read(this);

        menuContent.addComponent(new Button("Tasklist",
                new ButtonListener("tasklist")));
        menuContent.addComponent(new Button("Patient",
                new ButtonListener("patient")));
        menuContent.addComponent(new Button("Calendar",
                new ButtonListener("calendar")));
        menuContent.addComponent(new Button("Reschedule",
                new ButtonListener("reschedule")));
        menuContent.addComponent(new Button("Shop",
                new ButtonListener("shop")));
        menuContent.addComponent(new Button("Options",
                new ButtonListener("options")));

        // Allow going back to the start
        logout.addClickListener(event -> // Java 8
                MyUI.navigator.navigateTo(""));
    }

}
