import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class records {

    public static String[] groups;
    public static int[] occurrences;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int n = scn.nextInt();
        occurrences = new int[n];
        scn.nextLine();
        groups = new String[n];
        for (int i = 0; i < n; i++) {
            groups[i] = scn.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String group = groups[i];
            for (int j = 0; j < n; j++) {

            }
        }
    }
}
