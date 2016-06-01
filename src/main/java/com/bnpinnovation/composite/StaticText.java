package com.bnpinnovation.composite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by sajacaros on 16. 6. 1.
 */
public class StaticText extends Element {
    private String text;
    public StaticText(Rectangle position, String text)
    { super(position);
        this.text = text;
    }
    public void renderTo(Graphics surface) {
        prepare(surface);
        surface.drawString(text,1,1);
    }

}
