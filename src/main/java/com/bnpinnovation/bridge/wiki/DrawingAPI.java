package com.bnpinnovation.bridge.wiki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by sajacaros on 16. 5. 30.
 */
public interface DrawingAPI {
    void drawCircle(double x, double y, double radius);

    @Slf4j
    @Component(value = "DrawingApi1")
    class DrawingApi1 implements DrawingAPI {

        @Override
        public void drawCircle(double x, double y, double radius) {
            log.info("API1,circle at {}:{} radius {}", x,y,radius);
        }
    }

    @Slf4j
    @Component(value = "DrawingApi2")
    class DrawingApi2 implements DrawingAPI {

        @Override
        public void drawCircle(double x, double y, double radius) {
            log.info("API2,circle at {}:{} radius {}", x,y,radius);
        }
    }
}
