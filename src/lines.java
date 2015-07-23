import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class lines {
    public static ArrayList<Cow> cows = new ArrayList<>();
    public static int securityCameras = 3;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/2.in"));
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            cows.add(new Cow(scn.nextInt(), scn.nextInt()));
        }
        doGreatestCommon();
        doGreatestCommon();
        doGreatestCommon();

        if (cows.size() > 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }


    public static int greatestCommonAmt;

    public static void doGreatestCommon() {
        String streakType = "";
        int streak = 0;
        int streakAmt = 0;

        //finds commmon y's
        for (int i = 0; i < cows.size(); i++) {

            streakAmt = 0;
            for (int j = 0; j < cows.size(); j++) {
                if (cows.get(i).xPos == cows.get(j).xPos) {
                    streak = cows.get(i).xPos;
                    streakAmt++;
                }
            }
            if (streakAmt >= greatestCommonAmt) {
                streakType = "x";
                greatestCommonAmt = streakAmt;
            }
        }

        for (int i = 0; i < cows.size(); i++) {

            streakAmt = 0;
            for (int j = 0; j < cows.size(); j++) {
                if (cows.get(i).yPos == cows.get(j).yPos) {
                    streak = cows.get(i).yPos;
                    streakAmt++;
                }
            }
            if (streakAmt >= greatestCommonAmt) {
                streakType = "y";
                greatestCommonAmt = streakAmt;
            }
        }
        removeOnLine(streak, streakType);
        greatestCommonAmt = 0;
    }


    public static void removeOnLine(int val, String axis) {
        for (int i = 0; i < cows.size(); i++) {
            if (axis.equals("x")) {
                if (cows.get(i).xPos == val) {
                    cows.remove(i);
                    i--;
                }
            } else if (axis.equals("y")) {
                if (cows.get(i).yPos == val) {
                    cows.remove(i);
                    i--;
                }
            }
        }
    }
}

class Cow {
    int xPos;
    int yPos;

    public Cow(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }


}
