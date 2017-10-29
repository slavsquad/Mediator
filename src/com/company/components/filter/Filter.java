package com.company.components.filter;

import com.company.components.Component;
import com.company.mediator.Mediator;
import com.company.customer.Customer;

import javax.swing.*;
        import java.awt.event.KeyEvent;
        import java.util.ArrayList;

/**
 * EN: Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 *
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только
 * один канал общения – через отправку уведомлений посреднику.
 */
public class Filter extends JTextField implements Component {
    private Mediator mediator;
    private ListModel listModel;

    public Filter() {}

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        searchElements(start);
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        if (s.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            customers.add((Customer) listModel.getElementAt(i));
        }
        DefaultListModel<Customer> listModel = new DefaultListModel<>();
        for (Customer customer : customers) {
            if (customer.getLastName().contains(s)||customer.getName().contains(s)) {
                listModel.addElement(customer);
            }
        }
        mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}