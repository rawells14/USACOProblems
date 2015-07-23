import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class hshoe {

    public static int HighestLength = 0;
    public static char[][] data;
    public static int calls = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/10.in"));
        int n = scn.nextInt();
        scn.nextLine();
        data = new char[n][n];

        for (int i = 0; i < n; i++) {
            String temp = scn.nextLine();
            data[i] = temp.toCharArray();
        }
        if (data[0][0] == ')') {
            System.out.println("0");
            return;
        }

        compute("", 0, 0);
        System.out.println(HighestLength);
        System.out.println(calls);
    }


    public static void compute(String currentPath, int i, int j) {
        calls++;
        if (!isValid(i, j) || data[i][j] == 'X') {
            return;
        } else {
            char currentChar = data[i][j];


            currentPath += Character.toString(data[i][j]);
            if (isPerfectlyBalanced(currentPath.toCharArray())) {
                if (currentPath.length() > HighestLength) {
                    HighestLength = currentPath.length();
                }
            }
            data[i][j] = 'X';
            compute(currentPath, i, j + 1);
            compute(currentPath, i, j - 1);
            compute(currentPath, i - 1, j);
            compute(currentPath, i + 1, j);
            data[i][j] = currentChar;

        }
    }

    public static boolean isValid(int i, int j) {
        return (i >= 0 && i < data.length) && (j >= 0 && j < data.length);
    }

    public static boolean isPerfectlyBalanced(char[] arr) {
        if (arr.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] == ')') {
                return false;
            }
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            if (arr[i] == '(') {
                return false;
            }
        }
        return true;
    }
}
