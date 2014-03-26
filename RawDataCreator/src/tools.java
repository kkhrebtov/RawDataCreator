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

        String SQLexpression1 = "", SQLexpression2="",SQLexpression3="";

        for(int i=0; i<createdOpportunities.size();i++) {
              if(i == 0) {

                  SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                          "\t\t("+snapshotId+",'"+createdOpportunities.get(i).getObjectId()+"', 'Opportunity', '"+createdOpportunities.get(i).getEventTs()+"')\n";

                  SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value) VALUES\n" +
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'OwnerId',          '"      +createdOpportunities.get(i).getOwnerId()    +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'AccountId',        '"      +createdOpportunities.get(i).getAccountId()  +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CreatedDate',      '"      +createdOpportunities.get(i).getEventTs()    +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Description',      '"      +createdOpportunities.get(i).getDescription()+"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'LeadSource',       '"      +createdOpportunities.get(i).getLeadSource() +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Name',             '"      +createdOpportunities.get(i).getName()       +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Amount',           '"      +createdOpportunities.get(i).getAmount()     +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CloseDate',        '"      +createdOpportunities.get(i).getECD()        +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'StageName',        '"      +createdOpportunities.get(i).getStageName()  +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'StageDescription', '" +createdOpportunities.get(i).getStageDescription()+"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsClosed',         '"      +createdOpportunities.get(i).getIsClosed()   +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsWon',            '"      +createdOpportunities.get(i).getIsWon()      +"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CreatedById',      '"      +createdOpportunities.get(i).getCreatedById()+"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'LastModifiedDate', '" +createdOpportunities.get(i).getLastModifiedDate()+"'),\n"+
                          "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'LastModifiedById', '" +createdOpportunities.get(i).getLastModifiedById()+"')\n";

                  snapshotId+=10;
                  objectId+=10;
              } else {

                  Boolean opportunityUpdated = false;
                  int indexOfUpdatedOpportunity = 0;

                  for(int j=i-1; j>=0; j--) {

                      if (createdOpportunities.get(i).getName().equals(createdOpportunities.get(j).getName()) ) {
                          opportunityUpdated = true;
                          indexOfUpdatedOpportunity = j;
                          break;
                      }
                  }

                  if(opportunityUpdated) {
                      System.out.println("Update opportunity");
                      SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                              "("+snapshotId+",'"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Opportunity', '"+createdOpportunities.get(i).getEventTs()+"')\n";


                      SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value) VALUES\n" +
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'OwnerId',          '"      +createdOpportunities.get(i).getOwnerId()    +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'AccountId',        '"      +createdOpportunities.get(i).getAccountId()  +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CreatedDate',      '"      +createdOpportunities.get(i).getEventTs()    +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Description',      '"      +createdOpportunities.get(i).getDescription()+"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'LeadSource',       '"      +createdOpportunities.get(i).getLeadSource() +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Name',             '"      +createdOpportunities.get(i).getName()       +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Amount',           '"      +createdOpportunities.get(i).getAmount()     +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CloseDate',        '"      +createdOpportunities.get(i).getECD()        +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'StageName',        '"      +createdOpportunities.get(i).getStageName()  +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'StageDescription', '" +createdOpportunities.get(i).getStageDescription()+"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'IsClosed',         '"      +createdOpportunities.get(i).getIsClosed()   +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'IsWon',            '"      +createdOpportunities.get(i).getIsWon()      +"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CreatedById',      '"      +createdOpportunities.get(i).getCreatedById()+"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'LastModifiedDate', '" +createdOpportunities.get(i).getLastModifiedDate()+"'),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'LastModifiedById', '" +createdOpportunities.get(i).getLastModifiedById()+"')\n";




                      SQLexpression3 = "INSERT INTO SFDC_SNAPSHOT_DATA_OLD(snapshot_id, object_id, attr_name, attr_old_value) VALUES \n";

                       if(!createdOpportunities.get(i).getOwnerId().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getOwnerId())) {
                           SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'OwnerId', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getOwnerId()+"'),\n";
                       }

                      if(!createdOpportunities.get(i).getAccountId().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getAccountId())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'AccountID', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getAccountId()+"'),\n";
                      }

                      if(!createdOpportunities.get(i).getEventTs().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getEventTs())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CreatedDate', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getEventTs()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getDescription().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getDescription())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Description', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getAccountId()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getLeadSource().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getLeadSource())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'LeadSource', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getLeadSource()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getName().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getName())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Name', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getName()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getAmount().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getAmount())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'Amount', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getAmount()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getECD().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getECD())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CloseDate', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getECD()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getStageName().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getStageName())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'StageName', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getStageName()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getStageDescription().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getStageDescription())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'StageDescription', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getStageDescription()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getIsClosed().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getIsClosed())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'IsClosed', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getIsClosed()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getIsWon().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getIsWon())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'IsWon', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getIsWon()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getCreatedById().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getCreatedById())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'CreatedById', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getCreatedById()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getLastModifiedDate().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getLastModifiedDate())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'LastModifiedDate', '"+createdOpportunities.get(indexOfUpdatedOpportunity).getLastModifiedDate()+"'),\n";
                      }

                      if(createdOpportunities.get(i).getLastModifiedById().equals(createdOpportunities.get(indexOfUpdatedOpportunity).getLastModifiedById())) {
                          SQLexpression3+="\t\t("+snapshotId+", '"+createdOpportunities.get(indexOfUpdatedOpportunity).getObjectId()+"', 'LastModifiedById',  '"+createdOpportunities.get(indexOfUpdatedOpportunity).getLastModifiedById()+"')\n";
                      }

                     snapshotId+=10;

                  } else {
                      System.out.println("Insert new opportunity");
                      SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                              "("+snapshotId+",'"+createdOpportunities.get(i).getObjectId()+"', 'Opportunity', '"+createdOpportunities.get(i).getEventTs()+"')\n";


                      SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value, attr_old_value) VALUES\n" +
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'OwnerId',          '"+createdOpportunities.get(i).getOwnerId()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'AccountID',        '"+createdOpportunities.get(i).getAccountId()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CreatedDate',      '"+createdOpportunities.get(i).getEventTs().substring(0, 10)+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Description',      '"+createdOpportunities.get(i).getDescription()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'LeadSource',       '"+createdOpportunities.get(i).getLeadSource()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Name',             '"+createdOpportunities.get(i).getName()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'Amount',           '"+createdOpportunities.get(i).getAmount()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CloseDate',        '"+createdOpportunities.get(i).getECD()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'StageName',        '"+createdOpportunities.get(i).getStageName()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'StageDescription', '"+createdOpportunities.get(i).getStageDescription()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsClosed',         '"+createdOpportunities.get(i).getIsClosed()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'IsWon',            '"+createdOpportunities.get(i).getIsWon()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'CreatedById',      '"+createdOpportunities.get(i).getCreatedById()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'LastModifiedDate', '" +createdOpportunities.get(i).getLastModifiedDate()+"', NULL),\n"+
                              "\t\t("+snapshotId+", '"+createdOpportunities.get(i).getObjectId()+"', 'LastModifiedById', '" +createdOpportunities.get(i).getLastModifiedById()+"', NULL)\n";
                      snapshotId+=10;
                      objectId+=10;
                  }
              }

            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);
            System.out.println(SQLexpression3);
          }
    }


    public static void generateLeadsSQL(ArrayList<Lead> createdLeads) {

        String SQLexpression1 = "", SQLexpression2= "", SQLexpression3= "";

        for(int i=0; i<createdLeads.size();i++) {
            if(i == 0) {
                System.out.println("Insert first new Lead");

                SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                        "("+snapshotId+",'"+createdLeads.get(i).getObjectId()+"', 'Lead', '"+createdLeads.get(i).getEventTs()+"')\n";


                SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value) VALUES\n" +
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'OwnerId',                '"+createdLeads.get(i).getOwnerId()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedAccountID',     '"+createdLeads.get(i).getConvertedAccountId()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedContactId',     '"+createdLeads.get(i).getConvertedContactId()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedOpportunityId', '"+createdLeads.get(i).getConvertedOpportunityId()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedDate',          '"+createdLeads.get(i).getConvertedDate()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'CreatedDate',            '"+createdLeads.get(i).getCreatedDate()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Company',                '"+createdLeads.get(i).getCompany()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'FirstName',              '"+createdLeads.get(i).getFirstName()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'LastName',               '"+createdLeads.get(i).getLastName()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Name',                   '"+createdLeads.get(i).getName()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Title',                  '"+createdLeads.get(i).getTitle()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Email',                  '"+createdLeads.get(i).getEmail()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Phone',                  '"+createdLeads.get(i).getPhone()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Status',                 '"+createdLeads.get(i).getStatus()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'IsConverted',            '"+createdLeads.get(i).getIsConverted()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'CreatedById',            '"+createdLeads.get(i).getCreatedById()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'LastModifiedDate',       '"+createdLeads.get(i).getLastModifiedDate()+"'),\n"+
                        "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'LastModifiedById',       '"+createdLeads.get(i).getLastModifiedById()+"')\n";
                objectId+=10;
                snapshotId+=10;

            } else {

                Boolean leadUpdated = false;
                int indexOfUpdatedLead = 0;

                for(int j=i-1; j>=0; j--) {

                    if (createdLeads.get(i).getName().equals(createdLeads.get(j).getName()) ) {
                        leadUpdated = true;
                        indexOfUpdatedLead = j;
                        break;
                    }
                }

                if(leadUpdated) {
                    System.out.println("Update Lead");
                    SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                            "("+snapshotId+",'"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Lead', '"+createdLeads.get(i).getEventTs()+"')\n";

                    SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value, attr_old_value) VALUES\n" +
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'OwnerId',                '"+createdLeads.get(i).getOwnerId()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedAccountID',     '"+createdLeads.get(i).getConvertedAccountId()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedContactId',     '"+createdLeads.get(i).getConvertedContactId()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedOpportunityId', '"+createdLeads.get(i).getConvertedOpportunityId()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'ConvertedDate',          '"+createdLeads.get(i).getConvertedDate()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'CreatedDate',            '"+createdLeads.get(i).getCreatedDate()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Company',                '"+createdLeads.get(i).getCompany()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'FirstName',              '"+createdLeads.get(i).getFirstName()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'LastName',               '"+createdLeads.get(i).getLastName()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Name',                   '"+createdLeads.get(i).getName()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Title',                  '"+createdLeads.get(i).getTitle()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Email',                  '"+createdLeads.get(i).getEmail()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Phone',                  '"+createdLeads.get(i).getPhone()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'Status',                 '"+createdLeads.get(i).getStatus()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'IsConverted',            '"+createdLeads.get(i).getIsConverted()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'CreatedById',            '"+createdLeads.get(i).getCreatedById()+"'),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'LastModifiedDate',       '"+createdLeads.get(i).getLastModifiedDate()+"),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'LastModifiedById',       '"+createdLeads.get(i).getLastModifiedById()+")\n";

                    SQLexpression3 = "INSERT INTO SFDC_SNAPSHOT_DATA_OLD(snapshot_id, object_id, attr_name, attr_old_value) VALUES \n";

                    if(!createdLeads.get(i).getOwnerId().equals(createdLeads.get(indexOfUpdatedLead).getOwnerId())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getObjectId()+"', 'OwnerId', '"+createdLeads.get(indexOfUpdatedLead).getOwnerId()+"'),\n";
                    }
                    if(!createdLeads.get(i).getConvertedAccountId().equals(createdLeads.get(indexOfUpdatedLead).getConvertedAccountId())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getConvertedAccountId()+"', 'ConvertedAccountID', '"+createdLeads.get(indexOfUpdatedLead).getConvertedAccountId()+"'),\n";
                    }
                    if(!createdLeads.get(i).getConvertedContactId().equals(createdLeads.get(indexOfUpdatedLead).getConvertedContactId())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getConvertedContactId()+"', 'ConvertedContactId', '"+createdLeads.get(indexOfUpdatedLead).getConvertedContactId()+"'),\n";
                    }
                    if(!createdLeads.get(i).getConvertedOpportunityId().equals(createdLeads.get(indexOfUpdatedLead).getConvertedOpportunityId())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getConvertedOpportunityId()+"', 'ConvertedOpportunityId', '"+createdLeads.get(indexOfUpdatedLead).getConvertedOpportunityId()+"'),\n";
                    }
                    if(!createdLeads.get(i).getConvertedDate().equals(createdLeads.get(indexOfUpdatedLead).getConvertedDate())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getConvertedDate()+"', 'ConvertedDate', '"+createdLeads.get(indexOfUpdatedLead).getConvertedDate()+"'),\n";
                    }
                    if(!createdLeads.get(i).getCreatedDate().equals(createdLeads.get(indexOfUpdatedLead).getCreatedDate())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getCreatedDate()+"', 'CreatedDate', '"+createdLeads.get(indexOfUpdatedLead).getCreatedDate()+"'),\n";
                    }
                    if(!createdLeads.get(i).getCompany().equals(createdLeads.get(indexOfUpdatedLead).getCompany())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getCompany()+"', 'Company', '"+createdLeads.get(indexOfUpdatedLead).getCompany()+"'),\n";
                    }
                    if(!createdLeads.get(i).getFirstName().equals(createdLeads.get(indexOfUpdatedLead).getFirstName())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getFirstName()+"', 'FirstName', '"+createdLeads.get(indexOfUpdatedLead).getFirstName()+"'),\n";
                    }
                    if(!createdLeads.get(i).getLastName().equals(createdLeads.get(indexOfUpdatedLead).getLastName())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getLastName()+"', 'LastName', '"+createdLeads.get(indexOfUpdatedLead).getLastName()+"'),\n";
                    }
                    if(!createdLeads.get(i).getName().equals(createdLeads.get(indexOfUpdatedLead).getName())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getName()+"', 'Name', '"+createdLeads.get(indexOfUpdatedLead).getName()+"'),\n";
                    }
                    if(!createdLeads.get(i).getTitle().equals(createdLeads.get(indexOfUpdatedLead).getTitle())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getTitle()+"', 'Title', '"+createdLeads.get(indexOfUpdatedLead).getTitle()+"'),\n";
                    }
                    if(!createdLeads.get(i).getEmail().equals(createdLeads.get(indexOfUpdatedLead).getEmail())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getEmail()+"', 'Email', '"+createdLeads.get(indexOfUpdatedLead).getEmail()+"'),\n";
                    }
                    if(!createdLeads.get(i).getPhone().equals(createdLeads.get(indexOfUpdatedLead).getPhone())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getPhone()+"', 'Phone', '"+createdLeads.get(indexOfUpdatedLead).getPhone()+"'),\n";
                    }
                    if(!createdLeads.get(i).getStatus().equals(createdLeads.get(indexOfUpdatedLead).getStatus())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getStatus()+"', 'Status', '"+createdLeads.get(indexOfUpdatedLead).getStatus()+"'),\n";
                    }
                    if(createdLeads.get(i).getIsConverted() != (createdLeads.get(indexOfUpdatedLead).getIsConverted())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getIsConverted()+"', 'IsConverted', '"+createdLeads.get(indexOfUpdatedLead).getIsConverted()+"'),\n";
                    }
                    if(!createdLeads.get(i).getCreatedById().equals(createdLeads.get(indexOfUpdatedLead).getCreatedById())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getCreatedById()+"', 'CreatedById', '"+createdLeads.get(indexOfUpdatedLead).getCreatedById()+"'),\n";
                    }
                    if(!createdLeads.get(i).getLastModifiedDate().equals(createdLeads.get(indexOfUpdatedLead).getLastModifiedDate())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getLastModifiedDate()+"', 'LastModifiedDate', '"+createdLeads.get(indexOfUpdatedLead).getLastModifiedDate()+"'),\n";
                    }
                    if(!createdLeads.get(i).getLastModifiedById().equals(createdLeads.get(indexOfUpdatedLead).getLastModifiedById())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdLeads.get(indexOfUpdatedLead).getLastModifiedById()+"', 'LastModifiedById', '"+createdLeads.get(indexOfUpdatedLead).getLastModifiedById()+"'),\n";
                    }

                    snapshotId+=10;
                } else {
                    System.out.println("Insert new Lead");
                    SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                            "("+snapshotId+",'"+createdLeads.get(i).getObjectId()+"', 'Lead', '"+createdLeads.get(i).getEventTs()+"')\n";


                    SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value, attr_old_value) VALUES\n" +
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'OwnerId',                '"+createdLeads.get(i).getOwnerId()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedAccountID',     '"+createdLeads.get(i).getConvertedAccountId()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedContactId',     '"+createdLeads.get(i).getConvertedContactId()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedOpportunityId', '"+createdLeads.get(i).getConvertedOpportunityId()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'ConvertedDate',          '"+createdLeads.get(i).getConvertedDate()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'CreatedDate',            '"+createdLeads.get(i).getCreatedDate()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Company',                '"+createdLeads.get(i).getCompany()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'FirstName',              '"+createdLeads.get(i).getFirstName()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'LastName',               '"+createdLeads.get(i).getLastName()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Name',                   '"+createdLeads.get(i).getName()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Title',                  '"+createdLeads.get(i).getTitle()+"',NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Email',                  '"+createdLeads.get(i).getEmail()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Phone',                  '"+createdLeads.get(i).getPhone()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'Status',                 '"+createdLeads.get(i).getStatus()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'IsConverted',            '"+createdLeads.get(i).getIsConverted()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'CreatedById',            '"+createdLeads.get(i).getCreatedById()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'LastModifiedDate',       '"+createdLeads.get(i).getLastModifiedDate()+"', NULL),\n"+
                            "\t\t("+snapshotId+", '"+createdLeads.get(i).getObjectId()+"', 'LastModifiedById',       '"+createdLeads.get(i).getLastModifiedById()+"', NULL)\n";

                    snapshotId+=10;
                    objectId+=10;

                }
            }

            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);
            System.out.println(SQLexpression3);
        }
    }

    public static void generateContactsSQL(ArrayList<Contact> createdContacts) {

        String SQLexpression1 = "", SQLexpression2= "",  SQLexpression3= "";

        for(int i=0; i<createdContacts.size();i++) {
            if(i == 0) {
                System.out.println("Insert first new Contact");
                SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                        "("+snapshotId+",'"+createdContacts.get(i).getObjectId()+"', 'Contact', '"+createdContacts.get(i).getEventTs()+"')\n";


                SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value) VALUES\n" +
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'OwnerID',     '"+createdContacts.get(i).getOwnerId()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'AccountID',   '"+createdContacts.get(i).getAccountId()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedDate', '"+createdContacts.get(i).getCreatedDate()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Email',       '" +createdContacts.get(i).getContactEmail()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'FirstName',   '" +createdContacts.get(i).getContactFirstName()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastName',    '" +createdContacts.get(i).getContactLastName()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Name',        '" +createdContacts.get(i).getContactName()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Title',       '" +createdContacts.get(i).getContactTitle()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Phone',       '" +createdContacts.get(i).getContactPhone()+"')\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedById',      '"+createdContacts.get(i).getCreatedById()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastModifiedDate', '"+createdContacts.get(i).getLastModifiedDate()+"'),\n"+
                        "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastModifiedById', '"+createdContacts.get(i).getLastModifiedById()+"')\n";

                snapshotId+=10;
                objectId+=10;

            } else {

                Boolean contactUpdated = false;
                int indexOfUpdatedContact = 0;

                for(int j=i-1; j>=0; j--) {

                    if (createdContacts.get(i).getContactName().equals(createdContacts.get(j).getContactName())) {
                        contactUpdated = true;
                        indexOfUpdatedContact = j;
                        break;
                    }
                }

                if(contactUpdated) {
                    System.out.println("Update Contact");
                    SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                            "("+snapshotId+",'"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', "+createdContacts.get(i).getEventTs()+"')\n";

                    SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value) VALUES\n" +
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'OwnerID',       '" +createdContacts.get(i).getOwnerId()+              "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'AccountID',     '" +createdContacts.get(i).getAccountId()+            "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedDate',   '" +createdContacts.get(i).getCreatedDate()+          "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Email',         '" +createdContacts.get(i).getContactEmail()+        "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'FirstName',     '" +createdContacts.get(i).getContactFirstName()+     "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastName',      '" +createdContacts.get(i).getContactLastName()+      "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Name',          '" +createdContacts.get(i).getContactName()+         "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Title',         '" +createdContacts.get(i).getContactTitle()+        "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Phone',         '" +createdContacts.get(i).getContactPhone()+        "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedById',   '" +createdContacts.get(i).getCreatedById()+          "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastModifiedDate', '" +createdContacts.get(i).getLastModifiedDate()+ "'),\n"+
                           "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastModifiedById', '" +createdContacts.get(i).getLastModifiedById()+ "')\n";


                    SQLexpression3 = "INSERT INTO SFDC_SNAPSHOT_DATA_OLD(snapshot_id, object_id, attr_name, attr_old_value) VALUES \n";

                    if(!createdContacts.get(i).getOwnerId().equals(createdContacts.get(indexOfUpdatedContact).getOwnerId())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'OwnerId', '"+createdContacts.get(indexOfUpdatedContact).getOwnerId()+"'),\n";
                    }
                    if(!createdContacts.get(i).getAccountId().equals(createdContacts.get(indexOfUpdatedContact).getAccountId())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'AccountID', '"+createdContacts.get(indexOfUpdatedContact).getAccountId()+"'),\n";
                    }
                    if(!createdContacts.get(i).getCreatedDate().equals(createdContacts.get(indexOfUpdatedContact).getCreatedDate())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'CreatedDate', '"+createdContacts.get(indexOfUpdatedContact).getCreatedDate()+"'),\n";
                    }
                    if(!createdContacts.get(i).getContactEmail().equals(createdContacts.get(indexOfUpdatedContact).getContactEmail())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'Email', '"+createdContacts.get(indexOfUpdatedContact).getContactEmail()+"'),\n";
                    }
                    if(!createdContacts.get(i).getContactFirstName().equals(createdContacts.get(indexOfUpdatedContact).getContactFirstName())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'FirstName', '"+createdContacts.get(indexOfUpdatedContact).getContactFirstName()+"'),\n";
                    }
                    if(!createdContacts.get(i).getContactLastName().equals(createdContacts.get(indexOfUpdatedContact).getContactLastName())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'LastName', '"+createdContacts.get(indexOfUpdatedContact).getContactLastName()+"'),\n";
                    }
                    if(!createdContacts.get(i).getContactName().equals(createdContacts.get(indexOfUpdatedContact).getContactName())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'Name', '"+createdContacts.get(indexOfUpdatedContact).getContactName()+"'),\n";
                    }
                    if(!createdContacts.get(i).getContactTitle().equals(createdContacts.get(indexOfUpdatedContact).getContactTitle())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'Title', '"+createdContacts.get(indexOfUpdatedContact).getContactTitle()+"'),\n";
                    }
                    if(!createdContacts.get(i).getContactPhone().equals(createdContacts.get(indexOfUpdatedContact).getContactPhone())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'Phone', '"+createdContacts.get(indexOfUpdatedContact).getContactPhone()+"'),\n";
                    }
                    if(!createdContacts.get(i).getCreatedById().equals(createdContacts.get(indexOfUpdatedContact).getCreatedById())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'CreatedById', '"+createdContacts.get(indexOfUpdatedContact).getCreatedById()+"'),\n";
                    }
                    if(!createdContacts.get(i).getLastModifiedDate().equals(createdContacts.get(indexOfUpdatedContact).getLastModifiedDate())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'LastModifiedDate', '"+createdContacts.get(indexOfUpdatedContact).getLastModifiedDate()+"'),\n";
                    }
                    if(!createdContacts.get(i).getLastModifiedById().equals(createdContacts.get(indexOfUpdatedContact).getLastModifiedById())) {
                        SQLexpression3+="\t\t("+snapshotId+", '"+createdContacts.get(indexOfUpdatedContact).getObjectId()+"', 'LastModifiedById', '"+createdContacts.get(indexOfUpdatedContact).getLastModifiedById()+"'),\n";
                    }
                   snapshotId+=10;


                } else {
                    System.out.println("Insert new Contact");
                    SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                            "("+snapshotId+",'"+createdContacts.get(i).getObjectId()+"','Contact', '"+createdContacts.get(i).getEventTs()+"')\n";


                    SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value) VALUES\n" +
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'OwnerID',          '"+createdContacts.get(i).getOwnerId()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'AccountID',        '"+createdContacts.get(i).getAccountId()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedDate',      '"+createdContacts.get(i).getCreatedDate()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Email',            '"+createdContacts.get(i).getContactEmail()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'FirstName',        '"+createdContacts.get(i).getContactFirstName()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastName',         '"+createdContacts.get(i).getContactLastName()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Name'   ,          '"+createdContacts.get(i).getContactName()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Title',            '"+createdContacts.get(i).getContactTitle()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'Phone',            '"+createdContacts.get(i).getContactPhone()+"')\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'CreatedById',      '"+createdContacts.get(indexOfUpdatedContact).getCreatedById()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastModifiedDate', '"+createdContacts.get(indexOfUpdatedContact).getLastModifiedDate()+"'),\n"+
                            "("+snapshotId+", '"+createdContacts.get(i).getObjectId()+"', 'LastModifiedById', '"+createdContacts.get(indexOfUpdatedContact).getLastModifiedById()+"')\n";

                    snapshotId+=10;
                    objectId+=10;
                }
            }

            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);
            System.out.println(SQLexpression3);
        }
    }

    public static void generateAccountsSQL(ArrayList<Account> createdAccounts) {

        String SQLexpression1 = "", SQLexpression2= "";

        for(int i=0; i<createdAccounts.size();i++) {
            if(i == 0) {
                System.out.println("Insert first new Account");
                SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                        "("+snapshotId+",'"+createdAccounts.get(i).getAccountObjectId()+"', 'Account', '"+createdAccounts.get(i).getEventTs()+"')\n";


                SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value, attr_old_value) VALUES\n" +
                        "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'Name',           '" +createdAccounts.get(i).getAccountName()+"', NULL),\n"+
                        "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'Description',    '" +createdAccounts.get(i).getAccountDescription()+"', NULL),\n"+
                        "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'CreatedDate',   '" +createdAccounts.get(i).getCreatedDate()+"', NULL),\n"+
                        "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'AccountNumber', '" +createdAccounts.get(i).getAccountNumber()+"',  NULL),\n"+
                        "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'AccountSource', '"  +createdAccounts.get(i).getAccountSource()+"', NULL)\n";
                snapshotId+=10;
                objectId+=10;
            } else {

                Boolean contactUpdated = false;
                int indexOfUpdatedAccount = 0;

                for(int j=i-1; j>=0; j--) {

                    if (createdAccounts.get(i).getAccountName().equals(createdAccounts.get(j).getAccountName()) ) {
                        contactUpdated = true;
                        indexOfUpdatedAccount = j;
                        break;
                    }
                }

                if(contactUpdated) {
                    System.out.println("Update Account");
                    SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                            "("+snapshotId+",'"+createdAccounts.get(indexOfUpdatedAccount).getAccountObjectId()+"', 'Account', '"+createdAccounts.get(i).getEventTs()+"')\n";

                    SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attr_name, attr_value, attr_old_value) VALUES\n" +
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'Name',          '" +createdAccounts.get(i).getAccountName()+               "', '"+createdAccounts.get(indexOfUpdatedAccount).getAccountName()+"'),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'Description',   '" +createdAccounts.get(i).getAccountDescription()+    "', '"+createdAccounts.get(indexOfUpdatedAccount).getAccountDescription()+"'),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'CreatedDate',   '" +createdAccounts.get(i).getCreatedDate()+    "', '"+createdAccounts.get(indexOfUpdatedAccount).getCreatedDate()+"'),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'AccountNumber', '" +createdAccounts.get(i).getAccountNumber()+"', '"+createdAccounts.get(indexOfUpdatedAccount).getAccountNumber()+"'),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'AccountSource', '" +createdAccounts.get(i).getAccountSource()+         "', '"+createdAccounts.get(indexOfUpdatedAccount).getAccountSource()+"')\n";
                    snapshotId+=10;
                } else {
                    System.out.println("Insert new Contact");
                    SQLexpression1 = "INSERT INTO SFDC_SNAPSHOT (snapshot_id, object_id, object_type, snapshot_ts) VALUES \n"+
                            "("+snapshotId+",'"+createdAccounts.get(i).getAccountObjectId()+"', '"+createdAccounts.get(i).getEventTs()+"')\n";


                    SQLexpression2 = "INSERT INTO SFDC_SNAPSHOT_DATA (snapshot_id, object_id, attribute_name, value, old_value) VALUES\n" +
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'Name',          '" +createdAccounts.get(i).getAccountName()+"', NULL),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'Description',   '" +createdAccounts.get(i).getAccountDescription()+"', NULL),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'CreatedDate',   '" +createdAccounts.get(i).getCreatedDate()+"', NULL),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'AccountNumber', '" +createdAccounts.get(i).getAccountNumber()+"', NULL),\n"+
                            "("+snapshotId+", '"+createdAccounts.get(i).getAccountObjectId()+"', 'AccountSource', '" +createdAccounts.get(i).getAccountSource()+"', NULL)\n";
                    snapshotId+=10;
                    objectId+=10;
                }
            }

            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);
        }
    }
}
