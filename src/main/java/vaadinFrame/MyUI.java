package vaadinFrame;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import model.ContactService;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point.
 */
@Theme("mytheme")
@Widgetset("vaadinFrame.MyAppWidgetset")
public class MyUI extends UI {
    static Navigator navigator;
    protected static final String MAINVIEW = "main";

    PatientList patientList = new PatientList();

    // in-memory mock that mimics a datasource
    ContactService contactService = ContactService.createDemoService();

    /*
     * Main method. Entry point method executed to initialize and configure
     * the visible user interface.
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        configureComponents();
        buildLayout();
        getPage().setTitle("Navigations");
        // navigator to control the views
        navigator = new Navigator(this, this);
        // create and register the views
        navigator.addView("", new StartView());
        navigator.addView(MAINVIEW, (View) new MainView());
    }

    private void configureComponents() {

    }

    private void buildLayout() {
//        VerticalLayout vert = new VerticalLayout(patientList);
//        vert.setSizeFull();
//        patientList.setSizeFull();
//        vert.setExpandRatio(patientList, 1);
//        setContent(vert);

//        AccordeonTab mView = new AccordeonTab("basic");
//        mView.setSizeFull();
//        setContent(mView);
//        AccordeonTab mView2 = new AccordeonTab("tabchange");
//        mView2.setSizeFull();
//        setContent(mView2);

        HealthVisitorTwo visitor = new HealthVisitorTwo();
        setContent(visitor);
    }

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}
