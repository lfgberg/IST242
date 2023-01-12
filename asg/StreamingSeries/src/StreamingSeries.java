import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StreamingSeries {

    enum GENRE {
        HORROR,
        SCIFI,
        ROMANCE,
        TRUECRIME
    }

    public static String promptTitle(Scanner scan){
        System.out.println("Enter a series title: ");
        return scan.nextLine();
    }

    public static double promptLength(Scanner scan){

        double runtime = -1.0;

        do {
            System.out.println("Enter a positive nonzero runtime in minutes: ");
            runtime = scan.nextDouble();
        } while (runtime <= 0);

        return runtime;
    }

    public static ArrayList<String> promptEpisodes(Scanner scan){
        ArrayList<String> result = new ArrayList<>();

        System.out.println("Enter episode list; enter the season-num first and" +
                " then the title. Enter -1 for a season-num to stop");

        int lastNum = 0;

        while (true){
            int num = scan.nextInt();
            String name = scan.nextLine().trim();

            if (num == -1){
                break;
            } else if (num <= lastNum){
                System.out.println("Err: season numbers can't decrease");
            } else {
                lastNum = num;
                result.add("S" + num + " " + name);
            }
        }

        return result;
    }

    public static GENRE promptGenre(Scanner scan){
        while (true){
            System.out.println("Enter a genre (HORROR, SCI-FI, ROMANCE, TRUE-CRIME): ");

            String genre = scan.nextLine().toLowerCase();
            switch (genre) {
                case "horror" -> {return GENRE.HORROR;}
                case "sci-fi" -> {return GENRE.SCIFI;}
                case "romance" -> {return GENRE.ROMANCE;}
                case "true-crime" -> {return GENRE.TRUECRIME;}
                default -> {
                    System.out.println("Err: valid choices are HORROR, SCI-FI, ROMANCE, TRUE-CRIME");
                }
            }
        }
    }

    public static void writeSeasonsData(String filename, String title, GENRE genre,
                                        double runtime, ArrayList<String> episodes) throws Exception {
        try (PrintWriter out = new PrintWriter(filename)) {
            //  Attempt to write each line to a file

            out.printf("Title: %s\nGenre: %s\nRuntime: %.2f\n\nEpisodes:\n\n", title, genre, runtime);

            for (String s : episodes) {
                out.println(s);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        //  close the file
    }

    public static void readSeasonsData(String filename) throws Exception {
        File fileName = new File(filename);

        try {
            //  Attempt to read from the file
            Scanner input = new Scanner(fileName);

            //  Read each line of the file
            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String title = promptTitle(scan);
        double runtime = promptLength(scan);
        ArrayList<String> episodes = promptEpisodes(scan);
        GENRE genre = promptGenre(scan);

        try {
            writeSeasonsData("season-data.txt", title, genre, runtime, episodes);
            readSeasonsData("season-data.txt");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
