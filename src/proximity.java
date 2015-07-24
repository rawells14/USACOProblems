import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class proximity {

    public static int[] ids;
    public static TreeSet<Integer> crowded = new TreeSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        long t1 = System.currentTimeMillis();
        Scanner scn = new Scanner(new File("InputFIles/8.in"));
        int n = scn.nextInt();
        int k = scn.nextInt();
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = scn.nextInt();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1 + " ms to read and store input");
        for (int i = 0; i < n - k; i++) {
            for (int j = 1; j <= k; j++) {
                int temp = ids[j + i];
                if (ids[i] == temp) {
                    crowded.add(temp);
                    continue;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - t2 + " ms for logic");
        System.out.println(crowded.last());

    }
}
