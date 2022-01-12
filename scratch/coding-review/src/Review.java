/*
* Liam Geyer
* IST242 - Coding Review
* lfg5289@psu.edu
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Review {
    public static int promptForArraySize(Scanner scan) throws Exception {
        int num = -1;

        do {
            System.out.println("Enter the size of the array:");

            //  attempt to get input from the user
            try {
                num = scan.nextInt();
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }

            //  provide feedback on bad input
            if (num <= 0){
                System.out.println("Array size must be positive.");
            }
        } while (num <= 0); // loop until positive number returned

        return num;
    }

    public static int[] generateRandArray(int size){
        int[] randArray = new int[size];

        //  add (size) rand numbers
        for (int i = 0; i < size - 1; i++){
            int rand = (int) (Math.random() * 9) + 1;
            randArray[i] = rand;
        }

        return randArray;
    }

    public static String reportParity(int[] randArray){
        //  create an array to store whether each int is even
        boolean[] parity = new boolean[randArray.length];

        //  determine what ints are even
        for (int i = 0; i < randArray.length - 1; i++){
            boolean isEven = (randArray[i] % 2 == 0);
            parity[i] = isEven;
        }

        boolean hasEven = false;
        boolean hasOdd = false;

        //  find out whether there's a mixture or not
        for (boolean x : parity){
            if (x){
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        String status = "";

        //  return the appropriate string
        if (hasEven && hasOdd){
            status = "mixture";
        } else if (hasEven && !hasOdd){
            status =  "all even";
        } else if (hasOdd && !hasEven){
            status = "all odd";
        }

        return status;
    }

    public static void writeReport(int[] randArray) throws Exception {
        PrintWriter out = null;

        try {
            //  write each entry in the array to a report file
            out = new PrintWriter("report.txt");
            for (int num : randArray){
                out.println(num);
            }
            out.println(reportParity(randArray));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        } finally {
            //  close the file
            if (out != null) {
                out.close();
            }
        }
    }

    public static void readReport() throws Exception {
        File fileName = new File("report.txt");

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
            int arraySize = promptForArraySize(scan);
            int[] randArray = generateRandArray(arraySize);
            writeReport(randArray);
            readReport();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
