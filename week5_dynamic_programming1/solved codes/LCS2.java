import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int m = a.length+1;
        int n = b.length+1;
        int[][] L = new int[m][n];
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                
                if(i==0 || j==0)
                    L[i][j] = 0;

                else if(a[i-1] == b[j-1])       //index in in array starts from 0 but in L we store from 1 since L[0][0] = 0
                    L[i][j] = L[i-1][j-1] + 1;

                else
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
            }
        }
        return L[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

