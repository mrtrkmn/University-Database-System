package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class InstructorUI extends JFrame {

	private JPanel contentPane;
	private JTextField StudentId;
	private JTextField StudentName;
	private JLabel lblNewLabel_3;
	private JTextField Department;
	private JLabel lblCourse;
	private JTextField Course;
	private JLabel lblYear;
	private JTextField Year;
	private JLabel lblGrade;
	private JTextField Grade;
	private static JTable table;
	static String[] strings = { "S.ID", "S.Name", "S.Department Name", "S.Total_Credit" };
	static Object[][] values = { { "a", "a", "a", "a" } };
	private JButton List;
	private JButton Insert;
	private JButton Delete;
	private JButton Update;
	private static FromDB instanceOfDB;
	private JTextField totalCredit;
	private static TableUI page = new TableUI();
	private JTextField section;
	private JTextField semesterTextField;

	
	
	public InstructorUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		instanceOfDB = new FromDB();
		contentPane.setLayout(null);
		JLabel studentidlabel = new JLabel("Student ID :");
		studentidlabel.setBounds(20, 59, 67, 14);
		contentPane.add(studentidlabel);

		StudentId = new JTextField();
		StudentId.setBounds(99, 56, 86, 20);
		StudentId.setToolTipText("type your ID");
		contentPane.add(StudentId);
		StudentId.setColumns(10);

		JLabel studentnamelabel = new JLabel("Student Name : ");
		studentnamelabel.setBounds(236, 59, 106, 14);
		contentPane.add(studentnamelabel);

		StudentName = new JTextField();
		StudentName.setBounds(337, 56, 96, 20);
		StudentName.setToolTipText("type student name");
		contentPane.add(StudentName);
		StudentName.setColumns(10);

		lblNewLabel_3 = new JLabel("Department :");
		lblNewLabel_3.setBounds(236, 93, 86, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblTotalCredit = new JLabel("Total Credit :");
		lblTotalCredit.setBounds(20, 178, 67, 14);
		contentPane.add(lblTotalCredit);

		totalCredit = new JTextField();
		totalCredit.setBounds(99, 175, 86, 20);
		totalCredit.setColumns(10);
		contentPane.add(totalCredit);

		Department = new JTextField();
		Department.setBounds(337, 90, 96, 20);
		contentPane.add(Department);
		Department.setColumns(10);

		lblCourse = new JLabel("Course :");
		lblCourse.setBounds(20, 93, 96, 14);
		contentPane.add(lblCourse);

		Course = new JTextField();
		Course.setBounds(99, 129, 86, 20);
		contentPane.add(Course);
		Course.setColumns(10);
		
		JLabel lblSection = new JLabel("Section : ");
		lblSection.setBounds(236, 221, 67, 14);
		contentPane.add(lblSection);
		
		section = new JTextField();
		section.setColumns(10);
		section.setBounds(335, 218, 98, 20);
		contentPane.add(section);
		
		JLabel lblSemester = new JLabel("Semester : ");
		lblSemester.setBounds(236, 178, 65, 14);
		contentPane.add(lblSemester);
		
		semesterTextField = new JTextField();
		semesterTextField.setColumns(10);
		semesterTextField.setBounds(335, 175, 98, 20);
		contentPane.add(semesterTextField);

		lblYear = new JLabel("Year :");
		lblYear.setBounds(236, 132, 46, 14);
		contentPane.add(lblYear);

		Year = new JTextField();
		Year.setBounds(335, 129, 98, 20);
		contentPane.add(Year);
		Year.setColumns(10);

		lblGrade = new JLabel("Grade : ");
		lblGrade.setBounds(20, 132, 46, 14);
		contentPane.add(lblGrade);

		Grade = new JTextField();
		Grade.setBounds(99, 87, 86, 20);
		contentPane.add(Grade);
		Grade.setColumns(10);

		List = new JButton("List");
		List.setBounds(337, 288, 96, 23);
		contentPane.add(List);

		List.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				page.setTitle("QUERY RESULT");
				page.setVisible(true);
				
				if (StudentId.getText().equals("") && !StudentName.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.selectStudentsWithNames(StudentName.getText()),
							page.getTable());
				else if (StudentId.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.selectAll("student"), page.getTable());
				else if (StudentId.getText().equals("") && !totalCredit.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.selectStudentsAccordingToTotalCredit(Integer.parseInt(totalCredit.getText())),
							page.getTable());
				
				if(!totalCredit.getText().equals("") && StudentId.getText().equals("") && StudentName.getText().equals("") )
					instanceOfDB.connection2(instanceOfDB.selectStudentsAccordingToTotalCredit(Integer.parseInt(totalCredit.getText())),
							page.getTable());
					
					
				if (!Department.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.selectStudentsAccordingtoDeptName(Department.getText()),
							page.getTable());

				if(!Year.getText().equals("") && !semesterTextField.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.cStatement(Integer.parseInt(Year.getText()),semesterTextField.getText()),page.getTable());
		
				if(!StudentId.getText().equals("") && StudentName.getText().equals("") && Department.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.selectSpecificStudent(Integer.parseInt(StudentId.getText())),
							page.getTable());
				
				if(!StudentId.getText().equals("")&&!Year.getText().equals("") && !semesterTextField.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.cStatementForAStudent(Integer.parseInt(StudentId.getText()), Integer.parseInt(Year.getText()), semesterTextField.getText()),
							page.getTable());
			
				if(!section.getText().equals("")&&!Year.getText().equals("") && !semesterTextField.getText().equals(""))
					instanceOfDB.connection2(instanceOfDB.selectWithSections(Integer.parseInt(Year.getText()),
							semesterTextField.getText(), section.getText()), page.getTable());

				
				
			}
		});

		Insert = new JButton("Insert");
		Insert.setBounds(20, 288, 86, 23);
		Insert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				try {
					instanceOfDB.insertRecord(instanceOfDB.insertStudent(Integer.parseInt(StudentId.getText()),
							StudentName.getText(), Department.getText(), Integer.parseInt(totalCredit.getText())));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "You have to fill all necesseary fields; "
							+ "ID,NAME,DEPARTMENT,TOTALCREDIT"); 
				}
				
				
				 System.out.println("Successfuly added");

			}
		});
		contentPane.add(Insert);

		Delete = new JButton("Delete");
		Delete.setBounds(128, 288, 89, 23);
		contentPane.add(Delete);
		Delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(!StudentId.getText().equals("")){
					instanceOfDB.deleteRecord(instanceOfDB.delete(Integer.parseInt(StudentId.getText()), "student"));
					JOptionPane.showMessageDialog(rootPane, "Record successfully deleted");
				
				}else 
					JOptionPane.showMessageDialog(rootPane, "You should enter the ID of the student in order to delete its record from the db");
				
			}
		});

		Update = new JButton("Update");
		Update.setBounds(233, 288, 89, 23);
		contentPane.add(Update);
		
		

		Update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				page.setTitle("QUERY RESULT");
				page.setVisible(true);
				instanceOfDB.updateRecord(
						instanceOfDB.updateDepartment(Integer.parseInt(StudentId.getText()), Department.getText()));
				JOptionPane.showMessageDialog(rootPane, "The record updated as you requested");
				

			}
		});

	}

}
