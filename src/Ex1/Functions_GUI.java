package Ex1;

import com.google.gson.Gson;
import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.*;
import java.io.FileReader;
import java.io.Reader;

public class Functions_GUI implements functions {
    private LinkedList<function>  f = new LinkedList<function>();
    public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE,
            Color.red, Color.GREEN, Color.PINK};

    public Functions_GUI(){
        this.f= new LinkedList<function>();
    }

    public function get(int i){
        return this.f.get(i);
    }

    /**
     * this function reads from a file to java text.
     * @param file - the file name
     * @throws IOException
     */
    public void initFromFile(String file) throws IOException {
        ComplexFunction temp = new ComplexFunction();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine())!=null){
            line=line.replace(" ","");
            function function=temp.initFromString(line);
            add(function);
        }
    }

    /**
     * this function save from a java text to a file.
     * @param file - the file name
     * @throws IOException
     */
    public void saveToFile(String file) throws IOException {
       FileWriter Filewriter = new FileWriter(file);
       Iterator<function> iterator = this.f.iterator();
       StringBuilder s = new StringBuilder();
       while (iterator.hasNext()){
           s.append(iterator.next().toString() + "\n");
       }
       Filewriter.write(s.toString());
       Filewriter.close();
    }


    /**
     * this function draws functions with the help of GUI.
     * @param width - the width of the window - in pixels
     * @param height - the height of the window - in pixels
     * @param rx - the range of the horizontal axis
     * @param ry - the range of the vertical axis
     * @param resolution - the number of samples with in rx: the X_step = rx/resulution
     */
    public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
        StdDraw.setCanvasSize(width,height);
        StdDraw.setXscale(rx.get_min(),rx.get_max());
        StdDraw.setYscale(ry.get_min(),ry.get_max());
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        StdDraw.setPenRadius(0.004);
        for (double i = ry.get_min(); i <ry.get_max() ; i++) {
            StdDraw.line(rx.get_min(), i, rx.get_max(), i);
        }
        for (double i = rx.get_min(); i <rx.get_max() ; i++) {
            StdDraw.line(i,ry.get_min(),i,ry.get_max());
        }
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(rx.get_min(),0,rx.get_max(),0);
        StdDraw.line(0,ry.get_min(),0,ry.get_max());

        for (int i = (int)rx.get_min(); i <rx.get_max() ; i++) {
            StdDraw.text(i, -1, "" + i);
        }
        for (int i = (int)ry.get_min(); i <ry.get_max() ; i++) {
            if (i != 0) {
                StdDraw.text(-0.5, i, "" + i);
            }
        }
        StdDraw.setPenRadius(0.004);
        int n = resolution;
        int size = this.f.size();
        double[] x = new double[n+1];
        double[][] yy = new double[size][n+1];
        double x_step = (rx.get_max()-rx.get_min())/n;
        double x0 = rx.get_min();
        for (int i=0; i<=n; i++) {
            x[i] = x0;
            for(int a=0;a<size;a++) {
                yy[a][i] = this.f.get(a).f(x[i]);
            }
            x0+=x_step;
        }
        for(int a=0;a<size;a++) {
            int c = a%Colors.length;
            StdDraw.setPenColor(Colors[c]);

            System.out.println(a+") "+Colors[a]+"  f(x)= "+this.f.get(a));
            for (int i = 0; i < n; i++) {
                StdDraw.line(x[i], yy[a][i], x[i+1], yy[a][i+1]);
            }
        }
    }

    /**
     * this function draws functions with the help of GUI.
     * @param json_file - the file with all the parameters for the GUI window.
     */
    public void drawFunctions(String json_file) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(json_file);
            convertFromJson g = gson.fromJson(reader, convertFromJson.class);
            Range rx = new Range(g.Range_X[0], g.Range_X[1]);
            Range ry = new Range(g.Range_Y[0], g.Range_Y[1]);
            drawFunctions(g.Width, g.Height, rx, ry, g.Resolution);
        }
        catch (FileNotFoundException | IllegalArgumentException | com.google.gson.JsonSyntaxException | com.google.gson.JsonIOException e) {
            if(e instanceof IllegalArgumentException)
                System.out.println("IllegalArgumentException");
            if(e instanceof com.google.gson.JsonSyntaxException)
            {
                this.drawFunctions();
                System.out.println("com.google.gson.JsonSyntaxException");
            }
            if(e instanceof com.google.gson.JsonIOException)
            {
                this.drawFunctions();
                System.out.println("com.google.gson.JsonIOException");
            }
            this.drawFunctions();
            e.printStackTrace();
        }
    }

    /**
     * this function is a default function to drawFunctions.
     */
    public void drawFunctions() {
        Range rx = new Range(-10, 10);
        Range ry = new Range(-5, 15);
        drawFunctions(1000, 600, rx, ry, 200);
    }

    /**
     * The following functions are inherited from the collections department and used in the collections department
     * @return
     */
    public int size() {
        return this.f.size();
    }

    @Override
    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.f.contains(o);
    }

    @Override
    public Iterator<function> iterator() {
        return this.f.iterator();
    }

    @Override
    public Object[] toArray() {
        return f.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) this.f.toArray(a);
    }


    @Override
    public boolean add(function function) {
        return this.f.add(function);
    }

    @Override
    public boolean remove(Object o) {
        return this.f.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.f.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends function> c) {
        return this.f.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.retainAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.retainAll(c);
    }

    @Override
    public void clear() {
        this.f.clear();
    }
}



