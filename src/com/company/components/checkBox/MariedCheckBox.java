package com.company.components.checkBox;

import com.company.components.Component;
import com.company.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MariedCheckBox extends JCheckBox implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        super.fireActionPerformed(event);
        mediator.markCustomer();
        mediator.checkEnableElements();
    }

    @Override
    public String getName(){
        return this.getClass().getSimpleName();
    }
}
