import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class paint {

    public static ArrayList<Interval> intervals = new ArrayList<>();
    public static int[] commands;


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int n = scn.nextInt();
        int k = scn.nextInt();
        commands = new int[n];

        for (int i = 0; i < n; i++) {
            int magnitude = scn.nextInt();
            char direction = scn.next().charAt(0);
            if (direction == 'L') {
                magnitude = magnitude - magnitude - magnitude;
            }
            commands[i] = magnitude;
        }


        int currentPos = 0;
        for (int i = 0; i < commands.length; i++) {
            int st = Math.min(currentPos, commands[i] + currentPos);
            int en = Math.max(currentPos, commands[i] + currentPos);
            intervals.add(new Interval(st, en, 1));
            currentPos += commands[i];
        }

        combine();


        System.out.println(intervals);
        int amount = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).coats >= k) {
                amount += Math.abs(intervals.get(i).end - intervals.get(i).start);
            }
        }
        System.out.println(amount);
    }

    public static void removeDuplicates() {
        for (int i = intervals.size() - 1; i >= 0; i--) {
            for (int j = i + 1; j < intervals.size() - 1; j++) {
                if (intervals.get(i).equals(intervals.get(j))) {
                    intervals.remove(i);
                }
            }
        }
    }

    public static void combine() {
        int startSize = intervals.size();
        for (int i = 0; i < startSize; i++) {
            for (int j = i + 1; j < startSize - 1; j++) {
                if (overlapping(intervals.get(i), intervals.get(j)) && intervals.get(j).start != intervals.get(j).end) {
                    Interval[] vals = splitUp(intervals.get(i), intervals.get(j));
                    for (int h = 0; h < 3; h++) {
                        if (vals[h].start != vals[h].end) {
                            intervals.add(vals[h]);
                        }
                    }
                }
            }
        }
    }

    public static boolean inRange(int st, int en, int num) {
        return st <= num && en >= num;
    }

    public static boolean overlapping(Interval i1, Interval i2) {
        if (inRange(i1.start, i1.end, i2.start) && inRange(i1.start, i1.end, i2.end)) {
            return true;
        }
        return false;
    }

    public static Interval[] splitUp(Interval i1, Interval i2) {
        Interval[] arr = new Interval[3];
        arr[0] = new Interval(i1.start, i2.start, i1.coats);
        arr[1] = new Interval(i2.start, i2.end, i1.coats + i2.coats);
        arr[2] = new Interval(i1.end, i2.end, i2.coats);
        return arr;
    }


}

class Interval implements Comparable<Interval> {

    int start;
    int end;
    int coats;

    public Interval(int start, int end, int coats) {
        this.start = start;
        this.end = end;
        this.coats = coats;
    }

    //may use later
    public boolean shouldCombine(Interval a) {
        if (this.start <= a.start && this.end >= a.start && this.coats == a.coats) {
            return true;
        }
        return false;
    }

    //public Interval[]
    public String toString() {
        return "(" + this.start + ", " + this.end + ") X" + this.coats;
    }

    public boolean equals(Object o) {
        Interval i = (Interval) (o);
        return this.start == i.start && this.end == i.end;
    }

    public int compareTo(Interval i1) {
        if (this.start - this.end > i1.start - i1.end) {
            return 1;
        }
        if (this.start - this.end == i1.start - i1.end) {
            return 0;
        } else {
            return -1;
        }

    }


}
