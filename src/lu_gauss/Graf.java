package lu_gauss;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luk
 */
public class Graf {

    //Uchwyt do pól i metod klasy LU_Decomposition
    LU_Decomposition handler = new LU_Decomposition();

    //Model tabeli dla listy wierzchołków i łuków zebranych z pierwszego giazda pętli for
    DefaultTableModel modelA1;
    // model tabeli dla listy wierzchołków i łuków zebranych z drugieg gniazda pętli for
    DefaultTableModel modelA2;

    //Macierz wejściowa A
    //double[][] matrixA = handler.getMatrixA();
    //Macierz dolno-trójkątna L
    //double[][] matrixL;
    //Macierz górno-trójkątna U
    //double[][] matrixU;
    // lista danych do tabeli - zmodyfikowane 1-sze gn. pętli
    private ArrayList<RowArray> listFirstNestModified;
    // lista danych do tabeli - zmodyfikowane 2-gie gn. pętli
    private ArrayList<RowArray> listSecondNestModified;
    //lista połaczeń między wierchołkami (operacjami "/")
    private ArrayList<Connection> listOfConnections1;
    //lista połaczeń między wierchołkami (operacjami "+*")
    private ArrayList<Connection> listOfConnections2;

    public Graf() {

    }

    /**
     * Metoda wylicza elementy:W1 W2 W3 Im Ia2 Ia1 na podstawie zmodyfikowanego
     * 2 gniazda pętli (psiwykład.II - slajd4), Wyliczone współrzędne zapisywane
     * są do Tabeli A1
     *
     * @param n Liczba określająca wymiar macierzy A(NxN)
     * @param a1 Tabela, do której zostaną zapisane dane
     */
    public void CoordinatesFirstNest(int n, JTable a1) {
        double[][] matrixA = new double[n][n];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                matrixA[i][j] = random.nextInt(9);
                if (matrixA[i][i] == 0) {
                    matrixA[i][i] += 1;
                }
            }
        }
        double[][] matrixL = new double[n][n];
        for (int i = 0; i < matrixL.length; i++) {
            for (int j = 0; j < matrixL.length; j++) {
                if (i == j) {
                    matrixL[i][j] = 1;
                } else {
                    matrixL[i][j] = 0;
                }
            }
        }
        modelA1 = (DefaultTableModel) a1.getModel();
        // lista przechowuje elementy: W1 W2 W3 Im Ia2 Ia1(obiekty klasy RowArray) zliczane z 1 gniazda pętli 
        listFirstNestModified = new ArrayList<>();
        //Zlicza ile razy wykonała sie I pętla for
        int nr = 0;
        // Pierwsze zmodyfikowane gniazdo pętli
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k < i+1; k++) {
                    matrixL[j][i] = matrixA[j][i] / matrixA[i][i];
                    nr++;
                    int w1 = i + 1;
                    int w2 = j + 1;
                    int w3 = k + 1;
                    listFirstNestModified.add(new RowArray(nr, w1, w2, w3));
                }
            }
        }
        for (int i = 0; i < listFirstNestModified.size(); i++) {
            int id = listFirstNestModified.get(i).getId();
            int w1 = listFirstNestModified.get(i).getW1();
            int w2 = listFirstNestModified.get(i).getW2();
            int w3 = listFirstNestModified.get(i).getW3();
            Pairs im = listFirstNestModified.get(i).getIm();
            Pairs ia2 = listFirstNestModified.get(i).getIa2();
            Pairs ia1 = listFirstNestModified.get(i).getIa1();
            Object[] data = {id, w1, w2, w3, im, ia2, ia1};
            modelA1.addRow(data);
        }
    }
    
    public void addRowSet(JTable a1) {
        modelA1 = (DefaultTableModel) a1.getModel();
        for (int i = 0; i < listFirstNestModified.size(); i++) {
            int id = listFirstNestModified.get(i).getId();
            int w1 = listFirstNestModified.get(i).getW1();
            int w2 = listFirstNestModified.get(i).getW2();
            int w3 = listFirstNestModified.get(i).getW3();
            Pairs im = listFirstNestModified.get(i).getIm();
            Pairs ia2 = listFirstNestModified.get(i).getIa2();
            Pairs ia1 = listFirstNestModified.get(i).getIa1();
            Object[] data = {id, w1, w2, w3, im, ia2, ia1};
            modelA1.addRow(data);
            System.out.println("Wierzchołki" + Arrays.toString(data));
        }
    }

    /**
     * Metoda wylicza elementy:W1 W2 W3 Im Ia2 Ia1 na podstawie zmodyfikowanego
     * 2 gniazda pętli (psiwykład.II - slajd4), Wyliczone współrzędne zapisywane
     * są do Tabeli A2
     *
     * @param n Liczba określająca wymiar macierzy A(NxN)
     * @param a2 Tabela, do której zostaną zapisane dane
     */
    public void CoordinatesSecondNest(int n, JTable a2) {
        double[][] matrixA = new double[n][n];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                matrixA[i][j] = random.nextInt(9);
                if (matrixA[i][i] == 0) {
                    matrixA[i][i] += 1;
                }
            }
        }
        double[][] matrixL = new double[n][n];
        for (int i = 0; i < matrixL.length; i++) {
            for (int j = 0; j < matrixL.length; j++) {
                if (i == j) {
                    matrixL[i][j] = 1;
                } else {
                    matrixL[i][j] = 0;
                }
            }
        }
        double[][] matrixU = new double[n][n];
        for (int i = 0; i < matrixU.length; i++) {
            for (int j = 0; j < matrixU.length; j++) {
                if (i <= j) {
                    matrixU[i][j] = matrixA[i][j];
                } else {
                    matrixU[i][j] = 0;
                }
            }
        }
        modelA2 = (DefaultTableModel) a2.getModel();
        //lista przechowuje elementy: W1 W2 W3 Im Ia2 Ia1(obiekty klasy RowArray) zliczane z 2 gniazda pętli 
        listSecondNestModified = new ArrayList<>();
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
                    listSecondNestModified.add(new RowArray(nr, w1, w2, w3));
                }
            }
        }
    }

    /**
     * Metoda zwraca listę par ID wierzchołków (ID pobierane z obiektu klasy
     *
     * @RowNestedArr), między którymi są połączenia oraz informację o
     * kierunku(lewo, prawo, góra, skos)
     *
     */
    public void ConnectionsOfFirstNest() {
        listOfConnections1 = new ArrayList<>();

        for (int i = 0; i < listFirstNestModified.size(); i++) {
            for (int j = 1; j < listFirstNestModified.size(); j++) {
                if (i != j) {
                    RowArray rowA = listFirstNestModified.get(i);
                    RowArray rowB = listFirstNestModified.get(j);

                    //lewo if A.IM == B.IM && A.W3 < B.W3 && A.W1 == B.W1 A.W2 == B.W2
                    if (rowA.getW1() == rowA.getW1() && rowA.getIm().equals(rowB.getIm())
                            && rowA.getW3() < rowB.getW3()) {
                        listOfConnections1.add(new Connection(rowA.getId(), rowB.getId(), "LEFT"));
                    }//prawo if A.Ia2 = B.Ia2 && A.W2 < B.W2 && A.W1 == B.W1 A.W3 == B.W3
                    else if (rowA.getW1() == rowB.getW1() && rowA.getIa2().equals(rowB.getIa2())
                            && rowA.getW2() < rowB.getW2()) {
                        listOfConnections1.add(new Connection(rowA.getId(), rowB.getId(), "RIGHT"));
                    }//góra if A.W2 == B.W2  &&  A.W3 == B.W3  &&   A.Ia1 == B.Ia1  &&  A.W1 < B.W1
                    else if (rowA.getW2() == rowA.getW2() && rowA.getW3() == rowA.getW3()
                            && rowA.getIa1().equals(rowB.getIa1()) && rowA.getW1() < rowB.getW1()) {
                        listOfConnections1.add(new Connection(rowA.getId(), rowB.getId(), "UP"));
                    }//skos if A.Ia1 == B.Ia2 && A.W3 == B.W3
                    if (rowA.getW3() == rowB.getW3() && rowA.getIa1().equals(rowB.getIa2())
                            && Math.abs(rowA.getW1() - rowB.getW1()) == 1
                            && Math.abs(rowA.getW2() - rowB.getW2()) == 1) {
                        listOfConnections1.add(new Connection(rowA.getId(), rowB.getId(), "CROSS"));
                    }
                }
            }
        }
    }

    /**
     * Metoda zwraca listę par ID wierzchołków (ID pobierane z obiektu klasy
     *
     * @RowNestedArr), między którymi są połączenia oraz informację o
     * kierunku(lewo, prawo, góra, skos)
     */
    public void ConnectionsOfSecondNest() {
        listOfConnections2 = new ArrayList<>();

        for (int i = 0; i < listSecondNestModified.size(); i++) {
            for (int j = 1; j < listSecondNestModified.size(); j++) {
                if (i != j) {
                    RowArray rowA = listSecondNestModified.get(i);
                    RowArray rowB = listSecondNestModified.get(j);

                    //lewo if A.IM == B.IM && A.W3 < B.W3 && A.W1 == B.W1 A.W2 == B.W2
                    if (rowA.getW1() == rowA.getW1() && rowA.getIm().equals(rowB.getIm())
                            && rowA.getW3() < rowB.getW3()) {
                        listOfConnections2.add(new Connection(rowA.getId(), rowB.getId(), "LEFT"));
                    }//prawo if A.Ia2 = B.Ia2 && A.W2 < B.W2 && A.W1 == B.W1 A.W3 == B.W3
                    else if (rowA.getW1() == rowB.getW1() && rowA.getIa2().equals(rowB.getIa2())
                            && rowA.getW2() < rowB.getW2()) {
                        listOfConnections2.add(new Connection(rowA.getId(), rowB.getId(), "RIGHT"));
                    }//góra if A.W2 == B.W2  &&  A.W3 == B.W3  &&   A.Ia1 == B.Ia1  &&  A.W1 < B.W1
                    else if (rowA.getW2() == rowA.getW2() && rowA.getW3() == rowA.getW3()
                            && rowA.getIa1().equals(rowB.getIa1()) && rowA.getW1() < rowB.getW1()) {
                        listOfConnections2.add(new Connection(rowA.getId(), rowB.getId(), "UP"));
                    }//skos if A.Ia1 == B.Ia2 && A.W3 == B.W3
                    if (rowA.getW3() == rowB.getW3() && rowA.getIa1().equals(rowB.getIa2())
                            && Math.abs(rowA.getW1() - rowB.getW1()) == 1
                            && Math.abs(rowA.getW2() - rowB.getW2()) == 1) {
                        listOfConnections1.add(new Connection(rowA.getId(), rowB.getId(), "CROSS"));
                    }
                }
            }
        }
    }

    //Getters
    public ArrayList<RowArray> getListFirstNestModified() {
        return listFirstNestModified;
    }

    public ArrayList<RowArray> getListSecondNestModified() {
        return listSecondNestModified;
    }

    public ArrayList<Connection> getListOfConnections1() {
        return listOfConnections1;
    }

    public ArrayList<Connection> getListOfConnections2() {
        return listOfConnections2;
    }

    public DefaultTableModel getModelA1() {
        return modelA1;
    }

    public DefaultTableModel getModelA2() {
        return modelA2;
    }

}
