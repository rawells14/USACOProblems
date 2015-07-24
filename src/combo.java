import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class combo {
    public static int[] farmerCombo = new int[3];
    public static int[] masterCombo = new int[3];


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int validLocks = 0;
        int n = scn.nextInt();
        for (int i = 0; i < 3; i++) {
            farmerCombo[i] = scn.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            masterCombo[i] = scn.nextInt();
        }

        System.out.println(Arrays.toString(masterCombo));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (isValidPositionFarmer(i, j, k)) {
                        validLocks++;
                    }
                    if (isValidPositionMaster(i, j, k)) {
                        validLocks++;
                    }
                }
                if (isValidPositionFarmer(i,j, 1)||isValidPositionFarmer(i,j,2)){
                    validLocks++;
                }
            }
        }
        System.out.println(validLocks);
    }

    public static boolean isValidPositionFarmer(int a, int b, int c) {
        int[] temp = {a, b, c};
        for (int i = 0; i < 3; i++) {
            if (Math.abs(temp[i] - farmerCombo[i]) > 2) {
                return false;
            }

        }
        return true;
    }

    public static boolean isValidPositionMaster(int a, int b, int c) {


        int[] temp = {a, b, c};
        for (int i = 0; i < 3; i++) {
            if (Math.abs(temp[i] - masterCombo[i]) > 2) {
                return false;
            }

        }
        return true;
    }
}
