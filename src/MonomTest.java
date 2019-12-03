import Ex1.Monom;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonomTest {

    static Monom [] checkforBuildConstractur = new Monom[11];

//    s1[0] = new Monom("x");

//        checkforBuildConstractur[1]= new Monom("x");
//        checkforBuildConstractur[2]= new Monom("-x");
//        checkforBuildConstractur[3]= new Monom("1");
//        checkforBuildConstractur[4]= new Monom("0");
//        checkforBuildConstractur[5]= new Monom("0^8");
//        checkforBuildConstractur[6]= new Monom("2.34x^5");
//        checkforBuildConstractur[7]= new Monom("-4.05x^7");
//        checkforBuildConstractur[8]= new Monom("-7X^2");
//        checkforBuildConstractur[9]= new Monom("x^4");
//        checkforBuildConstractur[10]= new Monom("-x^1");

    @BeforeClass
    static public void BeforeAll()
    {
        checkforBuildConstractur[0]=new Monom(0,0);
    }


    @Test
    public void getComp() {
    }

    @Test
    public void get_coefficient() {
        assertEquals(0.0, checkforBuildConstractur[0].get_coefficient(),Monom.EPSILON);

    }

    @Test
    public void get_power() {
    }

    @Test
    public void derivative() {
    }

    @Test
    public void f() {
        Monom e = new Monom(4,1);
        Monom e1 = new Monom(4,2);
        double x = e.f(2);
        double y = e1.f(3);
        assertEquals(x,8,0.0);
        assertEquals(y,36,0.0);

    }

    @Test
    public void isZero() {
    }

    @Test
    public void add() {
    }

    @Test
    public void multipy() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void initFromString() {
    }

    @Test
    public void copy() {
    }

    @Test
    public void setBcoefficient() {
    }

    @Test
    public void setBpower() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void main() {
    }
}