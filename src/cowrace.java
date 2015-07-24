import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cowrace {

    public static int[] bs;
    public static int[] bt;

    public static int[] es;
    public static int[] et;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("InputFIles/1.in"));
        int n = scn.nextInt();
        int m = scn.nextInt();
        bs = new int[n];
        bt = new int[n];
        es = new int[n];
        et = new int[n];


        for (int i = 0; i < n; i++) {
            bs[i] = scn.nextInt();
            bt[i] = scn.nextInt();
        }
        for (int i = 0; i < m; i++) {
            es[i] = scn.nextInt();
            et[i] = scn.nextInt();
        }

        int bPullAheads = 0;
        int ePullAheads = 0;

        int bpos = 0;
        int epos = 0;

        int bi = 0;
        int ei = 0;

        while (bi < n && ei < m) {
            if (et[ei] == 0){
                ei++;
            }
            if (bt[bi] == 0){
                bi++;
            }




        }


    }
}
