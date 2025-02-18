import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;	
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Desktop;
import java.net.URI;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.Stack;
import java.awt.datatransfer.StringSelection;
import java.io.*;


public class Mynotepad extends JFrame {
	protected static final String Mynotepad = null;
	private JTextArea textArea;
	protected AbstractButton urlField;
	private static JFrame frame;
	private static JFrame o;
	private File currentFile;
    private static Stack<String> textStack = new Stack<>();
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mynotepad frame = new Mynotepad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public Mynotepad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 435);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New Tab");
		mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try {
					Desktop desktop = Desktop.getDesktop();
					desktop.browse(new URI("NotePad"));
				} catch (Exception ex) {
					System.out.println("An error occured: " + ex.getMessage());
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New Window");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.getCursor();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Open");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = urlField.getText();
				if (!url.isEmpty()) {
					try {
						Desktop desktop = Desktop.getDesktop();
					desktop.browse(new URI("Notepad"));
				} catch (Exception ex) {
						System.out.println("An error occured: " + ex.getMessage());
					}
				}
			    JFileChooser fileChooser = new JFileChooser();
				//int returnVal = fileChooser.showOpenDialog(this);
				//if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
				//	try {
					//	BufferedReader reader = new BufferedReader(new FileReader(file));
						//textArea.read(reader, null);
						//reader.close();
						//currentFile = file;
					//} catch (IOException ex) {
						//ex.printStackTrace();
					//}
				//}
				//int returnVal = fileChooser.showOpenDialog(this);
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mtnSave = new JMenuItem("Save");
		mtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textToSave = textArea.getText();
				JFileChooser fileChooser = new JFileChooser();
				int userSelection = fileChooser.showSaveDialog(Mynotepad.this);
				
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					
					try (BufferedWriter writer = new BufferedWriter(new FileWriter((filePath)))) {
						writer.write(textToSave);
						
						JOptionPane.showMessageDialog(Mynotepad. this, "File saved successfully");
					} catch (IOException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(Mynotepad.this, "Error saving file.");
					}
				}
				
			}
		});
		mnNewMenu.add(mtnSave);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Save as");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))){
						writer.write(textArea.getText());
						JOptionPane.showMessageDialog(null, "File saved Successfully.");
					} catch (IOException ex) {
						System.out.println("An error occured" + ex.getMessage());
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Save all");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Page Set Up");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Print");
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Close Tab");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Close Window");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Exit");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mtnUndo = new JMenuItem("Undo");
		mtnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			} 		
			
		});
		mnNewMenu_1.add(mtnUndo);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Cut");
		mnNewMenu_1.add(mntmNewMenuItem_12);
		
		JMenuItem mtnCopy = new JMenuItem("Copy");
		mtnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sourceFile = "Mynotepad"; 
		        String destinationFile = "My private.txt"; 

		        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
		             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                writer.write(line);		                writer.newLine(); 
		            }
	            System.out.println	("File copied successfully!");
		        } catch (IOException e1) {
		            //System.err.println("Error: " + e.getMessage());
		        } 
            }
		
		});
		
		
		mnNewMenu_1.add(mtnCopy);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Paste");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destination = "destination.txt";
				try (BufferedReader  reader = new BufferedReader(new FileReader(destination))) {
					String line;
					
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				textArea.paste();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Delete");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_15);
		
		JMenu mnNewMenu_2 = new JMenu("View");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Zoom");
		mnNewMenu_2.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Status Bar");
		mnNewMenu_2.add(mntmNewMenuItem_17);
		
		JTextArea textArea =  new JTextArea();
		getContentPane().add(textArea, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.WEST);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1, BorderLayout.SOUTH);
	}
}
