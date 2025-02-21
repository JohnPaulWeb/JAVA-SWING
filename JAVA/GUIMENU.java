
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIMENU {
    public static void main(String[] args) {

     
     JFrame frame = new JFrame("Menu Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        // frame.setLayout(new FlowLayout());
        
        
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
         m1.setFont(new Font("Arial Black", Font.BOLD, 14));
        JMenu m2 = new JMenu ("Edit");
         m2.setFont(new Font("Arial Black", Font.BOLD, 14));
        JMenu m3 = new JMenu ("View");
         m3.setFont(new Font("Arial Black", Font.BOLD, 14));
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        JMenuItem m11 = new JMenuItem("Open"); 
        JMenuItem m12 = new JMenuItem("Save as");
        
        JMenuItem m13 = new JMenuItem("New Tab");
        JMenuItem m14 = new JMenuItem("New Window");
        JMenuItem m15 = new JMenuItem("Open");
        JMenuItem m16 = new JMenuItem("Save");
        JMenuItem m17 = new JMenuItem("Save as");
        JMenuItem m18 = new JMenuItem("Save all");
        JMenuItem m19 = new JMenuItem("Page setup");
        JMenuItem m20 = new JMenuItem("Print");
          JMenuItem m21 = new JMenuItem("Close Tab");
            JMenuItem m22 = new JMenuItem("Close Window");
              JMenuItem m23 = new JMenuItem("Exit");
              
              JMenuItem m24 = new JMenuItem("Undo");
             JMenuItem m25 = new JMenuItem("Zoom");
        
       

        
        m1.add(m11);
        m1.add(m12);
        x
        m1.add(m13);
        m1.add(m14);
        m1.add(m15);
        m1.add(m16);
        m1.add(m17);
        m1.add(m18);
        m1.add(m19);
        m1.add(m20);
         m1.add(m21);
          m1.add(m22);
           m1.add(m23);   

               
               m2.add(m24);
               m3.add(m25);
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10);
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        
        
        JTextArea ta = new JTextArea();
        ta.setEditable(true);
        
       //  
//         send.addActionListener(new ActionListener() {
//         @override
//         public void actionPerformed(ActionEvent e) {
//          String text = tf.getText();
//          if (!text.isEmpty() {
//           ta.append(text + "\n");
//           tf.setText("");
//          
//          })
//         
//         }
//           
//         });
//         
//         reset.addActionListener(new ActionListener e) {
//           @override
//           
//           public void actionPerformed(ActionEvent e) {
//           
//           ta.setText 
//           }
//          
//         }

   // send.addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//      
//      String text = tf.getText();
//      if (!text.isEmpty()) {
//      
//        ta.append(text + "\n");
//        tf.setText("");
//      
//      }
//    
//    }
//    
//    });
   
   
  //  reset.addActionListener(new ActionListener() {
//      @Override
//      
//      public void actionPerformed(ActionEvent e) {
//      
//        ta.setText("");
//        tf.setText("");
//      }
//    
//    });
   
   
   // frame.getContentPane().add(BorderLayout.SOUTH, panel);
   frame.getContentPane().add(BorderLayout.NORTH, mb);
   frame.getContentPane().add(BorderLayout.CENTER, ta);
   frame.setVisible(true);

}

}


 // FILE 
// new tab, new window, open save, save as, save all, pagesetup, print Save, SAVE-ALL PRINT  

// ARIAL BLACK 
