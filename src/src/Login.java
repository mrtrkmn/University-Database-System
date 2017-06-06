package src;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.SelectableChannel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private static JTextField userName;
	private static JButton Ok;
	private static String[] values ={"Student","Instructor","Admin"};
	private static JComboBox choice = new JComboBox(values);
	private static JLabel lblPassword = new JLabel("Password :");
	private static JLabel lblUsername = new JLabel("Username :");
	private static JPasswordField passwordField;
	private static Login frame = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					frame.setTitle("Login UI");
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		choice.setBounds(168, 28, 121, 20);
		contentPane.add(choice);
		
		JLabel lblNewLabel = new JLabel("Who are you ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(43, 31, 110, 14);
		contentPane.add(lblNewLabel);
		
		
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(43, 78, 82, 14);
		contentPane.add(lblUsername);
		
		userName = new JTextField();
		userName.setBounds(168, 75, 121, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(43, 128, 82, 14);
		contentPane.add(lblPassword);
		
		 Ok = new JButton("Login");
		Ok.setBounds(200, 180, 89, 23);
		contentPane.add(Ok);
		
		
		JButton Clear = new JButton("Clear");
		Clear.setBounds(60, 180, 89, 23);
		contentPane.add(Clear);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 125, 121, 20);
		contentPane.add(passwordField);
		
		Clear.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// deletes the text in username and password
				userName.setText("");
				passwordField.setText("");

			}
    	    });
		
		Ok.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				frame.setVisible(false);
			
				checkIn();
				
				
			}
    	    });
		
		
	}
	private static void checkIn(){
		
	
		if(choice.getSelectedItem().equals(values[0]) && userName.getText().equals("110510016") && passwordField.getText().equals("0101"))
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						StudentUI frame = new StudentUI();
						frame.setTitle("Student Page");
						frame.setUserName(userName.getText());
						frame.setVisible(true);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			
		}else if (choice.getSelectedItem().equals(values[1]) && userName.getText().equals("007") && passwordField.getText().equals("0101")){
			
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InstructorUI frame = new InstructorUI();
						frame.setTitle("Instructor Page");
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}else if (choice.getSelectedItem().equals(values[2]) && userName.getText().equals("administrator") && passwordField.getText().equals("1010")){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AdminUI frame = new AdminUI();
						frame.setTitle("Admin Page");

						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}else 
			 JOptionPane.showMessageDialog(
                    null,
                     "Wrong username or password or wrong choice of user type try again ! ",
                     "Failure !!",
                     JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	public String getUserName() {
		return userName.getText();
	}
	public  String getUserType(){
		String userType =null;
		if(choice.getSelectedIndex()==0)
			userType=values[0];
		else if(choice.getSelectedIndex()==1)
			userType= values[1];
		else if (choice.getSelectedIndex()==2)
			userType= values[2];
		return userType;
		
	}
}
