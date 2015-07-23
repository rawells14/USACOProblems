import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cowfind {
    public static void main(String[] args) throws FileNotFoundException {
        int amt = 0;
        Scanner scn = new Scanner(new File("InputFIles/10.in"));
        char[] data = scn.nextLine().toCharArray();
        long t1 = System.currentTimeMillis();

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == '(' && data[i + 1] == '(') {
                for (int j = i + 1; j < data.length - 1; j++) {
                    if (data[j] == ')' && data[j + 1] == ')') {
                        amt++;
                    }
                }
            }
        }
        System.out.println("Time:  " + (System.currentTimeMillis() - t1));
        System.out.println(amt);
    }
}
