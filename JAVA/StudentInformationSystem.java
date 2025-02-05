package JAVA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentInformationSystem {
    public static void main(String[] args) {
        // JFrame
        JFrame frame = new JFrame("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome to the new Information System!", JLabel.CENTER);
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBackground(Color.PINK);

        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(10);
        JButton addButton = new JButton("Add Student");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(new JLabel()); // Spacer
        inputPanel.add(addButton);

        
         
        // Text Area for Display
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setBackground(Color.GRAY);
        
        
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBackground(Color.PINK);

        JLabel searchLabel = new JLabel("Search Name:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // List to Store Names
        ArrayList<String> names = new ArrayList<>();

        // Add Button ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputName = nameField.getText();
                if (!inputName.isEmpty()) {
                    names.add(inputName);
                    textArea.append(inputName + "\n");
                    JOptionPane.showMessageDialog(frame, "Student added successfully!");
                    nameField.setText("");
                    ageField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a name.");
                }
            }
        });

        // Search Button ActionListener
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = searchField.getText();
                if (names.contains(searchName)) {
                    JOptionPane.showMessageDialog(frame, "Name Found: " + searchName);
                } else {
                    JOptionPane.showMessageDialog(frame, "No Record Found.");
                }
            }
        });

        // Add Panels to Frame
        frame.add(inputPanel, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(searchPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
