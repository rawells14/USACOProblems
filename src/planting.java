import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Scanner;

public class planting extends JApplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Polygon p = new Polygon();
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = scn.nextInt();
            int y1 = scn.nextInt();
            int x2 = scn.nextInt();
            int y2 = scn.nextInt();
            if (!p.contains(x1, y1)) {
                p.addPoint(x1, y1);
            }
            if (!p.contains(x1, y2)) {
                p.addPoint(x1, y2);
            }
            if (!p.contains(x2, y2)) {
                p.addPoint(x2, y2);
            }
            if (!p.contains(x2, y1)) {
                p.addPoint(x2, y1);
            }


        }
        Frame f = new Frame();
        System.out.println(getArea(p));

    }

    public static double getArea(Polygon p) {
        double sum = 0.0;
        int[] xPoints = p.xpoints;
        int[] yPoints = p.ypoints;

        for (int i = 0; i < p.npoints; i++) {
            sum += ((double) Math.abs(xPoints[i]) * Math.abs((double) yPoints[i + 1])) - (Math.abs((double) yPoints[i]) * (double) Math.abs(xPoints[i + 1]));
        }
        return 0.5 * sum;
    }
}
