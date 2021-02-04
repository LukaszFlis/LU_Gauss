package lu_gauss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Wyznaczenie funkcji odwzorowania dla dwuwymiarowej MP Wyszukanie Fs i Ft
 * spełniające warunku lokalności i przyczynowości dla macierzy odwzorowania
 * grafu D(n,l) przy n =3(wymiar grafu) i l =4;
 *
 * @author Luk
 */
public class MP {

    private int[][] fS = new int[2][3];
    private int[] fT = new int[3];
    private int[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, 0}};

    private ArrayList<Vertices> k = new ArrayList<Vertices>(20);
    //list of CPU clocks
    private ArrayList<Integer> t = new ArrayList<>(20);
    // list of EP vertex coordinates
    private ArrayList<Pairs> fsK = new ArrayList<>(20);
    // list of EP[coordinates, T]
    private ArrayList<EP> ep = new ArrayList<>(20);

    /**
     * Initialize elements of the Fs array
     *
     * @param a 2d array
     * @param t
     */
    public void initFs(int[][] a, JTextField t) {
        String values = t.getText();
        String[] numbers = values.split(",");
        int it = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Integer.parseInt(numbers[it]);
                it++;
            }
        }
    }

    /**
     * Initialize elements of the Ft array
     *
     * @param a array
     */
    public void initFt(int[] a, JTextField t) {
        String values = t.getText();
        String[] numbers = values.split(",");
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(numbers[i]);
        }
    }

    /**
     * Initialize elements of the Vertice list
     *
     * @param k a list containing the coordinates of the graph's vertices
     */
    public void setK(JTable t, ArrayList<Vertices> k) {
        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        for (int i = 0; i < t.getRowCount(); i++) {
            w1 = (int) t.getValueAt(i, 1);
            w2 = (int) t.getValueAt(i, 2);
            w3 = (int) t.getValueAt(i, 3);
            k.add(new Vertices(w1, w2, w3));
        }
    }

    /**
     * Check condition of causality Ft*dj >= 1
     *
     * @param ft vector Ft
     * @param d Graph mapping array
     * @return true if the condition is met
     */
    public boolean isFtGood(int[] ft, int[][] d) {
        boolean test = true;
        int sum = 0;
        for (int i = 0; i < d[0].length; i++) {
            for (int j = 0; j < d.length; j++) {
                sum += ft[j] * d[j][i];
            }
            if (sum < 1) {
                test = false;
                break;
            }
        }
        return test;
    }

    /**
     * Check connection locality condition Fs*dj = -1 v 0 v 1
     *
     * @param f array Fs
     * @param d Graph mapping array
     * @return true if the condition is met
     */
    public boolean isFsGood(int[][] f, int[][] d) {
        boolean test = true;
        int sum = 0;
        for (int i = 0; i < d[0].length; i++) {
            for (int j = 0; j < d.length; j++) {
                sum += f[0][j] * d[j][i];
            }
            if (sum < -1 || sum > 1) {
                test = false;
                break;
            }
            for (int j = 0; j < d.length; j++) {
                sum += f[1][j] * d[j][i];
            }
            if (sum < -1 || sum > 1) {
                test = false;
                break;
            }
        }
        return test;
    }

    public boolean isEpGood() {
        Collections.sort(ep);
        boolean test = false;
        for (int i = 0; i < 20; i++) {
            if (ep.get(i + 1).getId().equals(ep.get(i).getId()) && ep.get(i + 1).getT() != ep.get(i).getT()) {
                test = true;
            } else {
                test = false;
                break;
            }
        }
        return test;
    }

    /**
     * Multiply matrix fT with vertice K
     *
     */
    public void setFtK() {
        var sum = 0;
        for (int i = 0; i < 20; i++) {
            sum = fT[0] * k.get(i).getW1() + fT[1] * k.get(i).getW2() + fT[2] * k.get(i).getW3();
            t.add(sum);
        }
    }

    /**
     * Set list of MP processing element's veritces (fs * k)
     */
    public void setFsK() {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < 20; i++) {
            sumA = fS[0][0] * k.get(i).getW1() + fS[0][1] * k.get(i).getW2() + fS[0][2] * k.get(i).getW3();
            sumB = (fS[1][0] * k.get(i).getW1() + fS[1][1] * k.get(i).getW2() + fS[1][2] * k.get(i).getW3());
            fsK.add(new Pairs(sumA, sumB));
        }
    }

    /**
     * Set list of MP processing element's (ep id + cpu clock)
     */
    public void setEP() {
        for (int i = 0; i < 20; i++) {
            ep.add(new EP(fsK.get(i), t.get(i)));
        }
    }

    /**
     * Print in preety format matrix Fs
     *
     * @param a 2D array
     * @param t table to show Fs
     */
    public void printFs(int[][] a, JTable t) {
        for (int i = 0; i < t.getRowCount(); i++) {
            for (int j = 0; j < t.getColumnCount(); j++) {
                t.setValueAt(a[i][j], i, j);
            }
        }
    }

    /**
     * Print in preety format matrix Ft
     *
     * @param a 2D array
     * @param t table to show Ft
     */
    public void printFt(int[] a, JTable t) {
        for (int i = 0; i < t.getColumnCount(); i++) {
            t.setValueAt(a[i], 0, i);
        }
    }

    /**
     * Print in preety format list ep to console
     *
     * @param ep ArrayList of processing elements (contains ep id and cpu clock
     * T)
     */
    public void printEP(ArrayList<EP> ep, JTable t) {
        for (int i = 0; i < ep.size(); i++) {
            DefaultTableModel model = (DefaultTableModel) t.getModel();
            int id = i + 1;
            int vertice1 = ep.get(i).getId().getA();
            int vertice2 = ep.get(i).getId().getB();
            int time = ep.get(i).getT();
            Object[] data = {id, vertice1, vertice2, time};
            model.addRow(data);
            t.setModel(model);
        }
    }

    /**
     * Getter method for matrix Fs
     *
     * @return matrix Fs
     */
    public int[][] getFs() {
        return fS;
    }

    /**
     * Getter method for matrix Ft
     *
     * @return matrix Ft
     */
    public int[] getFt() {
        return fT;
    }

    /**
     * Getter method for matrix D
     *
     * @return matrix Ss
     */
    public int[][] getD() {
        return d;
    }

    public ArrayList<Vertices> getK() {
        return k;
    }

    public ArrayList<Integer> getT() {
        return t;
    }

    public ArrayList<Pairs> getFsK() {
        return fsK;
    }

    public ArrayList<EP> getEp() {
        return ep;
    }

}
