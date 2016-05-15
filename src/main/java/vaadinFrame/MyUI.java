package vaadinFrame;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point.
 */
@Theme("mytheme")
@Widgetset("vaadinFrame.MyAppWidgetset")
public class MyUI extends UI {

    // Main method
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        buildLayout();
    }

    private void buildLayout() {
//        MyView myView = new MyView();
//        setContent(myView);
//        HealthVisitor visitor = new HealthVisitor();
//        setContent(visitor);
        PatientList patient = new PatientList();
        setContent(patient);
    }

//    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}
