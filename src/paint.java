import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class paint {
    public static int[] commands;
    public static int currentPosition = 0;
    public static ArrayList<Interval> overlaps = new ArrayList<Interval>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int n = scn.nextInt();
        commands = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int mag = scn.nextInt();
            char dir = scn.next().charAt(0);
            if (dir == 'L') {
                mag = mag - mag - mag;
            }
            commands[i] = mag += commands[i - 1];

        }


        int currentPosition = 0;

        for (int i = 1; i < commands.length; i++) {
            Interval a = new Interval(currentPosition, commands[i]);
            overlaps.add(a);
            connectOverlaps();
            currentPosition += commands[i];
        }


        System.out.println(Arrays.toString(commands));

    }

    public static int getTotalArea() {
        int sum = 0;
        for (int i = 0; i < overlaps.size(); i++) {
            sum += overlaps.get(i).getArea();
        }
        return sum;
    }

    public static void connectOverlaps() {
        if (overlaps.size() > 1) {
            for (int i = overlaps.size() - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (overlaps.get(i).isOverlapping(overlaps.get(j))) {
                        Interval a = overlaps.get(i).combine(overlaps.get(j));
                        overlaps.remove(i);
                        overlaps.remove(j);
                        overlaps.add(a);
                    }
                }
            }
        }
    }
}

class Interval {
    public int start;
    public int end;


    public Interval(int a, int b) {
        this.start = a;
        this.end = b;
    }

    public boolean isOverlapping(Interval i) {
        if (this.start <= i.start && this.end >= i.start) {
            return true;
        }
        if (this.start == i.end)
            return true;
        if (this.end == i.start) {
            return true;
        }
        if (this.start <= i.end && this.end >= i.end)
            return true;
        return false;
    }

    public Interval combine(Interval other) {
        return new Interval(Math.min(this.start, other.start), Math.max(this.end, other.end));
    }

    public int getArea() {
        return end - start;
    }

    public String toString() {
        return "(" + start + " -> " + end + ")";
    }
}
