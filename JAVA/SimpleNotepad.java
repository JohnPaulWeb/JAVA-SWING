import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SimpleNotepad extends JFrame {
    private JTextArea textArea;

    public SimpleNotepad() {
        setTitle("Notepad");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial Black", Font.PLAIN, 14));
        add(new JScrollPane(textArea));
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveFile());
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
    
    private void saveFile() {
        try {
            FileWriter writer = new FileWriter("notepad.txt");
            writer.write(textArea.getText());
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file");
        }
    }
    
    public static void main(String[] args) {
        new SimpleNotepad().setVisible(true);
    }
}
