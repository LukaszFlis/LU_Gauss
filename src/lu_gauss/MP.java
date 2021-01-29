package lu_gauss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *Wyznaczenie funkcji odwzorowania dla dwuwymiarowej MP
 * Wyszukanie Fs i Ft spełniające warunku lokalności i przyczynowości
 * dla macierzy odwzorowania grafu D(n,l) przy n =3(wymiar grafu) i l =4;
 * @author Luk
 */
public class MP {
    private  static Scanner sc = new Scanner(System.in);
    private int[][] fS = new int[2][3];
    private int[] ft = new int[3];
    private int[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, 0}};
    
    private static ArrayList<Vertices> k = new ArrayList<Vertices>(20);
    //list of CPU clocks
    private static ArrayList<Integer> t = new ArrayList<>(20);
    // list of EP vertex coordinates
    private static ArrayList<Pairs> fsK = new ArrayList<>(20);
    // list of EP[coordinates, T]
    private static ArrayList<EP> ep = new ArrayList<>(20);
    
    
    /**
     * Initialize elements of the Fs array
     *
     * @param a 2d array
     */
    public static void initFs(int[][] a) {
        var nr = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("Podaj " + nr + " element macierzy Fs: ");
                a[i][j] = sc.nextInt();
                nr++;
            }
        }
    }

    /**
     * Initialize elements of the Ft array
     *
     * @param a array
     */
    public static void initFt(int[] a) {
        System.out.println("");
        var nr = 1;
        for (int i = 0; i < a.length; i++) {
            System.out.print("Podaj " + nr + " element macierzy Ft: ");
            a[i] = sc.nextInt();
            nr++;
        }
    }

    /**
     * Initialize elements of the Vertice list
     *
     * @param k a list containing the coordinates of the graph's vertices
     * @return 
     */
    public static ArrayList initK(ArrayList<Vertices> k) { //ta metoda nie odpala się
        System.out.println("");
        int w1= 0;
        int w2 =0;
        int w3 = 0;
        int nr = 1;
        for (int i = 0; i < k.size(); i++) {
            System.out.print("Podaj w1" + nr + "wierzchołka: ");
            w1 = sc.nextInt();
            System.out.println("Podaj w2" + nr + "wierzchołka: ");
            w2 = sc.nextInt();
            System.out.println("Podaj w3" + nr + "wierzchołka: ");
            w3 = sc.nextInt();
            k.add(new Vertices(w1, w2, w3));
            nr++;
        }
        return k;
    }

    /**
     * Check condition of causality Ft*dj >= 1
     *
     * @param ft vector Ft
     * @param d Graph mapping array
     * @return true if the condition is met
     */
    public static boolean isFtGood(int[] ft, int[][] d) {
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
    public static boolean isFsGood(int[][] f, int[][] d) {
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

    /**
     *
     * @param ftK a list containing the CPU clocks executed in the processing
     * element
     * @param k a list containing the coordinates of the graph's vertices
     * @param ft temporal projection matrix
     */
    public static void setFtK(ArrayList<Integer> ftK, ArrayList<Vertices> k, int[] ft) {
        var w1 = 0;
        var w2 = 0;
        var w3 = 0;
        var sum = 0;

        for (int i = 0; i < k.size(); i++) {
            w1 = k.get(i).getW1() * ft[0];
            w2 = k.get(i).getW2() * ft[1];
            w3 = k.get(i).getW3() * ft[2];
            sum += (w1 + w2 + w3);
            ftK.add(sum);
        }
    }

    /**
     * Set list of EP veritces
     *
     * @param fsK a list containing pairs of coordinates of processing elements
     * @param k a list containing the coordinates of the graph's vertices
     * @param fs spatial mapping matrix
     */
    public static void setFsK(ArrayList<Pairs> fsK, ArrayList<Vertices> k, int[][] fs) {
        int sumA = 0;
        int sumB = 0;
        var x1 = 0;
        var x2 = 0;
        var x3 = 0;
        var y1 = 0;
        var y2 = 0;
        var y3 = 0;

        for (int i = 0; i < fsK.size(); i++) {
            x1 = fs[0][0] * k.get(i).getW1();
            x2 = fs[0][1] * k.get(i).getW2();
            x3 = fs[0][2] * k.get(i).getW3();
            sumA += (x1 + x2 + x3);
            y1 = fs[1][0] * k.get(i).getW1();
            y2 = fs[1][1] * k.get(i).getW2();
            y3 = fs[1][3] * k.get(i).getW3();
            sumB += (y1 + y2 + y3);
            fsK.add(new Pairs(sumA, sumB));
        }
    }

    public static void setEP(ArrayList<EP> ep, ArrayList<Pairs> fsk, ArrayList<Integer> ftk) {
        for (int i = 0; i < ep.size(); i++) {
            ep.add(new EP(fsk.get(i), ftk.get(i)));
        }
    }

    /**
     * Print in preety format matrix Fs to console
     *
     * @param a 2D array
     */
    public static void printFs(int[][] a) {
        System.out.println("Macierz Fs");
        for (int i = 0; i < a.length; i++) {
            System.out.print("|");
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    /**
     * Print in preety format matrix Ft to console
     *
     * @param a 2D array
     */
    public static void printFt(int[] a) {
        System.out.println("Macierz Ft");
        System.out.print("|");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.print("|\n");
    }

    public static void printK(ArrayList<Vertices> k) {
        System.out.println("Lista wierzchołków grafu");
        for (int i = 0; i < k.size(); i++) {
            System.out.println(Arrays.toString(k.get(i).getCoordinates()));
        }
    }

    public static void printEP(ArrayList<EP> ep) {
        System.out.println("Macierz elementów przetwarzających");
        for (int i = 0; i < ep.size(); i++) {
            System.out.println("{[" + ep.get(i).getId() + "], " + ep.get(i).getT() + "}");
        }
    }
    
    public int[][] getfS() {
        return fS;
    }

    public int[] getFt() {
        return ft;
    }

    public int[][] getD() {
        return d;
    }
    
}
