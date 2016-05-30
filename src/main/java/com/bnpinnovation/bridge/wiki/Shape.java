package com.bnpinnovation.bridge.wiki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sun.security.provider.SHA;

import javax.annotation.Resource;

/**
 * Created by sajacaros on 16. 5. 30.
 */
public interface Shape {
    void draw();
    void resizeByPercentage(double pot);

    @Slf4j
    class CircleShape implements Shape {
        private DrawingAPI drawingAPI;
        private double x,y,radius;

        public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.drawingAPI = drawingAPI;
        }

        @Override
        public void draw() {
            drawingAPI.drawCircle(x,y,radius);
        }

        @Override
        public void resizeByPercentage(double pot) {
            radius *= pot;
        }
    }
}
