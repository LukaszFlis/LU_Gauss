package lu_gauss;

/**
 * Tworzy wiersz tabeli ze szystkimi współrzędnymi
 *
 * @author Luk
 */
public class RowArray {

    private int id; //nr
    private int w1;//W1
    private int w2;//W2
    private int w3;//W3
    //Obiekty klasy Pairs (łuki zawierające dwie współrzędne)
    private Pairs im;//Im<i2[nr]
    private Pairs ia2;//Ia2[nr]
    private Pairs ia1;//Ia1[nr]

    /**
     * Konstruktor inicjujący wszystkie zmienne
     *
     * @param id nr wiersza
     * @param w1 pierwsza współrzędna wierzchołka
     * @param w2 druga współrzędna wierzchołka
     * @param w3 trzecia współrzędna wierzchołka
     */
    public RowArray(int id, int w1, int w2, int w3) {
        this.id = id;
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.im = new Pairs(w2, w1);
        this.ia2 = new Pairs(w1, w3);
        this.ia1 = new Pairs(w2, w3);
    }

    //Gettery do zmiennych
    public int getW1() {
        return w1;
    }

    public int getW2() {
        return w2;
    }

    public int getW3() {
        return w3;
    }

    public Pairs getIm() {
        return im;
    }

    public Pairs getIa2() {
        return ia2;
    }

    public Pairs getIa1() {
        return ia1;
    }

    public int getId() {
        return id;
    }

    public int[] getCoordinates() {
        int[] rawArray = {w1, w2, w3};
        return rawArray;
    }

    public void setW1(int w1) {
        this.w1 = w1;
    }

    public void setW2(int w2) {
        this.w2 = w2;
    }

    public void setW3(int w3) {
        this.w3 = w3;
    }
    
    

    @Override
    public String toString() {
        return id + ". " + w1 + " " + w2 + " " + w3 + " " + im + " " + ia2 + " " + ia1;
    }

}