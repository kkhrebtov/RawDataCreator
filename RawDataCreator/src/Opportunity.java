
/**
 * Created by kkhrebtov on 1/9/14.
 */
public class Opportunity  extends InsideSalesObject {
    private String ownerId = "",
                   accountId = "",
                   leadSource = "",
                   eventTs = "",
                   ECD = "",
                   amount = "",
                   name = "",
                   description = "",
                   stageName = "",
                   stageDescription = "";
    private Boolean isClosed = false,
                    isWon = false;
    private int opportunityObjectId = 0;

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
                       Boolean isWon
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
                this.getIsClosed() == this.getIsClosed() &&
                this.getIsWon() == opp.getIsWon() ) result = true;
        return result;
    }


}
