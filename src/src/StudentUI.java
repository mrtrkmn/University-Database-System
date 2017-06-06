package src;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class StudentUI extends JFrame {

	private JPanel contentPane;
	private JTextField userName,InstructorId,InstructorName,Course,Year,Department;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_3,lblCourse,lblYear;
	private static Login log = new Login();
	private static TableUI table = new TableUI();
	static String[] strings = {"S.ID","S.Name","S.Department Name","S.Total_Credit"};
	static Object[][] values = {{"a","a","a","a"},{"a","a","a","a"},{"a","a","a","a"},{"a","a","a","a"},{"a","a","a","a"},{"a","a","a","a"}};
	private static FromDB instanceOfDB ;
	private JTextField textField;
	private JTextField userType;

	
	public StudentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		instanceOfDB= new FromDB();
		JLabel studentidlabel = new JLabel("Username :");
		studentidlabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		studentidlabel.setBounds(164, 34, 77, 14);
		contentPane.add(studentidlabel);
		
		userName = new JTextField();
		userName.setEditable(false);
		userName.setBounds(260, 31, 98, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		
		lblNewLabel = new JLabel("Instructor ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 112, 86, 17);
		contentPane.add(lblNewLabel);
		
		InstructorId = new JTextField();
		InstructorId.setBounds(126, 110, 98, 20);
		contentPane.add(InstructorId);
		InstructorId.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Instructor Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(270, 113, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		InstructorName = new JTextField();
		InstructorName.setBounds(398, 110, 96, 20);
		contentPane.add(InstructorName);
		InstructorName.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Department :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(270, 154, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		Department = new JTextField();
		Department.setBounds(398, 151, 96, 20);
		contentPane.add(Department);
		Department.setColumns(10);
		
		lblCourse = new JLabel("Course ID :");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourse.setBounds(30, 154, 77, 14);
		contentPane.add(lblCourse);
		
		Course = new JTextField();
		Course.setBounds(126, 151, 98, 20);
		contentPane.add(Course);
		Course.setColumns(10);
		
		lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYear.setBounds(270, 193, 46, 14);
		contentPane.add(lblYear);
		
		Year = new JTextField();
		Year.setBounds(398, 190, 98, 20);
		contentPane.add(Year);
		Year.setColumns(10);
		
		JButton List = new JButton("List");
		List.setBounds(398, 226, 96, 23);
		contentPane.add(List);
		
		List.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				
				// lists specific or all  instructors' limited info with given id 
				// if there is no given specific id then it lists all instructors
				if(!InstructorId.getText().equals("") )
				instanceOfDB.connection2(instanceOfDB.selectInstructorWithID(Integer.parseInt(InstructorId.getText())), table.getTable());
				else 
				instanceOfDB.connection2(FromDB.selectInstructor, table.getTable());

			}
    	    });
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSemester.setBounds(30, 193, 86, 14);
		contentPane.add(lblSemester);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(126, 190, 98, 20);
		contentPane.add(textField);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserType.setBounds(164, 62, 77, 14);
		contentPane.add(lblUserType);
		
		userType = new JTextField();
		userType.setText(log.getUserType());
		userType.setColumns(10);
		userType.setBounds(260, 59, 98, 20);
		contentPane.add(userType);
		userType.setEditable(false);
	
	}
	
	public String getUserName(){
		return userName.getText();
	}
	public void setUserName(String text){
		userName.setText(text);
	}
}
