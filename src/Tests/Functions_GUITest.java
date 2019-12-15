package Tests;

import Ex1.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Functions_GUITest {
    public static void main(String[] a) {
        functions data = FunctionsFactory();
        int w=1000, h=600, res=200;
        Range rx = new Range(-10,10);
        Range ry = new Range(-5,15);
        data.drawFunctions(w,h,rx,ry,res);
        String file = "function_file.txt";
        String file2 = "function_file2.txt";
        try {
            data.saveToFile(file);
            Functions_GUI data2 = new Functions_GUI();
            data2.initFromFile(file);
            data.saveToFile(file2);
        }
        catch(Exception e) {e.printStackTrace();}

        String JSON_param_file = "GUI_params.txt";
        data.drawFunctions(JSON_param_file);
    }

    public static Functions_GUI FunctionsFactory() {
        Functions_GUI ans = new Functions_GUI();
        String s1 = "3.1 +2.4x^2 -x^4";
        String s2 = "5 +2x -3.3x +0.1x^5";
        String[] s3 = {"x +3","x -2", "x -4"};
        Polynom p1 = new Polynom(s1);
        Polynom p2 = new Polynom(s2);
        Polynom p3 = new Polynom(s3[0]);
        ComplexFunction cf3 = new ComplexFunction(p3);
        for(int i=1;i<s3.length;i++) {
            cf3.mul(new Polynom(s3[i]));
        }

        ComplexFunction cf = new ComplexFunction("plus", p1,p2);
        ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x +1"),cf3);
        cf4.plus(new Monom("2"));
        ans.add(cf.copy());
        ans.add(cf4.copy());
        cf.div(p1);
        ans.add(cf.copy());
        String s = cf.toString();
        function cf5 = cf4.initFromString(s1);
        function cf6 = cf4.initFromString(s2);
        ans.add(cf5.copy());
        ans.add(cf6.copy());
        ComplexFunction max = new ComplexFunction(ans.get(0).copy());
        ComplexFunction min = new ComplexFunction(ans.get(0).copy());
        for(int i=1;i<ans.size();i++) {
            max.max(ans.get(i));
            min.min(ans.get(i));
        }
        ans.add(max);
        ans.add(min);

        return ans;
    }
    @Test
    void initFromFile() {
        Functions_GUI f = (Functions_GUI)FunctionsFactory();
        Functions_GUI fg = new Functions_GUI();
        try{
            f.saveToFile("function_file2.txt");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try {
            fg.initFromFile("function_file2.txt");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i <f.size() ; i++) {
            assertEquals(f.get(i).toString(),fg.get(i).toString());
        }
    }

    @Test
    void saveToFile() {
        Functions_GUI f = (Functions_GUI)FunctionsFactory();
        try {
            f.saveToFile("function_file.txt");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Functions_GUI fg= new Functions_GUI();
        try {
            fg.initFromFile("function_file.txt");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i <fg.size() ; i++) {
            assertEquals(f.get(i).toString(),fg.get(i).toString());
        }
    }
}