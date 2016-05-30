package com.bnpinnovation.bridge;

import com.bnpinnovation.DesignPatternApplication;
import com.bnpinnovation.adapter.classadapter.ObjectIterator;
import com.bnpinnovation.adapter.objectadapter.WrappedObjectIterator;
import com.bnpinnovation.bridge.wiki.DrawingAPI;
import com.bnpinnovation.bridge.wiki.Shape;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DesignPatternApplication.class)
@Slf4j
public class BridgeTest {

    @Resource( name = "linuxCircular" )
    private DrawingAPI drawingAPI1;

    @Resource( name = "windowsCircular" )
    private DrawingAPI drawingAPI2;

	@Test
    public void bridgeTest() {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Shape.CircleShape(1, 2, 3, drawingAPI1);
        shapes[1] = new Shape.CircleShape(5, 7, 11, drawingAPI2);

        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }

}
