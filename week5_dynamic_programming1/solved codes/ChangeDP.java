import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money) {
        //write your code here
        int[] coins = {1, 3, 4};
        int[] minNumCoins = new int[money+1];
        minNumCoins[0] = 0;
        int numCoins;
        
        for(int m = 1; m<=money; m++) {
            minNumCoins[m] = Integer.MAX_VALUE;
            for(int i = 0; i<coins.length; i++) {
                if(m>=coins[i]) {
                    numCoins = minNumCoins[m-coins[i]] + 1;
                    if(numCoins < minNumCoins[m]) {
                        minNumCoins[m] = numCoins;
                    }
                }
            }
        }
        return minNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        System.out.println(getChange(money));

    }
}

