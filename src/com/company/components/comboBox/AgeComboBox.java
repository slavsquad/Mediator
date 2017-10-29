package com.company.components.comboBox;

import com.company.components.Component;
import com.company.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class AgeComboBox extends JComboBox implements Component {
    private Mediator mediator;
    DefaultComboBoxModel cbModel;

    public AgeComboBox() {
        super();
        cbModel = new DefaultComboBoxModel<Integer>();
        for (int i = 0; i < 100; i++) {
            cbModel.addElement(new Integer(i));
        }
        this.setModel(cbModel);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireItemStateChanged(ItemEvent e) {
        mediator.checkEnableElements();
    }

    @Override
    public String getName(){
        return this.getClass().getSimpleName();
    }
}
