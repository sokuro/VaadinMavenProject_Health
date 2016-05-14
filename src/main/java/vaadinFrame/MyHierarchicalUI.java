package vaadinFrame;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by uck1 on 14.05.2016.
 */
public class MyHierarchicalUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        //The root of the component hierarchy
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();  //Use the entire window
        setContent(content);    //Attach to the UI
    }
}
