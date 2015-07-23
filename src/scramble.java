import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class scramble {

    public static String[] bestCases;
    public static String[] worstCases;
    public static Cow1[] cows;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/9.in"));
        int n = scn.nextInt();
        scn.nextLine();
        String[] words = new String[n];
        cows = new Cow1[n];
        bestCases = new String[n];
        worstCases = new String[n];

        for (int i = 0; i < n; i++) {
            Cow1 c = new Cow1();
            cows[i] = c;
            String name = scn.nextLine();
            cows[i].name = name;
            words[i] = name;

        }

        for (int i = 0; i < n; i++) {
            cows[i].bestCase = bestCase(cows[i].name);
            bestCases[i] = cows[i].bestCase;
        }
        Arrays.sort(bestCases);


        for (int i = 0; i < n; i++) {
            cows[i].worstCase = worstCase(words[i]);
            worstCases[i] = cows[i].worstCase;
        }
        Arrays.sort(worstCases);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int best = getLocation(cows[i].bestCase, bestCases);

            int worst = getLocation(cows[i].worstCase, worstCases);
            System.out.println((Math.min(best, worst) + 1) + " " + (1 + Math.max(best, worst)));
        }


    }

    public static int getLocation(String s, String[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public static String bestCase(String s) {
        char[] data = s.toCharArray();
        Arrays.sort(data);
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            temp += data[i];
        }
        return temp;
    }

    public static String worstCase(String s) {
        char[] data = s.toCharArray();
        Arrays.sort(data);
        String temp = "";
        for (int i = data.length - 1; i >= 0; i--) {
            temp += data[i];
        }
        return temp;

    }


}

class Cow1 {
    String name;

    String bestCase;
    String worstCase;

    public Cow1() {

    }

    public Cow1(String n, String b, String w) {
        name = n;
        bestCase = b;
        worstCase = w;
    }
}
