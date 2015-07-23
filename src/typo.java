import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class typo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/5.in"));
        String st = scn.nextLine();
        int amt = 0;
        for (int i = 0; i < st.length(); i++) {
            String temp = st;
            if (temp.substring(i, i + 1).equals("(")) {
                temp = temp.substring(0, i) + ")" + temp.substring(i + 1, temp.length());
            } else if (temp.substring(i, i + 1).equals(")")) {
                temp = temp.substring(0, i) + "(" + temp.substring(i + 1, temp.length());
            }
            if (isBalanced(temp))
                amt++;
        }
        System.out.println(amt);

    }

    public static boolean isBalanced(String s) {
        int counter = 0;
        int i = 0;
        while (counter >= 0 && i < s.length()) {
            String temp = s.substring(i, i + 1);
            if (temp.equals("(")) {
                counter++;
            } else if (temp.equals(")")) {
                counter--;
            }
            i++;
            if (counter < 0)
                return false;
        }
        return !(counter != 0);
    }
}
