import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class nocow {

    public static TreeSet<String> possibleCombos = new TreeSet<>();
    public static ArrayList<ArrayList<String>> adjetives = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int n = scn.nextInt();
        int k = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scn.nextLine();
            s = s.substring(19, s.length());
            s = s.substring(0, s.length() - 5);
            String[] temp = s.split(" ");
            for (int j = 0; j < temp.length; j++) {

            }
        }
        System.out.println(adjetives);
    }


    public static void Compute(int index, String[] words) {

    }
}
