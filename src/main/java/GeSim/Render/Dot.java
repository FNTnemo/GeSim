package GeSim.Render;

import GeSim.Math.Function;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Dot {

    double x, y, r;
    Color color;

    static List<Dot> dots = new ArrayList<>();

    Dot(double x, double y, int r, Color color){
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

    public static void addDot(int x, int y, int r, Color color){
        dots.add(new Dot(x, y, r, color));
    }
    public static void addDot(double x, double y, int r, Color color){
        dots.add(new Dot(x*10+ Function.x0, y*10+Function.y0, r, color));
    }
    public static Dot getDot(int x, int y){
        for(Dot dot : dots){
            if(dot.x == x && dot.y == y)
                return dot;
        }
        return null;
    }
    public static Dot getDot(int index){
        return dots.get(index);
    }
    public static int dotsSize(){
        return dots.size();
    }
    public static List<Dot> getDots(){return dots;}
}
