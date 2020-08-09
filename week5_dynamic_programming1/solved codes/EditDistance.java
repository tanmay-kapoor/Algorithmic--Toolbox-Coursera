import java.util.*;

class EditDistance {

    private static int calcEditDistance(String s, String t) {
        //write your code here
        int n = s.length()+1;
        int m = t.length()+1;
        int[][] D = new int[n][m];
        D[0][0] = 0;

        for(int i = 1; i<n; i++) {
            D[i][0] = i;
        }
        for(int j = 1; j<m; j++) {
            D[0][j] = j;
        }

        for(int j = 1; j<m; j++) {
            for(int i = 1; i<n; i++) {
                int insertion = D[i][j-1] + 1;
                int deletion = D[i-1][j] + 1;
                int match = D[i-1][j-1];
                int mismatch = D[i-1][j-1] + 1;

                //i starts from 1 but char in string starts from 0 so i-1 position
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    D[i][j] = Math.min(insertion, Math.min(deletion, match));
                }
                else {
                    D[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
                }
            }
        }
        return D[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();

        System.out.println(calcEditDistance(s, t));
    }
}