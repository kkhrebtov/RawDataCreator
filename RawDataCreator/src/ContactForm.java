import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kkhrebtov on 1/9/14.
 */
public class ContactForm extends JDialog implements ActionListener, ItemListener {

    ArrayList<Contact> createdContacts = new ArrayList();

    private JTextField firstNameTextField;
    private JComboBox titleComboBox;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JButton createButton;
    private JButton generateSQLButton;
    private JButton cleanFormButton;
    private JLabel firstNameLabel;
    private JLabel ownerIdLabel;
    private JLabel titleLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JTextField lastNameTextField;
    private JLabel lastNameLabel;
    private JTextField dateOfCreationTextField;
    private JLabel dateOfCreationLabel;
    private JTextField accountIDTextField;
    private JLabel accountIDLabel;
    private JTextField eventTSTextField;
    private JLabel eventTSLabel;
    private JComboBox ownerIdTextField;
    private JComboBox createdByIdComboBox;
    private JTextField lastModifiedDateTextField;
    private JLabel createdByIdLabel;
    private JComboBox lastModifiedByIdlComboBox;
    private JLabel lastModifiedDateLabel;
    private JLabel lastModifiedByIdlLabel;

    public ContactForm() {

        InitUI();

        cleanFormButton.addActionListener(new ButtonListener() {
        });
        createButton.addActionListener(new ButtonListener() {
        });
        generateSQLButton.addActionListener(new ButtonListener() {
        });

    }

    private void InitUI() {

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        setSize(420, 400);
        setLayout(null);

        firstNameTextField.setBounds(100, 30, 90, 22);
        firstNameLabel.setBounds(30, 30, 70, 22);

        lastNameTextField.setBounds(270, 30, 90, 22);
        lastNameLabel.setBounds(200, 30, 70, 22);

        ownerIdTextField.setBounds(100, 30, 90, 22);
        ownerIdLabel.setBounds(30, 30, 70, 22);

        ownerIdTextField.setBounds(150, 60, 190, 22);
        ownerIdLabel.setBounds(30, 60, 90, 22);

        try {
            titleComboBox = new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\titles.txt"));
            titleComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        titleComboBox.setBounds(150, 90, 190, 22);
        titleLabel.setBounds(30, 90, 90, 22);

        emailTextField.setBounds(150, 120, 190, 22);
        emailTextField.setText("@company.com");
        emailLabel.setBounds(30, 120, 90, 22);


        phoneTextField.setBounds(150, 150, 190, 22);
        phoneLabel.setBounds(30, 150, 90, 22);

        dateOfCreationTextField.setBounds(150, 180, 190, 22);
        dateOfCreationLabel.setBounds(30, 180, 100, 22);

        accountIDTextField.setBounds(150, 210, 90, 22);
        accountIDLabel.setBounds(30, 210, 190, 22);

        eventTSTextField.setBounds(150, 240, 190, 22);
        eventTSLabel.setBounds(30, 240, 190, 22);
        eventTSTextField.setText("2011-07-11 11:00:00.000");


        try {
            createdByIdComboBox= new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            titleComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        createdByIdComboBox.setBounds(150, 270, 190, 22);
        createdByIdLabel.setBounds(30, 270, 90, 22);

        lastModifiedDateTextField.setBounds(150, 300, 190, 22);
        lastModifiedDateLabel.setBounds(30, 300, 100, 22);

        try {
            lastModifiedByIdlComboBox= new JComboBox(tools.readLines("D:\\RawDataCreator\\RawDataCreator\\resources\\employees.txt"));
            lastModifiedByIdlComboBox.setSelectedIndex(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        lastModifiedByIdlComboBox.setBounds(150, 330, 190, 22);
        lastModifiedByIdlLabel.setBounds(30, 330, 90, 22);

        createButton.setBounds(20, 360, 90, 30);
        cleanFormButton.setBounds(125, 360, 120, 30);
        generateSQLButton.setBounds(260, 360, 120, 30);

        add(firstNameTextField);
        add(firstNameLabel);
        add(lastNameLabel);
        add(lastNameTextField);
        add(ownerIdTextField);
        add(ownerIdLabel);
        add(titleComboBox);
        add(titleLabel);
        add(emailTextField);
        add(emailLabel);
        add(phoneTextField);
        add(phoneLabel);
        add(dateOfCreationLabel);
        add(dateOfCreationTextField);
        add(accountIDLabel);
        add(accountIDTextField);
        add(eventTSLabel);
        add(eventTSTextField);
        add(createdByIdComboBox);
        add(createdByIdLabel);
        add(lastModifiedDateLabel);
        add(lastModifiedDateTextField);
        add(lastModifiedByIdlComboBox);
        add(lastModifiedByIdlLabel);

        add(cleanFormButton);
        add(createButton);
        add(generateSQLButton);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();

            String label = o.getText();
            System.out.println("Button " + label + " pressed");

            switch(label) {
                case "CleanForm":
                    ownerIdTextField.setSelectedIndex(-1);
                    dateOfCreationTextField.setText("");
                    firstNameTextField.setText("");
                    lastNameTextField.setText("");
                    titleComboBox.setSelectedIndex(-1);
                    ownerIdTextField.setSelectedIndex(-1);
                    emailTextField.setText("");
                    phoneTextField.setText("");
                    accountIDTextField.setText("");
                    eventTSTextField.setText("2011-07-11 11:00:00.000");
                    createdByIdComboBox.setSelectedIndex(-1);
                    lastModifiedDateTextField.setText("");
                    lastModifiedByIdlComboBox.setSelectedIndex(-1);
                    break;
                case "Create":
                    createdContacts.add(new Contact(ownerIdTextField.getSelectedItem().toString(),
                                                    accountIDTextField.getText(),
                                                    dateOfCreationTextField.getText(),
                                                    firstNameTextField.getText(),
                                                    lastNameTextField.getText(),
                                                    titleComboBox.getSelectedItem().toString(),
                                                    emailTextField.getText(),
                                                    phoneTextField.getText(),
                                                    eventTSTextField.getText(),
                                                    createdByIdComboBox.getSelectedItem().toString(),
                                                    lastModifiedDateTextField.getText(),
                                                    lastModifiedByIdlComboBox.getSelectedItem().toString()

                    ));
                    break;
                case "Generate SQL":
                    tools.generateContactsSQL(createdContacts);
                    break;

            }

        }
    }


    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
            int index = combo.getSelectedIndex();
        }

    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }


}
