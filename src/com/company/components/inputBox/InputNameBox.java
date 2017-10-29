package com.company.components.inputBox;

public class InputNameBox extends InputBox {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
