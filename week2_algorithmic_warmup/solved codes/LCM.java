import java.util.*;

public class LCM {
  private static long lcm(long a, long b) {
    long max = a>b?a:b;
    long step = max;
    long lcm = 0;

    while(a!=0) {
      if(max%a==0 && max%b==0) {
        lcm = max;
        break;
      }
      max+=step;
    }
    return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
