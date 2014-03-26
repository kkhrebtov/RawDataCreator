import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kkhrebtov on 1/21/14.
 */
public class AccountForm extends JDialog implements ActionListener, ItemListener {

    ArrayList<Account> createdAccounts = new ArrayList();
    private JTextField createdDateTextField;
    private JTextField accountSourceTextField;
    private JTextField accountNumberTextField;
    private JComboBox accountNameComboBox;
    private JTextField accountDescriptionTextField;
    private JButton createButton;
    private JButton cleanFormButton;
    private JButton generateSQLButton;
    private JLabel accountNameLabel;
    private JLabel accountDescriptionLabel;
    private JLabel createdDateLabel;
    private JLabel accountNumberLabel;
    private JLabel accountSourceLabel;
    private JTextField eventTSTextField;
    private JLabel eventTSLabel;
    private JComboBox ownerIdComboBox;
    private JLabel ownerIdLabel;
    private JTextField phoneTextField;
    private JLabel phoneLabel;
    private JComboBox createdByIdComboBox;
    private JTextField lastModifiedDateTextField;
    private JComboBox lastModifiedByIdComboBox;
    private JLabel createdByIdLabel;
    private JLabel lastModifiedDateLabel;
    private JLabel lastModifiedByIdLabel;


    public AccountForm() {

        InitUI();

        cleanFormButton.addActionListener(new ButtonListener() {
        });
        createButton.addActionListener(new ButtonListener() {
        });
        generateSQLButton.addActionListener(new ButtonListener() {
        });

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

            switch(label) {
                case "CleanForm":
                    ownerIdComboBox.setSelectedIndex(-1);
                    accountNameComboBox.setSelectedIndex(-1);
                    accountDescriptionTextField.setText("");
                    createdDateTextField.setText("");
                    eventTSTextField.setText("");
                    accountNumberTextField.setText("");
                    accountSourceTextField.setText("");
                    phoneTextField.setText("");
                    createdByIdComboBox.setSelectedIndex(-1);
                    lastModifiedDateTextField.setText("");
                    lastModifiedByIdComboBox.setSelectedIndex(-1);
                    eventTSTextField.setText("2011-07-11 11:00:00.000 +0:00");
                    break;
                case "Create":
                    createdAccounts.add(new Account(createdByIdComboBox.getSelectedItem().toString(),
                                                    accountNameComboBox.getSelectedItem().toString(),
                                                    accountDescriptionTextField.getText(),
                                                    createdDateTextField.getText(),
                                                    accountNumberTextField.getText(),
                                                    accountSourceTextField.getText(),
                                                    phoneTextField.getText(),
                                                    createdByIdComboBox.getSelectedItem().toString(),
                                                    lastModifiedDateTextField.getText(),
                                                    lastModifiedByIdComboBox.getSelectedItem().toString(),
                                                    eventTSTextField.getText()
                     ));

                    break;
                case "Generate SQL":
                    tools.generateAccountsSQL(createdAccounts);
                    break;

            }

        }
    }

    private void InitUI() {

        System.out.println("Create new Account");

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        setSize(420, 390);
        setLayout(null);

        try {
            ownerIdComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            ownerIdComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ownerIdLabel.setBounds(30, 0, 190, 22);
        ownerIdComboBox.setBounds(210, 0, 190, 22);

        try {
            accountNameComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\accounts.txt"));
            accountNameComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountNameLabel.setBounds(30, 30, 190, 22);
        accountNameComboBox.setBounds(210, 30, 190, 22);

        accountDescriptionLabel.setBounds(30, 60, 190, 22);
        accountDescriptionTextField.setBounds(210, 60, 190, 22);

        createdDateLabel.setBounds(30, 90, 190, 22);
        createdDateTextField.setBounds(210, 90, 190, 22);

        accountNumberLabel.setBounds(30, 120, 190, 22);
        accountNumberTextField.setBounds(210, 120, 190, 22);

        accountSourceLabel.setBounds(30, 150, 190, 22);
        accountSourceTextField.setBounds(210, 150, 190, 22);

        phoneLabel.setBounds(30, 180, 190, 22);
        phoneTextField.setBounds(210, 180, 190, 22);

        eventTSLabel.setBounds(30, 210, 190, 22);
        eventTSTextField.setBounds(210, 210, 190, 22);

        try {
            createdByIdComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            createdByIdComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        createdByIdLabel.setBounds(30, 240, 190, 22);
        createdByIdComboBox.setBounds(210, 240, 190, 22);

        lastModifiedDateLabel.setBounds(30, 270, 190, 22);
        lastModifiedDateTextField.setBounds(210, 270, 190, 22);

        try {
            lastModifiedByIdComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            lastModifiedByIdComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        lastModifiedByIdLabel.setBounds(30, 300, 190, 22);
        lastModifiedByIdComboBox.setBounds(210, 300, 190, 22);



        createButton.setBounds(20, 330, 90, 30);
        cleanFormButton.setBounds(125, 330, 120, 30);
        generateSQLButton.setBounds(260, 330, 120, 30);


        add(ownerIdComboBox);
        add(ownerIdLabel);
        add(accountNameLabel);
        add(accountNameComboBox);
        add(accountDescriptionLabel);
        add(accountDescriptionTextField);
        add(createdDateLabel);
        add(createdDateTextField);
        add(accountNumberLabel);
        add(accountNumberTextField);
        add(accountSourceLabel);
        add(accountSourceTextField);
        add(phoneTextField);
        add(phoneLabel);
        add(eventTSLabel);
        add(eventTSTextField);

        add(lastModifiedByIdComboBox);
        add(lastModifiedByIdLabel);
        add(createdByIdComboBox);
        add(createdByIdLabel);
        add(lastModifiedDateTextField);
        add(lastModifiedByIdLabel);

        add(createButton);
        add(cleanFormButton);
        add(generateSQLButton);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}