package lu_gauss;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luk
 */
public class Graf {

    //Uchwyt do pól i metod klasy LU_Decomposition
    LU_Decomposition handler;

    //Model tabeli dla listy wierzchołków i łuków zebranych z pierwszego giazda pętli for
    DefaultTableModel modelA1;
    // model tabeli dla listy wierzchołków i łuków zebranych z drugieg gniazda pętli for
    DefaultTableModel modelA2;

    //Macierz wejściowa A
    double[][] matrixA;
    //Macierz dolno-trójkątna L
    double[][] matrixL;
    //Macierz górno-trójkątna U
    double[][] matrixU;

    private ArrayList<RowArray> listNestOneModified;// lista danych do tabeli - zmodyfikowane 1-sze gn. pętli
    private ArrayList<RowArray> listNestTwoModified;// lista danych do tabeli - zmodyfikowane 2-gie gn. pętli
    private ArrayList<Connection> listOfConnections1;//lista połaczeń między wierchołkami (operacjami "/")
    private ArrayList<Connection> listOfConnections2;//lista połaczeń między wierchołkami (operacjami "+*")

    public Graf() {
        this.matrixU = handler.getMatrixU();
        this.matrixL = handler.getMatrixL();
        this.matrixA = handler.getMatrixA();
        this.handler = new LU_Decomposition();
    }

    /**
     * Metoda wylicza elementy do tabeli i zapisuje je do tablicy przy
     * zmodyfikowanym 1-szym gnieździe pętli (psiwykład2 - slajd6)
     *
     * @param n Liczba określająca wymiar macierzy A(NxN)
     * @param a1 Tabela, do której zostaną zapisane dane
     */
    public void CoordinatesFirstNest(int n, JTable a1) {
        modelA1 = (DefaultTableModel) a1.getModel();
        // lista przechowuje elementy: W1 W2 W3 Im Ia2 Ia1(obiekty klasy RowArray) zliczane z 1 gniazda pętli 
        listNestOneModified = new ArrayList<>();
        //Zlicza ile razy wykonała sie I pętla for
        int nr = 0;
        // Pierwsze zmodyfikowane gniazdo pętli
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k < i; k++) {
                    matrixL[j][i] = matrixA[j][i] / matrixA[i][i];
                    nr++;
                    int w1 = i + 1;
                    int w2 = j + 1;
                    int w3 = k + 1;
                    listNestOneModified.add(new RowArray(nr, w1, w2, w3, new Pairs(w2, w1), new Pairs(w1, w3), new Pairs(w2, w3)));
                }
            }
        }
    }

    /**
     * Metoda wylicza elementy do tabeli i zapisuje je do tablicy przy
     * zmodyfikowanym 1-szym gnieździe pętli (psiwykład2 - slajd6)
     *
     * @param n Liczba określająca wymiar macierzy A(NxN)
     * @param a2 Tabela, do której zostaną zapisane dane
     */
    public void CoordinatesSecondNest(int n, JTable a2) {
        modelA2 = (DefaultTableModel) a2.getModel();
        //lista przechowuje elementy: W1 W2 W3 Im Ia2 Ia1(obiekty klasy RowArray) zliczane z 2 gniazda pętli 
        listNestTwoModified = new ArrayList<>();
        //Zlicza ile razy wykonała sie I pętla for
        int nr = 0;

        //Drugie zmodyfikowane gniazdo pętli
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < n; k++) {
                    matrixU[j][k] = matrixA[j][k] - (matrixL[j][i] * matrixA[i][k]);
                    nr++;
                    int w1 = i + 1;
                    int w2 = j + 1;
                    int w3 = k + 1;
                    listNestTwoModified.add(new RowArray(nr, w1, w2, w3, new Pairs(w2, w1), new Pairs(w1, w3), new Pairs(w2, w3)));
                }
            }
        }
    }
    

    //Getters
    public ArrayList<RowArray> getListNestOneModified() {
        return listNestOneModified;
    }

    public ArrayList<RowArray> getListNestTwoModified() {
        return listNestTwoModified;
    }

    public ArrayList<Connection> getListOfConnections1() {
        return listOfConnections1;
    }

    public ArrayList<Connection> getListOfConnections2() {
        return listOfConnections2;
    }

}
