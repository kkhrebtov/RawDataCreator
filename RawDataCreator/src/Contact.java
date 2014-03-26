/**
 * Created by kkhrebtov on 1/9/14.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Contact extends InsideSalesObject {

    private String  ownerId = "";
    private String accountId = "";
    private String createdDate = "";
    private String contactFirstName = "";
    private String contactLastName = "";
    private String contactName = "";
    private String contactTitle = "";
    private String contactEmail = "";
    private String contactPhone = "";
    private String eventTs = "";



    private String createdById ="";
    private String lastModifiedDate = "";
    private String lastModifiedById = "";
    private int contactObjectId = 0;



    public Contact(String ownerId, String accountId, String createdDate, String contactFirstName, String contactLastName, String contactTitle, String contactEmail, String contactPhone, String eventTs, String createdById, String lastModifiedDate, String lastModifiedById) {
        this.ownerId   = ownerId;
        this.accountId   = accountId;
        this.createdDate = createdDate;
        this.contactFirstName = contactFirstName;
        this.contactLastName  = contactLastName;
        this.contactName  = contactFirstName + " " + contactLastName;
        this.contactTitle = contactTitle;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.eventTs = eventTs;
        this.createdById = createdById;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedById = lastModifiedById;
        this.contactObjectId = objectId;

        //objectId+=10;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public String getEventTs() {
        return eventTs;
    }

    public String getCreatedById() {
        return createdById;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public int getObjectId() {
        return contactObjectId;
    }

}
