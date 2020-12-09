package ex2;

import java.util.Vector;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static Vector unionSet(Vector a, Vector b) {
        Vector c = new Vector();
        for(int i = 0;i<a.size();i++){
            for(int y =0;y<b.size();y++){
                if(b.get(y).equals(a.get(i)))
                    c.add(b.get(y));
            }
        }
        return c;
    }
}
