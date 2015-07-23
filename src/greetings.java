import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class greetings {

    public static int[] bCommands;
    public static int[] eCommands;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int nBessie = scn.nextInt();
        int nElsie = scn.nextInt();
        bCommands = new int[nBessie];
        eCommands = new int[nElsie];


        for (int i = 0; i < nBessie; i++) {
            int temp = scn.nextInt();
            char temp2 = scn.next().charAt(0);
            if (temp2 == 'L') {
                temp = temp - temp - temp;
            }
            bCommands[i] = temp;
            scn.nextLine();
        }
        for (int i = 0; i < nElsie; i++) {
            int temp = scn.nextInt();
            char temp2 = scn.next().charAt(0);
            if (temp2 == 'L') {
                temp = temp - temp - temp;
            }
            eCommands[i] = temp;
            scn.nextLine();
        }


        int bIndex = 0;
        int bPos = 0;

        int eIndex = 0;
        int ePos = 0;

        int timesMetUp = -1;

        while (bIndex < nBessie || eIndex < nElsie) {
       //     if (eCommands)
        }


    }
}

