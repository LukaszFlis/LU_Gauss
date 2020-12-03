/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lu_gauss;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 *
 * @author Luk
 */
public class Main extends javax.swing.JFrame {
    double[][] matrixA;
    DefaultTableModel modelA;
    DefaultTableModel modelL;
    DefaultTableModel modelU;
    /**
     *
     */
    public Main() {
        initComponents();
        modelA = (DefaultTableModel) tableA.getModel();
        modelL = (DefaultTableModel) tableL.getModel();
        modelU = (DefaultTableModel) tableU.getModel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        panelWejsciowe = new JPanel();
        panelParametry = new JPanel();
        jLabel1 = new JLabel();
        spinnerN = new JSpinner();
        buttonPokaz = new JButton();
        panelMacierz = new JPanel();
        panelTabelaA = new JPanel();
        jScrollPane1 = new JScrollPane();
        tableA = new JTable();
        panelTabelaL = new JPanel();
        jScrollPane2 = new JScrollPane();
        tableL = new JTable();
        panelTabelaU = new JPanel();
        jScrollPane3 = new JScrollPane();
        tableU = new JTable();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        buttonOblicz = new JButton();
        panelWyjsciowe = new JPanel();
        panelObliczenia = new JPanel();
        panelHelp = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ResourceBundle bundle = ResourceBundle.getBundle("lu_gauss/Bundle"); // NOI18N
        setTitle(bundle.getString("Main.title")); // NOI18N
        setLocationByPlatform(true);
        setName("MainFrame"); // NOI18N

        jTabbedPane1.setFont(new Font("Times New Roman", 0, 14)); // NOI18N

        panelParametry.setBackground(new Color(204, 204, 255));
        panelParametry.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), bundle.getString("Main.panelParametry.border.title"), TitledBorder.LEFT, TitledBorder.TOP, new Font("Times New Roman", 1, 14), new Color(51, 0, 255))); // NOI18N

        jLabel1.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText(bundle.getString("Main.jLabel1.text")); // NOI18N

        spinnerN.setModel(new SpinnerNumberModel(2, 2, 50, 1));

        buttonPokaz.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        buttonPokaz.setText(bundle.getString("Main.buttonPokaz.text")); // NOI18N
        buttonPokaz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonPokazActionPerformed(evt);
            }
        });

        GroupLayout panelParametryLayout = new GroupLayout(panelParametry);
        panelParametry.setLayout(panelParametryLayout);
        panelParametryLayout.setHorizontalGroup(panelParametryLayout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, panelParametryLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(71, 71, 71)
                .add(spinnerN, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .add(57, 57, 57)
                .add(buttonPokaz, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelParametryLayout.setVerticalGroup(panelParametryLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelParametryLayout.createSequentialGroup()
                .add(panelParametryLayout.createParallelGroup(GroupLayout.BASELINE)
                    .add(spinnerN, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .add(buttonPokaz))
                .add(0, 4, Short.MAX_VALUE))
        );

        panelMacierz.setBackground(new Color(204, 204, 255));
        panelMacierz.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), bundle.getString("Main.panelMacierz.border.title"), TitledBorder.LEFT, TitledBorder.TOP, new Font("Times New Roman", 1, 14), new Color(255, 0, 102))); // NOI18N
        panelMacierz.setMinimumSize(new Dimension(1280, 600));

        panelTabelaA.setBackground(new Color(255, 255, 255));
        panelTabelaA.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelTabelaA.setMinimumSize(new Dimension(400, 400));
        panelTabelaA.setPreferredSize(new Dimension(400, 400));

        jScrollPane1.setBackground(new Color(255, 255, 255));

        tableA.setFont(new Font("Times New Roman", 0, 10)); // NOI18N
        tableA.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableA.setName("macierz A"); // NOI18N
        tableA.setRowSelectionAllowed(false);
        tableA.getTableHeader().setResizingAllowed(false);
        tableA.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableA);
        if (tableA.getColumnModel().getColumnCount() > 0) {
            tableA.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.macierz A.columnModel.title0")); // NOI18N
        }

        GroupLayout panelTabelaALayout = new GroupLayout(panelTabelaA);
        panelTabelaA.setLayout(panelTabelaALayout);
        panelTabelaALayout.setHorizontalGroup(panelTabelaALayout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, jScrollPane1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        panelTabelaALayout.setVerticalGroup(panelTabelaALayout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, panelTabelaALayout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
        );

        panelTabelaL.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelTabelaL.setMinimumSize(new Dimension(400, 400));

        tableL.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableL.getTableHeader().setResizingAllowed(false);
        tableL.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableL);
        if (tableL.getColumnModel().getColumnCount() > 0) {
            tableL.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableL.columnModel.title0")); // NOI18N
        }

        GroupLayout panelTabelaLLayout = new GroupLayout(panelTabelaL);
        panelTabelaL.setLayout(panelTabelaLLayout);
        panelTabelaLLayout.setHorizontalGroup(panelTabelaLLayout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, jScrollPane2, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        panelTabelaLLayout.setVerticalGroup(panelTabelaLLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelTabelaLLayout.createSequentialGroup()
                .add(jScrollPane2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        panelTabelaU.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelTabelaU.setMinimumSize(new Dimension(400, 400));
        panelTabelaU.setPreferredSize(new Dimension(400, 400));

        tableU.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        jScrollPane3.setViewportView(tableU);
        if (tableU.getColumnModel().getColumnCount() > 0) {
            tableU.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableU.columnModel.title0")); // NOI18N
        }

        GroupLayout panelTabelaULayout = new GroupLayout(panelTabelaU);
        panelTabelaU.setLayout(panelTabelaULayout);
        panelTabelaULayout.setHorizontalGroup(panelTabelaULayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane3, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        panelTabelaULayout.setVerticalGroup(panelTabelaULayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelTabelaULayout.createSequentialGroup()
                .add(jScrollPane3, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText(bundle.getString("Main.jLabel3.text")); // NOI18N

        jLabel4.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText(bundle.getString("Main.jLabel4.text")); // NOI18N

        jLabel5.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText(bundle.getString("Main.jLabel5.text")); // NOI18N

        jLabel2.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText(bundle.getString("Main.jLabel2.text")); // NOI18N

        buttonOblicz.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        buttonOblicz.setText(bundle.getString("Main.buttonOblicz.text")); // NOI18N
        buttonOblicz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonObliczActionPerformed(evt);
            }
        });

        GroupLayout panelMacierzLayout = new GroupLayout(panelMacierz);
        panelMacierz.setLayout(panelMacierzLayout);
        panelMacierzLayout.setHorizontalGroup(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelMacierzLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.TRAILING)
                    .add(panelMacierzLayout.createSequentialGroup()
                        .add(panelMacierzLayout.createParallelGroup(GroupLayout.TRAILING)
                            .add(jLabel3)
                            .add(panelTabelaA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .add(6, 6, 6)
                        .add(panelMacierzLayout.createParallelGroup(GroupLayout.TRAILING)
                            .add(panelTabelaL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(panelMacierzLayout.createParallelGroup(GroupLayout.TRAILING)
                            .add(panelTabelaU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5)))
                    .add(panelMacierzLayout.createSequentialGroup()
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(buttonOblicz, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMacierzLayout.setVerticalGroup(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelMacierzLayout.createSequentialGroup()
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5))
                .add(9, 9, 9)
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING, false)
                    .add(panelTabelaL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelTabelaU, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .add(panelTabelaA, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.UNRELATED)
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(buttonOblicz))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout panelWejscioweLayout = new GroupLayout(panelWejsciowe);
        panelWejsciowe.setLayout(panelWejscioweLayout);
        panelWejscioweLayout.setHorizontalGroup(panelWejscioweLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelWejscioweLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelWejscioweLayout.createParallelGroup(GroupLayout.LEADING, false)
                    .add(panelMacierz, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(panelParametry, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelWejscioweLayout.setVerticalGroup(panelWejscioweLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelWejscioweLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelParametry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.RELATED)
                .add(panelMacierz, GroupLayout.PREFERRED_SIZE, 503, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(bundle.getString("Main.panelWejsciowe.TabConstraints.tabTitle"), panelWejsciowe); // NOI18N

        GroupLayout panelWyjscioweLayout = new GroupLayout(panelWyjsciowe);
        panelWyjsciowe.setLayout(panelWyjscioweLayout);
        panelWyjscioweLayout.setHorizontalGroup(panelWyjscioweLayout.createParallelGroup(GroupLayout.LEADING)
            .add(0, 1264, Short.MAX_VALUE)
        );
        panelWyjscioweLayout.setVerticalGroup(panelWyjscioweLayout.createParallelGroup(GroupLayout.LEADING)
            .add(0, 581, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(bundle.getString("Main.panelWyjsciowe.TabConstraints.tabTitle"), panelWyjsciowe); // NOI18N

        GroupLayout panelObliczeniaLayout = new GroupLayout(panelObliczenia);
        panelObliczenia.setLayout(panelObliczeniaLayout);
        panelObliczeniaLayout.setHorizontalGroup(panelObliczeniaLayout.createParallelGroup(GroupLayout.LEADING)
            .add(0, 1264, Short.MAX_VALUE)
        );
        panelObliczeniaLayout.setVerticalGroup(panelObliczeniaLayout.createParallelGroup(GroupLayout.LEADING)
            .add(0, 581, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(bundle.getString("Main.panelObliczenia.TabConstraints.tabTitle"), panelObliczenia); // NOI18N

        GroupLayout panelHelpLayout = new GroupLayout(panelHelp);
        panelHelp.setLayout(panelHelpLayout);
        panelHelpLayout.setHorizontalGroup(panelHelpLayout.createParallelGroup(GroupLayout.LEADING)
            .add(0, 1264, Short.MAX_VALUE)
        );
        panelHelpLayout.setVerticalGroup(panelHelpLayout.createParallelGroup(GroupLayout.LEADING)
            .add(0, 581, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(bundle.getString("Main.panelHelp.TabConstraints.tabTitle"), panelHelp); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, jTabbedPane1)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
                .add(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPokazActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonPokazActionPerformed
        SecureRandom random = new SecureRandom();
        int n = (int) spinnerN.getValue();
        this.matrixA = new double[n][n];
        
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++){
                matrixA[i][j] = random.nextInt(10);
            }
        }
        modelA.setRowCount(n);
        modelA.setColumnCount(n + 1);
        
        for (int i = 1; i <= n; i++) {
            tableA.getColumnModel().getColumn(i).setHeaderValue(i);
        }
        
        for (int i = 0; i < modelA.getRowCount(); i++) {
            modelA.setValueAt(i + 1, i, 0);
        }
        
        for (int i = 0; i < modelA.getRowCount(); i++) {
            for (int j = 1; j < modelA.getColumnCount(); j++) {
                modelA.setValueAt(matrixA[i][j-1], i, j);
            }
        }
        tableA.setModel(modelA);
    }//GEN-LAST:event_buttonPokazActionPerformed

    private void buttonObliczActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonObliczActionPerformed
        
        int n = (int) spinnerN.getValue();
        double[][] matrixL = new double[n][n];
        double[][] matrixU = new double[n][n];
        
        //zerowanie macierzyL i ustawienie '1' na głownej przekątnej
        for(int i = 0; i < matrixL.length; i++) {
            for(int j = 0; j < matrixL.length; j++) {
                if(i == j) {
                    matrixL[i][j] = 1;
                } else { matrixL[i][j] = 0; }
            }
        }
        
        //zerowanie macierzy U
        for(int i = 0; i < matrixU.length; i++) {
            for(int j = 0; j < matrixU.length; j++) {
                matrixL[i][j] = 0;
            }
        }
        
        //rozkład macierzyA na L i U
        //
        for(int i = 1; i < n -1; i++) {
            for(int j = i+1; j < n; j++) {
               if ( matrixA[i][i] != 0 ) {
                   matrixL[j][i] =  matrixA[j][i]/matrixA[i][i];
               } else { matrixL[j][i] = 0; }
            }   
            for(int j = i + 1; j < n; j++){
                for (int k = i + 1; k < n; k++) {
                    matrixU[j][k] = matrixA[j][k] - (matrixL[j][i] * matrixA[i][k]);
                }
            }
        }
        
        /*for (double[] matrixA1 : matrixA) {
            for (int j = 0; j < matrixA.length; j++) {
                System.out.println(matrixA1[j] + ", ");
            }
        }*/
        
        //przypisanie wartości do macierzy U
        /*for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i <= j) {
                    matrixU[i][j] = matrixA[i][j];
                } else { matrixU[i][j] = 0;}
            }
        }*/
        //utworzenie kolumn i wierszy tabeli L
        modelL.setRowCount(n);
        modelL.setColumnCount(n + 1);
        
        //ustawienie tytułu kolumn 1 - n tabeli L
        for (int i = 1; i <= n; i++) {
            tableL.getColumnModel().getColumn(i).setHeaderValue(i);
        }
        
        //ustawienie wartości wierszy w kolumnie 0 tabeli L
        for (int i = 0; i < modelL.getRowCount(); i++) {
            modelL.setValueAt(i + 1, i, 0);
        }
        
        //ustawienie wartości wierszy w kolumnach 1 - n tabeli L
        //wartości pobierane są z macierzy L
        for (int i = 0; i < modelL.getRowCount(); i++) {
            for (int j = 1; j < modelL.getColumnCount(); j++) {
                modelL.setValueAt(matrixL[i][j-1], i, j);
            }
        }
        
        //przypisanie nowego modelu dla tabeli L
        tableL.setModel(modelL);
        
        //utworzenie kolumn i wierszy tabeli U
        modelU.setRowCount(n);
        modelU.setColumnCount(n + 1);
        
        //ustawienie tytułu kolumn 1 - n tabeli U
        for (int i = 1; i <= n; i++) {
            tableU.getColumnModel().getColumn(i).setHeaderValue(i);
        }
        
        //ustawienie wartości wierszy w kolumnie 0 tabeli U
        for (int i = 0; i < modelU.getRowCount(); i++) {
            modelU.setValueAt(i + 1, i, 0);
        }
        
        //ustawienie wartości wierszy w kolumnach 1 - n tabeli U
        //wartości pobierane są z macierzy U
        for (int i = 0; i < modelU.getRowCount(); i++) {
            for (int j = 1; j < modelU.getColumnCount(); j++) {
                modelU.setValueAt(matrixU[i][j-1], i, j);
            }
        }
        
        //przypisanie nowego modelu dla tabeli U
        tableU.setModel(modelU);
        
 
    }//GEN-LAST:event_buttonObliczActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buttonOblicz;
    private JButton buttonPokaz;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JPanel panelHelp;
    private JPanel panelMacierz;
    private JPanel panelObliczenia;
    private JPanel panelParametry;
    private JPanel panelTabelaA;
    private JPanel panelTabelaL;
    private JPanel panelTabelaU;
    private JPanel panelWejsciowe;
    private JPanel panelWyjsciowe;
    private JSpinner spinnerN;
    private JTable tableA;
    private JTable tableL;
    private JTable tableU;
    // End of variables declaration//GEN-END:variables
}
