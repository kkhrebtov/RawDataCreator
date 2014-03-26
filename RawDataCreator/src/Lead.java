/**
 * Created by kkhrebtov on 1/14/14.
 */
public class Lead  extends InsideSalesObject {

    private String ownerId = "";
    private String convertedAccountId = "";
    private String convertedContactId = "";
    private String convertedOpportunityId = "";
    private String convertedDate = "";
    private String createdDate = "";
    private String company = "";
    private String firstName = "";
    private String lastName = "";
    private String name = "";
    private String title = "";
    private String email ="";
    private String phone="";
    private String status ="";
    private String eventTs = "";
    private String createdById="";
    private String lastModifiedDate="";
    private String lastModifiedById="";

    private Boolean isConverted = false;
    private int leadObjectId = 0;

    public Lead(String ownerId,
                String convertedAccountId,
                String convertedContactId,
                String convertedOpportunityId,
                String convertedDate,
                String createdDate,
                String company,
                String firstName,
                String lastName,
                String title,
                String email,
                String phone,
                String status,
                String eventTs,
                Boolean isConverted,
                String createdById,
                String lastModifiedDate,
                String lastModifiedById

    ) {
        this.ownerId = ownerId;
        this.convertedAccountId = convertedAccountId;
        this.convertedContactId = convertedContactId;
        this.convertedOpportunityId = convertedOpportunityId;
        this.convertedDate = convertedDate;
        this.createdDate = createdDate;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = company + " "+firstName+" "+lastName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.isConverted = isConverted;
        this.eventTs = eventTs;
        this.isConverted = isConverted;
        this.createdById = createdById;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedById = lastModifiedById;
        this.leadObjectId = objectId;
        //objectId+=10;
    }

    public String getOwnerId() {return ownerId;}
    public String getConvertedAccountId() {return convertedAccountId;}
    public String getConvertedContactId() {return convertedContactId;}
    public String getConvertedOpportunityId() {return convertedOpportunityId;}
    public String getConvertedDate() {return convertedDate;}
    public String getCreatedDate() {return createdDate;}
    public String getCompany() {return company;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getName() {return name;}
    public String getTitle() {return title;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    public String getStatus() {return status;}
    public String getEventTs() {return eventTs;}
    public Boolean getIsConverted() {return isConverted;}
    public int getObjectId() {return leadObjectId;}
    public String getCreatedById() {
        return createdById;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }
}
