import java.lang.String;import java.lang.System;import java.util.Arrays;
import java.util.Scanner;

public class HaybaleStacking {
    public static void main(String[] args) {
        Scanner asdf = new Scanner(System.in);
        int n = asdf.nextInt();
        int k = asdf.nextInt();
        int[] stacks = new int[n+1];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < k; i++) {
            int a = asdf.nextInt();
            int b = asdf.nextInt();
            for (int j = a; j <= b; j++) {
                stacks[j]++;
            }
        }
        Arrays.sort(stacks);
        System.out.println(stacks[(stacks.length-1) / 2]);
        System.out.println("Time: " + (System.currentTimeMillis()-t1));
    }
}
