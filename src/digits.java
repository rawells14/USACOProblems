import java.lang.Integer;import java.lang.String;import java.lang.System;import java.util.ArrayList;
import java.util.Scanner;

public class digits {

    public static ArrayList<Integer> b2Combos = new ArrayList();
    public static ArrayList<Integer> b3Combos = new ArrayList();

    public static void main(String[] args) {

        Scanner asdf = new Scanner(System.in);
        String b2 = asdf.nextLine();
        String b3 = asdf.nextLine();

        long t1 = System.currentTimeMillis();
        //go through binary combos of mistakes
        for (int i = 0; i < b2.length(); i++) {
            String mistake = null;
            if (b2.substring(i, i + 1).equals("1")) {
                mistake = b2.substring(0, i) + "0" + b2.substring(i + 1, b2.length());

            } else {
                mistake = b2.substring(0, i) + "1" + b2.substring(i + 1, b2.length());
            }


                b2Combos.add(Integer.parseInt(mistake, 2));

        }


        if (b3.substring(0, 1).equals("0")) {
            if (!b3Combos.contains(Integer.parseInt("1" + b3.substring(1, b3.length()), 3)))
                b3Combos.add(Integer.parseInt("1" + b3.substring(1, b3.length()), 3));
            if (!b3Combos.contains(Integer.parseInt("2" + b3.substring(1, b3.length()), 3)))
                b3Combos.add(Integer.parseInt("2" + b3.substring(1, b3.length()), 3));
            b3 = b3.substring(1, b3.length());
        }

        for (int i = 0; i < b3.length(); i++) {
            String mistake = "";
            if (b3.substring(i, i + 1).equals("0")) {
                mistake = b3.substring(0, i) + "1" + b3.substring(i + 1, b3.length());
                b3Combos.add(Integer.parseInt(mistake, 3));

                mistake = "";
                mistake = b3.substring(0, i) + "2" + b3.substring(i + 1, b3.length());

                b3Combos.add(Integer.parseInt(mistake, 3));

                mistake = "";
            }
            if (b3.substring(i, i + 1).equals("1")) {
                mistake = b3.substring(0, i) + "0" + b3.substring(i + 1, b3.length());
                if (!b3Combos.contains(Integer.parseInt(mistake, 3))) {
                    b3Combos.add(Integer.parseInt(mistake, 3));
                }
                mistake = "";
                mistake = b3.substring(0, i) + "2" + b3.substring(i + 1, b3.length());
                if (!b3Combos.contains(Integer.parseInt(mistake, 3))) {
                    b3Combos.add(Integer.parseInt(mistake, 3));
                }
                mistake = "";
            }
            if (b3.substring(i, i + 1).equals("2")) {
                mistake = b3.substring(0, i) + "0" + b3.substring(i + 1, b3.length());
                if (!b3Combos.contains(Integer.parseInt(mistake, 3))) {
                    b3Combos.add(Integer.parseInt(mistake, 3));
                }
                mistake = "";
                mistake = b3.substring(0, i) + "1" + b3.substring(i + 1, b3.length());
                if (!b3Combos.contains(Integer.parseInt(mistake, 3))) {
                    b3Combos.add(Integer.parseInt(mistake, 3));
                }
                mistake = "";
            }
        }
        System.out.println(b2Combos);
        System.out.println(b3Combos);
        for (int i = 0; i < b2Combos.size(); i++) {
            for (int j = 0; j < b3Combos.size(); j++) {
                if (b2Combos.get(i) == b3Combos.get(j)) {
                    System.out.println(b2Combos.get(i) + " " + b3Combos.get(i));
                }
            }
        }
        System.out.println("Time: " + (System.currentTimeMillis() - t1));
    }
}
