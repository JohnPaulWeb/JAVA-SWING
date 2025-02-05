package JAVA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentInformationSystem2 {
    public static void main(String[] args) {
    
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(Color.YELLOW);
        JLabel label = new JLabel("Enter your name: ");
        JTextField textField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(searchButton);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout());
        JLabel searchLabel = new JLabel("Search Name: ");
        JTextField searchField = new JTextField(20);
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        JTextArea textArea = new JTextArea(10,20);
        textArea.setEditable(false);
        
        

        // List to store names
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        
        
       

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String searchName = searchField.getText();

                if (names.contains(searchName)) {
                    JOptionPane.showMessageDialog(frame, "Name Found: " + searchName);
                } else {
                    JOptionPane.showMessageDialog(frame, "No Record Found");
                }
            }
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(searchPanel, BorderLayout.CENTER);
        

        frame.setVisible(true);
    }
}
