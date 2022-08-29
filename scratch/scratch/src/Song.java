import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Song {
    public static void main(String[] args) {
        //  creates a scanner
        Scanner scan = new Scanner(System.in);

        //  creates a list to store our songwriters
        List<String> songWriters = new ArrayList<>();

        System.out.println("Enter the songwriter names:");

        //  loops until loop is set to false by the user entering 'q'
        boolean loop = true;

        while (loop){
            //  takes input from the scanner, adds to the list if the user doesn't quit
            String x = scan.nextLine();
            if (x.equals("q")){
                loop = false;
            } else {
                songWriters.add(x);
            }
        }

        System.out.println(songWriters);
    }
}
