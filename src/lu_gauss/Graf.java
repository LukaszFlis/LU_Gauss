package lu_gauss;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Luk
 */
public class Graf {

    //Model tabeli dla listy wierzchołków i łuków
    DefaultTableModel modelA1;
    //Model tabeli dla listy połączeń
    private DefaultTableModel modelC;
    // lista danych do tabeli - zmodyfikowane 1-sze gn. pętli
    private ArrayList<RowArray> listNestModified;
    // lista danych do tabeli - zmodyfikowane 2-gie gn. pętli
    //private ArrayList<RowArray> listSecondNestModified;
    //lista połaczeń między wierchołkami grafu
    private ArrayList<Connection> listOfConnections;

    public Graf() {

    }

    /**
     * Metoda wylicza elementy:W1 W2 W3 Im Ia2 Ia1 na podstawie zmodyfikowanych
     * gniazd pętli (psiwykład.II - slajd4) Wyliczone współrzędne zapisywane są
     * do Tabeli A1
     *
     * @param n Liczba określająca wymiar macierzy A(NxN)
     * @param a1 Tabela, do której zostaną zapisane dane
     */
    public void Coordinates(int n, JTable a1) {
        modelA1 = (DefaultTableModel) a1.getModel();
        // lista przechowuje elementy: W1 W2 W3 Im Ia2 Ia1(obiekty klasy RowArray) zliczane z 1 gniazda pętli 
        listNestModified = new ArrayList<>();
        //listSecondNestModified = new ArrayList<>();
        //Zlicza ile razy wykonała sie I pętla for
        int nr = 0;
        // Pierwsze zmodyfikowane gniazdo pętli
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k < i + 1; k++) {
                    //matrixL[j][i] = matrixA[j][i] / matrixA[i][i];
                    nr++;
                    int w1 = i + 1;
                    int w2 = j + 1;
                    int w3 = k + 1;
                    listNestModified.add(new RowArray(nr, w1, w2, w3));
                }
            }
        }
        //Zlicza ile razy wykonała sie I pętla for
        int it = 6;

        //Drugie zmodyfikowane gniazdo pętli
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < n; k++) {
                    //matrixU[j][k] = matrixA[j][k] - (matrixL[j][i] * matrixA[i][k]);
                    it++;
                    int w1 = i + 1;
                    int w2 = j + 1;
                    int w3 = k + 1;
                    listNestModified.add(new RowArray(it, w1, w2, w3));
                }
            }
        }

        for (int i = 0; i < listNestModified.size(); i++) {
            int id = listNestModified.get(i).getId();
            int w1 = listNestModified.get(i).getW1();
            int w2 = listNestModified.get(i).getW2();
            int w3 = listNestModified.get(i).getW3();
            Pairs im = listNestModified.get(i).getIm();
            Pairs ia2 = listNestModified.get(i).getIa2();
            Pairs ia1 = listNestModified.get(i).getIa1();
            //Pairs ia22 = null;
            //Pairs ia11 = null;
            Object[] data = {id, w1, w2, w3, im, ia2, ia1};
            modelA1.addRow(data);
        }

    }

    /**
     * Metoda zwraca listę par ID wierzchołków (ID pobierane z obiektu klasy
     *
     * @RowArray), między którymi są połączenia oraz informację o kierunku(lewo,
     * prawo, góra, skos)
     * @param cor Tabela zawierające liste wierzchołków i łuków
     * @param con Tabela, wktórej zapisywane są pray połączeń i ich kierunek
     */
    public void Connections(JTable cor, JTable con) {
        modelC = (DefaultTableModel) con.getModel();
        listOfConnections = new ArrayList<>();
        ArrayList<RowArray> listNests = new ArrayList<>();
        int id;
        int w1;
        int w2;
        int w3;

        for (int i = 0; i < cor.getRowCount(); i++) {
            id = (int) cor.getValueAt(i, 0);
            w1 = (int) cor.getValueAt(i, 1);
            w2 = (int) cor.getValueAt(i, 2);
            w3 = (int) cor.getValueAt(i, 3);
            listNests.add(new RowArray(id, w1, w2, w3));
            System.out.println(listNests.get(i));
        }

        for (int i = 0; i < listNests.size(); i++) {
            for (int j = 1; j < listNests.size(); j++) {
                if (i != j) {
                    RowArray rowA = listNests.get(i);
                    RowArray rowB = listNests.get(j);

                    //lewo if A.IM == B.IM && A.W3 < B.W3 && A.W1 == B.W1 && A.W2 == B.W2
                    if (rowA.getW1() == rowB.getW1() && rowA.getW2() == rowB.getW2()&&rowA.getIm().equals(rowB.getIm())
                            && rowA.getW3() - rowB.getW3() == -1) {
                        listOfConnections.add(new Connection(rowA.getId(), rowB.getId(), "LEFT"));
                    }//prawo if A.Ia2 = B.Ia2 && A.W2 < B.W2 && A.W1 == B.W1 A.W3 == B.W3
                    else if (rowA.getW1() == rowB.getW1() && rowA.getW3() == rowB.getW3() && rowA.getIa2().equals(rowB.getIa2())
                            && rowA.getW2() - rowB.getW2() == -1) {
                        listOfConnections.add(new Connection(rowA.getId(), rowB.getId(), "RIGHT"));
                    }//góra if A.W2 == B.W2  &&  A.W3 == B.W3  &&   A.Ia1 == B.Ia1  &&  A.W1 < B.W1
                    else if (rowA.getW2() == rowB.getW2() && rowA.getW3() == rowB.getW3()
                            && rowA.getIa1().equals(rowB.getIa1()) && rowA.getW1() - rowB.getW1() == -1) {
                        listOfConnections.add(new Connection(rowA.getId(), rowB.getId(), "UP"));
                    }//skos if A.Ia1 == B.Ia2 && A.W3 == B.W3
                    else if (rowA.getW3() == rowB.getW3() && rowA.getIa1().equals(rowB.getIa2())
                            && rowA.getW1() - rowB.getW1() == -1
                            && rowA.getW2() - rowB.getW2() == -1) {
                        listOfConnections.add(new Connection(rowA.getId(), rowB.getId(), "CROSS"));
                    }
                }
            }
        }
        for (int i = 0; i < listOfConnections.size(); i++) {
            int id1 = listOfConnections.get(i).getFirstVerticeID();
            int id2 = listOfConnections.get(i).getSecondVerticeID();
            String direction = listOfConnections.get(i).getDirectionOfConnection();
            Object[] data = {id1, id2, direction};
            modelC.addRow(data);
        }
    }

    public void sort(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.setSortsOnUpdates(true);
    }

    //Getters
    public ArrayList<RowArray> getListFirstNestModified() {
        return listNestModified;
    }

    public ArrayList<Connection> getListOfConnections() {
        return listOfConnections;
    }

    public DefaultTableModel getModelA1() {
        return modelA1;
    }

    public DefaultTableModel getModelC() {
        return modelC;
    }
}
