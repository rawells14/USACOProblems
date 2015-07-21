import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class escape {
    public static int highestAmount;
    public static int recursiveCalls = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner asdf = new Scanner(System.in);
        int n = asdf.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = asdf.nextInt();

        }
        Arrays.sort(weights);
        for (int i = 0; i <= weights.length; i++) {
            compute(weights, i, 0, 0);
        }

        System.out.println(highestAmount);
        System.out.println("Recursive Calls: "+ recursiveCalls);
    }

    public static void compute(int[] weights, int currentIndex, int currentSum, int amtOfWeights) {
        recursiveCalls++;
        if (currentIndex >= weights.length) {
            return;
        }
        if (!carries(currentSum, weights[currentIndex])) {
            amtOfWeights++;
            currentSum += weights[currentIndex];
            currentIndex++;
            if (amtOfWeights >= highestAmount) {
                highestAmount = amtOfWeights;
            }
            for (int i = currentIndex; i < weights.length; i++) {
                compute(weights, i, currentSum, amtOfWeights);
            }

        } else {
            compute(weights, currentIndex + 1, currentSum, amtOfWeights);
        }
    }


    public static boolean carries(int p, int q) {
        String s1 = Integer.toString(p);
        String s2 = Integer.toString(q);
        for (int i = s1.length(); i > 0; i--) {
            if ((Integer.parseInt(s1.substring(i - 1, i)) + (Integer.parseInt(s2.substring(i - 1, i)))) >= 10) {
                return true;
            }
        }
        return false;
    }
}
