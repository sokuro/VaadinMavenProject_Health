package vaadinFrame;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;


/**
 * Created by uck1 on 15.05.2016.
 */
public class AccordeonTab extends CustomComponent {

    public AccordeonTab(String context) {
        VerticalLayout layout = new VerticalLayout();

        if ("basic".equals(context))
            basic(layout);
        else if ("tabchange".equals(context))
            tabchange(layout);
        else
            setCompositionRoot(new Label("Error"));

        setCompositionRoot(layout); //necessary
    }

    // Basic Tabs
    void basic(VerticalLayout layout) {
        layout.setWidth("300px");

        Accordion accordion = new Accordion();

        Layout tab1 = new VerticalLayout();
        tab1.addComponent(new Image(null,
                new ThemeResource("icons/ems-venue-icon-large-circle-120x120.png")));
        accordion.addTab(tab1, "Tab 1");

        Component tab2 = new Image("Circle",
                new ThemeResource("icons/EOD-Circle-120x1201.png"));
        accordion.addTab(tab2, "Tab 2");

        String[] tabs = {"Guy","icon-circle-120x120","Robotic-Circle-120x1201"};
        for (String caption: tabs) {
            String basename = "icons/" + caption;
            VerticalLayout tab = new VerticalLayout();
            tab.addComponent(new Embedded(null,
                    new ThemeResource(basename + ".png")));
//            accordion.addTab(tab, caption,
//                    new ThemeResource(basename + ".png"));
            accordion.addTab(tab, caption);
        }
        layout.addComponent(accordion);
    }

    // Create dynamically when the tab is selected
    void tabchange(VerticalLayout layout) {
        layout.setWidth("300px");

        // BEGIN-EXAMPLE: layout.accordion.tabchange
        Accordion accordion = new Accordion();

        // Create tab content dynamically when tab is selected
        accordion.addSelectedTabChangeListener(
                new Accordion.SelectedTabChangeListener() {
                    private static final long serialVersionUID = -2358653511430014752L;

                    public void selectedTabChange(TabSheet.SelectedTabChangeEvent event){
                        // Find the accordion (as a TabSheet)
                        TabSheet accordion = event.getTabSheet();

                        // Find the tab (here we know it's a layout)
                        Layout tab = (Layout) accordion.getSelectedTab();

                        // Get the tab caption from the tab object
                        String caption = accordion.getTab(tab).getCaption();

                        // Fill the tab content
                        tab.removeAllComponents();
                        tab.addComponent(new Image(null,
                                new ThemeResource("icon/"+caption+".png")));
                    }
         });
        // Have some tabs
        String[] tabs = {"Guy", "thumbs-down-circle-120x120", "thumbs-up-circle-120x120", "EOD-Circle-120x1201"};
        for (String caption: tabs)
//            accordion.addTab(new VerticalLayout(), caption,
//                    new ThemeResource("img/planets/"+caption+"_symbol.png"));
            accordion.addTab(new VerticalLayout(), caption);
        // END-EXAMPLE: layout.accordion.tabchange
        layout.addComponent(accordion);
    }

}
