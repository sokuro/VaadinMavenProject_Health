package vaadinFrame;


import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.*;
import components.Contact;
import components.ContactService;

/**
 * Created by uck1 on 15.05.2016.
 */
public class PatientList extends CustomComponent{

    TextField filter = new TextField();
    Patient patient = new Patient();
    Grid contactList = new Grid();
    Button newContact = new Button("New Contact");

    ContactService service = ContactService.createDemoService();

    public PatientList() {
        configureComponents();
        buildLayout();
    }

    private void configureComponents() {
        newContact.addClickListener(e -> patient.edit(new Contact()));
        filter.setInputPrompt("Filter contacts...");
        filter.addTextChangeListener(e -> refreshContacts(e.getText()));

        contactList.setContainerDataSource(new BeanItemContainer<>(Contact.class));
        contactList.setColumnOrder("firstName", "lastName", "email");
        contactList.removeColumn("id");
        contactList.removeColumn("birthDate");
        contactList.removeColumn("phone");
        contactList.setSelectionMode(Grid.SelectionMode.SINGLE);
        contactList.addSelectionListener(e
                -> patient.edit((Contact) contactList.getSelectedRow()));
        refreshContacts();
    }

    private void buildLayout() {
//        Panel panel = new Panel("Patients");

        HorizontalLayout actions = new HorizontalLayout(filter, newContact);
        actions.setWidth("100%");
        filter.setWidth("100%");
        actions.setExpandRatio(filter, 1);

        VerticalLayout vertical = new VerticalLayout(actions, contactList);
        vertical.setSizeFull();
        contactList.setSizeFull();
        vertical.setExpandRatio(contactList, 1);

        HorizontalLayout horizontal = new HorizontalLayout(vertical, patient);
        horizontal.setSizeFull();
        horizontal.setExpandRatio(vertical, 1);

//        panel.setContent(vertical);
//        setCompositionRoot(panel);
        setCompositionRoot(horizontal);
    }

    void refreshContacts() {
        refreshContacts(filter.getValue());
    }

    private void refreshContacts(String stringFilter) {
        contactList.setContainerDataSource(new BeanItemContainer<>(
                Contact.class, service.findAll(stringFilter)));
        patient.setVisible(false);
    }

}