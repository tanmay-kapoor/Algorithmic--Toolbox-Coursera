import java.util.*;

class PrimitiveCalculator {
    static ArrayList<Integer> sequence = new ArrayList<Integer>();

    static void createArray(int n) {
        int[] minSteps = new int[n+1];
        minSteps[0] = 0;
        int[] steps = new int[3];

        minSteps[1] = 1;
        for(int num = 2; num<=n; num++) {
            if(num==2 || num==3) {
                minSteps[num] = 1;
            }
            else {
                steps[0] = steps[1] = steps[2] = Integer.MAX_VALUE;

                if(num%3==0)
                    steps[0] = minSteps[num/3] + 1;
                if(num%2==0)
                    steps[1] = minSteps[num/2] + 1;
                steps[2] = minSteps[num-1] + 1;

                minSteps[num] = Math.min(steps[0], Math.min(steps[1], steps[2]));
            }
        }
        getOptimalSequence(n, minSteps);
    }

    static void getOptimalSequence(int n, int[] minSteps) {
        sequence.add(n);
        int[] steps = new int[3];

        if(n==1) {
            Collections.reverse(sequence);
            return;
        }

        steps[0] = steps[1] = steps[2] = Integer.MAX_VALUE;
        if(n%3==0)
            steps[0] = minSteps[n/3];
        if(n%2==0)
            steps[1] = minSteps[n/2];
        steps[2] = minSteps[n-1];

        int min = Math.min(steps[0], Math.min(steps[1], steps[2]));
        if(min == steps[0]) {
            getOptimalSequence(n/3, minSteps);
        }
        else if(min == steps[1]) {
            getOptimalSequence(n/2, minSteps);
        }
        else {
            getOptimalSequence(n-1, minSteps);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        createArray(n);
        System.out.println(sequence.size()-1); 
        for(int i = 0; i<sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
    }
}