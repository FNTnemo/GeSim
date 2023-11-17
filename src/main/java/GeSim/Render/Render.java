package GeSim.Render;

import GeSim.Math.Function;

import java.awt.*;

public class Render {
    public static void dotsRender(Graphics g) {
        for(Dot dot : Dot.dots){
            g.setColor(dot.color);
            g.fillOval((int) (dot.x - (dot.r/2)), (int) (dot.y - (dot.r/2)), (int) dot.r, (int) dot.r);
            System.out.println("dot rendered");
        }
    }

}
