/**
 * Created by kkhrebtov on 1/9/14.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Contact extends InsideSalesObject {

    private String  accountId = "",
                    createdDate = "",
                    contactFirstName = "",
                    contactLastName = "",
                    contactName = "",
                    contactTitle = "",
                    contactRole = "",
                    contactEmail = "",
                    contactPhone = "",
                    eventTs = "";
    private int contactObjectId = 0;



    public Contact(String accountId, String createdDate, String contactFirstName, String contactLastName, String contactTitle, String contactRole, String contactEmail, String contactPhone, String eventTs) {
        this.accountId   = accountId;
        this.createdDate = createdDate;
        this.contactFirstName = contactFirstName;
        this.contactLastName  = contactLastName;
        this.contactName  = contactFirstName + " " + contactLastName;
        this.contactTitle = contactTitle;
        this.contactRole  = contactRole;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.eventTs = eventTs;
        this.contactObjectId = objectId;
        objectId+=10;
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

    public String getContactRole() {
        return contactRole;
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

    public int getObjectId() {
        return contactObjectId;
    }

}
