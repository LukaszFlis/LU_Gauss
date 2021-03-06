package lu_gauss;

import java.security.SecureRandom;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luk
 */
public class LU_Decomposition {

    private double[][] matrixA;
    private double[][] matrixA1;
    private double[][] matrixA2;
    private double[][] matrixL;
    private double[][] matrixU;

    private DefaultTableModel modelA;
    private DefaultTableModel modelA1;
    private DefaultTableModel modelA2;
    private DefaultTableModel modelL;
    private DefaultTableModel modelU;

    LU_Decomposition() {
    }

    /**
     * Tworzy nową macierz A, Przypisuje do niej wartosci losowe z określonego
     * zakresu, Jeżeli na głownej przekątnej A występuje 0 dodaje 1 Pobiera
     * DefaultTableModel z tabeli A Modyfikuje modelA
     *
     * @param tableA tabela w GUI, wyświetla wartosci wygenerowane w macierzy A
     * @param n rozmiar macierzy A(NxN)
     */
    public void createMatrixA(JTable tableA, int n) {
        SecureRandom random = new SecureRandom();
        modelA = (DefaultTableModel) tableA.getModel();
        matrixA = new double[n][n];

        //przypisanie do matrixA losowych wartości z zakresu 0-9
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                matrixA[i][j] = random.nextInt(9);
                if (matrixA[i][i] == 0) {
                    matrixA[i][i] += 1;
                }
            }
        }
        //ustawienieliczby wierszy i kolumn w tabeli A
        setModelA(n, n + 1);

        //ustawienie tytułu kolumn od 1 do n w tabeli A
        for (int i = 1; i <= n; i++) {
            tableA.getColumnModel().getColumn(i).setHeaderValue(i);
        }

        //ustawienie wartości wierszy w kolumnie 0 tabeli A
        for (int i = 0; i < modelA.getRowCount(); i++) {
            modelA.setValueAt(i + 1, i, 0);
        }

        //ustawienie wartości wierszy w kolumnach 1 do n tabeli A
        //wartości pobierane są z matrixA
        for (int i = 0; i < modelA.getRowCount(); i++) {
            for (int j = 1; j < modelA.getColumnCount(); j++) {
                modelA.setValueAt(matrixA[i][j - 1], i, j);
            }
        }
    }

    /**
     * Define new matrix L and U Setup lower trianuglar matrix L Setup upper
     * triangular matrix U Make the decomposition of matrix A Define
     * DefaultTableModel for modelL Define DefaultTableModel for modelU
     *
     * @param tableL tabel in GUI, wich show matrix L
     * @param tableU tabel in GUI that show matrix U
     * @param n size of square matrix
     * @param czas label in gui, which displays the execution time of the
     * algorithm
     */
    public void makeDecomposition(JTable tableL, JTable tableU, int n, JLabel czas) {
        modelL = (DefaultTableModel) tableL.getModel();
        modelU = (DefaultTableModel) tableU.getModel();
        matrixL = new double[n][n];
        matrixU = new double[n][n];

        //pomiar czasu
        long start = System.nanoTime();

        // Rozkład macierzy A = LU (algorytm z wykładu)
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1 ; j < n ; j++) {
                matrixL[j][i] = matrixA[j][i] / matrixA[i][i];
            }
            for (int j = i+1; j < n; j++) {
                for (int k = i + 1; k < n; k++) {
                    matrixA[j][k] -= matrixL[j][i] * matrixA[i][k];
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    matrixU[i][j] = matrixA[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    matrixL[i][i] = 1;
            }
        }
        long time = System.nanoTime() - start;
        czas.setText("Czas wykonania algorytmu w nanosekundach: " + String.valueOf(time));
        //ustawienie liczby wierszy i  kolumn w tabeli L
        setModelL(n, n + 1);

        //ustawienie tytułu kolumn od 1 do n w tabeli L
        for (int i = 1; i <= n; i++) {
            tableL.getColumnModel().getColumn(i).setHeaderValue(i);
        }

        //ustawienie wartości wierszy w kolumnie 0 tabeli L
        for (int i = 0; i < modelL.getRowCount(); i++) {
            modelL.setValueAt(i + 1, i, 0);
        }

        //ustawienie wartości wierszy w kolumnach 1 do n tabeli L
        //wartości pobierane są z matrixL
        for (int i = 0; i < modelL.getRowCount(); i++) {
            for (int j = 1; j < modelL.getColumnCount(); j++) {
                modelL.setValueAt(matrixL[i][j - 1], i, j);
            }
        }

        //ustawienie liczby wierszy i kolumn w tabeli U
        setModeLU(n, n + 1);

        //ustawienie tytułu kolumn 1 - n tabeli U
        for (int j = 1; j <= n; j++) {
            tableU.getColumnModel().getColumn(j).setHeaderValue(j);
        }

        //ustawienie wartości wierszy w kolumnie 0 tabeli U
        for (int j = 0; j < modelU.getRowCount(); j++) {
            modelU.setValueAt(j + 1, j, 0);
        }

        //ustawienie wartości wierszy w kolumnach 1 - n tabeli U
        //wartości pobierane są z matrixU
        for (int i = 0; i < modelU.getRowCount(); i++) {
            for (int j = 1; j < modelU.getColumnCount(); j++) {
                modelU.setValueAt(matrixU[i][j - 1], i, j);
            }
        }
    }

    public void verify(int n, JTable aBis, JTable a1, JTable a2, JLabel sumaEl) {

        modelA = (DefaultTableModel) aBis.getModel();

        //ustawienie liczby wierszy i  kolumn w tabeli ABis
        setModelA(n, n + 1);

        //ustawienie tytułu kolumn od 1 do n w tabeli ABis
        for (int i = 1; i <= n; i++) {
            aBis.getColumnModel().getColumn(i).setHeaderValue(i);
        }

        //ustawienie wartości wierszy w kolumnie 0 tabeli ABis
        for (int i = 0; i < modelA.getRowCount(); i++) {
            modelA.setValueAt(i + 1, i, 0);
        }

        //ustawienie wartości wierszy w kolumnach 1 do n tabeli ABis
        //wartości pobierane są z matrixA
        for (int i = 0; i < modelA.getRowCount(); i++) {
            for (int j = 1; j < modelA.getColumnCount(); j++) {
                modelA.setValueAt(matrixA[i][j - 1], i, j);
            }
        }
        modelA1 = (DefaultTableModel) a1.getModel();
        modelA2 = (DefaultTableModel) a2.getModel();

        matrixA1 = new double[n][n];
        matrixA2 = new double[n][n];

        //werfikacja matrixA == matrixA1
        //matrixA1 = matrixL * matrixU
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum += matrixL[i][k] * matrixU[k][j];
                }
                matrixA1[i][j] = sum;
                sum = 0;
            }
        }

        //ustawienie liczby wierszy i  kolumn w tabeli A1
        setModelA1(n, n + 1);

        //ustawienie tytułu kolumn od 1 do n w tabeli A1
        for (int i = 1; i <= n; i++) {
            a1.getColumnModel().getColumn(i).setHeaderValue(i);
        }

        //ustawienie wartości wierszy w kolumnie 0 tabeli A1
        for (int i = 0; i < modelA1.getRowCount(); i++) {
            modelA1.setValueAt(i + 1, i, 0);
        }

        //ustawienie wartości wierszy w kolumnach 1 do n tabeli A1
        //wartości pobierane są z matrixA1
        for (int i = 0; i < modelA1.getRowCount(); i++) {
            for (int j = 1; j < modelA1.getColumnCount(); j++) {
                modelA1.setValueAt(matrixA1[i][j - 1], i, j);
            }
        }
        //dodatkowa weryfikacja poprawności algorytmu
        // A2 = A1 - A
        //Jeżeli suma elementów A2 = 0
        //Dekompozycja jest poprawna
        double suma = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA2[i][j] = matrixA1[i][j] - matrixA[i][j];
                suma += matrixA2[i][j];
            }
        }

        sumaEl.setText("Suma elementów macierzy A'' = " + String.valueOf(suma));

        //ustawienie liczby wierszy i  kolumn w tabeli A2
        setModelA2(n, n + 1);

        //ustawienie tytułu kolumn od 1 do n w tabeli A2
        for (int i = 1; i <= n; i++) {
            a2.getColumnModel().getColumn(i).setHeaderValue(i);
        }

        //ustawienie wartości wierszy w kolumnie 0 tabeli A2
        for (int i = 0; i < modelA2.getRowCount(); i++) {
            modelA2.setValueAt(i + 1, i, 0);
        }

        //ustawienie wartości wierszy w kolumnach 1 do n tabeli A2
        //wartości pobierane są z matrixA2
        for (int i = 0; i < modelA2.getRowCount(); i++) {
            for (int j = 1; j < modelA2.getColumnCount(); j++) {
                modelA2.setValueAt(matrixA2[i][j - 1], i, j);
            }
        }
    }

    public double[][] getMatrixA() {
        return matrixA;
    }

    public double[][] getMatrixL() {
        return matrixL;
    }

    public double[][] getMatrixU() {
        return matrixU;
    }

    /**
     * Set value in matrix A specified cell
     *
     * @param r row
     * @param c column
     * @param value
     */
    public void setMatrixA(int r, int c, double value) {
        this.matrixA[r][c] = value;
    }

    public DefaultTableModel getModelA() {
        return modelA;
    }

    /**
     *
     * @param row numebr of rows
     * @param col number of columns
     */
    public void setModelA(int row, int col) {
        this.modelA.setRowCount(row);
        this.modelA.setColumnCount(col);

    }

    public DefaultTableModel getModelA1() {
        return modelA1;
    }

    /**
     *
     * @param row number of rows
     * @param col number of columns
     */
    public void setModelA1(int row, int col) {
        this.modelA1.setRowCount(row);
        this.modelA1.setColumnCount(col);
    }

    public DefaultTableModel getModelA2() {
        return modelA2;
    }

    /**
     * Set rows and columns of DefaultTableModel
     *
     * @param row number of rows
     * @param col number of columns
     */
    public void setModelA2(int row, int col) {
        this.modelA2.setRowCount(row);
        this.modelA2.setColumnCount(col);
    }

    public DefaultTableModel getModelL() {
        return modelL;
    }

    /**
     *
     * @param row number of rows
     * @param col number of columns
     */
    public void setModelL(int row, int col) {
        this.modelL.setRowCount(row);
        this.modelL.setColumnCount(col);
    }

    public DefaultTableModel getModelU() {
        return modelU;
    }

    /**
     *
     * @param row number of rows
     * @param col number of columns
     */
    public void setModeLU(int row, int col) {
        this.modelU.setRowCount(row);
        this.modelU.setColumnCount(col);
    }
}
