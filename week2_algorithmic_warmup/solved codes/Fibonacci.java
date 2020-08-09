import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    long f = 0, s = 1, t = 0;
    if(n<=1)
      return n;
    long terms = 2;

    while(terms<=n) {
      t = f+s;
      f = s;
      s = t;
      terms++;
    }
    return t;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
