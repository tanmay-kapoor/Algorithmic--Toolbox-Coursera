import java.util.*;

public class Inversions {
    int swaps = 0;

    private void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid-low+1;
        int n2 = high-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i<n1; i++) {
            left[i] = arr[low+i];
        }
        for(int j = 0; j<n2; j++) {
            right[j] = arr[mid+1+j];
        }

        int i = 0, j = 0, k = low;
        while(i<n1 && j<n2) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                swaps += (mid+1)-(i+low);
                arr[k++] = right[j++];
            }
        }
        while(i<n1) {
            arr[k++] = left[i++];
        }
        while(j<n2) {
            arr[k++] = right[j++];
        }
    }

    private void sort(int[] a, int low, int high) {

        if(low<high) {
            int mid = (low + high) / 2;
            sort(a, low, mid);
            sort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inversions ob = new Inversions();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ob.sort(arr, 0, arr.length-1);
        System.out.println(ob.swaps);
    }
}

