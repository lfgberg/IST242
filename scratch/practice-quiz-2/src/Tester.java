/*
 * Liam Geyer
 * IST242 - practice quiz 2
 * lfg5289@psu.edu
 */

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        Media b = new Book("book name", "book subtitle", 2, new ArrayList<>(), "author", Media.MediaSize.LARGE);
        b.checkIn("Bob Lob");
        b.checkOut("Not Bob Lob");
        b.checkIn("Not Bob Lob");
        b.checkOut("Bob Lob");
    }
}
