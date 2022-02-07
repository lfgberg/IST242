/*
 * Liam Geyer
 * IST242 - practice quiz 2
 * lfg5289@psu.edu
 */

import java.util.ArrayList;

public class Book extends Media {
    private String author;
    private MediaSize size;

    public Book(){
        super("", "", 0, new ArrayList<>());
        this.author = "";
        this.size = MediaSize.SMALL;
    }

    public Book(String title, String subtitle, int id, ArrayList<String> heldBy,
                String author, MediaSize size){
        super(title, subtitle, id, heldBy);
        this.author = author;
        this.size = size;
    }

    /**
     * Checks out a piece of media
     * @param name the person checking out media
     * @return {@code true} if successfully checked out
     */
    @Override
    public boolean checkOut(String name){
        if (super.getHeldBy().isEmpty()){
            System.out.printf("Checking out %s, by %s\n", super.getTitle(), author);
            super.addHeldBy(name);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a piece of media
     * @param name the person returning media
     * @return {@code true} if successful
     */
    @Override
    public boolean checkIn(String name) {
        if (super.getHeldBy().contains(name)){
            System.out.printf("%s checking in %s\n", name, super.getTitle());
            super.removeHeldBy(name);
            return true;
        } else {
            return false;
        }
    }
}
