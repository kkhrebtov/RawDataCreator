import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kkhrebtov on 1/10/14.
 */
public class LeadForm extends JDialog implements ActionListener, ItemListener {

    ArrayList<Lead> createdLeads = new ArrayList();

    private JComboBox companyNameComboBox;
    private JLabel companyNameLabel;

    private JComboBox titleComboBox;
    private JLabel titleLabel;

    private JTextField firstNameTextField;
    private JLabel firstNameLabel;

    private JTextField emailText;
    private JLabel emailTextLabel;

    private JTextField phoneTextField;
    private JLabel phoneTextLabel;

    private JComboBox statusComboBox;
    private JLabel statusLabel;

    private JButton cleanFormButton;
    private JButton createButton;
    private JButton generateSQLButton;
    private JComboBox ownerIdComboBox;
    private JLabel ownerIdLabel;
    private JTextField convertedAccountIdTextField;
    private JLabel convertedAccountIdLabel;
    private JTextField convertedContactIdTextField;
    private JLabel  convertedContactIdLabel;
    private JTextField convertedOpportunityIdTextField;
    private JLabel convertedOpportunityIdLabel;
    private JTextField convertedDateTextField;
    private JLabel convertedDateLabel;
    private JTextField createdDateTextField;
    private JLabel createdDateLabel;
    private JCheckBox isConvertedCheckBox;
    private JTextField eventTSTextField;
    private JLabel eventTSLabel;
    private JTextField lastNameTextField;
    private JLabel lastNameLabel;
    private JComboBox createdByIdComboBox;
    private JTextField lastModifiedDateTextField;
    private JTextField lastModifiedByIdTextField;
    private JLabel lastModifiedByIdLabel;
    private JLabel lastModifiedDateLabel;
    private JLabel createdByIdLabel;


    public LeadForm() {

        InitUI();

        cleanFormButton.addActionListener(new ButtonListener() {
        });
        createButton.addActionListener(new ButtonListener() {
        });
        generateSQLButton.addActionListener(new ButtonListener() {
        });

    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();

            String label = o.getText();
            System.out.println("Button " + label + " pressed");

            switch(label) {
                case "CleanForm":
                    ownerIdComboBox.setSelectedIndex(-1);
                    convertedAccountIdTextField.setText("");
                    convertedContactIdTextField.setText("");
                    convertedOpportunityIdTextField.setText("");
                    convertedDateTextField.setText("");
                    createdDateTextField.setText("");
                    companyNameComboBox.setSelectedIndex(-1);
                    firstNameTextField.setText("");
                    lastNameTextField.setText("");
                    titleComboBox.setSelectedIndex(-1);
                    emailText.setText("");
                    phoneTextField.setText("");
                    statusLabel.setText("");
                    eventTSTextField.setText("2011-07-11 11:00:00.000");
                    isConvertedCheckBox.setSelected(false);
                    createdByIdComboBox.setSelectedIndex(-1);
                    lastModifiedByIdTextField.setText("");
                    lastModifiedDateTextField.setText("");
                    break;
                case "Create":
                   createdLeads.add(new Lead(ownerIdComboBox.getSelectedItem().toString(),
                                             convertedAccountIdTextField.getText(),
                                             convertedContactIdTextField.getText(),
                                             convertedOpportunityIdTextField.getText(),
                                             convertedDateTextField.getText(),
                                             createdDateTextField.getText(),
                                             companyNameComboBox.getSelectedItem().toString(),
                                             firstNameTextField.getText(),
                                             lastNameTextField.getText(),
                                             titleComboBox.getSelectedItem().toString(),
                                             emailText.getText(),
                                             phoneTextField.getText(),
                                             statusComboBox.getSelectedItem().toString(),
                                             eventTSTextField.getText(),
                                             isConvertedCheckBox.isSelected(),
                                             createdByIdComboBox.getSelectedItem().toString(),
                                             lastModifiedDateTextField.getText(),
                                             lastModifiedByIdTextField.getText()
                   ));

                   break;
                case "Generate SQL":
                    tools.generateLeadsSQL(createdLeads);
                    break;

            }

        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
            int index = combo.getSelectedIndex();

            switch(index) {
                case 0:
                    System.out.println("Selected Opportunity");
                    OpportunityForm oppForm = new OpportunityForm();
                    break;
                case 4:
                    ContactForm contactForm = new ContactForm();
                    break;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }


    private void InitUI() {
        System.out.println("Create new Lead");

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        setSize(420, 610);
        setLayout(null);

        try {
            ownerIdComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            ownerIdComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ownerIdComboBox.setBounds(210, 0, 190, 22);
        ownerIdLabel.setBounds(30, 0, 190, 22);

        convertedAccountIdTextField.setBounds(210, 30, 190, 22);
        convertedAccountIdLabel.setBounds(30, 30, 190, 22);

        convertedContactIdTextField.setBounds(210, 60, 190, 22);
        convertedContactIdLabel.setBounds(30, 60, 190, 22);

        convertedOpportunityIdTextField.setBounds(210, 90, 190, 22);
        convertedOpportunityIdLabel.setBounds(30, 90, 190, 22);

        convertedDateTextField.setBounds(210, 120, 190, 22);
        convertedDateLabel.setBounds(30, 120, 190, 22);

        createdDateTextField.setBounds(210, 150, 190, 22);
        createdDateLabel.setBounds(30, 150, 190, 22);

        try {
            companyNameComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\accounts.txt"));
            companyNameComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        companyNameComboBox.setBounds(210, 180, 190, 22);
        companyNameLabel.setBounds(30, 180, 150, 22);

        try {
            titleComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\titles.txt"));
            titleComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        titleComboBox.setBounds(210, 210, 190, 22);
        titleLabel.setBounds(30, 210, 150, 22);

        firstNameTextField.setBounds(120, 240, 100, 22);
        firstNameLabel.setBounds(30, 240, 70, 22);

        lastNameTextField.setBounds(320, 240, 90, 22);
        lastNameLabel.setBounds(240, 240, 70, 22);

        emailText.setBounds(210, 270, 190, 22);
        emailTextLabel.setBounds(30, 270, 150, 22);

        phoneTextField.setBounds(210, 300, 190, 22);
        phoneTextLabel.setBounds(30, 300, 150, 22);

        try {
            statusComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\statuses.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        statusComboBox.setBounds(210, 330, 190, 22);
        statusLabel.setBounds(30, 330, 150, 22);

        eventTSTextField.setBounds(210, 360, 190, 22);
        eventTSLabel.setBounds(30, 360, 150, 22);

        isConvertedCheckBox.setBounds(30, 390, 190, 22);

        try {
            createdByIdComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            createdByIdComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        createdByIdComboBox.setBounds(210, 420, 190, 22);
        createdByIdLabel.setBounds(30, 420, 150, 22);

        lastModifiedDateTextField.setBounds(210, 450, 190, 22);
        lastModifiedDateLabel.setBounds(30, 450, 150, 22);

        lastModifiedByIdTextField.setBounds(210, 480, 190, 22);
        lastModifiedByIdLabel.setBounds(30, 480, 150, 22);

        createButton.setBounds(20, 510, 90, 30);
        cleanFormButton.setBounds(125, 510, 120, 30);
        generateSQLButton.setBounds(260, 510, 120, 30);

        add(ownerIdComboBox);
        add(ownerIdLabel);
        add(convertedAccountIdTextField);
        add(convertedAccountIdLabel);
        add(convertedContactIdTextField);
        add(convertedContactIdLabel);
        add(convertedOpportunityIdTextField);
        add(convertedOpportunityIdLabel);
        add(convertedDateTextField);
        add(convertedDateLabel);
        add(createdDateTextField);
        add(createdDateLabel);
        add(isConvertedCheckBox);
        add(eventTSLabel);
        add(eventTSTextField);

        add(companyNameComboBox);
        add(companyNameLabel);

        add(titleComboBox);
        add(titleLabel);

        add(firstNameTextField);
        add(firstNameLabel);

        add(lastNameTextField);
        add(lastNameLabel);

        add(emailText);
        add(emailTextLabel);

        add(phoneTextField);
        add(phoneTextLabel);

        add(statusComboBox);
        add(statusLabel);

        add(createdByIdComboBox);
        add(createdByIdLabel);

        add(lastModifiedDateTextField);
        add(lastModifiedDateLabel);

        add(lastModifiedByIdTextField);
        add(lastModifiedByIdLabel);

        add(createButton);
        add(cleanFormButton);

        add(generateSQLButton);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
