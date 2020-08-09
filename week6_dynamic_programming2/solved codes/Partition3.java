//equal sum partiton (3 parts)
import java.util.*;

class Partition3 {
    List<Integer> removeIndex(List<Integer> arr, boolean[][] dp, int k, int n) {
		// Required sets set1 and set2. 
		List<Integer> set1 = new ArrayList<Integer>();      //contains indices of elements in the subset
        //List<Integer> set2 = new ArrayList<Integer>();
        
		int i = n; 
		int currSum = k; 
	
		while (i > 0 && currSum >= 0) {
			// If current element does 
			// not contribute to k, then 
			// it belongs to set 2. 
			if (dp[i - 1][currSum]) { 
				i--; 
				//set2.add(arr.get(i)); 
			} 
	
			// If current element contribute 
			// to k then it belongs to set 1. 
			else if (dp[i - 1][currSum - arr.get(i - 1)]) { 
				i--; 
				currSum -= arr.get(i); 
                set1.add(i);            //set1.add(arr.get(i)) to add the actual element of subset
			} 
        }
        for(int x = 0; i<set1.size(); i++) {
            arr.remove(x);
        }
        return arr;
    }

    boolean[][] checkSubset(List<Integer> arr, int sum, int n) {
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 0; i<=n; i++) {
            for(int j = 0; j<=sum; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = j==0?true:false;
                }
                else if(j-arr.get(i-1) < 0) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr.get(i-1)];
                }
            }
        }
        return dp;
    }

    int checkPossibility(List<Integer> arr, int sum , int n) {
        if(sum%6 != 0)
            return 0;

        boolean[][] dp = checkSubset(arr, sum/3, n);

        if(!dp[n][sum/3])
            return 0;
        
        arr = removeIndex(arr, dp, sum/3, n);
        sum -= sum/3;
        n = arr.size();
        dp = checkSubset(arr, sum, n);

        return dp[n][sum/2]?1:0;
    }


    public static void main(String[] args) {
        Partition3 ob = new Partition3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<Integer>();
        int sum = 0;
        for(int i = 0; i<n; i++) {
            arr.add(sc.nextInt());
            sum += arr.get(i);
        }
        Collections.sort(arr, Collections.reverseOrder());      //if not picking greatest at each point.. there might exist a case where sum%3==0 but sum%2!=0
        int ans = ob.checkPossibility(arr, sum, n);
        System.out.println(ans);
    }
}