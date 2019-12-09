package Ex1;


import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Functions_GUI implements functions {
    private LinkedList<function>  f = new LinkedList<function>();

    public Functions_GUI(){
        this.f= new LinkedList<function>();
    }

    @Override
    public void initFromFile(String file) throws IOException {
        ComplexFunction temp = new ComplexFunction();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine())!=null){
                StringBuilder content = new StringBuilder();
                content.append(line);
                String s = content.toString();
                s=s.replace(" ","");
                function function=temp.initFromString(s);
                add(function);
            }
        }
    }

    @Override
    public void saveToFile(String file) throws IOException {


        }
        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(str);

        String str1 = "World";
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(file, true));
        writer1.append(' ');
        writer1.append(str);
    }

    @Override
    public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {

    }

    @Override
    public void drawFunctions(String json_file) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<function> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean add(function function) {

        return this.f.add(function);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends function> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.retainAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public static void main(String[] args) throws IOException {
        Functions_GUI t = new Functions_GUI();
        t.initFromFile("C:/try/function_file.txt");
    }

}