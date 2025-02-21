
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrelimExam {
    public static void main(String[] args) {

       
        JFrame frame = new JFrame("Product Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

       
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(Color.DARK_GRAY);
        northPanel.setPreferredSize(new Dimension(400, 200));
     

       
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(Color.DARK_GRAY);
        welcomePanel.setPreferredSize(new Dimension(400, 48));
        JLabel welcomeLabel = new JLabel("Product Inventory");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        welcomePanel.add(welcomeLabel);
        
       

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inputPanel.setBackground(Color.GRAY);
        inputPanel.setPreferredSize(new Dimension(400, 40));

        JLabel productLabel = new JLabel("Product Name:");
        productLabel.setPreferredSize(new Dimension(120, 20));
        productLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        JTextField producttextField = new JTextField(23);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setPreferredSize(new Dimension(120, 20));
        priceLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        JTextField priceTextField = new JTextField(23);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setPreferredSize(new Dimension(120, 20));
        quantityLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        JTextField quantitytextField = new JTextField(23);

        JButton button = new JButton("Add Product");
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setPreferredSize(new Dimension (120, 25));
        
        JButton button2 = new JButton("Search Product");
        button2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button2.setPreferredSize(new Dimension (120, 25));

        JButton button3 = new JButton("Display Inventory");
        button3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button3.setPreferredSize(new Dimension (120, 25));

        

        inputPanel.add(productLabel);
        inputPanel.add(producttextField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceTextField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantitytextField);
        inputPanel.add(button);
        inputPanel.add(button2);
        
        inputPanel.add(button3);

       
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(Color.LIGHT_GRAY);
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        
        // JTextField searchField = new JTextField(20);
//         searchField.setToolTipText("Enter the products name to search.");

        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        searchPanel.add(searchLabel);
        // searchPanel.add(searchField);
        searchPanel.add(searchButton);


        
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        textArea.setText("List of Product: \n\n");
        textArea.setMargin(new Insets(20, 50, 20, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        
 
        
        
        ArrayList<String> students = new ArrayList<>();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = producttextField.getText();
                String price = priceTextField.getText();
                String quantity = quantitytextField.getText();

              
                if (product.length() == 0 || price.length() == 0 || quantity.length() == 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter name, price, and quantity.");
                    return;
                }
                
                

                String studentData = product + " | Price: " + price + " | Quantity: " + quantity;
                students.add(studentData);
                textArea.append(studentData + "\n");
                JOptionPane.showMessageDialog(frame, "Product added successfully!");

               
                producttextField.setText("");
                priceTextField.setText("");
                quantitytextField.setText("");
            }
        });
        
        
        
        
         button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = producttextField.getText();
                String price = priceTextField.getText();
                String quantity = quantitytextField.getText();

              
              
              
              // Dito po here cinomment ko po siya para mag display po yung name and price and quantity 
              
              
              
               //  if (product.length() == 0 || price.length() == 0 || quantity.length() == 0) {
//                     JOptionPane.showMessageDialog(frame, "Please enter name, price, and quantity.");
//                     return;
//                 }
//                 
                

                String studentData = product + " | Price: " + price + " | Quantity: " + quantity;
                students.add(studentData);
                textArea.append(studentData + "\n");
                JOptionPane.showMessageDialog(frame, "Product added successfully!");

               
                producttextField.setText("");
                priceTextField.setText("");
                quantitytextField.setText("");
            }
        });

        
          
            button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = producttextField.getText();
                String price = priceTextField.getText();
                String quantity = quantitytextField.getText();

              
                if (product.length() == 0 || price.length() == 0 || quantity.length() == 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter product, price, and quantity.");
                    return;
                }
                
                

                String studentData = product + " | Price: " + price + " | Quantity: " + quantity;
                students.add(studentData);
                textArea.append(studentData + "\n");
                JOptionPane.showMessageDialog(frame, "Product added successfully!");

               
                producttextField.setText("");
                priceTextField.setText("");
                quantitytextField.setText("");
            }
        });
        


// 
//         searchButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                //  String searchName = searchField.getText();
//                 boolean found = false;
// 
//                 for (String student : students) {
//                     if (student.contains(searchName)) {
//                         JOptionPane.showMessageDialog(frame, "Product found: " + student);
//                         found = true;
//                         break;
//                     }
//                 }
// 
//                 if (!found) {
//                     JOptionPane.showMessageDialog(frame, "Product not found.");
//                 }
//             }
//         });


        northPanel.add(welcomePanel, BorderLayout.NORTH);
        northPanel.add(inputPanel, BorderLayout.CENTER);
        northPanel.add(searchPanel, BorderLayout.SOUTH);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

   
        frame.setVisible(true);
    }
}
