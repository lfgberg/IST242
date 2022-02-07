/*
* Liam Geyer
* IST242 - practice quiz 2
* lfg5289@psu.edu
 */

import java.util.ArrayList;

public abstract class Media {
    enum MediaSize {
        SMALL, MEDIUM, LARGE, NOT_APPLICABLE
    }

    private String title;
    private String subtitle;
    private int id;
    private ArrayList<String> heldBy;

    public Media(){
        this.title = "";
        this.subtitle = "";
        this.id = 0;
        this.heldBy = new ArrayList<>();
    }

    public Media(String title, String subtitle, int id, ArrayList<String> heldBy){
        this.title = title;
        this.subtitle = subtitle;
        this.id = id;
        this.heldBy = heldBy;
    }

    /**
     * Checks out a piece of media
     * @param name the person checking out media
     * @return {@code true} if successfully checked out
     */
    public abstract boolean checkOut(String name);

    /**
     * Returns a piece of media
     * @param name the person returning media
     * @return {@code true} if successful
     */
    public abstract boolean checkIn(String name);

    /**
     * @return list of everyone who's checked out a piece of media
     */
    public ArrayList<String> getHeldBy(){
        return heldBy;
    }

    /**
     * @return the title of a piece of media
     */
    public String getTitle(){
        return title;
    }

    /**
     * Adds someone to the heldBy list
     * @param name the person checking out media
     */
    public void addHeldBy(String name){
        heldBy.add(name);
    }

    /**
     * remove someone from the heldBy list
     * @param name the person returning media
     */
    public void removeHeldBy(String name){
        heldBy.remove(name);
    }
}
