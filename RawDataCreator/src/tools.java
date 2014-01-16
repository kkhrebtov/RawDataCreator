import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkhrebtov on 1/14/14.
 */
public class tools extends InsideSalesObject {

    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public static void generateOpportunitiesSQL(ArrayList<Opportunity> createdOpportunities) {

        String SQLexpression1 = "", SQLexpression2="";

        for(int i=0; i<createdOpportunities.size();i++) {
              if(i == 0) {

                  SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                          "("+snapshotId+",'"+createdOpportunities.get(i).getObjectId()+"', "+createdOpportunities.get(i).getEventTs()+"', 'Insert')\n";

                  SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'OwnerId', '"          +createdOpportunities.get(i).getOwnerId()+  "', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'AccountId', '"        +createdOpportunities.get(i).getAccountId()+"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CreateDate', '"       +createdOpportunities.get(i).getEventTs().substring(0, 7)+"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Description', '"      +createdOpportunities.get(i).getDescription()+"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Lead Source', '"      +createdOpportunities.get(i).getLeadSource() +"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Name', '"             +createdOpportunities.get(i).getName()       +"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Amount', '"           +createdOpportunities.get(i).getAmount()     +"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CloseDate', '"        +createdOpportunities.get(i).getECD()        +"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Stage Name', '"       +createdOpportunities.get(i).getStageName()  +"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Stage Description', '"+createdOpportunities.get(i).getStageDescription()+"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsClosed', '"         +createdOpportunities.get(i).getIsClosed()        +"', NULL),\n"+
                          "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsWon', '"            +createdOpportunities.get(i).getIsWon()           +"', NULL)\n";

                  snapshotId+=10;

              } else {

                  Boolean opportunityUpdated = false;
                  int indexOfUpdatedOpportunity = 0;

                  for(int j=i-1; j>=0; j--) {

                      if (createdOpportunities.get(i).getName().toString().equals(createdOpportunities.get(j).getName().toString()) ) {
                          opportunityUpdated = true;
                          indexOfUpdatedOpportunity = j;
                          break;
                      }
                  }

                  if(opportunityUpdated == true) {
                      System.out.println("Update opportunity");
                      SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                              "("+snapshotId+",'"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', "+createdOpportunities.get(i).getEventTs()+"', 'Insert')\n";

                      SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'OwnerId', '"+createdOpportunities.get(i).getOwnerId()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getOwnerId()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'AccountId', '"+createdOpportunities.get(i).getAccountId()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getAccountId()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CreateDate', '"+createdOpportunities.get(i).getEventTs().substring(0, 7)+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getEventTs().substring(0, 7)+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Description', '"+createdOpportunities.get(i).getDescription()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getDescription()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Lead Source', '"+createdOpportunities.get(i).getLeadSource()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getLeadSource()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Name', '"+createdOpportunities.get(i).getName()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getName()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Amount', '"+createdOpportunities.get(i).getAmount()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getAmount()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CloseDate', '"+createdOpportunities.get(i).getECD()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getECD()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Stage Name', '"+createdOpportunities.get(i).getStageName()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getStageName()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Stage Description', '"+createdOpportunities.get(i).getStageDescription()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getStageDescription()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'IsClosed', '"+createdOpportunities.get(i).getIsClosed()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getIsClosed()+"'),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'IsWon', '"+createdOpportunities.get(i).getIsWon()+"', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getIsWon()+"'),\n";
                      snapshotId+=10;

                  } else {
                      System.out.println("Insert new opportunity");
                      SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                              "("+snapshotId+",'"+createdOpportunities.get(i).getObjectId()+"', "+createdOpportunities.get(i).getEventTs()+"', 'Insert')\n";


                      SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'OwnerId', '"+createdOpportunities.get(i).getOwnerId()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'AccountId', '"+createdOpportunities.get(i).getAccountId()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CreateDate', '"+createdOpportunities.get(i).getEventTs().substring(0, 7)+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Description', '"+createdOpportunities.get(i).getDescription()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Lead Source', '"+createdOpportunities.get(i).getLeadSource()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Name', '"+createdOpportunities.get(i).getName()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Amount', '"+createdOpportunities.get(i).getAmount()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CloseDate', '"+createdOpportunities.get(i).getECD()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Stage Name', '"+createdOpportunities.get(i).getStageName()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Stage Description', '"+createdOpportunities.get(i).getStageDescription()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsClosed', '"+createdOpportunities.get(i).getIsClosed()+"', NULL),\n"+
                              "("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsWon', '"+createdOpportunities.get(i).getIsWon()+"', NULL)\n";
                      snapshotId+=10;

                  }
              }

            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);
          }
    }


    public static void generateLeadsSQL(ArrayList<Lead> createdLeads) {

        String SQLexpression1 = "", SQLexpression2= "";

        for(int i=0; i<createdLeads.size();i++) {
            if(i == 0) {
                System.out.println("Insert first new Lead");
                SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                        "("+snapshotId+",'"+createdLeads.get(i).getObjectId()+"', "+createdLeads.get(i).getEventTs()+"', 'Insert')\n";


                SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'OwnerId', '"               +createdLeads.get(i).getOwnerId()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedAccountId', '"    +createdLeads.get(i).getConvertedAccountId()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedContactId', '"    +createdLeads.get(i).getConvertedContactId().substring(0, 7)+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedOpportunityId', '"+createdLeads.get(i).getConvertedOpportunityId()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedDate', '"         +createdLeads.get(i).getConvertedDate()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'CreatedDate', '"           +createdLeads.get(i).getCreatedDate()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Company', '"               +createdLeads.get(i).getCompany()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'First Name', '"            +createdLeads.get(i).getFirstName()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Last Name', '"             +createdLeads.get(i).getLastName()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Name', '"                  +createdLeads.get(i).getName()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Title', '"                 +createdLeads.get(i).getTitle()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Email', '"                 +createdLeads.get(i).getEmail()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Phone', '"                 +createdLeads.get(i).getPhone()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Status', '"                +createdLeads.get(i).getStatus()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'IsConverted', '"           +createdLeads.get(i).getIsConverted()+"', '"+"', NULL),\n";

                snapshotId+=10;

            } else {

                Boolean leadUpdated = false;
                int indexOfUpdatedLead = 0;

                for(int j=i-1; j>=0; j--) {

                    if (createdLeads.get(i).getName().toString().equals(createdLeads.get(j).getName().toString()) ) {
                        leadUpdated = true;
                        indexOfUpdatedLead = j;
                        break;
                    }
                }

                if(leadUpdated == true) {
                    System.out.println("Update Lead");
                    SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                            "("+snapshotId+",'"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', "+createdLeads.get(i).getEventTs()+"', 'Insert')\n";

                    SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'OwnerId', '"               +createdLeads.get(i).getOwnerId()+"', '"+createdLeads.get(indexOfUpdatedLead).getOwnerId()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedAccountId', '"    +createdLeads.get(i).getConvertedAccountId()+"', '"+createdLeads.get(indexOfUpdatedLead).getConvertedAccountId()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedContactId', '"    +createdLeads.get(i).getConvertedContactId().substring(0, 7)+"', '"+createdLeads.get(indexOfUpdatedLead).getConvertedContactId().substring(0, 7)+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedOpportunityId', '"+createdLeads.get(i).getConvertedOpportunityId()+"', '"+createdLeads.get(indexOfUpdatedLead).getConvertedOpportunityId()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedDate', '"         +createdLeads.get(i).getConvertedDate()+"', '"+createdLeads.get(indexOfUpdatedLead).getConvertedDate()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'CreatedDate', '"           +createdLeads.get(i).getCreatedDate()+"', '"+createdLeads.get(indexOfUpdatedLead).getCreatedDate()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Company', '"               +createdLeads.get(i).getCompany()+"', '"+createdLeads.get(indexOfUpdatedLead).getCompany()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'First Name', '"            +createdLeads.get(i).getFirstName()+"', '"+createdLeads.get(indexOfUpdatedLead).getFirstName()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Last Name', '"             +createdLeads.get(i).getLastName()+"', '"+createdLeads.get(indexOfUpdatedLead).getLastName()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Name', '"                  +createdLeads.get(i).getName()+"', '"+createdLeads.get(indexOfUpdatedLead).getName()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Title', '"                 +createdLeads.get(i).getTitle()+"', '"+createdLeads.get(indexOfUpdatedLead).getTitle()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Email', '"                 +createdLeads.get(i).getEmail()+"', '"+createdLeads.get(indexOfUpdatedLead).getEmail()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Phone', '"                 +createdLeads.get(i).getPhone()+"', '"+createdLeads.get(indexOfUpdatedLead).getPhone()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Status', '"                +createdLeads.get(i).getStatus()+"', '"+createdLeads.get(indexOfUpdatedLead).getStatus()+"'),\n"+
                            "("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'IsConverted', '"           +createdLeads.get(i).getIsConverted()+"', '"+createdLeads.get(indexOfUpdatedLead).getIsConverted()+"'),\n";
                    snapshotId+=10;
                } else {
                    System.out.println("Insert new Lead");
                    SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                            "("+snapshotId+",'"+createdLeads.get(i).getObjectId()+"', "+createdLeads.get(i).getEventTs()+"', 'Insert')\n";


                    SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'OwnerId', '"               +createdLeads.get(i).getOwnerId()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedAccountId', '"    +createdLeads.get(i).getConvertedAccountId()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedContactId', '"    +createdLeads.get(i).getConvertedContactId().substring(0, 7)+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedOpportunityId', '"+createdLeads.get(i).getConvertedOpportunityId()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedDate', '"         +createdLeads.get(i).getConvertedDate()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'CreatedDate', '"           +createdLeads.get(i).getCreatedDate()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Company', '"               +createdLeads.get(i).getCompany()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'First Name', '"            +createdLeads.get(i).getFirstName()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Last Name', '"             +createdLeads.get(i).getLastName()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Name', '"                  +createdLeads.get(i).getName()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Title', '"                 +createdLeads.get(i).getTitle()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Email', '"                 +createdLeads.get(i).getEmail()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Phone', '"                 +createdLeads.get(i).getPhone()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Status', '"                +createdLeads.get(i).getStatus()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'IsConverted', '"           +createdLeads.get(i).getIsConverted()+"', '"+"', NULL),\n";
                    snapshotId+=10;

                }
            }

            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);
        }
    }

    public static void generateContactsSQL(ArrayList<Contact> createdContacts) {

        String SQLexpression1 = "", SQLexpression2= "";

        for(int i=0; i<createdContacts.size();i++) {
            if(i == 0) {
                System.out.println("Insert first new Lead");
                SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                        "("+snapshotId+",'"+createdContacts.get(i).getObjectId()+"', "+createdContacts.get(i).getEventTs()+"', 'Insert')\n";


                SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'AccountId', '"   +createdContacts.get(i).getAccountId()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedDate', '" +createdContacts.get(i).getCreatedDate()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Email', '"       +createdContacts.get(i).getContactEmail()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'First Name', '"  +createdContacts.get(i).getContactFirstName()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Last Name', '"   +createdContacts.get(i).getContactLastName()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Name', '"        +createdContacts.get(i).getContactName()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Title', '"       +createdContacts.get(i).getContactTitle()+"', '"+"', NULL),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Phone', '"       +createdContacts.get(i).getContactPhone()+"', '"+"', NULL),\n";

                snapshotId+=10;

            } else {

                Boolean contactUpdated = false;
                int indexOfUpdatedContact = 0;

                for(int j=i-1; j>=0; j--) {

                    if (createdContacts.get(i).getContactName().toString().equals(createdContacts.get(j).getContactName().toString()) ) {
                        contactUpdated = true;
                        indexOfUpdatedContact = j;
                        break;
                    }
                }

                if(contactUpdated == true) {
                    System.out.println("Update Contact");
                    SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                            "("+snapshotId+",'"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', "+createdContacts.get(i).getEventTs()+"', 'Insert')\n";

                    SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'AccountId', '"   +createdContacts.get(i).getAccountId()+               "', '"+createdContacts.get(indexOfUpdatedContact).getAccountId()+"'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedDate', '" +createdContacts.get(i).getCreatedDate()+    "', '"+createdContacts.get(indexOfUpdatedContact).getCreatedDate()+"'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Email', '"       +createdContacts.get(i).getContactEmail()+    "', '"+createdContacts.get(indexOfUpdatedContact).getContactEmail()+"'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'First Name', '"  +createdContacts.get(i).getContactFirstName()+"', '"+createdContacts.get(indexOfUpdatedContact).getContactFirstName()+"'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Last Name', '"   +createdContacts.get(i).getContactLastName()+         "', '"+createdContacts.get(indexOfUpdatedContact).getContactLastName()+"'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Name', '"        +createdContacts.get(i).getContactName()+           "', '"+createdContacts.get(indexOfUpdatedContact).getContactName()+"'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Title', '"       +createdContacts.get(i).getContactTitle()+               "', '"+createdContacts.get(indexOfUpdatedContact).getContactTitle()+"'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Phone', '"       +createdContacts.get(i).getContactPhone()+             "', '"+createdContacts.get(indexOfUpdatedContact).getContactPhone()+"'),\n";
                    snapshotId+=10;
                } else {
                    System.out.println("Insert new Contact");
                    SQLexpression1 = "INSERT INTO SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts, operation) VALUES \n"+
                            "("+snapshotId+",'"+createdContacts.get(i).getObjectId()+"', "+createdContacts.get(i).getEventTs()+"', 'Insert')\n";


                    SQLexpression2 = "INSERT INTO SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'AccountId', '"   +createdContacts.get(i).getAccountId()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedDate', '" +createdContacts.get(i).getCreatedDate()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Email', '"       +createdContacts.get(i).getContactEmail()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'First Name', '"  +createdContacts.get(i).getContactFirstName()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Last Name', '"   +createdContacts.get(i).getContactLastName()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Name', '"        +createdContacts.get(i).getContactName()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Title', '"       +createdContacts.get(i).getContactTitle()+"', '"+"', NULL),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Phone', '"       +createdContacts.get(i).getContactPhone()+"', '"+"', NULL),\n";
                    snapshotId+=10;

                }
            }

            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);
        }
    }

}
