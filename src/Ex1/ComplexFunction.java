package Ex1;


import java.util.Stack;

public class ComplexFunction implements complex_function {

    private function right;
    private function left;
    private Operation operator=Operation.None;

    public ComplexFunction(){
        this.left=null;
        this.right=null;
        //tom
    }

    public ComplexFunction(function f1){
        this.right = null;
        this.left = f1;

    }

    public ComplexFunction (ComplexFunction n){
        this.right = n.right;
        this.left = n.left;
        this.operator = n.operator;
    }

    public ComplexFunction(Operation op , function left , function right) {
        this.operator = op;
        this.left = left;
        this.right = right;
    }

    public ComplexFunction(String op , function f1 , function f2){
        op=op.toLowerCase();
        this.left = f1;
        this.right = f2;
        if(op.equals("plus")){
            this.operator = Operation.Plus;
        }
        else if(op.equals("mul")){
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
        if(this.operator == Operation.None){
            this.operator=Operation.Comp;
            this.right=f1;
        }
        else{
            ComplexFunction temp = new ComplexFunction();
            temp.operator= Operation.Comp;
            temp.left= new ComplexFunction(this);
            temp.right=f1;

            this.operator=temp.operator;
            this.left=temp.left;
            this.right=temp.right;

        }
    }

    @Override
    public function left() {
        return this.left;
    }

    @Override
    public function right() {
        return this.right;
    }

    @Override
    public Operation getOp() {
        return this.operator;
    }

    @Override
    public double f(double x) {
        if(this.operator==Operation.Min){
            return (Math.min(this.left.f(x),this.right.f(x)));
        }
        else if(this.operator==Operation.Max){
            return (Math.max(this.left.f(x),this.right.f(x)));
        }
        else if(this.operator==Operation.Divid){
            return (this.left.f(x)/this.right.f(x));
        }
        else if(this.operator==Operation.Plus){
            return (this.left.f(x)+this.right.f(x));
        }
        else if(this.operator==Operation.Times){
            return (this.left.f(x)*this.right.f(x));
        }
        else if(this.operator==Operation.Comp){
            return (this.left.f(this.right.f(x)));
        }
        else {
            return this.left.f(x);
        }
    }

    @Override
    public function copy() {
    function copyFunction = new ComplexFunction(this);
    return copyFunction;
    }

    @Override
    public function initFromString(String s) {
        s=s.replace(" ","");
        ComplexFunction p = new ComplexFunction();
        function ans = p.initFromStringRec(s);
        return ans ;
    }

    private function initFromStringRec(String s) {
        if (!s.contains("(")) {
            return new Polynom(s);
        }
        int comma = findComma(s);
        String op = findOp(s);
        function left = initFromStringRec(s.substring(op.length() + 1, comma));
        function right = initFromStringRec(s.substring(comma + 1, s.length() - 1));
        function f = new ComplexFunction(op,left,right);
        return f;
    }

    public Operation op(String s1){
        if(s1.equals("mul")) return Operation.Times;
        else if(s1.equals("div")) return Operation.Divid;
        else if(s1.equals("plus")) return Operation.Plus;
        else if(s1.equals("max")) return Operation.Max;
        else if(s1.equals("min")) return Operation.Min;
        else if(s1.equals("comp")) return Operation.Comp;
        return Operation.None;
    }

    public int findComma(String s) {
        Stack st = new Stack();
        int temp = 0;
        boolean b = false;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ',') {
                st.pop();
                if (st.isEmpty()) {
                    temp = i;
                    b = true;
                }
            }
            if(b==true) break;
        }
        return temp;
    }

    public String findOp(String o) {
        String op = "";
        int i = 0;
        boolean b = true;
        while (b==true && o.charAt(i) != '(') {
            op = op + o.charAt(i);
            if (i == o.length()-1) {
                op = "";
                b=false;
            }
            i++;
        }
        return op;
    }
    private String getopration(Operation p){
        if(p==Operation.Comp) return "comp";
        else if(p==Operation.Divid) return "div";
        else if(p==Operation.Max) return "max";
        else if(p==Operation.Min) return "min";
        else if(p==Operation.Plus) return "plus";
        else if(p==Operation.Times) return "mul";
        else return "";
    }

    public String toString() {
        if (this.right == null) return this.left.toString();
        else {
            return this.getopration(this.operator) + "(" + this.left.toString() + "," + this.right.toString() + ")";
        }
    }

    public boolean equals(Object p1) {
        function cf = (function) (p1);
        for (int i = -100; i <100 ; i++) {
            if (this.f(i)-cf.f(i)>Monom.EPSILON) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        ComplexFunction e = new ComplexFunction("plus(div(+1.0x+1.0,mul(mul(+1.0x+3.0,+1.0x-2.0),+1.0x-4.0)),2.0)"
//        );
//        System.out.println(e.toString());

//            System.out.println(e.left.toString());
//            System.out.println(e.right.toString());
//            System.out.println(e.operator);
//            e.mul(new Polynom("2x+3"));
//            System.out.println(e.toString());
//            System.out.println(e.findComma("Times(Plus(4.0x^2+1.0,4.0x^2),2.0x+3.0)"));

//        function c = e.initFromString("2.0x+3.0");
//        ComplexFunction p = (ComplexFunctionbc;
//        ComplexFunction f = new ComplexFunction((ComplexFunction)c);
//        System.out.println(f.toString());

//        ("div(plus(4.0x^3,4.0x^2),1.0x^2+3.0x-5.0)");
//        ComplexFunction e=new ComplexFunction("plus",new Polynom("8x^2"),new Polynom("50x"));
//        ComplexFunction c =new ComplexFunction("plus",new Polynom("8x^2"),new Polynom("50x"));
//        System.out.println(e.equals(c));
        Monom p1 = new Monom("6.7x^5");
        ComplexFunction f = new ComplexFunction();
        function f1 = f.initFromString("mul(6.7x,x^4)");
        System.out.println(p1.equals(f1));

//        ComplexFunction cf =new ComplexFunction (new Polynom("x^2+3"));
//        System.out.println(cf.toString());
    }
}
