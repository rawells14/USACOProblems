import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class wrongdir {

    public static ArrayList<Coordinate> possibleLocations = new ArrayList<>();
    public static ArrayList<Condition> preComputedLocations = new ArrayList<>();

    public static String command;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/7.in"));
        command = scn.nextLine();

        //compute all vals from perfect string


        long time = System.currentTimeMillis();
        for (int i = 0; i < command.length(); i++) {
            String reduced = command.substring(i, command.length());


            if (command.substring(i, i + 1).equals("F")) {
                compute(command.substring(0, i) + "L" + command.substring(i + 1, command.length()));
                compute(command.substring(0, i) + "R" + command.substring(i + 1, command.length()));
            } else if (command.substring(i, i + 1).equals("L")) {
                compute(command.substring(0, i) + "F" + command.substring(i + 1, command.length()));
                compute(command.substring(0, i) + "R" + command.substring(i + 1, command.length()));
            } else if (command.substring(i, i + 1).equals("R")) {
                compute(command.substring(0, i) + "F" + command.substring(i + 1, command.length()));
                compute(command.substring(0, i) + "L" + command.substring(i + 1, command.length()));
            }
        }


        System.out.println(possibleLocations);
        System.out.println(possibleLocations.size());
        System.out.println("Time: " + (System.currentTimeMillis() - time));
    }

    public static void compute(String s) {
        Coordinate c = getLocation(s);
        if (!possibleLocations.contains(c)) {
            possibleLocations.add(c);
        }
    }

    public static int lastDirection = 0;

    public static Coordinate getLocation(String s) {
        int direction = 1; //up: 1, right 2, down 3, left 4
        char[] data = s.toCharArray();
        int x = 0;
        int y = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 'F') {
                if (direction == 1)
                    y++;
                else if (direction == 2)
                    x++;
                else if (direction == 3)
                    y--;
                else if (direction == 4)
                    x--;

                continue;
            } else if (data[i] == 'R') {
                if (direction == 4)
                    direction = 1;
                else
                    direction++;

            } else if (data[i] == 'L') {
                if (direction == 1)
                    direction = 4;
                else
                    direction--;

            }
        }
        lastDirection = direction;
        return new Coordinate(x, y);
    }

    public static void initializeConditions() {
        for (int i = 0; i < command.length(); i++) {
            preComputedLocations.add(new Condition(getLocation(command.substring(i, command.length())), lastDirection));
        }
    }
}


class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Object o) {
        Coordinate c = (Coordinate) (o);
        return this.y == c.getY() && this.x == c.getX();
    }

    public String toString() {
        return "(" + x + ", " + y + ") ";
    }

}

class Condition {
    public Coordinate c;
    public int direction;

    public Condition(Coordinate c, int direction) {
        this.c = c;
        this.direction = direction;
    }

    public String toString() {
        return c.toString() + "--" + this.direction;
    }
}