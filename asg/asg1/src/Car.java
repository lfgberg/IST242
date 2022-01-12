

/*
 * Liam Geyer
 * IST242 - Car Warm Up
 * lfg5289@psu.edu
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Car {

    public static String getModel(Scanner scan) throws Exception{
        String model;

        do {
            //  Prompt the user for the model of the car
            System.out.println("Enter the model of your vehicle: ");

            //  attempt to assign user input
            try {
                model = scan.nextLine();
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }
        } while (model.isEmpty());

        return model;
    }

    public static int getYear(Scanner scan) throws Exception {
        int year = -1;

        do {
            //  Prompt the user for the release year
            System.out.println("Enter the release year of your vehicle: ");

            //  attempt to assign user input
            try {
                year = scan.nextInt();
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }

            //  provide feedback on bad input
            if (year < 0){
                System.out.println("Entered year must be positive.");
            }
        } while (year < 0); //  continue to loop until a positive year is entered

        return year;
    }

    public static ArrayList<String> getTrim(Scanner scan) throws Exception{
        boolean loop = true;
        ArrayList<String> trim = new ArrayList<>();

        do {
            //  Prompt for input
            System.out.println("Enter the vehicle's trim, enter 0 when finished: ");
            String temp;

            //  attempt to get the next line of input
            try {
                temp = scan.next();
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }

            //  either stop looping, or add the line to the collection
            if (temp.equals("0")){
                loop = false;
            } else {
                trim.add(temp);
            }
        } while (loop);

        return trim;
    }

    public static String getType(Scanner scan) throws Exception {

        //  valid car types
        String[] validTypes = {"Truck", "Sedan", "Coupe", "Station Wagon", "Van"};
        boolean loop = true;
        String temp;

        do {
            //  prompt for input
            System.out.println("Enter the vehicle type (Truck/Sedan/Coupe/Station Wagon/Van): ");

            //  attempt to get car type
            try {
                temp = scan.next();
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }

            //  stop looping if the type is valid
            for (String type : validTypes){
                if (temp.equalsIgnoreCase(type)){
                    loop = false;
                }
            }

            //  provide feedback if the input is bad
            if (loop){
                System.out.println("Please enter one of the following types: Truck, Sedan, Coupe, Station Wagon, Van.");
            }
        } while (loop);

        return temp;
    }

    public static double getMPG(Scanner scan) throws Exception {
        double mpg = -1.0;

        do {
            //  prompt for mpg
            System.out.println("Enter the miles per gallon: ");

            //  attempt to assign user input to mpg
            try {
                mpg = scan.nextDouble();
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }

            //  provide feedback on bad input
            if (mpg < 0){
                System.out.println("Entered value must be positive.");
            }
        } while (mpg < 0); //  keep looping until a positive value is entered

        return mpg;
    }

    public static String formatInfo(String model, int releaseYear, ArrayList<String> trim, String type, double mpg){
        String entry = model + "\n" + releaseYear + "\n";

        //  add the trim only if it has an entry
        if (!trim.isEmpty()){
            //  Concat the trim into one line
            String temp = "";
            for (String y : trim){
                temp = temp.concat(y + " ");
            }

            entry = entry + temp + "\n";
        }

        entry = entry + type + "\n" + mpg;
        return entry;
    }

    public static void writeFile(String entry) throws Exception {
        PrintWriter out = null;

        try {
            //  Attempt to write the entry to the car file
            out = new PrintWriter("car.txt");
            out.println(entry);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        } finally {
            //  close the file
            if (out != null) {
                out.close();
            }
        }
    }

    public static void readFile() throws Exception {
        File fileName = new File("car.txt");

        try {
            //  Attempt to read from the file
            Scanner input = new Scanner(fileName);

            //  Read each line of the car file
            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            //  call all of our methods to get info about the car
            String model = getModel(scan);
            int releaseYear = getYear(scan);
            ArrayList<String> trim = getTrim(scan);
            String type = getType(scan);
            double mpg = getMPG(scan);

            //  write the info to a file
            writeFile(formatInfo(model, releaseYear, trim, type, mpg));

            //  display the contents
            readFile();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
