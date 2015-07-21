import java.util.Scanner;


public class ctiming {
    public static void main(String[] args) {
        Scanner asdf = new Scanner(System.in);

        int days = asdf.nextInt();
        int hours = asdf.nextInt();
        int minutes = asdf.nextInt();


        int totalMin = 0;

        //convert days into 0 based
        days = days - 11;
        hours = hours - 11;
        minutes = minutes - 11;


        hours += (days * 24);
        minutes += (hours * 60);

        if (minutes < 0)
            System.out.println(-1);
        else{
            System.out.println(minutes);
        }
        //each day after


    }
}
