package vaadinFrame;

import com.vaadin.ui.*;

/**
 * Created by uck1 on 15.05.2016.
 */
public class MainView extends CustomComponent {

    TextField entry = new TextField();
    Label label = new Label();

    public MainView() {

        Panel entryPanel = new Panel("Health Visitor");
        entryPanel.setWidth(10, Unit.CM);
        entryPanel.setHeight(10, Unit.CM);

        Layout panelContent = new FormLayout();
        panelContent.addComponent(new Label("Hello"));

        entryPanel.setContent(panelContent);

        setCompositionRoot(entryPanel); //necessary
    }
}
