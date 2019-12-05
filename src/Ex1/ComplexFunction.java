package Ex1;
import java.util.Stack;

public class ComplexFunction implements complex_function {

    private function right;
    private function left;
    private Operation operator=Operation.None;

    public ComplexFunction(){
        this.left=null;
        this.right=null;
    }
    public ComplexFunction(function f1){
        this.right = null;
        this.left = f1;
    }

    public ComplexFunction(ComplexFunction n){
        this.right = n.right;
        this.left = n.left;
        this.operator = n.operator;
    }

    public ComplexFunction(String op , function f1 , function f2){
        this.right = f1;
        this.left = f2;
        if(op.equals("plus")){
            this.operator = Operation.Plus;
        }
        else if(op.equals("times")){
            this.operator = Operation.Times;
        }
        else if(op.equals("div")){
            this.operator = Operation.Divid;
        }
        else if(op.equals("max")){
            this.operator = Operation.Max;
        }
        else if(op.equals("min")){
            this.operator = Operation.Min;
        }
        else if(op.equals("comp")){
            this.operator = Operation.Comp;
        }
        else{
            System.err.println("ERR: the operation is not correct");
        }
    }

    @Override
    public void plus(function f1) {
        if(this.operator == Operation.None){
            this.operator=Operation.Plus;
            this.right=f1;
        }
        else{
            ComplexFunction temp = new ComplexFunction();
            temp.operator= Operation.Plus;
            temp.left= new ComplexFunction(this);
            temp.right=f1;

            this.operator=temp.operator;
            this.left=temp.left;
            this.right=temp.right;

        }
    }

    @Override
    public void mul(function f1) {
        if(this.operator == Operation.None){
            this.operator=Operation.Times;
            this.right=f1;
        }
        else{
            ComplexFunction temp = new ComplexFunction();
            temp.operator= Operation.Times;
            temp.left= new ComplexFunction(this);
            temp.right=f1;

            this.operator=temp.operator;
            this.left=temp.left;
            this.right=temp.right;

        }
    }

    @Override
    public void div(function f1) {
        if(this.operator == Operation.None){
            this.operator=Operation.Divid;
            this.right=f1;
        }
        else{
            ComplexFunction temp = new ComplexFunction();
            temp.operator= Operation.Divid;
            temp.left= new ComplexFunction(this);
            temp.right=f1;

            this.operator=temp.operator;
            this.left=temp.left;
            this.right=temp.right;

        }
    }

    @Override
    public void max(function f1) {
        if(this.operator == Operation.None){
            this.operator=Operation.Max;
            this.right=f1;
        }
        else{
            ComplexFunction temp = new ComplexFunction();
            temp.operator= Operation.Max;
            temp.left= new ComplexFunction(this);
            temp.right=f1;

            this.operator=temp.operator;
            this.left=temp.left;
            this.right=temp.right;

        }
    }

    @Override
    public void min(function f1) {
        if(this.operator == Operation.None){
            this.operator=Operation.Min;
            this.right=f1;
        }
        else{
            ComplexFunction temp = new ComplexFunction();
            temp.operator= Operation.Min;
            temp.left= new ComplexFunction(this);
            temp.right=f1;

            this.operator=temp.operator;
            this.left=temp.left;
            this.right=temp.right;

        }
    }

    @Override
    public void comp(function f1) {

    }

    @Override
    public function left() {
        return null;
    }

    @Override
    public function right() {
        return null;
    }

    @Override
    public Operation getOp() {
        return null;
    }

    @Override
    public double f(double x) {
        return 0;
    }

    @Override
    public function initFromString(String s) {
        String r;
        String l="";
        String op="";
        int i = 0;
        boolean b = false;
        while (s.charAt(i)!='(' && i<s.length()){
            op=op+s.charAt(i);
            i++;
            if(i==s.length()-1){
                b=true;
            }
        }

        int comma= this.findComma(s);
        return null;
    }


    @Override
    public function copy() {
        return null;
    }

    public int findComma(String s) {
        Stack st = new Stack();
        int temp = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ',') {
                st.pop();
                if (st.isEmpty())
                    temp = i;
            }
        }
        return temp;
    }

    public String toString(){
        return this.operator + "(" + this.left.toString() + "," + this.right.toString() + ")";
    }

    public static void main(String[] args) {
        ComplexFunction e = new ComplexFunction("plus",new Monom(4,2),new Polynom("4x^2+1"));
        System.out.println(e.left.toString());
        System.out.println(e.right.toString());
        System.out.println(e.operator);
        e.mul(new Polynom("2x+3"));
        System.out.println(e.toString());
        System.out.println(e.findComma("Times(Plus(4.0x^2+1.0,4.0x^2),2.0x+3.0)"));


    }
}
