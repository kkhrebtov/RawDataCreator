/**
 * Created by kkhrebtov on 1/21/14.
 */
public class Account extends InsideSalesObject {
    private String
            ownerId = "",
            accountName = "",
            accountDescription = "",
            accountNumber = "",
            accountSource = "",
            phone = "",
            website = "",
            createdDate = "",
            createdById = "",
            lastModifiedDate = "",
            lastModifiedById = "",
            eventTs = "";

    private int accountObjectId = 0;

    public Account(String ownerId, String accountName, String accountDescription, String createdDate, String accountNumber, String accountSource, String phone, String createdById, String lastModifiedDate, String lastModifiedById, String eventTs) {
        this.ownerId = ownerId;
        this.accountName = accountName;
        this.accountDescription = accountDescription;
        this.accountNumber = accountNumber;
        this.accountSource = accountSource;
        this.phone = phone;
        this.website = "http://www."+accountName.replace(" ", "").toLowerCase()+".com";
        this.createdDate = createdDate;
        this.createdById = createdById;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedById = lastModifiedById;
        this.eventTs = eventTs;
        this.accountObjectId = objectId;
        //objectId+=10;
     }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountSource() {
        return accountSource;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getEventTs() {
        return eventTs;
    }

    public int getAccountObjectId() {
        return accountObjectId;
    }
}
