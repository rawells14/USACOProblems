import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cowrow {
    public static int greatestInARow = 0;
    public static ArrayList<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int n = scn.nextInt();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            data.add(scn.nextInt());
        }
        long time2 = System.currentTimeMillis();

        for (int j = 0; j < data.size(); j++) {
            int removed = data.get(j);
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k = 0; k < data.size(); k++) {
                temp.add(data.get(j));
            }
            while (temp.contains((Integer) (removed))) {
                temp.remove((Integer)(removed));
            }

            if (inARow(temp) >= greatestInARow)
                greatestInARow = inARow(temp);
        }


        long time3 = System.currentTimeMillis();
        System.out.println("Time to Read input: " + (time2 - time1));
        System.out.println("Time for main logic: " + (time3 - time2));
        System.out.println(greatestInARow);

    }

    public static int inARow(ArrayList<Integer> arr) {
        int greatest = 1;
        int currentGreatest = 1;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) == arr.get(i + 1)) {
                currentGreatest++;
            } else {
                if (currentGreatest >= greatest) {
                    greatest = currentGreatest;
                }
                currentGreatest = 1;
            }
        }
        return greatest;

    }

    public static int[] replaceAll(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                arr[i] = -1;
                count++;
            }
        }
        int[] temp = new int[arr.length - count];
        int arrIndex = 0;
        for (int i = 0; i < arr.length - count; i++) {
            if (arr[i] != -1) {
                arrIndex++;
                temp[arrIndex] = arr[i];

            }
        }
        System.out.println(Arrays.toString(temp));
        return temp;
    }

}
