import java.util.*;

class LCS2print {
    String subsequence = "";

    String findLCS(int[] a, int[] b) {
        int m = a.length+1;
        int n = b.length+1;
        int[][] L = new int[m][n];

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(i==0 || j==0)
                    L[i][j] = 0;
                else if(a[i-1] == b[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
            }
        }

        return findSubsequence(L, a, b);
    }

    String findSubsequence(int[][] L, int[] a, int[] b) {
        int i = a.length, j = b.length;

        while(L[i][j]!=0) {
            if(a[i-1] == b[j-1]) {
                subsequence = a[i-1] + subsequence;
                i--;
                j--;
            }
            else if(L[i][j-1] > L[i-1][j])
                j--;
            else
                i--;
        }
        return subsequence;
    }

    public static void main(String[] args) {
        LCS2print ob = new LCS2print();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] a = new int[m];
        for(int i = 0; i<m; i++) {
            a[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] b = new int[n];
        for(int j = 0; j<n; j++) {
            b[j] = sc.nextInt();
        }
        String ans = ob.findLCS(a, b);
        System.out.println("lcs length = " + ans.length());
        if(ans.length()>0)
            System.out.println("lcs = " + ans);
    }
}