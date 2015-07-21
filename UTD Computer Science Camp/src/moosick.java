import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class moosick {

    public static ArrayList<Integer> indices = new ArrayList();

    public static void main(String[] args) {
        Scanner asdf = new Scanner(System.in);
        int n = asdf.nextInt();
        int[] notes = new int[n];
        for (int i = 0; i < n; i++) {
            notes[i] = asdf.nextInt();
        }
        int c = asdf.nextInt();
        int[] rudiments = new int[c];
        for (int i = 0; i < c; i++) {
            rudiments[i] = asdf.nextInt();
        }

        //main logic
        long t1 = System.currentTimeMillis();
        Arrays.sort(rudiments);

        for (int i = 0; i < notes.length - c + 1; i++) {
            int[] tempNotes = new int[c];
            for (int j = 0; j < c; j++) {
                tempNotes[j] = notes[j + i];
            }

            Arrays.sort(tempNotes);

            int contstant = rudiments[0] - tempNotes[0];
            boolean isConstant = true;
            for (int j = 0; j < tempNotes.length; j++) {
                if (rudiments[j] - tempNotes[j] != contstant) {
                    isConstant = false;
                }
            }

            if (isConstant) {
                indices.add(i + 1);
            }

        }

        System.out.println(indices.size());
        for (int i = 0; i < indices.size(); i++) {
            System.out.println(indices.get(i));
        }
        System.out.println("Time: " + (System.currentTimeMillis()-t1));

    }
}

