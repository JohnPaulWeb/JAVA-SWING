package JAVA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActivityAddress {
    public static void main(String[] args) {

        // Create a Basic Window
        JFrame frame = new JFrame("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // North Panel
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(Color.DARK_GRAY);
        northPanel.setPreferredSize(new Dimension(400, 200));
     

        // Welcome Panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(Color.DARK_GRAY);
        welcomePanel.setPreferredSize(new Dimension(400, 48));
        JLabel welcomeLabel = new JLabel("Welcome to the Student Information System!");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        welcomePanel.add(welcomeLabel);
        
       

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inputPanel.setBackground(Color.GRAY);
        inputPanel.setPreferredSize(new Dimension(400, 40));

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setPreferredSize(new Dimension(120, 20));
        nameLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        JTextField nametextField = new JTextField(23);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setPreferredSize(new Dimension(120, 20));
        addressLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        JTextField addressTextField = new JTextField(23);
        
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setPreferredSize(new Dimension(120, 20));
        ageLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        JTextField agetextField = new JTextField(23);

        JButton button = new JButton("Add Student");
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setPreferredSize(new Dimension (120, 25));
        
        

        inputPanel.add(nameLabel);
        inputPanel.add(nametextField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTextField);
        inputPanel.add(ageLabel);
        inputPanel.add(agetextField);
        inputPanel.add(button);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(Color.LIGHT_GRAY);
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        JTextField searchField = new JTextField(20);
        searchField.setToolTipText("Enter the student's name to search.");

        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);


        // Display Area
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        textArea.setText("LIST OF STUDENTS:\n\n");
        textArea.setMargin(new Insets(20, 50, 20, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        
        
        
        // List to Store Student Data
        ArrayList<String> students = new ArrayList<>();

        // Add Student Button Functionality
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametextField.getText();
                String age = agetextField.getText();
                String address = addressTextField.getText();

                // Ensure fields are not empty
                if (name.length() == 0 || age.length() == 0 || address.length() == 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter name, age, and address.");
                    return;
                }

                String studentData = name + " | Age: " + age + " | Address: " + address;
                students.add(studentData);
                textArea.append(studentData + "\n");
                JOptionPane.showMessageDialog(frame, "Student added successfully!");

                // Clear input fields
                nametextField.setText("");
                agetextField.setText("");
                addressTextField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = searchField.getText();
                boolean found = false;

                for (String student : students) {
                    if (student.contains(searchName)) {
                        JOptionPane.showMessageDialog(frame, "Student found: " + student);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(frame, "Student not found.");
                }
            }
        });

        // Add components to the frame
        northPanel.add(welcomePanel, BorderLayout.NORTH);
        northPanel.add(inputPanel, BorderLayout.CENTER);
        northPanel.add(searchPanel, BorderLayout.SOUTH);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
