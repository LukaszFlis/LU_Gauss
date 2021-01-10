package lu_gauss;

/**
 * Tworzy wiersz tabeli ze szystkimi współrzędnymi
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
     *Konstruktor inicjujący wszystkie zmienne
     * @param id
     * @param coordinateX
     * @param coordinateY
     * @param coordinateZ
     * @param im
     * @param ia2
     * @param ia1
     */
    public RowArray(int id, int coordinateX, int coordinateY, int coordinateZ,
    Pairs im, Pairs ia2, Pairs ia1) {
    this.id = id;
    this.w1 = coordinateX;
    this.w2 = coordinateY;
    this.w3 = coordinateZ;
    this.im = im;
    this.ia2 = ia2;
    this.ia1 = ia1;

}
    //Gettery do zmiennych
    public int getCoordinateX() {
        return w1;
    }

    public int getCoordinateY() {
        return w2;
    }

    public int getCoordinateZ() {
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

    public int getId() { return id;}

    public int[] getCoordinates(){
        int[] rawArray = {w1, w2, w3};
        return rawArray ;
    }

   
    @Override
    public String toString(){
        return id + ". "+ w1 + " " + w2 + " " + w3 + " " + im + " " + ia2 + " "  + ia1;
    }

}
