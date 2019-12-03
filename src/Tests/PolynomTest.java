//package Tests;
//
//import Ex1.Monom;
////import org.junit.jupiter.api.BeforeAll;
////import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//
//public class PolynomTest {
//
////    static Monom [] checkforStringConstractur = new Monom[11];
////    static Monom [] checkforBuildConstractur = new Monom[11];
////
////    @BeforeAll
////    public static void BeforeAll (){
////        checkforBuildConstractur[0]= new Monom("2X^2");
////        checkforBuildConstractur[1]= new Monom("x");
////        checkforBuildConstractur[2]= new Monom("-x");
////        checkforBuildConstractur[3]= new Monom("1");
////        checkforBuildConstractur[4]= new Monom("0");
////        checkforBuildConstractur[5]= new Monom("0^8");
////        checkforBuildConstractur[6]= new Monom("2.34x^5");
////        checkforBuildConstractur[7]= new Monom("-4.05x^7");
////        checkforBuildConstractur[8]= new Monom("-7X^2");
////        checkforBuildConstractur[9]= new Monom("x^4");
////        checkforBuildConstractur[10]= new Monom("-x^1");
////
////        checkforStringConstractur[0]= new Monom(2,2);
////        checkforStringConstractur[1]= new Monom(1,1);
////        checkforStringConstractur[2]= new Monom(-1,1);
////        checkforStringConstractur[3]= new Monom(1,0);
////        checkforStringConstractur[4]= new Monom(0,0);
////        checkforStringConstractur[5]= new Monom(0,8);
////        checkforStringConstractur[6]= new Monom(2.34,5);
////        checkforStringConstractur[7]= new Monom(-4.05,7);
////        checkforStringConstractur[8]= new Monom(-7,2);
////        checkforStringConstractur[9]= new Monom(1,4);
////        checkforStringConstractur[10]= new Monom(-1,1);
////    }
//
//    @Test
//    public void f() {
//
////        //check of x=2
////        double [] ans1 = {8,2,-2,1,0,0,74.88,-518.4,-28,16,-2};
////        for (int i = 0; i <checkforStringConstractur.length ; i++) {
////            assertEquals(ans1[i] , checkforStringConstractur[i].f(2) , Monom.EPSILON);
////        }
////        for (int i = 0; i <checkforBuildConstractur.length; i++) {
////            assertEquals(ans1[i] , checkforBuildConstractur[i].f(2) , Monom.EPSILON);
////        }
//    }
//
//    @Test
//    public void add() {
//    }
//
//    @org.junit.Test
//    public void testAdd() {
//    }
//
//    @org.junit.Test
//    public void substract() {
//    }
//
//    @org.junit.Test
//    public void multiply() {
//    }
//
//    @org.junit.Test
//    public void testEquals() {
//    }
//
//    @org.junit.Test
//    public void isZero() {
//    }
//
//    @org.junit.Test
//    public void root() {
//    }
//
//    @org.junit.Test
//    public void copy() {
//    }
//
//    @org.junit.Test
//    public void derivative() {
//    }
//
//    @org.junit.Test
//    public void area() {
//    }
//
//    @org.junit.Test
//    public void iteretor() {
//    }
//
//    @org.junit.Test
//    public void testMultiply() {
//    }
//
//    @org.junit.Test
//    public void initFromString() {
//    }
//}