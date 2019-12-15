package Ex1;
import java.util.Stack;

public class ComplexFunction implements complex_function {

    private function right;
    private function left;
    private Operation operator=Operation.None;

    /**
     * this constructor update the default functions of left side and right side to null.
     */
    public ComplexFunction(){
        this.left=null;
        this.right=null;
    }

    /**
     * this constructor update the function of left side to f1, and the function of right side to null.
     * @param f1 is a function that represent the function of left side.
     */
    public ComplexFunction(function f1){
        this.right = null;
        this.left = f1;
    }

    /**
     * this constructor copies between two ComplexFunction.
     * @param n is a ComplexFunction of copying it to this ComplexFunction.
     */
    public ComplexFunction (ComplexFunction n){
        this.right = n.right;
        this.left = n.left;
        this.operator = n.operator;
    }

    /**
     * the constructor of ComplexFunction.
     * @param op is a operation of this ComplexFunction.
     * @param left is a function of left side of this ComplexFunction.
     * @param right is a function of right side of this ComplexFunction.
     */
    public ComplexFunction(Operation op , function left , function right) {
        if(op==Operation.None || op== Operation.Error){
            throw new RuntimeException("The operation is wrong");
        }
        this.operator = op;
        this.left = left;
        this.right = right;
    }

    /**
     * the constructor of ComplexFunction.
     * @param op is a string of this ComplexFunction.
     * @param f1 is a function of left side of this ComplexFunction.
     * @param f2 is a function of right side of this ComplexFunction.
     */
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

    /**
     * this function connects two functions with one complexFunction.
     * @param f1 the complex_function which will be added to this complex_function.
     */
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

    /**
     * this function double two functions with one complexFunction.
     * @param f1 the complex_function which will be multiply be this complex_function.
     */
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

    /**
     * this function divides two functions with one complexFunction.
     * @param f1 the complex_function which will be divid this complex_function.
     */
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

    /**
     * this function maximizes two functions with one complexFunction.
     * @param f1 the complex_function which will be compared with this complex_function - to compute the maximum.
     */
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

    /**
     *this function does a minimum between two functions with one complexFunction.
     * @param f1 the complex_function which will be compared with this complex_function - to compute the minimum.
     */
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

    /**
     *The function puts a function within a function.
     * @param f1 complex function
     */
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

    /**
     * this function return the function of left side.
     * @return
     */
    public function left() {
        return this.left;
    }

    /**
     * this function return the function of right side.
     * @return
     */
    public function right() {
        return this.right;
    }

    /**
     * this function return the operation of this complex function.
     * @return
     */
    public Operation getOp() {
        return this.operator;
    }

    /**
     * this function calculator the value of the complex function in x value.
     * @param x is a double that represent the value of the x that we calculator.
     * @return
     */
    public double f(double x) {
        if(this.right!=null && this.right.f(x)==0 && this.operator==Operation.Divid) throw new RuntimeException("You cannot divide by 0");
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

    /**
     * this constructor copies between two ComplexFunction.
     * @return
     */
    public function copy() {
        function copyFunction = new ComplexFunction(this);
        return copyFunction;
    }

    /**
     * this function turns a string into a function.
     * @param s is a string that will become a function.
     * @return
     */
    public function initFromString(String s) {
        s=s.replace(" ","");
        ComplexFunction p = new ComplexFunction();
        function ans = p.initFromStringRec(s);
        return ans ;
    }

    /**
     *this is an auxiliary function to initFromString.
     * @param s is a string that will become a function.
     * @return
     */
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

    /**
     * this is an auxiliary function to initFromString.
     * @param s1 is a string that will become a function.
     * @return
     */
    public Operation op(String s1){
        if(s1.equals("mul")) return Operation.Times;
        else if(s1.equals("div")) return Operation.Divid;
        else if(s1.equals("plus")) return Operation.Plus;
        else if(s1.equals("max")) return Operation.Max;
        else if(s1.equals("min")) return Operation.Min;
        else if(s1.equals("comp")) return Operation.Comp;
        return Operation.None;
    }

    /**
     * this is an auxiliary function to initFromString tha find the main comma.
     * @param s is a string that will become a function.
     * @return
     */
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

    /**
     * this is an auxiliary function to initFromString that find the main operation.
     * @param o is a string that will become a function.
     * @return
     */
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

    /**
     * this function return string that represent operation.
     * @param p the operation.
     * @return
     */
    private String getopration(Operation p){
        if(p==Operation.Comp) return "comp";
        else if(p==Operation.Divid) return "div";
        else if(p==Operation.Max) return "max";
        else if(p==Operation.Min) return "min";
        else if(p==Operation.Plus) return "plus";
        else if(p==Operation.Times) return "mul";
        else return "";
    }

    /**
     * this function bring a string that represent the Complex Function.
     * @return
     */
    public String toString() {
        if (this.right == null) return this.left.toString();
        else {
            return this.getopration(this.operator) + "(" + this.left.toString() + "," + this.right.toString() + ")";
        }
    }

    /**
     * this function check if two functions are equals each other.
     * @param p1 the second function.
     * @return
     */
    public boolean equals(Object p1) {
        function cf = (function) (p1);
        for (int i = -100; i <100 ; i++) {
            double f1 = (double)Math.round(this.f(i)*10000000000000000d/10000000000000000d);
            double f2 = (double)Math.round(cf.f(i)*10000000000000000d/10000000000000000d);
            if (Math.abs(f1-f2)>Monom.EPSILON) return false;
        }
        return true;
    }


}
