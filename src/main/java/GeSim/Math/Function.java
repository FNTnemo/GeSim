package GeSim.Math;

import GeSim.Render.Dot;

import java.awt.*;

public enum Function {
    None(),
    Parabola(),
    Hyperbola();

    Function function;

    public static int x0 = 800/2, y0 = 600/2;


    //parabola

    public double calcParabolaY(double x, double a, double b, double c){
        //x*=10; a*=10; b*=10; c*=10;
        return -(a*(x*x) + b*x + c);
    }
    public double calcParabolaY(int x){
        return -(x*x);
    }
    public double calcParabolaX0(double b, double a){
        if(a == 0){return 0;}
        return (-b) /(2*a);
    }
    public void parabola(double maxX, double a, double b, double c){
        if(Dot.dotsSize()!=0){Dot.getDots().clear();}
        for (double x = calcParabolaX0(b, a)- maxX; x <= calcParabolaX0(b, a) + maxX; x++) {
            Dot.addDot(x, calcParabolaY(x, a, b, c), 5, Color.black);
        }
    }

    //hyperbola (not works)
    public double calcHyperbolaY(double x){
        if(x==0){return 0;}
        return -((double) 1 / x);
    }
    public double calcHyperbolaY(double x, double a, double k){
        if(x==0){return 0;}
        return -(k/(a*x));
    }

    public void hyperbola(double maxX, double k, double a){
        if(Dot.dotsSize()!=0){Dot.getDots().clear();}
        for (double x = -maxX; x <= maxX; x++) {
            if(calcHyperbolaY(x)==0){continue;}
            Dot.addDot(x, calcHyperbolaY(x), 5, Color.black);
        }
    }


    public void setFunction(Function function){
        this.function = function;
    }
    public Function getFunction(){
        return function;
    }
    public static void clearFunc(){
        Dot.getDots().clear();
    }

}
