import java.awt.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kkhrebtov on 12/30/13.
 */
public class OpportunityForm extends JDialog implements ActionListener, ItemListener {

    final String[] opportunityAttributes = {
            "Expected Close Date", "Amount",
            "Name","Description",
            "Stage Name", "Stage Description",
            "Status", "Result"};

    ArrayList <Opportunity> createdOpportunities = new ArrayList();

    int oppsCounter = 0;

    private JComboBox ownerId = null;
    private JLabel ownerIdLabel = null;

    private JComboBox accountId = null;
    private JLabel accountIdLabel = null;

    private JComboBox leadSource = null;
    private JLabel leadSourceLabel = null;

    private JTextField eventTsText = null;
    private JLabel eventTsLabel = null;

    private JTextField ECDText = null;
    private JLabel ECDLabel = null;

    private JTextField amountText = null;
    private JLabel amountLabel = null;

    private JTextField nameText = null;
    private JLabel nameLabel = null;

    private JTextField descriptionText = null;
    private JLabel descriptionLabel = null;

    private JTextField stageNameText = null;
    private JLabel stageNameLabel = null;

    private JTextField stageDescrText = null;
    private JLabel stageDescrLabel = null;

    private JTextField statusText = null;
    private JLabel statusLabel = null;

    private JTextField resultText = null;
    private JLabel resultLabel = null;

    private JCheckBox isClosed = null;
    private JCheckBox isWon = null;

    private JButton createButton = null;
    private JButton cleanFormButton = null;
    private JButton generateSQLButton = null;

    public OpportunityForm() {

        InitUI();

        cleanFormButton.addActionListener(new ButtonListener());
        createButton.addActionListener(new ButtonListener());
        generateSQLButton.addActionListener(new ButtonListener());

    }

    public Opportunity getOpportunity(int i) {
     return (Opportunity) createdOpportunities.get(i);
    }

    public int getOpportunitiesCount() {
        return createdOpportunities.size();
    }

    public void itemStateChanged(ItemEvent e) {

    }

    public void actionPerformed(ActionEvent e) {

        System.exit(0);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();

            String label = o.getText();
            System.out.println("Button " + label + " pressed");

//            boolean oppExists = false;
//            for(Opportunity opp : createdOpportunities) {
//                if (opp.getName() == nameText.getText()) oppExists = true;
//            }
//

            switch(label){
                case "Clean Form":
                    ownerId.setSelectedIndex(-1);
                    accountId.setSelectedIndex(-1);
                    leadSource.setSelectedIndex(-1);
                    eventTsText.setText("2011-07-11 11:00:00.000 +0:00");
                    ECDText.setText("2011-07-11");
                    nameText.setText("");
                    amountText.setText("1000");
                    descriptionText.setText("");
                    stageNameText.setText("");
                    stageDescrText.setText("");
                    statusText.setText("");
                    resultText.setText("");
                    isClosed.setSelected(false);
                    isWon.setSelected(false);
                    break;
                case "Create":
                   createdOpportunities.add(new Opportunity(ownerId.getSelectedItem().toString(),
                                                            accountId.getSelectedItem().toString(),
                                                            leadSource.getSelectedItem().toString(),
                                                            eventTsText.getText(),
                                                            ECDText.getText(),
                                                            amountText.getText(),
                                                            nameText.getText(),
                                                            descriptionText.getText(),
                                                            stageNameText.getText(),
                                                            stageDescrText.getText(),
                                                            isClosed.isSelected(),
                                                            isWon.isSelected()
                                             ));
                    oppsCounter++;
                    ownerId.setSelectedIndex(-1);
                    accountId.setSelectedIndex(-1);
                    leadSource.setSelectedIndex(-1);
                    eventTsText.setText("2011-07-11 11:00:00.000 +0:00");
                    ECDText.setText("2011-07-11");
                    nameText.setText("");
                    amountText.setText("1000");
                    descriptionText.setText("");
                    stageNameText.setText("");
                    stageDescrText.setText("");
                    statusText.setText("");
                    resultText.setText("");
                    isClosed.setSelected(false);
                    isWon.setSelected(false);
                    System.out.println("Total opportunities created: " + createdOpportunities.size());
                    break;
                case "Generate SQL":
                    tools.generateOpportunitiesSQL(createdOpportunities);
            }
        }
    }

    private void InitUI() {
        System.out.println("Create new Opportunity");

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        eventTsText  = new JTextField("2011-07-11 11:00:00.000 +0:00");
        eventTsLabel = new JLabel();

        try {
            ownerId = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            ownerId.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ownerIdLabel = new JLabel();

        try {
            accountId = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\accounts.txt"));
            accountId.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountIdLabel = new JLabel();

        try {
            leadSource = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\leadSources.txt"));
            leadSource.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        leadSourceLabel = new JLabel();

        ECDText = new JTextField("2011-07-11");
        ECDLabel = new JLabel();

        amountText = new JTextField("1000");
        amountLabel = new JLabel();

        nameText = new JTextField("");
        nameLabel = new JLabel();

        descriptionText = new JTextField("");
        descriptionLabel = new JLabel();

        stageNameText = new JTextField("");
        stageNameLabel = new JLabel();

        stageDescrText = new JTextField("");
        stageDescrLabel = new JLabel();

        statusText = new JTextField("");
        statusLabel = new JLabel();

        resultText = new JTextField("");
        resultLabel = new JLabel();

        isClosed = new JCheckBox("IsClosed");
        isWon = new JCheckBox("IsWon");

        createButton = new JButton("Create");
        cleanFormButton = new JButton("Clean Form");
        generateSQLButton = new JButton("Generate SQL");

        ownerId.setBounds(210, 20, 190, 30);
        ownerIdLabel.setBounds(30, 20, 150, 30);
        ownerIdLabel.setText("Owner ID");

        accountId.setBounds(210, 50, 190, 30);
        accountIdLabel.setBounds(30, 50, 150, 30);
        accountIdLabel.setText("Account ID");

        leadSource.setBounds(210, 80, 190, 30);
        leadSourceLabel.setBounds(30, 80, 150, 30);
        leadSourceLabel.setText("Lead Source");

        eventTsText.setBounds(210, 110, 190, 30);
        eventTsLabel.setBounds(30, 110, 150, 30);
        eventTsLabel.setText("Event TS");

        ECDText.setBounds(210, 140, 190, 30);
        ECDLabel.setBounds(30, 140, 150, 30);
        ECDLabel.setText("Expected Close Date");

        amountText.setBounds(210, 170, 150, 30);
        amountLabel.setBounds(30, 170, 80, 30);
        amountLabel.setText("Amount");

        nameText.setBounds(210, 200, 150, 30);
        nameLabel.setBounds(30, 200, 80, 30);
        nameLabel.setText("Name");

        descriptionText.setBounds(210, 230, 150, 30);
        descriptionLabel.setBounds(30, 230, 80, 30);
        descriptionLabel.setText("Description");

        stageNameText.setBounds(210, 260, 150, 30);
        stageNameLabel.setBounds(30, 260, 80, 30);
        stageNameLabel.setText("Stage Name");

        stageDescrText.setBounds(210, 290, 150, 30);
        stageDescrLabel.setBounds(30, 290, 80, 30);
        stageDescrLabel.setText("Stage Description");

        statusText.setBounds(210, 320, 150, 30);
        statusLabel.setBounds(30, 320, 80, 30);
        statusLabel.setText("Status");

        resultText.setBounds(210, 350, 150, 30);
        resultLabel.setBounds(30, 350, 80, 30);
        resultLabel.setText("Result");

        isClosed.setBounds(30, 380, 90, 30);
        isWon.setBounds(210, 380, 90, 30);

        createButton.setBounds(20, 420, 90, 30);
        cleanFormButton.setBounds(125, 420, 120, 30);
        generateSQLButton.setBounds(260, 420, 120, 30);

        setLayout(null);

        add(ownerId);
        add(ownerIdLabel);

        add(accountId);
        add(accountIdLabel);

        add(leadSource);
        add(leadSourceLabel);

        add(eventTsLabel);
        add(eventTsText);

        add(ECDText);
        add(ECDLabel);

        add(amountText);
        add(amountLabel);

        add(nameText);
        add(nameLabel);

        add(descriptionText);
        add(descriptionLabel);

        add(stageNameText);
        add(stageNameLabel);

        add(stageDescrText);
        add(stageDescrLabel);

        add(statusText);
        add(statusLabel);

        add(resultText);
        add(resultLabel);

        add(isClosed);
        add(isWon);

        add(createButton);
        add(cleanFormButton);
        add(generateSQLButton);

        setSize(420, 510);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
