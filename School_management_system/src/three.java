import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Connection;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class three extends JFrame {
	 
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	//importaing libbary from mysql stuff
	 static final String DB_URL = "jdbc:mysql://localhost/pooya";
	 //name of data base
	   //  Database credentials
	   static final String USER = "root";
	   //user name
	   static final String PASS = "1234pooya";
	   //password
	
	   
	   //Setting Up the Connection
	   public static Connection connects(){
		   //method for connection libary
			Connection conn1=null;
			//you make object
			 
			try{
			
				//STEP 2: Register JDBC driver
			      Class.forName(JDBC_DRIVER);
			      //1
			    //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      
			      conn1 = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			      //1
			      System.out.println("Connected database successfully...");
			    
			      
		}catch(Exception e){
				System.err.println(e);
				System.out.println("1- Error is in catch exception statemnt");	
		}
		return conn1;
		//you return it because you make method with conncetion type and you are returning a object that yo made from conn
		}
	   Connection conn1=null; 
	   //
	private JPanel contentPane;
	//
	private JTextField nametxtField;
	private JTextField familyNametxtField;
	private JTextField phoneNrtxtField;
	private JTextField studentNrtxtField;
	private JTextField yearNrtxtField;
	private JTextField emailtxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					three frame = new three();
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
	public three() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setBounds(34, 59, 71, 14);
		contentPane.add(lblNewLabel);
		
		nametxtField = new JTextField();
		nametxtField.setBounds(34, 84, 133, 20);
		contentPane.add(nametxtField);
		nametxtField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("family name");
		lblNewLabel_1.setBounds(34, 115, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		familyNametxtField = new JTextField();
		familyNametxtField.setBounds(34, 140, 133, 20);
		contentPane.add(familyNametxtField);
		familyNametxtField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("phone number");
		lblNewLabel_2.setBounds(34, 171, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		phoneNrtxtField = new JTextField();
		phoneNrtxtField.setBounds(34, 196, 133, 20);
		contentPane.add(phoneNrtxtField);
		phoneNrtxtField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("student number");
		lblNewLabel_3.setBounds(34, 227, 95, 14);
		contentPane.add(lblNewLabel_3);
		
		studentNrtxtField = new JTextField();
		studentNrtxtField.setBounds(34, 252, 133, 20);
		contentPane.add(studentNrtxtField);
		studentNrtxtField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("year number");
		lblNewLabel_4.setBounds(34, 294, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		yearNrtxtField = new JTextField();
		yearNrtxtField.setBounds(34, 319, 133, 20);
		contentPane.add(yearNrtxtField);
		yearNrtxtField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("email");
		lblNewLabel_5.setBounds(34, 348, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		emailtxtField = new JTextField();
		emailtxtField.setBounds(34, 375, 133, 20);
		contentPane.add(emailtxtField);
		emailtxtField.setColumns(10);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new two().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(385, 415, 89, 23);
		contentPane.add(btnBack);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// Check if Empty
			if (nametxtField.getText().isEmpty()| familyNametxtField.getText().isEmpty()| phoneNrtxtField.getText().isEmpty() 
				| studentNrtxtField.getText().isEmpty() | yearNrtxtField.getText().isEmpty() | emailtxtField.getText().isEmpty() ) {
				// Do stuff here
				JOptionPane.showMessageDialog(null, "Please complete all fields and conitnue!");
				
			}else {
				// do other stuff
				try {
					
					//STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");
				    
				      //STEP 3: Open a connection
				      System.out.println("Connecting to a selected database...");
				      conn1 = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				      System.out.println("Connected database successfully...");
				      
				      Statement stmt= null;
				      //
					System.out.println("Inserting Records to the Table");
					
					stmt = conn1.createStatement();
					//its perred the server to load the data it can be deffernt in other case
				String query1 = "INSERT INTO pooya_table (id,name,familyName,phoneNr,StudentNumber,yearNumber,email) VALUES  (?,?,?,?,?,?,?)";
					//sql line
				id_Increament id_Incr= new id_Increament();
				//you made a object
				 int id= id_Incr.id_Incrementable();
				
			 
			 PreparedStatement pst= conn1.prepareStatement(query1);
			// search in internet
			//you insert data
			 pst.setInt(1, id);
			 pst.setString(2, nametxtField.getText());
			 pst.setString(3, familyNametxtField.getText());
			 pst.setString(4, phoneNrtxtField.getText());
			 pst.setString(5, studentNrtxtField.getText());
			 pst.setString(6, yearNrtxtField.getText());
			 pst.setString(7, emailtxtField.getText());
			 //
			 pst.executeUpdate();
			 
			 /*SETTING UP  THE ACQUIRED DATA TO SET METHODS IN  THE SETGETMETHOD CLASS*/	
			 setGetMethod sgtmth= new setGetMethod();
			//from that class
			  
			 sgtmth.setname(nametxtField.getText());
			 sgtmth.setfamilyName(familyNametxtField.getText());
			 sgtmth.setphoneNr(phoneNrtxtField.getText());
			 sgtmth.setstudentNr(studentNrtxtField.getText());
			 sgtmth.setyearNr(yearNrtxtField.getText());
			 sgtmth.setemail(emailtxtField.getText());
			 
			
				//
			 System.out.println("The Student is  created");
			 pst.close();
			 
				}catch(Exception err) {
					System.out.println("Error is in catch exception statemnt");
					System.err.println(err);
				}
			
			
			
			}
		
			}
		});
		registerBtn.setBounds(34, 427, 89, 23);
		contentPane.add(registerBtn);
	}
}
