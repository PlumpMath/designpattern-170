package com.bnpinnovation.composite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by sajacaros on 16. 6. 1.
 */
public class Form extends Element {
    private Collection subelements
            = new ArrayList<>();
    public Form( Rectangle position )
    { super(position);
    }
    public void add(Element subelement)
    { subelements.add( subelement ) ;
    }
    public void renderTo(Graphics surface) {
        prepare(surface);
        Iterator i = subelements.iterator();
        while (i.hasNext())
            ((Element) i.next()).renderTo(surface);
    }

}
