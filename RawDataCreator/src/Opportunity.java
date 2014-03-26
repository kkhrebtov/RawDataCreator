
/**
 * Created by kkhrebtov on 1/9/14.
 */
public class Opportunity  extends InsideSalesObject {
    private String ownerId = "";
    private String accountId = "";
    private String leadSource = "";
    private String eventTs = "";
    private String ECD = "";
    private String amount = "";
    private String name = "";
    private String description = "";
    private String stageName = "";
    private String stageDescription = "";
    private String createdById="";



    private String lastModifiedDate="";
    private String lastModifiedById="";
    private Boolean isClosed = false,
                    isWon = false;
    private int opportunityObjectId = 0;

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public void setEventTs(String eventTs) {
        this.eventTs = eventTs;
    }

    public void setECD(String ECD) {
        this.ECD = ECD;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public void setIsWon(Boolean isWon) {
        this.isWon = isWon;
    }

    public void setOpportunityObjectId(int opportunityObjectId) {
        this.opportunityObjectId = opportunityObjectId;
    }

    public Opportunity(String ownerId,
                       String accountId,
                       String leadSource,
                       String eventTs,
                       String ECD,
                       String amount,
                       String name,
                       String description,
                       String stageName,
                       String stageDescription,
                       Boolean isClosed,
                       Boolean isWon,
                       String createdById,
                       String lastModifiedDate,
                       String lastModifiedById
                       ) {
       this.ownerId = ownerId;
       this.accountId = accountId;
       this.leadSource = leadSource;
       this.eventTs = eventTs;
       this.ECD = ECD;
       this.amount = amount;
       this.name = name;
       this.description = description;
       this.stageName = stageName;
       this.stageDescription = stageDescription;
       this.isClosed = isClosed;
       this.isWon = isWon;
       this.createdById= createdById;
       this.lastModifiedDate=lastModifiedDate;
       this.lastModifiedById = lastModifiedById;
       this.opportunityObjectId = objectId;
       objectId+=10;

    }

    public String getOwnerId() {return ownerId;}
    public String getAccountId() {return accountId;}
    public String getLeadSource() {return leadSource;}
    public String getEventTs() {return eventTs;}
    public String getECD() {return ECD;}
    public String getAmount() {return amount;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getStageName() {return stageName;}
    public String getStageDescription() {return stageDescription;}
    public String getCreatedById() {return createdById;}
    public String getLastModifiedDate() {return lastModifiedDate;}
    public String getLastModifiedById() {return lastModifiedById;}
    public Boolean getIsClosed() {return isClosed;}
    public Boolean getIsWon() {return isWon;}
    public int getObjectId() {return opportunityObjectId;}

    public Boolean isEqual(Opportunity opp) {
        Boolean result = false;
        if (this.getName() == opp.getName() &&
            this.getOwnerId() == opp.getOwnerId() &&
                this.getAccountId() == opp.getAccountId() &&
                this.getLeadSource() == opp.getLeadSource() &&
                this.getEventTs() == opp.getEventTs() &&
                this.getECD() == opp.getECD() &&
                this.getAmount() == opp.getAmount() &&
                this.getDescription() == opp.getDescription() &&
                this.getStageName() == opp.getStageName()&&
                this.getStageDescription() == opp.getStageDescription() &&
                this.getCreatedById() == opp.getCreatedById() &&
                this.getLastModifiedById() == opp.getLastModifiedById() &&
                this.getLastModifiedDate() == opp.getLastModifiedDate() &&
                this.getIsClosed() == this.getIsClosed() &&
                this.getIsWon() == opp.getIsWon() ) result = true;
        return result;
    }


}
