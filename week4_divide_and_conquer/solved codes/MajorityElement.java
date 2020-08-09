import java.util.*;
import java.io.*;

public class MajorityElement {

    private static int count(int[] a, int low, int high, int num) {
        int count = 0;
        for(int i = low; i<=high; i++) {
            if(a[i]==num) {
                count++;
            }
        }
        return count++;
    }

    private static int getMajorityElement(int[] a, int low, int high) {
        if(low==high) 
            return a[low];
        
        int mid = (low+high)/2;
        int left = getMajorityElement(a, low, mid);
        int right = getMajorityElement(a, mid+1, high);

        if (left==right)
            return left;
        int leftCount = count(a, low, mid, left);
        int rightCount = count(a, mid+1, high, right);

        if(leftCount>rightCount)
            return left;
        else
            return right;
    }
    //Alternate solution = Hashmap
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int element = getMajorityElement(a, 0, a.length-1);
        int occ = count(a, 0, a.length-1, element);
        if(occ > (n/2))
            System.out.println("1");
        else
            System.out.println("0");
    }
}

