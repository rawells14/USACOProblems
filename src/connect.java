import java.util.ArrayList;
import java.util.Scanner;

public class connect {
    public static Node[] cows;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        cows = new Node[n];
        for (int i = 0; i < n; i++) {
            cows[i] = new Node(scn.nextInt(), scn.nextInt());
        }

        for (int i = 0; i < cows.length; i++) {
            for (int j = 0; j < cows.length; j++) {
                if (cows[i].x == cows[j].x) {
                    if (cows[i].y > cows[j].y)
                        cows[i].down.add(cows[j]);
                    else
                        cows[i].up.add(cows[j]);
                }
                if (cows[i].y == cows[j].y) {
                    if (cows[i].x > cows[j].x) {
                        cows[i].left.add(cows[j]);
                    } else {
                        cows[i].right.add(cows[j]);
                    }
                }
            }
        }
    }

    public boolean isValidMove(String travelingFrom, String travelingTo) {
        return travelingFrom.equals(travelingTo);
    }
}

class Node {
    public ArrayList<Node> left;
    public ArrayList<Node> right;
    public ArrayList<Node> up;
    public ArrayList<Node> down;

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;

    }


}