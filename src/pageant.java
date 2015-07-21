import java.lang.Integer;import java.lang.Math;import java.lang.String;import java.lang.System;import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class pageant {

    public static HashSet<int[]> blob1 = new HashSet<int[]>();
    public static HashSet<int[]> blob2 = new HashSet<int[]>();
    public static int m;
    public static int n;
    public static char[][] grid;

    public static void main(String[] args) {
        Scanner asdf = new Scanner(System.in);
        m = asdf.nextInt();
        n = asdf.nextInt();

        asdf.nextLine();
        grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            grid[i] = asdf.nextLine().toCharArray();
        }
        long t1 = System.currentTimeMillis();

        int initialX = 0;
        int initialY = 0;
        label1:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'X') {
                    initialX = i;
                    initialY = j;
                    break label1;
                }
            }
        }

        floodFill1(initialX, initialY);

        initialX = 0;
        initialY = 0;

        label2:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'X') {
                    initialX = i;
                    initialY = j;
                    break label2;
                }
            }
        }
        floodFill2(initialX, initialY);

        double minDist = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] blob1Cord : blob1) {
            for (int[] blob2Cord : blob2) {
                double distance = Math.sqrt(Math.pow(blob1Cord[0] - blob2Cord[0], 2) + Math.pow(blob1Cord[1] - blob2Cord[1], 2));
                if (distance < minDist) {
                    minDist = distance;
                    minX = Math.abs(blob1Cord[0] - blob2Cord[0]);
                    minY = Math.abs(blob1Cord[1] - blob2Cord[1]);
                }


            }
        }
        System.out.println(minX + minY - 1);
        System.out.println("Time: " + (System.currentTimeMillis() - t1));

    }


    public static void floodFill1(int x, int y) {
        if (isValid(x, y)) {
            if (grid[x][y] == 'X') {
                blob1.add(new int[]{x, y});
                grid[x][y] = '.';
            } else {
                return;
            }
        } else {
            return;
        }
        floodFill1(x + 1, y);
        floodFill1(x - 1, y);
        floodFill1(x, y + 1);
        floodFill1(x, y - 1);
        return;
    }

    public static void floodFill2(int x, int y) {
        if (isValid(x, y)) {
            if (grid[x][y] == 'X') {
                blob2.add(new int[]{x, y});
                grid[x][y] = '.';
            } else {
                return;
            }
        } else {
            return;
        }
        floodFill2(x + 1, y);
        floodFill2(x - 1, y);
        floodFill2(x, y + 1);
        floodFill2(x, y - 1);
        return;
    }

    public static boolean isValid(int x, int y) {
        return (x >= 0 && x < m) && (y >= 0 && y < n);
    }
}
