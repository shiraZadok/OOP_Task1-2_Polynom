package Tests;

import Ex1.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexFunctionTest {

    static ComplexFunction[] cheack = new ComplexFunction[11];
    static Polynom [] p = new Polynom[11];
    static Monom[] m = new Monom[11];
    static String[] Op = {"mul","min","max","comp","plus","div"};

    @BeforeClass
    static public void BeforeAll() {
        p[0] = new Polynom("2x");
        p[1] = new Polynom("-50");
        p[2] = new Polynom("-8x^2+4x-40");
        p[3] = new Polynom("6x^7");
        p[4] = new Polynom("2x^4-8x^2+6");
        p[5] = new Polynom("-x^3");
        p[6] = new Polynom("45");
        p[7] = new Polynom("-4.05x^7");
        p[8] = new Polynom("x^5+x^4-x^3-2x^2");
        p[9] = new Polynom("5x^3-4X^4");
        p[10] = new Polynom("-x^1");

        m[0] = new Monom("2x^2");
        m[1]= new Monom("x");
        m[2]= new Monom("-x");
        m[3]= new Monom("1");
        m[4]= new Monom("0");
        m[5]= new Monom("x^0");
        m[6]= new Monom("2.34x^5");
        m[7]= new Monom("-4.05x^7");
        m[8]= new Monom("-7X^2");
        m[9]= new Monom("x^4");
        m[10]= new Monom("-x^1");

        for (int i=0; i<cheack.length; i++){
            if(i<2) {
                cheack[i] = new ComplexFunction("plus", p[i], m[i]);
            }
            else if(i<4){
                cheack[i] = new ComplexFunction("div", p[i], m[i]);
            }
            else if(i<6){
                cheack[i] = new ComplexFunction("mul", p[i], m[i]);
            }
            else if(i<8){
                cheack[i] = new ComplexFunction("max", p[i], m[i]);
            }
            else if(i<10){
                cheack[i] = new ComplexFunction("min", p[i], m[i]);
            }
            else cheack[i] = new ComplexFunction("comp", p[i], m[i]);
        }


//        public enum Operation {
//            Plus, Times, Divid, Max, Min, Comp , None, Error
//        }
    }

    @Test
    public void plus() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        for(int i=0; i<cheack.length; i++){
            if(i!=7) {
                assertEquals(cheack[i].toString(), ans[i]);
            }
        }

    }

    @Test
    public void mul() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        for(int i=0; i<cheack.length; i++){
            assertEquals(cheack[i].toString(), ans[i]);
        }
    }

    @Test
    public void div() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        for(int i=0; i<cheack.length; i++){
            assertEquals(cheack[i].toString(), ans[i]);
        }
    }

    @Test
    public void max() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        for(int i=0; i<cheack.length; i++){
            assertEquals(cheack[i].toString(), ans[i]);
        }
    }

    @Test
    public void min() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        for(int i=0; i<cheack.length; i++){
            assertEquals(cheack[i].toString(), ans[i]);
        }
    }

    @Test
    public void comp() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        for(int i=0; i<cheack.length; i++){
            assertEquals(cheack[i].toString(), ans[i]);
        }
    }

    @Test
    public void left() {
        for (int i=0; i<cheack.length; i++){
            if(i<2) {
                assertEquals(p[i], cheack[i].left());
            }
            else if(i<4){
                assertEquals(p[i], cheack[i].left());
            }
            else if(i<6){
                assertEquals(p[i], cheack[i].left());
            }
            else if(i<8){
                assertEquals(p[i], cheack[i].left());
            }
            else if(i<10){
                assertEquals(p[i], cheack[i].left());
            }
            else assertEquals(p[i], cheack[i].left());
        }
    }

    @Test
    public void right() {
        for (int i=0; i<cheack.length; i++){
            if(i<2) {
                assertEquals(m[i], cheack[i].right());
            }
            else if(i<4){
                assertEquals(m[i], cheack[i].right());
            }
            else if(i<6){
                assertEquals(m[i], cheack[i].right());
            }
            else if(i<8){
                assertEquals(m[i], cheack[i].right());
            }
            else if(i<10){
                assertEquals(m[i], cheack[i].right());
            }
            else assertEquals(m[i], cheack[i].right());
        }
    }

    @Test
    public void getOp() {

        for (int i=0; i<cheack.length; i++){
            if(i<2) {
                assertEquals(Operation.Plus, cheack[i].getOp());
            }
            else if(i<4){
                assertEquals(Operation.Divid, cheack[i].getOp());
            }
            else if(i<6){
                assertEquals(Operation.Times, cheack[i].getOp());
            }
            else if(i<8){
                assertEquals(Operation.Max, cheack[i].getOp());
            }
            else if(i<10){
                assertEquals(Operation.Min, cheack[i].getOp());
            }
            else assertEquals(Operation.Comp, cheack[i].getOp());
        }
    }

    @Test
    public void f() {

        double [] ans = {
                0.0,
                -50.0,
                0,
                0.0,
                0.0,
                0.0,
                45.0,
                0.0,
                -0.0,
                0.0,
                0.0,
        };

        for (int i=0; i<cheack.length; i++){
            if(i!=2) {
                double result = cheack[i].f(0);
                assertEquals(ans[i], result, Monom.EPSILON);
            }
        }

    }

    @Test
    public void copy() {

        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        function[] copy = new function[11];
        for (int i=0; i<copy.length; i++){
            copy[i]=cheack[i].copy();
            assertEquals(ans[i], copy[i].toString());
        }
    }

    @Test
    public void initFromString() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        function [] buildF = new function[11];
        for (int i=0 ; i<buildF.length; i++){
            buildF[i]= cheack[i].initFromString(ans[i]);
            assertTrue(buildF[i] instanceof function);
        }

    }

    @Test
    public void testToString() {
        String  [] ans = {
                "plus(2.0x,2.0x^2)",
                "plus(-50.0,x)",
                "div(-8.0x^2+4.0x-40.0,-x)",
                "div(6.0x^7,1.0)",
                "mul(2.0x^4-8.0x^2+6.0,0.0)",
                "mul(-x^3,1.0)",
                "max(45.0,2.34x^5)",
                "max(-4.05x^7,-4.05x^7)",
                "min(x^5+x^4-x^3-2.0x^2,-7.0x^2)",
                "min(5.0x^3-4.0x^4,x^4)",
                "comp(-x,-x)"
        };

        for(int i=0; i<cheack.length; i++){
            assertEquals(cheack[i].toString(), ans[i]);
        }
    }

    @Test
    public void testEquals() {
        ComplexFunction[] result = new ComplexFunction[11];
        for (int i=0; i<cheack.length; i++) {
                if(i<2) {
                    result[i] = new ComplexFunction("plus", p[i], m[i]);
                }
                else if(i<4){
                    result[i] = new ComplexFunction("div", p[i], m[i]);
                }
                else if(i<6){
                    result[i] = new ComplexFunction("mul", p[i], m[i]);
                }
                else if(i<8){
                    result[i] = new ComplexFunction("max", p[i], m[i]);
                }
                else if(i<10){
                    result[i] = new ComplexFunction("min", p[i], m[i]);
                }
                else result[i] = new ComplexFunction("comp", p[i], m[i]);
            }
        for (int i=0; i<cheack.length; i++) {
            if(i!=2) {
                assertTrue(cheack[i].equals(result[i]));
            }
        }

    }
}