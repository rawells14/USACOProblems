import java.applet.Applet;
import java.awt.*;

public class Painter extends Applet {

    public void paint(Graphics g) {

    }

    public static void drawIt(Graphics g, Polygon p) {
        g.setColor(Color.BLACK);
        g.drawPolygon(p);
    }
}  