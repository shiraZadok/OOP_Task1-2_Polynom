package Ex1;

public class ComplexFunction implements complex_function {

    private Node root=null;

    public ComplexFunction(){
        root=null;
    }
    public ComplexFunction(Node r){

    }

    public ComplexFunction(ComplexFunction c){

    }

    @Override
    public void plus(function f1) {

    }

    @Override
    public void mul(function f1) {

    }

    @Override
    public void div(function f1) {

    }

    @Override
    public void max(function f1) {

    }

    @Override
    public void min(function f1) {

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
        return null;
    }

    @Override
    public function copy() {
        return null;
    }


    private class Node {
        private function right;
        private function left;
        private Operation operator=Operation.None;

        public Node(Operation operator, function right, function left){
            this.right = right;
            this.left = left;
            this.operator = operator;
        }

        public Node(function f1){
            this.right = null;
            this.left = f1;
        }

        public Node(Node n){
            this.right = n.right;
            this.left = n.left;
            this.operator = n.operator;
        }
    }
}