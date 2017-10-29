package com.company;

import com.company.components.checkBox.EmploymentCheckBox;
import com.company.components.checkBox.MariedCheckBox;
import com.company.components.comboBox.AgeComboBox;
import com.company.components.buttons.AddButton;
import com.company.components.buttons.DeleteButton;
import com.company.components.buttons.SaveButton;
import com.company.components.filter.Filter;
import com.company.components.inputBox.*;
import com.company.components.list.List;
import com.company.components.textBox.TextBox;
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
        mediator.registerComponent(new InputPartnerLastNameBox());
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
