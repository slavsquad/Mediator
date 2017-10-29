package com.company;

import com.company.components.*;
import com.company.mediator.Editor;
import com.company.mediator.Mediator;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new InputNameBox());
        mediator.registerComponent(new InputLastNameBox());
        mediator.registerComponent(new AgeComboBox());
        mediator.registerComponent(new MariedCheckBox());
        mediator.registerComponent(new InputPartnerNameBox());
        mediator.registerComponent(new InputPartnerLastName());
        mediator.registerComponent(new EmploymentCheckBox());
        mediator.registerComponent(new InputCompanyBox());
        mediator.registerComponent(new InputPositionBox());

        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
