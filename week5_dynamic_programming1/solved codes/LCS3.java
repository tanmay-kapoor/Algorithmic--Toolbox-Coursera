import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int m = a.length+1;
        int n = b.length+1;
        int o = c.length+1;
        int[][][] L = new int[m][n][o];

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                for(int k = 0; k<o; k++) {
                    if(i==0 || j==0 || k==0)
                        L[i][j][k] = 0;
                    else if(a[i-1] == b[j-1] && a[i-1] == c[k-1])
                        L[i][j][k] = L[i-1][j-1][k-1] + 1;
                    else
                        L[i][j][k] = Math.max(L[i-1][j][k], Math.max(L[i][j-1][k], L[i][j][k-1]));
                }
            }
        }
        return L[m-1][n-1][o-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

