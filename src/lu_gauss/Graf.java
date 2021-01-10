package lu_gauss;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luk
 */
public class Graf {

    LU_Decomposition handler;
    DefaultTableModel modelA1;
    DefaultTableModel modelA2;
    

    public Graf() {
        this.handler = new LU_Decomposition();
    }

    public void Dependencies(int n, JTable a1) {
        modelA1 = (DefaultTableModel) a1.getModel();

        double[][] matrixA = handler.getMatrixA();
        double[][] matrixL = handler.getMatrixL();
        double[][] matrixU = handler.getMatrixU();
        
        //List <Integer> cordinates = List.of();

        //rozkład LU
        /*for (int i = 0; i < n-2; i++) {
            for (int j =i+1 ; j < n; j++) {
                matrixL[j][i] = matrixA[j][i]/matrixA[i][i]; 
                for (int k = i+1; k < n; k++) {      
                    matrixU[j][k] = matrixA[j][k] - (matrixL[j][i] * matrixA[i][k]);
                }
            }
        }*/
        // Pierwsze zmodyfikowane gniazdo pętli
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k < i; k++) {
                    matrixL[j][i] = matrixA[j][i] / matrixA[i][i];
                  
                }
            }
        }
    }
}
