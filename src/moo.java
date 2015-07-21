import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class moo {
    public static int calls = 0;
    public static int[] mooLengths;

    public static void main(String[] args) throws FileNotFoundException {
        long time = System.currentTimeMillis();
        mooLengths = getChars(29);
        Scanner scn = new Scanner(new File("InputFIles/10.in"));
        System.out.println(getLet(scn.nextInt()));
        System.out.println("Time: " + (System.currentTimeMillis()-time));
    }

    public static String getLet(int pos) {
        pos = pos - 1;
        int sum = 0;
        int index = 0;
        while (sum < pos) {
            sum += mooLengths[index];
            index++;
        }
        if (pos == sum) {
            return "m";
        }else {
            return "o";
        }

    }

    public static int[] getChars(int hiVal) {
        int cur = 3;
        int[] arr = {3};
        while (cur <= hiVal) {
            int[] temp = new int[arr.length * 2 + 1];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            temp[arr.length] = cur + 1;
            for (int i = arr.length; i < arr.length * 2; i++) {
                temp[i + 1] = arr[i - arr.length];
            }
            arr = temp;
            cur++;
        }
        return arr;
    }


}
