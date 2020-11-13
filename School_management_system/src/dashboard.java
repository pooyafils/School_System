import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class dashboard extends JFrame {
	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					dashboard frame = new dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    int myvar;

	/**
	 * Create the frame.
	 */
	 Connection conn1=null;
	// JDBC driver name and database URL
	static  final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	//importaing libbary from mysql stuff
	 static final String DB_URL = "jdbc:mysql://localhost/pooya";
	 //name of data base
	   //  Database credentials
	   static final String USER = "root";
	   //user name
	   static final String PASS = "1234pooya";
	   private JTextField txtF;
	   //password
	  /*
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
	 */  
	   //
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("f");
		scrollPane.setOpaque(false);
		scrollPane.setBounds(0, 52, 685, 209);
		contentPane.add(scrollPane);
		 table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		table.setOpaque(false);
		JButton btnShowStudents = new JButton("Show Students");
		btnShowStudents.setBackground(Color.WHITE);
		btnShowStudents.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
					String query1="SELECT* FROM pooya_Table";
					 // Query1
					System.out.println("Before taking hte resultset");
					 PreparedStatement pst1 =conn1.prepareStatement(query1);
					 ResultSet r2=pst1.executeQuery();	 
					 table.setModel(DbUtils.resultSetToTableModel(r2));
				}catch(Exception e1) {
					System.err.println(e1+ " ERROR IS HERE");		
				}	
			}
		});
		btnShowStudents.setBounds(10, 11, 125, 23);
		contentPane.add(btnShowStudents);
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new two().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(145, 11, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int row = table.getSelectedRow();
				
				 
				int modelRow = table.convertRowIndexToModel( row );
				model.removeRow( modelRow );
				 
				  
				
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
					 
					 // Query1
					System.out.println("Before taking hte resultset ROW="+row);
					
					String tableColid;
					
					 
					tableColid = table.getModel().getValueAt(row, 0).toString(); 
					System.out.println("THE  ID IS :"+tableColid);
					
					 
					PreparedStatement 
					pst1 = conn1.prepareStatement("DELETE FROM pooya_Table WHERE Id ="+tableColid + "");
					 //pst1.setString(1, tableColid);
					 pst1.executeUpdate();
					 
					

					 
					 
				
				
				
				
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setBounds(253, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			//@Override
			
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query1="select * FROM pooya_Table where name=?";
					 PreparedStatement pst1 =conn1.prepareStatement(query1);
					 pst1.setString(1,txtF.getText());
					 ResultSet r2=pst1.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(r2));

					 while(r2.next()) {
						 
					 } 
				}catch(Exception e1) {
					System.err.println(e1+ " ERROR IS HERE");
				}
			}

			private void FillTable(JTable table, String[] columnNames) throws SQLException{
				    	String searchedText = txtF.getText();
						//STEP 2: Register JDBC driver
					      try {
							Class.forName("com.mysql.jdbc.Driver");
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					      //STEP 3: Open a connection
					      System.out.println("Connecting to a selected database...");
					      conn1 = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
					      System.out.println("Connected database successfully...");
					      Statement stmt= null;
						stmt = conn1.createStatement();
						 String query3="SELECT id,name,familyName,phoneNr,studentNumber,yearNumber,email FROM pooya_table WHERE familyName ='"+  txtF.getText()+"'";
						 System.out.println(searchedText);
					 PreparedStatement pst2 =conn1.prepareStatement(query3);
					 ResultSet res =pst2.executeQuery();
					 //Create new table model
				        DefaultTableModel tableModel = new DefaultTableModel();

				        //Retrieve meta data from ResultSet
				        ResultSetMetaData metaData = res.getMetaData();

				        //Get number of columns from meta data
				        int columnCount = metaData.getColumnCount();
				       
				      
				        //Get all column names from meta data and add columns to table model
				        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
				            tableModel.addColumn(metaData.getColumnLabel(columnIndex));  	 		
				        }
				        //Create array of Objects with size of column count from meta data
				        Object[] row = new Object[columnCount];
				        //Scroll through result set
				        while (res.next()){
				            //Get object from column with specific index of result set to array of objects
				            for (int i = 0; i < columnCount; i++){
				                row[i] = res.getObject(i+1);
				            }
				            //Now add row to table model with that array of objects as an argument
				            tableModel.addRow(row);
				        }
				        //Now add that table model to your table and you are done :D
				        table.setModel(tableModel);
			}
		});
		btnNewButton_1.setBounds(352, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		txtF = new JTextField();
		txtF.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
				String query1="select * FROM pooya_Table where name=?";
				 PreparedStatement pst1 =conn1.prepareStatement(query1);
				 pst1.setString(1,txtF.getText());
				 ResultSet r2=pst1.executeQuery();
				 table.setModel(DbUtils.resultSetToTableModel(r2));
				 while(r2.next()) {
				 }
			}catch(Exception e1) {
				System.err.println(e1+ " ERROR IS HERE");
			}
			}
		});
		txtF.setToolTipText("Search here...");
		txtF.setBounds(451, 12, 118, 20);
		contentPane.add(txtF);
		txtF.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("print");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header=new MessageFormat("list ");
				MessageFormat footer= new MessageFormat("page");
			try {
				table.print( JTable.PrintMode.FIT_WIDTH,header,footer);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
		});
		btnNewButton_2.setBounds(586, 11, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}