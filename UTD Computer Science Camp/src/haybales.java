import java.util.Scanner;

public class haybales {
    public static void main(String[] args) {
        Scanner asdf = new Scanner(System.in);
        int n = asdf.nextInt();
        int[] bales = new int[n];
        for (int i = 0; i < n; i++) {
            bales[i] = asdf.nextInt();
        }
        long t1 = System.currentTimeMillis();
        int average = 0;
        for (int i = 0; i < n; i++) {
            average += bales[i];
        }
        average = average / n;

        int hayBalesMoved = 0;
        while (!allSameHeight(bales)) {
            //looks for a bale with a low index
            int lowIndex = 0;
            int highIndex = 0;
            for (int i = 0; i < bales.length; i++) {
                if (bales[i] < bales[lowIndex]) {
                    lowIndex = i;
                }
            }
            for (int i = 0; i < bales.length; i++) {
                if (bales[i] > bales[highIndex]) {
                    highIndex = i;
                }
            }

            bales[lowIndex]++;
            bales[highIndex]--;
            hayBalesMoved++;


        }
        System.out.println(hayBalesMoved);
        System.out.println("Time: " + (System.currentTimeMillis() - t1));
    }

    public static boolean allSameHeight(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1])
                return false;
        }
        return true;
    }
}
