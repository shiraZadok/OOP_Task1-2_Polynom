package Ex1;

import java.util.Iterator;

public class Test {

    ////////////////////////////////////  TEST   ////////////////////////////////////////////

    public static void TestPolinom1(){
        System.out.println("*********TestPolinom1****************");
        String[] AMonom= {"0","2x^3", "4.5x^2", "x", "8"};
        Polynom multi = new Polynom("x^2+x+1");
        Polynom add= new Polynom("2x^7+3");
        for (int i = 0; i < AMonom.length; i++) {
            Monom t = new Monom(AMonom[i]);
            Polynom poly = new Polynom();
            poly.add(t);
            System.out.println("the poly in rund "+i+ ":    " +poly.toString());
            Polynom p = new Polynom(poly.toString());
            System.out.println("the poly after toString:   "+ p.toString());
            System.out.println("the f(x) in the value- " +i+":   "+poly.f(i));
            poly.multiply(multi);
            System.out.println("the poly after multi in x^2+x+1: "  + poly.toString());
            poly.add(add);
            System.out.println("the poly after add poly 2x^7+3:  " + poly.toString());
            Polynom_able c = poly.copy();
            System.out.println("the copy poly:   " + c.toString());
            System.out.println("if equals?:   " + poly.equals(c));
            poly.substract(c);
            System.out.println("the poly after substract:  " + poly.toString());
            System.out.println("If ZERO?:   " + poly.isZero());
            System.out.println("////////////////////////////////////////////");
        }
    }

    public static void TestPolinom2(){
        System.out.println("*********TestPolinom2****************");
        Polynom p = new Polynom("-2x^2+3.5x+6");
        Polynom poly = new Polynom();
        System.out.println("the orginal poly:  " + p.toString());
        p.derivative();
        System.out.println("the dertivite poly:  " + p.toString());
        System.out.println("the area:   " +p.area(-1,1, Monom.EPSILON));
        System.out.println("the root:  "  +p.root(-2,1, Monom.EPSILON) );
        Monom m = new Monom("-2.999999");
        Monom m1 = new Monom("-3");
        System.out.println(Monom.EPSILON);
        System.out.println(m.equals(m1));
    }


    public static void TestMonom(){
        System.out.println("*********TestMonom****************");
        String[] good = {"0", "-x","x","2.5x^3", "-2.5x^4", "5"};
        String[] bad = {"3..7"};
        Monom t = new Monom("-2.5x^3");
        for(int i=0;i<good.length;i++) {
            Monom m = new Monom(good[i].toString());
            Monom m1 = new Monom(m.toString());
            System.out.println("the orginal monom: " + m.toString());
            boolean b = m.equals(m1);
            System.out.println("check if its equals: " +b);
            m.add(t);
            System.out.println("add: "+ m.toString());
            m.multipy(t);
            System.out.println("mult after add: "+ m);
            System.out.println("//////////////////////");
        }

    }
}


