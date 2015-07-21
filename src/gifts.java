import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class gifts {


    public static int budget = 0;
    public static int highestAmountOfGifts = 0;
    public static int recursiveCalls = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFiles/3.in"));
        int n = scn.nextInt();
        budget = scn.nextInt();
        int[][] prices = new int[n][2];
        for (int i = 0; i < n; i++) {
            prices[i][0] = scn.nextInt();
            prices[i][1] = scn.nextInt();
        }
        for (int i = 0; i < prices.length; i++) {
            compute(prices, i, new ArrayList<Integer[]>());
        }

        System.out.println("Best: " + highestAmountOfGifts);
        System.out.println("Calls: " + recursiveCalls);
    }


    public static void compute(int[][] prices, int currentIndex, ArrayList<Integer[]> group) {
        recursiveCalls++;
        if (currentIndex >= prices.length) {
            return;
        }
        Integer[] curElement = {prices[currentIndex][0], prices[currentIndex][1]};
        group.add(curElement);
        if (getBestPrice(group) <= budget) {
            if (group.size() >= highestAmountOfGifts) {
                highestAmountOfGifts = group.size();
            }
            for (int i = currentIndex; i < prices.length; i++) {
                compute(prices, currentIndex + 1, group);
            }

        } else {
            return;
        }


    }


    public static int getBestPrice(ArrayList<Integer[]> group) {
        int[] normals = new int[group.size()];
        for (int i = 0; i < normals.length; i++) {
            normals[i] = group.get(i)[0];
        }
        Arrays.sort(normals);
        int sum = 0;
        for (int i = 0; i < group.size(); i++) {
            sum += group.get(i)[0] + group.get(i)[1];
        }
        sum = sum - normals[normals.length - 1] / 2;
        return sum;
    }
}