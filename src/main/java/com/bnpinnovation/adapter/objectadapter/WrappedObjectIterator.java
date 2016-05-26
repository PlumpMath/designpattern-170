package com.bnpinnovation.adapter.objectadapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;

/**
 * Created by sajacaros on 16. 5. 26.
 */
@Slf4j
public class WrappedObjectIterator implements Iterator {
    private boolean atEndOfFile = false;
    private final ObjectInputStream in;

    public WrappedObjectIterator(ObjectInputStream in) {
        this.in = in;
    }

    @Override
    public boolean hasNext() {
        return atEndOfFile == false;
    }

    @Override
    public Object next() {
        try {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.info("readObejct ocurred exception. message : {}", e.getMessage());
            atEndOfFile = true;
            return null;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
