/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lu_gauss;

import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luk
 */
public class LU_Decomposition extends JFrame{
    private double[][] matrixA;
    private DefaultTableModel modelA;
    private DefaultTableModel modelA1;
    private DefaultTableModel modelL;
    private DefaultTableModel modelU;
    
    LU_Decomposition() {
    }

    /**
     * Tworzy nową macierz A
     * Przypisuje do nie wartosci losowe z określonego zakresu,
     * Zabezpieczenie operacji dzielenia przez 0
     * Jeżeli na głownej przekątnej A występuje 0 dodaje 1
     * Pobiera DefaultTableModel z tabeli A
     * Modyfikuje modelA
     * @param tableA tabela w GUI, wyświetla wartosci wygenerowane w macierzy A
     * @param n rozmiar macierzy A(NxN)
     */
    public void createMatrxA(JTable tableA, int n ) {
        
        SecureRandom random = new SecureRandom();
        modelA = (DefaultTableModel) tableA.getModel(); 
        matrixA = new double[n][n];
        
        //przypisanie do matrixA losowych wartości z zakresu 0-9
        for (int i =0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                matrixA[i][j] = random.nextInt(9);
                if (matrixA[i][i] == 0) {
                    matrixA[i][i] += 1;
                }
            }
        }
        //ustawienieliczby wierszy i kolumn w tabeli A
        setModelA(n, n+1);
        
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
                modelA.setValueAt(matrixA[i][j-1], i, j);
            }
        }
    }
    
    /**
     * Define new matrix L and U
     * Setup lower trianuglar matrix L
     * Setup upper triangular matrix U
     * Make the decomposition of matrix A
     * Define DefaultTableModel for modelL
     * Define DefaultTableModel for modelU
     * 
     * @param tableL tabel in GUI, wich show matrix L
     * @param tableU tabel in GUI that show matrix U 
     * @param n size of square matrix
     * @param czas label in gui, which displays the execution time of the algorithm 
     */
    public void makeDecomposition (JTable tableL, JTable tableU, int n, JLabel czas) {
        modelL = (DefaultTableModel) tableL.getModel();
        modelU = (DefaultTableModel) tableU.getModel();
        
        double[][] matrixL = new double[n][n];
        double[][] matrixU = new double[n][n];
        //zerowanie macierzyL i ustawienie '1' na głownej przekątnej
        for(int i = 0; i < matrixL.length; i++) {
            for(int j = 0; j < matrixL.length; j++) {
                if(i == j) matrixL[i][j] = 1;
                else matrixL[i][j] = 0;
            }
        }
        
        //zerowanie macierzy U
        for(int i = 0; i < matrixU.length; i++) {
            for(int j = 0; j < matrixU.length; j++) {
                matrixL[i][j] = 0;
            }
        }
        
        long start = System.nanoTime();
        
        //rozkład macierzy A = LU
        for(int i = 0; i < n ; i++) {
            for(int j = i; j < n; j++) {
                   matrixL[j][i] =  matrixA[j][i]/matrixA[i][i];
            }   
            for(int j = i + 1; j < n; j++){
                for (int k = i + 1 ; k < n; k++) {
                    matrixA[j][k] = matrixA[j][k] - (matrixL[j][i] * matrixA[i][k]);
                }
            }            
        }
        long time = System.nanoTime()- start;
        czas.setText("Czas wykonania algorytmu w nanosekundach: " + String.valueOf(time));
        
        //przypisanie wartości do macierzy U
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i <= j) {
                    matrixU[i][j] = matrixA[i][j];
                } else { matrixU[i][j] = 0;}
            }
        }
        
        
        //ustawienie liczby wierszy i  kolumn w tabeli L
        setModelL(n, n+1);
        
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
                modelL.setValueAt(matrixL[i][j-1], i, j);
            }
        }
        
        //ustawienie liczby wierszy i kolumn w tabeli U
        setModelU(n, n+1);
        
        //ustawienie tytułu kolumn 1 - n tabeli U
        for (int i = 1; i <= n; i++) {
            tableU.getColumnModel().getColumn(i).setHeaderValue(i);
        }
        
        //ustawienie wartości wierszy w kolumnie 0 tabeli U
        for (int i = 0; i < modelU.getRowCount(); i++) {
            modelU.setValueAt(i + 1, i, 0);
        }
        
        //ustawienie wartości wierszy w kolumnach 1 - n tabeli U
        //wartości pobierane są z matrixU
        for (int i = 0; i < modelU.getRowCount(); i++) {
            for (int j = 1; j < modelU.getColumnCount(); j++) {
                modelU.setValueAt(matrixU[i][j-1], i, j);
            }
        }
    }

    public void verify(int n, double[][] matrixL, double[][] matrixU, JTable tableA1) {
        
        modelA1 = (DefaultTableModel)tableA1.getModel();
        double[][] matrixA1 = new double[n][n];
        
        //werfikacja matrixA == matrixA1
        //matrixA1 = matrxL * matrixU
        double sum =0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for (int k = 0; k<n; k++){
                    sum+= matrixL[i][k] * matrixU[k][j];
                }
                matrixA1[i][j] = sum;
                sum = 0;
            }
        }
        
        
        
        //ustawienie liczby wierszy i  kolumn w tabeli A1
        setModelA1(n, n+1);
        
        //ustawienie tytułu kolumn od 1 do n w tabeli A1
        for (int i = 1; i <= n; i++) {
            tableA1.getColumnModel().getColumn(i).setHeaderValue(i);
        }
        
        //ustawienie wartości wierszy w kolumnie 0 tabeli A1
        for (int i = 0; i < modelA1.getRowCount(); i++) {
            modelA1.setValueAt(i + 1, i, 0);
        }
        
        //ustawienie wartości wierszy w kolumnach 1 do n tabeli A1
        //wartości pobierane są z matrixA1
        for (int i = 0; i < modelA1.getRowCount(); i++) {
            for (int j = 1; j < modelA1.getColumnCount(); j++) {
                modelA1.setValueAt(matrixA1[i][j-1], i, j);
            }
        }
    }
    
    public double[][] getMatrixA() {
        return matrixA;
    }

    /**
     *
     * @param matrixA new array
     */
    public void setMatrixA(double[][] matrixA) {
        this.matrixA = matrixA;
    }

    /**
     * Set the value of selected item
     * @param r row
     * @param c column
     * @param value
     */
    public void setMatrixA (int r, int c, double value) {
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
    public void setModelU(int row, int col) {
        this.modelU.setRowCount(row);
        this.modelU.setColumnCount(col);
    }

    public DefaultTableModel getModelA1() {
        return modelA1;
    }
    public void setModelA1(int row, int col) {
        this.modelA1.setRowCount(row);
        this.modelA1.setColumnCount(col);
    }
    
}
