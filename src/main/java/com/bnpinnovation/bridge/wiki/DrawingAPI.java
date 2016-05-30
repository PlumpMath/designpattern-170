package com.bnpinnovation.bridge.wiki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by sajacaros on 16. 5. 30.
 */
// Implementor
public interface DrawingAPI {
    void drawCircle(double x, double y, double radius);

    // concrete implementor
    @Slf4j
    @Component(value = "linuxCircular")
    class DrawingApi1 implements DrawingAPI {

        @Override
        public void drawCircle(double x, double y, double radius) {
            log.info("linux 동그라미 그리기,circle at {}:{} radius {}", x,y,radius);
        }
    }

    // concrete implementor
    @Slf4j
    @Component(value = "windowsCircular")
    class DrawingApi2 implements DrawingAPI {

        @Override
        public void drawCircle(double x, double y, double radius) {
            log.info("윈도우즈 동그라미 그리기,circle at {}:{} radius {}", x,y,radius);
        }
    }
}
