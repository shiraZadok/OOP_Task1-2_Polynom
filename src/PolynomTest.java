import Ex1.Polynom;
import org.junit.Before;
import org.junit.Test;
import Ex1.Monom;
import static org.junit.Assert.*;


public class PolynomTest {

    static Polynom[] checkforBuildConstractur = new Polynom[11];

    @Before
    public static void BeforeEach (){
        checkforBuildConstractur[0]= new Polynom("2X^2");
        checkforBuildConstractur[1]= new Polynom("x");
        checkforBuildConstractur[2]= new Polynom("-x");
        checkforBuildConstractur[3]= new Polynom("1");
        checkforBuildConstractur[4]= new Polynom("0");
        checkforBuildConstractur[5]= new Polynom("0^8");
        checkforBuildConstractur[6]= new Polynom("2.34x^5");
        checkforBuildConstractur[7]= new Polynom("-4.05x^7");
        checkforBuildConstractur[8]= new Polynom("-7X^2");
        checkforBuildConstractur[9]= new Polynom("x^4");
        checkforBuildConstractur[10]= new Polynom("-x^1");
}

    @Test
    public void f() {
    }

    @Test
    public void add() {

    }

    @Test
    public void testAdd() {
    }

    @Test
    public void substract() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void isZero() {
    }

    @Test
    public void root() {
    }

    @Test
    public void copy() {
    }

    @Test
    public void derivative() {
    }

    @Test
    public void area() {
    }

    @Test
    public void iteretor() {
    }

    @Test
    public void testMultiply() {
    }

    @Test
    public void organarrangement() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void initFromString() {
    }
}