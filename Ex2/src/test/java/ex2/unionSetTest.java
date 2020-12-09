package ex2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class unionSetTest {
    @Test
    @DisplayName("Normal test")
    //Permet simplement de vérifier que l'implémentation fonctionne
    public void normal(){
        Vector<String> a = new Vector<>();
        Vector<String> b = new Vector<>();
        Vector<String> c = new Vector<>();
        a.add("Test");
        b.add("Test");
        c.add("Test");
        assertTrue(c.equals(App.unionSet(a,b)),"a+b not equal to c");
        a.add("Test2");
        a.add("Test3");
        assertTrue(c.equals(App.unionSet(a,b)),"aUb not equal to c");
        a.clear();
        b.clear();
        c.clear();
        a.add("Test");
        b.add("Test, mais dans B");
        assertTrue(c.equals(App.unionSet(a,b)),"aUb not empty");
    }
    @Test
    @DisplayName("Empty A")
    //Permet de tester l'implémentation dans le cas où le Vector A est vide (si par exemple A doit obligatoirement avoir une valeur)
    public void emptyA(){
        Vector<String> a = new Vector<>();
        Vector<String> b = new Vector<>();
        Vector<String> c = new Vector<>();
        b.add("Test");
        assertTrue(c.equals(App.unionSet(a,b)));
    }
    @Test
    @DisplayName("Empty B")
    //Permet de tester l'implémentation dans le cas où le Vector B est vide (si par exemple A doit obligatoirement avoir une valeur)
    public void emptyB(){
        Vector<String> a = new Vector<>();
        Vector<String> b = new Vector<>();
        Vector<String> c = new Vector<>();
        a.add("Test");
        assertTrue(c.equals(App.unionSet(a,b)));
    }
    @Test
    @DisplayName("Empty A and B")
    //Permet de tester l'implémentation dans le cas où les deux vecteurs sont vides (Cas où la méthode ne sert à rien, donc)
    public void emptyBoth(){
        Vector<String> a = new Vector<>();
        Vector<String> b = new Vector<>();
        Vector<String> c = new Vector<>();
        assertTrue(c.equals(App.unionSet(a,b)));
    }
    @Test
    @DisplayName("Different Vector Type")
    //Permet de tester l'implémentation dans le cas où le type de Vector A diffère de B.
    public void differentA(){
        Vector<Double> a = new Vector<>();
        Vector<String> b = new Vector<>();
        Vector<Object> c = new Vector<>();
        assertTrue(c.equals(App.unionSet(a,b)));
    }
    @Test
    @DisplayName("A is null")
    //Permet de vérifier que l'implémentation gère si le vecteur A est non initialisé.
    public void nullA(){
        Vector<String> a = null;
        Vector<String> b = new Vector<>();
        b.add("Test");
        assertThrows(NullPointerException.class,() ->{App.unionSet(a,b);});
    }
    @Test
    @DisplayName("B is null")
    //Permet de vérifier que l'implémentation gère si le vecteur B est non initialisé.
    public void nullB(){
        Vector<String> a = new Vector<>();
        Vector<String> b = null;
        assertThrows(NullPointerException.class,() ->{App.unionSet(a,b);});
    }
    @Test
    @DisplayName("They're both null")
    //Permet de vérifier que l'implémentation gère si aucun des vecteurs est initialisé.
    public void nullBoth(){
        Vector<String> a = null;
        Vector<String> b = null;
        assertThrows(NullPointerException.class,() ->{App.unionSet(a,b);});
    }
}
