package com.company.mediator;


import com.company.components.Component;

import javax.swing.*;

/**
 * EN: Common mediator interface.
 *
 * RU: Общий интерфейс посредников.
 */
public interface Mediator {
    void addNewCustomer(Customer customer);
    void deleteCustomer();
    void getInfoFromList(Customer customer);
    void saveChanges();
    void markCustomer();
    void clear();
    void sendToFilter(ListModel listModel);
    void setElementsList(ListModel list);
    void registerComponent(Component component);
    void hideElements(boolean flag);
    void checkEnableElements();
    void createGUI();
}