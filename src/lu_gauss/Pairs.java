package lu_gauss;

import java.util.Objects;

/**
 *Przechowuje pary współrzędnych łuków
 * @author Luk
 */
public class Pairs {
    //1Współrzędna łuku
    int a;
    //2Współrzędna łuku
    int b;
    
    //Konstruktor iniciujący
    Pairs(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    
    

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    /**
     *
     * @param o Object
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pairs that = (Pairs) o;
        return a == that.a &&
                b == that.b;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
