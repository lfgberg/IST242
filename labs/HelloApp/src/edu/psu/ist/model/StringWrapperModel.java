/*
 * Liam Geyer
 * ist242 - Hello World w/MVC
 * lfg5289@psu.edu
 */

package edu.psu.ist.model;

public class StringWrapperModel {
    private String wrappedString = "Hi Everybody";

    /**
     * @return wrappedString
     */
    public String getWrappedString() {
        return wrappedString;
    }

    /**
     * Changes the wrappedString value
     * @param wrappedString new string
     */
    public void setWrappedString(String wrappedString) {
        this.wrappedString = wrappedString;
    }

    /**
     * @return Returns the reverse of the wrappedString
     */
    public String reverseText(){
        return new StringBuilder(wrappedString).reverse().toString();
    }
}
