package com.bnpinnovation.composite;

import java.awt.*;

/**
 * Created by sajacaros on 16. 6. 1.
 */
abstract class Element {
    private Rectangle position;
    public Element(Rectangle position) {
        this.position = position;
    }

    protected void prepare(Graphics surface) {

    }
    public abstract void renderTo(Graphics surface);
}
