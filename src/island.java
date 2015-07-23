import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class island {

    public static boolean[] isFlooded;
    public static int[] islandHeights;
    public static int maxIslands = 0;
    public static int currentLevel = 0;
    public static int maxLevel = 0;


    public static void main(String[] args) throws FileNotFoundException {
        long t1 = System.currentTimeMillis();
        Scanner scn = new Scanner(new File("InputFIles/5.in"));
        int n = scn.nextInt();
        islandHeights = new int[n];
        isFlooded = new boolean[n];
        for (int i = 0; i < n; i++) {
            islandHeights[i] = scn.nextInt();
            if (islandHeights[i] > maxLevel)
                maxLevel = islandHeights[i];
        }

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1 + " ms for input");
        while (currentLevel <= maxLevel) {
            floodIslands();
            if (getAmountOfIslands() >= maxIslands)
                maxIslands = getAmountOfIslands();
            currentLevel++;
        }
        System.out.println(System.currentTimeMillis() - t2 + " ms for main logic");
        System.out.println(maxIslands);

    }

    public static void floodIslands() {
        for (int i = 0; i < islandHeights.length; i++) {
            if (islandHeights[i] <= currentLevel) {
                isFlooded[i] = true;
            }
        }
    }

    public static int getAmountOfIslands() {
        int amount = 0;
        for (int i = 1; i < isFlooded.length - 1; i++) {
            if (!isFlooded[i] && !isFlooded[i - 1] || !isFlooded[i] && !isFlooded[i + 1]) {
                amount++;
                i += getNextGap(i) - 1;
            }
        }

        //corner cases

        if (!isFlooded[0] && isFlooded[1]) {
            amount++;
        }
        if (!isFlooded[isFlooded.length - 1] && isFlooded[isFlooded.length - 2]) {
            amount++;
        }
        return amount;
    }

    public static int getNextGap(int currentIndex) {
        int amount = 0;
        while (!isFlooded[currentIndex] && currentIndex < isFlooded.length - 1) {
            amount++;
            currentIndex++;
        }
        return amount;
    }

}
