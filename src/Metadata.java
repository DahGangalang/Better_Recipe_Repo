/*
 * Class for tracking Recipe Metadata
 */

package src;

import java.util.GregorianCalendar;
import java.util.Date;

public class Metadata {
 
    //Class Fields
    private Date creationDate;
    private Date modifiedTime;
    private String userCreation;
    private String userLastModified;

    //Constructr
    public Metadata() {

        //Establish creation dates
        this.creationDate = (new GregorianCalendar()).getTime();
        this.modifiedTime = creationDate;

        //Not really implemented
        try {
            this.userCreation = System.getProperty("user.name");
            this.userLastModified = this.userCreation;
        } catch(Exception e) {
            this.userCreation = "Unable to Retrieve";
            this.userLastModified = "Unable to Retrieve";
            e.printStackTrace();
        }

    } //End Constructor

    //Getters
    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public String getUserLastModified() {
        return userLastModified;
    }

    //Setters
    public void setModifiedTime() {
        this.modifiedTime = (new GregorianCalendar()).getTime();
    }

    public void setUserLastModified() {
        this.userLastModified = System.getProperty("user.name");
    }

} //End of Metadata
