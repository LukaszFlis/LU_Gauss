package lu_gauss;

/**
 *
 * @author Luk
 */
public class EP implements Comparable<EP>{
    //Id EP
    private Pairs id;
    //CPU Clock
    private int t;

    /**
     * Konstruktor inicjujący wszystkie zmienne
     *
     * @param id coordinates of EP
     * @param t cpu clock
     */
    public EP(Pairs id, int t) {
        this.id = id;
        this.t = t;
    }
    
    //Gettery do zmiennych
    public Pairs getId() {
        return id;
    }

    public int getT() {
        return t;
    }
    
    
    public void setId(Pairs id) {
        this.id = id;
    }

    public void setT(int t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "{[" + id + "]," + t + "}";
    }

    @Override
    public int compareTo(EP o) {
        int result = this.id.a- o.id.a;
            if (result == 0) {
                result = this.id.b - o.id.b;
            }
        return result;
    }
    
}
