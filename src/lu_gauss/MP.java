package lu_gauss;

import java.util.Scanner;

/**
 *Wyznaczenie funkcji odwzorowania dla dwuwymiarowej MP
 * Wyszukanie Fs i Ft spełniające warunku lokalności i przyczynowości
 * dla macierzy odwzorowania grafu D(n,l) przy n =3(wymiar grafu) i l =4;
 * @author Luk
 */
public class MP {
    private  Scanner sc = new Scanner(System.in);
    private int[][] fS = {{1, 0, 1}, {-1, 0, -1}};
    private int[] ft = {-1, 1, -2};
    private int[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, 0}};
    
    
    
    public boolean isFtGood(int[] f, int[][] d) {
        boolean test = true;
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                for (int k = 0; k < d.length; k++) {
                    sum += f[i] * d[j][k];
                    if (sum < 1) {
                        test = false;
                        break;
                    }
                }
            }
        }
        return test;
    }
    public boolean isFsGood(int[][] f, int[][] d) {
        boolean test = true;
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                for (int k = 0; k < d.length; k++) {
                    sum += f[i][j] * d[j][k];
                    if (sum < -1 || sum >1) {
                        test = false;
                        break;
                    }
                }
            }
        }
        return test;
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
