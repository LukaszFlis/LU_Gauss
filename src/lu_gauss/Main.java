package lu_gauss;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
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

    // Uchwyt do pól i metod klasy LU_Decomposition
    LU_Decomposition lu;
    // Uchwyt do pól i metod klasy Graf
    Graf graf;

    /**
     *
     */
    public Main() {
        this.lu = new LU_Decomposition();
        this.graf = new Graf();
        initComponents();
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
        czas = new JLabel();
        buttonOblicz = new JButton();
        panellWeyfikacja = new JPanel();
        panelA1 = new JPanel();
        jScrollPane6 = new JScrollPane();
        tableA1 = new JTable();
        jLabel7 = new JLabel();
        jLabel6 = new JLabel();
        buttonVerification = new JButton();
        jLabel9 = new JLabel();
        labelSumEl = new JLabel();
        panelA = new JPanel();
        jScrollPane4 = new JScrollPane();
        tableABis = new JTable();
        panelA2 = new JPanel();
        jScrollPane5 = new JScrollPane();
        tableA2 = new JTable();
        panelTabelePomocnicze = new JPanel();
        jPanel2 = new JPanel();
        btnNests = new JButton();
        btnListConnections = new JButton();
        jPanel3 = new JPanel();
        jScrollPane7 = new JScrollPane();
        tableFirstNest = new JTable();
        jScrollPane8 = new JScrollPane();
        tableOfConnections = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ResourceBundle bundle = ResourceBundle.getBundle("lu_gauss/Bundle"); // NOI18N
        setTitle(bundle.getString("Main.title")); // NOI18N
        setLocationByPlatform(true);
        setName("MainFrame"); // NOI18N
        setResizable(false);

        jTabbedPane1.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new Dimension(1024, 768));

        panelWejsciowe.setPreferredSize(new Dimension(1020, 760));

        panelParametry.setBackground(new Color(204, 204, 255));
        panelParametry.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), bundle.getString("Main.panelParametry.border.title"), TitledBorder.LEFT, TitledBorder.TOP, new Font("Times New Roman", 1, 14), new Color(51, 0, 255))); // NOI18N
        panelParametry.setPreferredSize(new Dimension(1010, 100));

        jLabel1.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText(bundle.getString("Main.jLabel1.text")); // NOI18N

        spinnerN.setModel(new SpinnerNumberModel(2, 2, 100, 1));

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
            .add(panelParametryLayout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jLabel1)
                .add(49, 49, 49)
                .add(spinnerN, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.RELATED, 643, Short.MAX_VALUE)
                .add(buttonPokaz, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelParametryLayout.setVerticalGroup(panelParametryLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelParametryLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelParametryLayout.createParallelGroup(GroupLayout.BASELINE)
                    .add(jLabel1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .add(spinnerN, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .add(buttonPokaz))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMacierz.setBackground(new Color(204, 204, 255));
        panelMacierz.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), bundle.getString("Main.panelMacierz.border.title"), TitledBorder.LEFT, TitledBorder.TOP, new Font("Times New Roman", 1, 14), new Color(255, 0, 102))); // NOI18N
        panelMacierz.setMinimumSize(new Dimension(0, 0));
        panelMacierz.setPreferredSize(new Dimension(1010, 650));

        panelTabelaA.setBackground(new Color(255, 255, 255));
        panelTabelaA.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panelTabelaA.setMinimumSize(new Dimension(326, 326));
        panelTabelaA.setPreferredSize(new Dimension(326, 326));

        jScrollPane1.setBackground(new Color(255, 255, 255));

        tableA.setAutoCreateRowSorter(true);
        tableA.setFont(new Font("Times New Roman", 0, 10)); // NOI18N
        tableA.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableA.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableA.setFillsViewportHeight(true);
        tableA.setName("macierz A"); // NOI18N
        tableA.setRowSelectionAllowed(false);
        tableA.setShowGrid(true);
        tableA.getTableHeader().setResizingAllowed(false);
        tableA.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableA);
        if (tableA.getColumnModel().getColumnCount() > 0) {
            tableA.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.macierz A.columnModel.title0")); // NOI18N
        }

        GroupLayout panelTabelaALayout = new GroupLayout(panelTabelaA);
        panelTabelaA.setLayout(panelTabelaALayout);
        panelTabelaALayout.setHorizontalGroup(panelTabelaALayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane1, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );
        panelTabelaALayout.setVerticalGroup(panelTabelaALayout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, jScrollPane1, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        panelTabelaL.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panelTabelaL.setMinimumSize(new Dimension(0, 0));
        panelTabelaL.setPreferredSize(new Dimension(326, 326));

        jScrollPane2.setPreferredSize(new Dimension(320, 320));

        tableL.setAutoCreateRowSorter(true);
        tableL.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableL.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableL.setFillsViewportHeight(true);
        tableL.setShowGrid(true);
        tableL.getTableHeader().setResizingAllowed(false);
        tableL.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableL);
        if (tableL.getColumnModel().getColumnCount() > 0) {
            tableL.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableL.columnModel.title0")); // NOI18N
        }

        GroupLayout panelTabelaLLayout = new GroupLayout(panelTabelaL);
        panelTabelaL.setLayout(panelTabelaLLayout);
        panelTabelaLLayout.setHorizontalGroup(panelTabelaLLayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane2, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );
        panelTabelaLLayout.setVerticalGroup(panelTabelaLLayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane2, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        panelTabelaU.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panelTabelaU.setMinimumSize(new Dimension(0, 0));
        panelTabelaU.setPreferredSize(new Dimension(326, 326));

        tableU.setAutoCreateRowSorter(true);
        tableU.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableU.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableU.setFillsViewportHeight(true);
        tableU.setShowGrid(true);
        jScrollPane3.setViewportView(tableU);
        if (tableU.getColumnModel().getColumnCount() > 0) {
            tableU.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableU.columnModel.title0")); // NOI18N
        }

        GroupLayout panelTabelaULayout = new GroupLayout(panelTabelaU);
        panelTabelaU.setLayout(panelTabelaULayout);
        panelTabelaULayout.setHorizontalGroup(panelTabelaULayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane3, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );
        panelTabelaULayout.setVerticalGroup(panelTabelaULayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane3, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jLabel3.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText(bundle.getString("Main.jLabel3.text")); // NOI18N

        jLabel4.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText(bundle.getString("Main.jLabel4.text")); // NOI18N

        jLabel5.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText(bundle.getString("Main.jLabel5.text")); // NOI18N

        jLabel2.setFont(new Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText(bundle.getString("Main.jLabel2.text")); // NOI18N

        czas.setText(bundle.getString("Main.czas.text")); // NOI18N

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
                .add(3, 3, 3)
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.TRAILING)
                    .add(panelTabelaA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(8, 8, 8)
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.TRAILING, false)
                    .add(jLabel4)
                    .add(panelTabelaL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(GroupLayout.LEADING, panelMacierzLayout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(buttonOblicz)))
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING)
                    .add(panelMacierzLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(czas, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(panelMacierzLayout.createSequentialGroup()
                        .add(8, 8, 8)
                        .add(panelMacierzLayout.createParallelGroup(GroupLayout.TRAILING)
                            .add(jLabel5)
                            .add(panelTabelaU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(11, Short.MAX_VALUE))))
        );
        panelMacierzLayout.setVerticalGroup(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelMacierzLayout.createSequentialGroup()
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5))
                .addPreferredGap(LayoutStyle.RELATED)
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING)
                    .add(panelTabelaA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(panelTabelaL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(panelTabelaU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.RELATED)
                .add(panelMacierzLayout.createParallelGroup(GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(buttonOblicz)
                    .add(czas, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        GroupLayout panelWejscioweLayout = new GroupLayout(panelWejsciowe);
        panelWejsciowe.setLayout(panelWejscioweLayout);
        panelWejscioweLayout.setHorizontalGroup(panelWejscioweLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelWejscioweLayout.createSequentialGroup()
                .add(panelParametry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(GroupLayout.TRAILING, panelWejscioweLayout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(panelMacierz, GroupLayout.PREFERRED_SIZE, 1020, GroupLayout.PREFERRED_SIZE))
        );
        panelWejscioweLayout.setVerticalGroup(panelWejscioweLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelWejscioweLayout.createSequentialGroup()
                .add(panelParametry, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.UNRELATED)
                .add(panelMacierz, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("Main.panelWejsciowe.TabConstraints.tabTitle"), panelWejsciowe); // NOI18N

        panellWeyfikacja.setPreferredSize(new Dimension(1020, 768));

        panelA1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panelA1.setPreferredSize(new Dimension(330, 330));

        tableA1.setAutoCreateRowSorter(true);
        tableA1.setFont(new Font("Times New Roman", 0, 10)); // NOI18N
        tableA1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableA1.setToolTipText(bundle.getString("Main.A'.toolTipText")); // NOI18N
        tableA1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableA1.setFillsViewportHeight(true);
        tableA1.setName("A'"); // NOI18N
        tableA1.setShowGrid(true);
        tableA1.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tableA1);
        if (tableA1.getColumnModel().getColumnCount() > 0) {
            tableA1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.A'.columnModel.title0_1")); // NOI18N
        }

        GroupLayout panelA1Layout = new GroupLayout(panelA1);
        panelA1.setLayout(panelA1Layout);
        panelA1Layout.setHorizontalGroup(panelA1Layout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane6, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );
        panelA1Layout.setVerticalGroup(panelA1Layout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane6, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        jLabel7.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText(bundle.getString("Main.jLabel7.text")); // NOI18N

        jLabel6.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText(bundle.getString("Main.jLabel6.text")); // NOI18N

        buttonVerification.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        buttonVerification.setText(bundle.getString("Main.buttonVerification.text")); // NOI18N
        buttonVerification.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonVerificationActionPerformed(evt);
            }
        });

        jLabel9.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText(bundle.getString("Main.jLabel9.text")); // NOI18N

        labelSumEl.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        labelSumEl.setText(bundle.getString("Main.labelSumEl.text")); // NOI18N

        panelA.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panelA.setPreferredSize(new Dimension(330, 330));

        tableABis.setAutoCreateRowSorter(true);
        tableABis.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableABis.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableABis.setFillsViewportHeight(true);
        tableABis.setShowGrid(true);
        tableABis.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tableABis);
        if (tableABis.getColumnModel().getColumnCount() > 0) {
            tableABis.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableABis.columnModel.title0")); // NOI18N
        }

        GroupLayout panelALayout = new GroupLayout(panelA);
        panelA.setLayout(panelALayout);
        panelALayout.setHorizontalGroup(panelALayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane4, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );
        panelALayout.setVerticalGroup(panelALayout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane4, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        panelA2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panelA2.setPreferredSize(new Dimension(330, 330));

        tableA2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "(i,j)"
            }
        ));
        tableA2.setFillsViewportHeight(true);
        tableA2.setShowGrid(true);
        tableA2.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableA2);
        if (tableA2.getColumnModel().getColumnCount() > 0) {
            tableA2.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableA2.columnModel.title0")); // NOI18N
        }

        GroupLayout panelA2Layout = new GroupLayout(panelA2);
        panelA2.setLayout(panelA2Layout);
        panelA2Layout.setHorizontalGroup(panelA2Layout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane5, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );
        panelA2Layout.setVerticalGroup(panelA2Layout.createParallelGroup(GroupLayout.LEADING)
            .add(jScrollPane5, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        GroupLayout panellWeyfikacjaLayout = new GroupLayout(panellWeyfikacja);
        panellWeyfikacja.setLayout(panellWeyfikacjaLayout);
        panellWeyfikacjaLayout.setHorizontalGroup(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panellWeyfikacjaLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.TRAILING)
                    .add(jLabel6)
                    .add(panelA1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(buttonVerification))
                .add(3, 3, 3)
                .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.TRAILING)
                    .add(panelA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .add(3, 3, 3)
                .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.LEADING)
                    .add(labelSumEl, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                    .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.TRAILING)
                        .add(panelA2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(jLabel9)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panellWeyfikacjaLayout.setVerticalGroup(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panellWeyfikacjaLayout.createSequentialGroup()
                .add(24, 24, 24)
                .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.TRAILING)
                    .add(panellWeyfikacjaLayout.createSequentialGroup()
                        .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(jLabel6))
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.LEADING)
                            .add(panelA1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(panelA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .add(panellWeyfikacjaLayout.createSequentialGroup()
                        .add(jLabel9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(panelA2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.RELATED)
                .add(panellWeyfikacjaLayout.createParallelGroup(GroupLayout.BASELINE)
                    .add(buttonVerification)
                    .add(labelSumEl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(bundle.getString("Main.panellWeyfikacja.TabConstraints.tabTitle"), panellWeyfikacja); // NOI18N

        btnNests.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        btnNests.setText(bundle.getString("Main.btnNests.text")); // NOI18N
        btnNests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNestsActionPerformed(evt);
            }
        });

        btnListConnections.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        btnListConnections.setText(bundle.getString("Main.btnListConnections.text")); // NOI18N
        btnListConnections.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnListConnectionsActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(156, 156, 156)
                .add(btnNests)
                .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnListConnections, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                .add(189, 189, 189))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(GroupLayout.BASELINE)
                    .add(btnListConnections)
                    .add(btnNests))
                .addContainerGap())
        );

        tableFirstNest.setFont(new Font("Times New Roman", 0, 10)); // NOI18N
        tableFirstNest.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr", "W1", "W2", "W3", "Il[nr]", "Ia2[nr]", "Ia1[nr]"
            }
        ));
        tableFirstNest.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableFirstNest.setColumnSelectionAllowed(true);
        tableFirstNest.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        tableFirstNest.setFillsViewportHeight(true);
        tableFirstNest.setShowGrid(true);
        jScrollPane7.setViewportView(tableFirstNest);
        tableFirstNest.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (tableFirstNest.getColumnModel().getColumnCount() > 0) {
            tableFirstNest.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title0")); // NOI18N
            tableFirstNest.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title1_4")); // NOI18N
            tableFirstNest.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title2_4")); // NOI18N
            tableFirstNest.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title3_4")); // NOI18N
            tableFirstNest.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title4")); // NOI18N
            tableFirstNest.getColumnModel().getColumn(5).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title5")); // NOI18N
            tableFirstNest.getColumnModel().getColumn(6).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title6")); // NOI18N
        }

        tableOfConnections.setFont(new Font("Times New Roman", 0, 10)); // NOI18N
        tableOfConnections.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID1", "ID2", "Direction"
            }
        ));
        tableOfConnections.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableOfConnections.setFillsViewportHeight(true);
        tableOfConnections.setShowGrid(true);
        jScrollPane8.setViewportView(tableOfConnections);
        if (tableOfConnections.getColumnModel().getColumnCount() > 0) {
            tableOfConnections.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title0")); // NOI18N
            tableOfConnections.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title1_4")); // NOI18N
            tableOfConnections.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("Main.tableFirstNest.columnModel.title2_4")); // NOI18N
        }

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane7)
                .add(55, 55, 55)
                .add(jScrollPane8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .add(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(GroupLayout.TRAILING)
                    .add(GroupLayout.LEADING, jScrollPane8, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .add(jScrollPane7))
                .addContainerGap())
        );

        GroupLayout panelTabelePomocniczeLayout = new GroupLayout(panelTabelePomocnicze);
        panelTabelePomocnicze.setLayout(panelTabelePomocniczeLayout);
        panelTabelePomocniczeLayout.setHorizontalGroup(panelTabelePomocniczeLayout.createParallelGroup(GroupLayout.LEADING)
            .add(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTabelePomocniczeLayout.setVerticalGroup(panelTabelePomocniczeLayout.createParallelGroup(GroupLayout.LEADING)
            .add(panelTabelePomocniczeLayout.createSequentialGroup()
                .add(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.RELATED)
                .add(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(bundle.getString("Main.panelTabelePomocnicze.TabConstraints.tabTitle"), panelTabelePomocnicze); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING)
            .add(jTabbedPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPokazActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonPokazActionPerformed
        int n = (int) spinnerN.getValue();
        lu.createMatrixA(tableA, n);
        tableA.setModel(lu.getModelA());
    }//GEN-LAST:event_buttonPokazActionPerformed

    private void buttonObliczActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonObliczActionPerformed

        int n = (int) spinnerN.getValue();
        lu.makeDecomposition(tableL, tableU, n, czas);

        //przypisanie nowego modelu dla tabeli L
        tableL.setModel(lu.getModelL());

        //przypisanie nowego modelu dla tabeli U
        tableU.setModel(lu.getModelU());

    }//GEN-LAST:event_buttonObliczActionPerformed

    private void buttonVerificationActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonVerificationActionPerformed
        int n = (int) spinnerN.getValue();
        lu.verify(n, tableABis, tableA1, tableA2, labelSumEl);

        //przypisanie nowego modelu dla tabeli A1
        tableA1.setModel(lu.getModelA1());

        //przypisanie nowego modelu dla tabeli ABis
        tableABis.setModel(lu.getModelA());

        //przypisanie nowego modelu dla tabeli A2
        tableA2.setModel(lu.getModelA2());

    }//GEN-LAST:event_buttonVerificationActionPerformed

    private void btnNestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNestsActionPerformed
        int n = (int) spinnerN.getValue();
        graf.Coordinates(n, tableFirstNest);
        graf.sort(tableFirstNest);
        tableFirstNest.setModel(graf.getModelA1());
        
    }//GEN-LAST:event_btnNestsActionPerformed

    private void btnListConnectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListConnectionsActionPerformed
        int n = (int) spinnerN.getValue();
        graf.Connections(tableFirstNest, tableOfConnections);
        tableOfConnections.setModel(graf.getModelC());
    }//GEN-LAST:event_btnListConnectionsActionPerformed

    /* public JTable getTableA() {
        return tableA;
    }*/
    public JTable getTableA1() {
        return tableA1;
    }

    public JTable getTableA2() {
        return tableA2;
    }

    public JTable getTableABis() {
        return tableABis;
    }

    public JTable getTableU() {
        return tableU;
    }

    public JTable getTableL() {
        return tableL;
    }

    public static JTable getTableFirstNest() {
        return tableFirstNest;
    }

    public JTable getTableOfConnections() {
        return tableOfConnections;
    }
    

    public JLabel getLabelSumEl() {
        return labelSumEl;
    }

    public JSpinner getSpinnerN() {
        return spinnerN;
    }


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
    private JButton btnListConnections;
    private JButton btnNests;
    private JButton buttonOblicz;
    private JButton buttonPokaz;
    private JButton buttonVerification;
    private JLabel czas;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel9;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JTabbedPane jTabbedPane1;
    private JLabel labelSumEl;
    private JPanel panelA;
    private JPanel panelA1;
    private JPanel panelA2;
    private JPanel panelMacierz;
    private JPanel panelParametry;
    private JPanel panelTabelaA;
    private JPanel panelTabelaL;
    private JPanel panelTabelaU;
    private JPanel panelTabelePomocnicze;
    private JPanel panelWejsciowe;
    private JPanel panellWeyfikacja;
    private JSpinner spinnerN;
    private JTable tableA;
    private JTable tableA1;
    private JTable tableA2;
    private JTable tableABis;
    private static JTable tableFirstNest;
    private JTable tableL;
    private JTable tableOfConnections;
    private JTable tableU;
    // End of variables declaration//GEN-END:variables
}
