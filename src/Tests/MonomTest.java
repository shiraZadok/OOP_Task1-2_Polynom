package Tests;

import Ex1.Monom;
import Ex1.function;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MonomTest {

    static Monom[] cheackforTest = new Monom[12];
    /**
     * That function build a tester arrays of Monom to cheack
     */
    @Before
     public void BeforEach() {
        cheackforTest[0] = new Monom("2x^2");
        cheackforTest[1]= new Monom("x");
        cheackforTest[2]= new Monom("-x");
        cheackforTest[3]= new Monom("1");
        cheackforTest[4]= new Monom("0");
        cheackforTest[5]= new Monom("x^0");
        cheackforTest[6]= new Monom("2.34x^5");
        cheackforTest[7]= new Monom("-4.05x^7");
        cheackforTest[8]= new Monom("-7X^2");
        cheackforTest[9]= new Monom("x^4");
        cheackforTest[10]= new Monom("-x^1");
        cheackforTest[11]= new Monom("-0.999x^1");

    }

    /**
     * That function cheack the function get_coefficient in Monom.class
     */
    @Test
    public void get_coefficient() {
        double [] ans = {2.0,1.0,-1.0,1.0,0.0,1.0,2.34,-4.05,-7.0,1.0,-1.0,-0.999};
        for (int i=0 ; i<cheackforTest.length; i++){
            double result = cheackforTest[i].get_coefficient();
            assertEquals(ans[i], cheackforTest[i].get_coefficient(),Monom.EPSILON);
        }
    }

    /**
     * That function cheack the function get_power in Monom.class
     */
    @Test
    public void get_power() {
        int [] ans = {2,1,1,0,0,0,5,7,2,4,1,1};
        for (int i=0 ; i<cheackforTest.length; i++){
            int result = cheackforTest[i].get_power();
            assertEquals(ans[i], result);
        }
    }

    /**
     * That function cheack the function derivative in Monom.class
     */
    @Test
    public void derivative() {
        Monom [] ans = {
                new Monom("4x"),
                new Monom("1"),
                new Monom("-1"),
                new Monom("0"),
                new Monom("0"),
                new Monom("0"),
                new Monom("11.7x^4"),
                new Monom("-28.35x^6"),
                new Monom("-14x"),
                new Monom("4x^3"),
                new Monom("-1"),
                new Monom("-0.999")
        };
        for (int i=0 ; i<cheackforTest.length; i++){
            Monom result = cheackforTest[i].derivative();
            assertEquals(ans[i].get_power(),result.get_power(), Monom.EPSILON);
            assertEquals(ans[i].get_coefficient(), result.get_coefficient(),Monom.EPSILON);
        }
    }

    /**
     * That function cheack the function f in Monom.class
     */
    @Test
    public void f() {
        MonomTest test = new MonomTest();
        double [] answerForX0 = {0,0,0,1,0,1,0,0,0,0,0,0};

        for (int i=0; i<cheackforTest.length; i++){
            double result = cheackforTest[i].f(0);
            assertEquals(answerForX0[i],result,Monom.EPSILON);
        }
    }

    /**
     * That function cheack the function isZero in Monom.class
     */
    @Test
    public void isZero() {
        boolean [] ans = {false, false, false, false, true, false, false, false, false, false,false,false};
        for (int i=0; i<cheackforTest.length; i++){
            boolean result = cheackforTest[i].isZero();
            assertEquals(ans[i], result);
        }
    }

    /**
     * That function cheack the function add in Monom.class
     */
    @Test
    public void add() {
        Monom [] ansFor2 = {
                new Monom("4.4x^2"),
                new Monom("3.4x"),
                new Monom("1.4x"),
                new Monom("3.4"),
                new Monom("2.4"),
                new Monom("3.4"),
                new Monom("4.74x^5"),
                new Monom("-1.65x^7"),
                new Monom("-4.6x^2"),
                new Monom("3.4x^4"),
                new Monom("1.4x"),
                new Monom("1.401x")
        };

        Monom addForPower0 = new Monom("2.4x^0");
        Monom addForPower1 = new Monom("2.4x^1");
        Monom addForPower2 = new Monom("2.4x^2");
        Monom addForPower4 = new Monom("2.4x^4");
        Monom addForPower5 = new Monom("2.4x^5");
        Monom addForPower7 = new Monom("2.4x^7");

        cheackforTest[0].add(addForPower2);
        cheackforTest[1].add(addForPower1);
        cheackforTest[2].add(addForPower1);
        cheackforTest[3].add(addForPower0);
        cheackforTest[4].add(addForPower0);
        cheackforTest[5].add(addForPower0);
        cheackforTest[6].add(addForPower5);
        cheackforTest[7].add(addForPower7);
        cheackforTest[8].add(addForPower2);
        cheackforTest[9].add(addForPower4);
        cheackforTest[10].add(addForPower1);
        cheackforTest[11].add(addForPower1);

        // cheack the function add for 2.4^x?
        for (int i=0; i<cheackforTest.length; i++) {
            assertEquals(ansFor2[i].get_power(),cheackforTest[i].get_power(), Monom.EPSILON);
            System.out.println("power:"+ cheackforTest[i].get_power());
            assertEquals(ansFor2[i].get_coefficient(), cheackforTest[i].get_coefficient(),Monom.EPSILON);
            System.out.println("coefficient:"+ cheackforTest[i].get_coefficient());
            System.out.println("+++++++++++++++++++++++++++++++++++");
        }
    }

    /**
     * That function cheack the function multipy in Monom.class
     */
    @Test
    public void multipy() {
        Monom [] ansForMul = {
                new Monom("6x^9"),
                new Monom("3x^8"),
                new Monom("-3x^8"),
                new Monom("3x^7"),
                new Monom("0"),
                new Monom("3x^7"),
                new Monom("7.02x^12"),
                new Monom("-12.15x^14"),
                new Monom("-21x^9"),
                new Monom("3x^11"),
                new Monom("-3x^8"),
                new Monom("-2.997x^8")
        };

        Monom zero = new Monom("0");

        // cheack the function add for 0
        for (int i=0; i<cheackforTest.length; i++) {
            cheackforTest[i].multipy(new Monom("0"));
            assertEquals(zero.get_power(),cheackforTest[i].get_power(), Monom.EPSILON);
            assertEquals(zero.get_coefficient(),cheackforTest[i].get_coefficient(),Monom.EPSILON);
        }
    }

    /**
     * That function cheack the function testToString in Monom.class
     */
    @Test
    public void testToString() {
        String [] ans = {
                "2.0x^2",
                "x",
                "-x",
                "1.0",
                "0.0",
                "1.0",
                "2.34x^5",
                "-4.05x^7",
                "-7.0x^2",
                "x^4",
                "-x",
                "-0.999x"
        };
        for(int i=0; i<cheackforTest.length; i++) {
            assertEquals(ans[i], cheackforTest[i].toString());
        }

    }


    /**
     * That function cheack the function initFromString in Monom.class
     */
    @Test
    public void initFromString() {
        String [] ans = {
                "2x^2",
                "x",
                "-x",
                "1",
                "0",
                "x^0",
                "2.34x^5",
                "-4.05x^7",
                "-7X^2",
                "x^4",
                "-x^1",
                "-0.999x^1"
        };
        function[] result= new function[12];
        for(int i=0; i<result.length;i++) {
            result[i] = cheackforTest[i].initFromString(ans[i]);
            assertTrue(result[i] instanceof function);
        }
    }


    /**
     * That function cheack the function copy in Monom.class
     */
    @Test
    public void copy() {
        function [] result = new function[12];
        Monom MonomForMul = new Monom("2x");
        for (int i=0;i<result.length; i++){
            result[i]= cheackforTest[i].copy();
            cheackforTest[i].multipy(MonomForMul);
            if(i!=4) {
                assertNotEquals(cheackforTest[i].get_power(), ((Monom) result[i]).get_power(), Monom.EPSILON);
                assertNotEquals(cheackforTest[i].get_coefficient(), ((Monom) result[i]).get_coefficient(), Monom.EPSILON);
            }
        }
    }

    /**
     * That function cheack the function testEquals in Monom.class
     */
    @Test
    public void testEquals() {
        String [] ans = {
                "2.0x^2",
                "x",
                "-x",
                "1.0",
                "0.0",
                "1.0",
                "2.34x^5",
                "-4.05x^7",
                "-7.0x^2",
                "x^4",
                "-x",
                "-0.999x"
        };
        Monom [] ansM = new Monom[12];
        for(int i=0; i<ansM.length; i++) {
            ansM[i] = new Monom(ans[i]);
            assertEquals(ansM[i].get_coefficient(), cheackforTest[i].get_coefficient(), Monom.EPSILON);
            assertEquals(ansM[i].get_power(), cheackforTest[i].get_power(), Monom.EPSILON);
        }
    }
}