package src;

import java.awt.BorderLayout;
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
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JTextPane;

public class AdminUI extends JFrame {

	private JPanel contentPane;
	private JTextField StudentId, Grade, Year, Course, StudentName, InstructorId, InstructorName, Department;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblCourse;
	private JLabel lblYear;
	private JLabel lblGrade;
	private JButton List, Insert, Delete, Update;
	private JLabel lblSemester;
	private JTextField textField_1;
	private JTextField salaryTextField;
	private JLabel salaryLabel;
	private JTextPane txtpnInOrderTo;
	private JScrollPane scrollPane;

	private FromDB instanceOfDB = new FromDB();
	private TableUI tbUI = new TableUI();
	private static JTextField totalCredit;

	public AdminUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel studentidlabel = new JLabel("Student ID  :");
		studentidlabel.setBounds(10, 40, 67, 14);
		contentPane.add(studentidlabel);

		StudentId = new JTextField();
		StudentId.setToolTipText("type your ID");
		StudentId.setBounds(98, 37, 86, 20);
		contentPane.add(StudentId);
		StudentId.setColumns(10);

		JLabel studentnamelabel = new JLabel("Student Name : ");
		studentnamelabel.setBounds(220, 40, 106, 14);
		contentPane.add(studentnamelabel);

		StudentName = new JTextField();
		StudentName.setToolTipText("type student name");
		StudentName.setBounds(336, 37, 96, 20);
		contentPane.add(StudentName);
		StudentName.setColumns(10);

		lblNewLabel = new JLabel("Instructor ID :");
		lblNewLabel.setBounds(10, 79, 76, 14);
		contentPane.add(lblNewLabel);

		InstructorId = new JTextField();
		InstructorId.setBounds(98, 76, 86, 20);
		contentPane.add(InstructorId);
		InstructorId.setColumns(10);

		lblNewLabel_1 = new JLabel("Instructor Name :");
		lblNewLabel_1.setBounds(220, 79, 106, 14);
		contentPane.add(lblNewLabel_1);

		InstructorName = new JTextField();
		InstructorName.setBounds(336, 76, 98, 20);
		contentPane.add(InstructorName);
		InstructorName.setColumns(10);

		lblNewLabel_3 = new JLabel("Department :");
		lblNewLabel_3.setBounds(220, 121, 86, 14);
		contentPane.add(lblNewLabel_3);

		Department = new JTextField();
		Department.setBounds(336, 118, 96, 20);
		contentPane.add(Department);
		Department.setColumns(10);

		lblCourse = new JLabel("Course :");
		lblCourse.setBounds(10, 121, 76, 14);
		contentPane.add(lblCourse);

		Course = new JTextField();
		Course.setBounds(98, 118, 86, 20);
		contentPane.add(Course);
		Course.setColumns(10);

		lblYear = new JLabel("Year :");
		lblYear.setBounds(220, 164, 46, 14);
		contentPane.add(lblYear);

		Year = new JTextField();
		Year.setBounds(336, 161, 96, 20);
		contentPane.add(Year);
		Year.setColumns(10);

		lblGrade = new JLabel("Grade : ");
		lblGrade.setBounds(10, 167, 67, 14);
		contentPane.add(lblGrade);

		Grade = new JTextField();
		Grade.setBounds(98, 164, 86, 20);
		contentPane.add(Grade);
		Grade.setColumns(10);

		List = new JButton("List");
		List.setBounds(336, 259, 96, 23);
		contentPane.add(List);

		List.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				tbUI.setTitle("QUERY RESULT");
				tbUI.setVisible(true);

				if (InstructorId.getText().equals("") && StudentId.getText().equals(""))
					instanceOfDB.connection2((instanceOfDB.selectAll("instructor")), tbUI.getTable());
				else if (InstructorId.getText().equals("") && !StudentId.getText().equals(""))
					instanceOfDB.connection2((instanceOfDB.selectAll("student")), tbUI.getTable());
				else if (!InstructorId.getText().equals("") && StudentId.getText().equals(""))
					instanceOfDB.connection2((instanceOfDB.selectAll("student")), tbUI.getTable());
				else if (!InstructorId.getText().equals("") && !StudentId.getText().equals(""))
					JOptionPane.showMessageDialog(rootPane, "You have to choose one of them ");

				if (StudentId.getText().equals("this")) {
					instanceOfDB.connection2(instanceOfDB.selectAll("student"), tbUI.getTable());
					StudentId.setText("");
				}
			}
		});

		Insert = new JButton("Insert");
		Insert.setBounds(29, 259, 86, 23);
		contentPane.add(Insert);

		Insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				
				// TO delete a student, user have to entered all fields which are related to student
				// like StrudentId,StudentName, Department , totalCredit
				
				if (!StudentId.getText().equals("") && !StudentName.getText().equals("")
						&& !totalCredit.getText().equals("") && !Department.getText().equals(""))
					instanceOfDB.insertStudent(Integer.parseInt(StudentId.getText()), StudentName.getText(),
							Department.getText(), Integer.parseInt(totalCredit.getText()));
				else
					JOptionPane.showMessageDialog(rootPane, "You have to complete required fields");
				//
				JOptionPane.showMessageDialog(rootPane, "The record successfuly added");

				// try {
				// instanceOfDB.insertRecord(instanceOfDB.insertInstructor(
				// Integer.parseInt(InstructorId.getText()),
				// InstructorName.getText(),
				// Department.getText(),
				// Integer.parseInt(salaryTextField.getText())));
				// JOptionPane.showMessageDialog(rootPane, "Successfuly added");
				// } catch (NumberFormatException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// JOptionPane.showMessageDialog(null, "You have an error");
				// }

			}
		});

		Delete = new JButton("Delete");
		Delete.setBounds(125, 259, 89, 23);
		contentPane.add(Delete);
		Delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
		// Checks different scenarios 

		if(!StudentId.getText().equals("")){
					instanceOfDB.deleteRecord(instanceOfDB.delete(Integer.parseInt(StudentId.getText()), "student"));
					JOptionPane.showMessageDialog(rootPane, "Record successfully deleted");
				
		}else if(!StudentId.getText().equals("") && !InstructorId.getText().equals("")){
	instanceOfDB.deleteRecord(instanceOfDB.delete(Integer.parseInt(StudentId.getText()), "instructor"));
	instanceOfDB.delete(Integer.parseInt(InstructorId.getText()),"instructor" );	
			JOptionPane.showMessageDialog(rootPane, "Records successfully deleted");
		}else
					JOptionPane.showMessageDialog(rootPane, "You should enter the ID of the student in order to delete its record from the db");
			
		
		
		if(!InstructorId.getText().equals("")){
			instanceOfDB.deleteRecord(instanceOfDB.delete(Integer.parseInt(StudentId.getText()), "student"));
			JOptionPane.showMessageDialog(rootPane, "Record successfully deleted");
		
		}	else if(!StudentId.getText().equals("") && !InstructorId.getText().equals("")){
			instanceOfDB.deleteRecord(instanceOfDB.delete(Integer.parseInt(StudentId.getText()), "instructor"));
			instanceOfDB.delete(Integer.parseInt(InstructorId.getText()),"instructor" );	
					JOptionPane.showMessageDialog(rootPane, "Records successfully deleted");
						
		}
				
			
			}
		});

		Update = new JButton("Update");
		Update.setBounds(237, 259, 89, 23);
		contentPane.add(Update);

		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(220, 199, 61, 14);
		contentPane.add(lblSemester);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(334, 196, 98, 20);
		contentPane.add(textField_1);

		salaryTextField = new JTextField();
		salaryTextField.setColumns(10);
		salaryTextField.setBounds(98, 199, 86, 20);
		contentPane.add(salaryTextField);

		salaryLabel = new JLabel("Salary :");
		salaryLabel.setBounds(10, 202, 61, 14);
		contentPane.add(salaryLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 293, 403, 71);
		contentPane.add(scrollPane);

		txtpnInOrderTo = new JTextPane();
		txtpnInOrderTo.setEditable(false);
		scrollPane.setViewportView(txtpnInOrderTo);
		txtpnInOrderTo.setText(
				"IN ORDER TO INSERT STUDENT OR AN INSTRUCTOR TO DB YOU HAVE TO GIVE REQUESTED FIELDS \r\n\r\nFor Students :\r\n-Student ID\r\n-Student Name\r\n-Deparment\r\n- Total credit (BUT NOT MANDATORY)\r\n\r\nFor instructors \r\n-Instructor ID\r\n-Instructor Name,\r\n- Department\r\n- Salary (NOT MANDATORY\r\n)\r\n");

		totalCredit = new JTextField();
		totalCredit.setColumns(10);
		totalCredit.setBounds(336, 227, 96, 20);
		contentPane.add(totalCredit);

		JLabel lblTotalCredit = new JLabel("Total credit : ");
		lblTotalCredit.setBounds(220, 234, 86, 14);
		contentPane.add(lblTotalCredit);

		Update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				tbUI.setTitle("QUERY RESULT");
				tbUI.setVisible(true);
				instanceOfDB.updateRecord(
						instanceOfDB.updateDepartment(Integer.parseInt(StudentId.getText()), Department.getText()));
				JOptionPane.showMessageDialog(rootPane, "The record updated as you requested");

			}
		});

	}
}
