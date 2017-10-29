package com.company.components;

public class InputNameBox extends InputBox {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
