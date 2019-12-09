package Test;

import Ex1.Monom;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonomTest {

static Monom [] checkforBuildConstractur = new Monom[11];

    @BeforeClass
    static public void BeforeAll() {
        checkforBuildConstractur[0] = new Monom("2x^2");
        checkforBuildConstractur[1]= new Monom("x");
        checkforBuildConstractur[2]= new Monom("-x");
        checkforBuildConstractur[3]= new Monom("1");
        checkforBuildConstractur[4]= new Monom("0");
        checkforBuildConstractur[5]= new Monom("x^0");
        checkforBuildConstractur[6]= new Monom("2.34x^5");
        checkforBuildConstractur[7]= new Monom("-4.05x^7");
        checkforBuildConstractur[8]= new Monom("-7X^2");
        checkforBuildConstractur[9]= new Monom("x^4");
        checkforBuildConstractur[10]= new Monom("-x^1");
    }

    @Test
    public void f() {
        MonomTest test = new MonomTest();
        Monom [] answerForX0 = {new Monom("0"),new Monom("0")
                ,new Monom("0"),new Monom("1"),new Monom("0")
                ,new Monom("0"),new Monom("0"),new Monom("0")
                ,new Monom("0"),new Monom("0"),new Monom("0")};

        for (int i=0; i<checkforBuildConstractur.length; i++){
            double result = checkforBuildConstractur[i].f(0);
            assertEquals(answerForX0[i],result);
       }
    }

    private void assertEquals(Monom monom, double result) {
    }

    @Test
    public void getComp() {
        
    }

    @Test
    public void get_coefficient() {

    }

    @Test
    public void get_power() {
    }

    @Test
    public void derivative() {
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