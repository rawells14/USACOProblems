import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.*;


public class times17 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        out.println(new BigInteger(s.nextLine(), 2).multiply(new BigInteger("17")).toString(2));
    }
}
