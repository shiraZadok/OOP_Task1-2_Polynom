import Ex1.Polynom;
import Ex1.Polynom_able;
import Ex1.function;
import jdk.nashorn.internal.objects.annotations.Function;
import org.junit.Before;
import org.junit.Test;
import Ex1.Monom;
import static org.junit.Assert.*;


public class PolynomTest {

    static Polynom[] checkforBuildConstractur = new Polynom[11];

    @Before
    public void BeforeEach() {
        checkforBuildConstractur[0] = new Polynom("2x");
        checkforBuildConstractur[1] = new Polynom("-50");
        checkforBuildConstractur[2] = new Polynom("-8x^2+4x-40");
        checkforBuildConstractur[3] = new Polynom("6x^7");
        checkforBuildConstractur[4] = new Polynom("2x^4-8x^2+6");
        checkforBuildConstractur[5] = new Polynom("-x^3");
        checkforBuildConstractur[6] = new Polynom("45");
        checkforBuildConstractur[7] = new Polynom("-4.05x^7");
        checkforBuildConstractur[8] = new Polynom("x^5+x^4-x^3-2x^2");
        checkforBuildConstractur[9] = new Polynom("5x^3-4X^4");
        checkforBuildConstractur[10] = new Polynom("-x^1");
        // checkforBuildConstractur[11]= new Polynom("0");
    }

    @Test
    public void f() {
        double ans[] = {4, -50, -64, 768, 6, -8, 45, -518.4, 32, -24, -2};
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            assertEquals(ans[i], checkforBuildConstractur[i].f(2), Monom.EPSILON);
        }
    }

    @Test
    public void add() {
        Polynom p1 = new Polynom("x^5+2x+3");
        Polynom p2 = new Polynom("x^5-47");
        Polynom p3 = new Polynom("x^5-8x^2+4x-37");
        Polynom p4 = new Polynom("6x^7+x^5+3");
        Polynom p5 = new Polynom("x^5+2x^4-8x^2+9");
        Polynom p6 = new Polynom("x^5-x^3+3");
        Polynom p7 = new Polynom("x^5+48");
        Polynom p8 = new Polynom("-4.05x^7+x^5+3");
        Polynom p9 = new Polynom("2x^5+x^4-x^3-2x^2+3");
        Polynom p10 = new Polynom("x^5-4x^4+5x^3+3");
        Polynom p11 = new Polynom("x^5-x+3");

        Polynom ans[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            Polynom p = new Polynom("x^5+3");
            p.add(checkforBuildConstractur[i]);
            assertEquals(ans[i], p);
        }
    }

    @Test
    public void testAdd() {
        Polynom p1 = new Polynom("x^5+2x");
        Polynom p2 = new Polynom("x^5-50");
        Polynom p3 = new Polynom("x^5-8x^2+4x-40");
        Polynom p4 = new Polynom("6.0x^7+x^5");
        Polynom p5 = new Polynom("x^5+2x^4-8x^2+6");
        Polynom p6 = new Polynom("x^5-x^3");
        Polynom p7 = new Polynom("x^5+45");
        Polynom p8 = new Polynom("-4.05x^7+x^5");
        Polynom p9 = new Polynom("2x^5+x^4-x^3-2x^2");
        Polynom p10 = new Polynom("x^5-4x^4+5x^3");
        Polynom p11 = new Polynom("x^5-x");

        Polynom ans[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        Monom p = new Monom("x^5");
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            checkforBuildConstractur[i].add(p);
            assertEquals(ans[i], checkforBuildConstractur[i]);
        }
    }

    @Test
    public void substract() {
        Polynom p1 = new Polynom("-8x^5+2x");
        Polynom p2 = new Polynom("-8x^5-50");
        Polynom p3 = new Polynom("-8x^5-8x^2+4x-40");
        Polynom p4 = new Polynom("6x^7-8x^5");
        Polynom p5 = new Polynom("-8x^5+2x^4-8x^2+6");
        Polynom p6 = new Polynom("-8x^5-x^3");
        Polynom p7 = new Polynom("-8x^5+45");
        Polynom p8 = new Polynom("-4.05x^7-8x^5");
        Polynom p9 = new Polynom("-7x^5+x^4-x^3-2x^2");
        Polynom p10 = new Polynom("-8x^5-4x^4+5x^3");
        Polynom p11 = new Polynom("-8x^5-x");

        Polynom ans[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        Polynom_able p = new Polynom("8x^5");
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            checkforBuildConstractur[i].substract(p);
            assertEquals(ans[i], checkforBuildConstractur[i]);
        }
    }

    @Test
    public void multiply() {
        Polynom p1 = new Polynom("16x^6+4x^2");
        Polynom p2 = new Polynom("-400x^5-100x");
        Polynom p3 = new Polynom("-64x^7+32x^6-320x^5-16x^3+8x^2-80x");
        Polynom p4 = new Polynom("48x^12+12x^8");
        Polynom p5 = new Polynom("16x^9-64x^7+52x^5-16x^3+12x");
        Polynom p6 = new Polynom("-8x^8-2x^4");
        Polynom p7 = new Polynom("360x^5+90x");
        Polynom p8 = new Polynom("-32.4x^12-8.1x^8");
        Polynom p9 = new Polynom("8x^10+8x^9-8x^8-16x^7+2x^6+2x^5-2x^4-4x^3");
        Polynom p10 = new Polynom("-32x^9+40x^8-8x^5+10x^4");
        Polynom p11 = new Polynom("-8x^6-2x^2");

        Polynom ans[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        Polynom_able p = new Polynom("8x^5+2x");
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            checkforBuildConstractur[i].multiply(p);
            assertEquals(ans[i], checkforBuildConstractur[i]);
        }
    }

    @Test
    public void testEquals() {
        Polynom_able p = new Polynom("-8x^2+4x-40");
        boolean ans[] = {false, false, true, false, false, false, false, false, false, false, false};
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            assertEquals(ans[i], checkforBuildConstractur[i].equals(p));
        }
    }

    @Test
    public void isZero() {
        boolean ans[] = {false, false, false, false, false, false, false, false, false, false, false, true};
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            assertEquals(ans[i], checkforBuildConstractur[i].isZero());
        }
    }

    @Test
    public void root() {
        Polynom r = new Polynom("5x+1");
        double x = r.root(-7, 1, Monom.EPSILON);
        boolean b = false;
        if (r.f(x) <= Monom.EPSILON) b = true;
        assertTrue(b);
    }

    @Test
    public void copy() {
        Polynom[] c = new Polynom[15];
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            c[i] = (Polynom) checkforBuildConstractur[i].copy();
            assertEquals(c[i], checkforBuildConstractur[i]);
        }
    }

    @Test
    public void derivative() {
        Polynom p1 = new Polynom("2");
        Polynom p2 = new Polynom("0.0");
        Polynom p3 = new Polynom("-16.0x+4.0");
        Polynom p4 = new Polynom("42.0x^6");
        Polynom p5 = new Polynom("8.0x^3-16.0x");
        Polynom p6 = new Polynom("-3.0x^2");
        Polynom p7 = new Polynom("0.0");
        Polynom p8 = new Polynom("-28.349999999999998x^6");
        Polynom p9 = new Polynom("5.0x^4+4.0x^3-3.0x^2-4.0x");
        Polynom p10 = new Polynom("-16.0x^3+15.0x^2");
        Polynom p11 = new Polynom("-1.0");

        Polynom ans[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            assertEquals(ans[i].toString(), checkforBuildConstractur[i].derivative().toString());
        }
    }

    @Test
    public void area() {
        double first = 2;
        double end = 5;
        double[] ans = {21.0000002, 0, 0, 292776.7725757364, 943.2000505, 0, 135, 0, 2981.8501705, 0, 0, 0};
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            assertEquals(ans[i], checkforBuildConstractur[i].area(first, end, Monom.EPSILON), Monom.EPSILON);
        }
    }

    @Test
    public void testMultiply() {
        Polynom p1 = new Polynom("16x^2");
        Polynom p2 = new Polynom("-400x");
        Polynom p3 = new Polynom("-64x^3+32x^2-320x");
        Polynom p4 = new Polynom("48x^8");
        Polynom p5 = new Polynom("16x^5-64x^3+48x");
        Polynom p6 = new Polynom("-8x^4");
        Polynom p7 = new Polynom("360x");
        Polynom p8 = new Polynom("-32.4x^8");
        Polynom p9 = new Polynom("8x^6+8x^5-8x^4-16x^3");
        Polynom p10 = new Polynom("40x^4-32x^5");
        Polynom p11 = new Polynom("-8x^2");

        Polynom ans[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};
        Monom m = new Monom("8x");
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            checkforBuildConstractur[i].multiply(m);
            assertEquals(ans[i], checkforBuildConstractur[i]);
        }
    }

    @Test
    public void organarrangement() {
        Polynom p1 = new Polynom("16x^2+5x^3");
        Polynom p2 = new Polynom("-400x+x^2");
        Polynom p3 = new Polynom("-64x+32x^3-320x^2");
        Polynom p4 = new Polynom("48x^8+3");
        Polynom p5 = new Polynom("16x^3-64x^5+48x");
        Polynom p6 = new Polynom("1-8x^4");
        Polynom p7 = new Polynom("50+360x");
        Polynom p8 = new Polynom("-32.4x^8+5");
        Polynom p9 = new Polynom("8x^5+8x^6-8x^3-16x^4");
        Polynom p10 = new Polynom("40x^4-32x^5");
        Polynom p11 = new Polynom("-8x^2+9");

        Polynom beforeOrganarrangement[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};

        Polynom p12 = new Polynom("5.0x^3+16.0x^2");
        Polynom p13 = new Polynom("x^2-400.0x");
        Polynom p14 = new Polynom("32.0x^3-320.0x^2-64.0x");
        Polynom p15 = new Polynom("48.0x^8+3.0");
        Polynom p16 = new Polynom("-64.0x^5+16.0x^3+48.0x");
        Polynom p17 = new Polynom("-8.0x^4+1.0");
        Polynom p18 = new Polynom("360.0x+50.0");
        Polynom p19 = new Polynom("-32.4x^8+5.0");
        Polynom p20 = new Polynom("8.0x^6+8.0x^5-16.0x^4-8.0x^3");
        Polynom p21 = new Polynom("-32.0x^5+40.0x^4");
        Polynom p22 = new Polynom("-8.0x^2+9.0");

        Polynom afterOrganarrangement[] = {p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22};

        for (int i = 0; i <beforeOrganarrangement.length ; i++) {
            beforeOrganarrangement[i].Organarrangement();
            assertEquals(afterOrganarrangement[i],beforeOrganarrangement[i]);
        }
    }

    @Test
    public void testToString() {
        String ans[] = {"2.0x", "-50.0", "-8.0x^2+4.0x-40.0", "6.0x^7", "2.0x^4-8.0x^2+6.0", "-x^3", "45.0", "-4.05x^7", "x^5+x^4-x^3-2.0x^2", "5.0x^3-4.0x^4", "-x"};
        for (int i = 0; i < checkforBuildConstractur.length; i++) {
            assertEquals(ans[i], checkforBuildConstractur[i].toString());
        }
    }

    @Test
    public void initFromString() {
        String polinomString[] = {"2x", "-50", "-8x^2+4x-40", "6x^7", "2x^4-8x^2+6", "-x^3", "45", "-4.05x^7", "x^5+x^4-x^3-2x^2", "5x^3-4x^4", "-x"};
        function ans[] = new function[11];
        for (int i = 0; i <polinomString.length ; i++){
            ans[i] = checkforBuildConstractur[i].initFromString(polinomString[i]);
            assertTrue(ans[i]instanceof function);
            }
    }
}
