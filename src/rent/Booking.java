package rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class Booking extends JFrame {
	
	PreparedStatement pst;
    Connection con;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Object from;
	private Object To;

	protected String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
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
	public Booking() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		
		JLabel lblNewLabel = new JLabel("Booking Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(225, 23, 152, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CarName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(97, 65, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CarType");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(97, 102, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Source");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(97, 136, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Destination");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(97, 179, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("BookDate");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(97, 222, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ReturnDate");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(97, 261, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Price");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(97, 297, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("TotalDays");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(97, 337, 89, 14);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(234, 62, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 99, 117, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(234, 133, 117, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(235, 176, 116, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(234, 294, 117, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(234, 334, 117, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(233, 216, 91, 20);
		contentPane.add(dateChooser);

        dateChooser.setDateFormatString("yyyy/MM/dd");
        		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(233, 261, 91, 20);
		contentPane.add(dateChooser_1);
		dateChooser_1.setDateFormatString("yyyy/MM/dd");
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.util.Date utilDate=new java.util.Date();
					java.sql.Date BookDate = new java.sql.Date(utilDate.getTime());
					java.sql.Date ReturnDate = new java.sql.Date(utilDate.getTime());
					
					String sql = "insert into Booking2(CarName,CarType,Source,Destination,BookDate,ReturnDate,Price, TotalDays)values ( ?,?,?,?,?,?,?,?)";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement(sql);
					String CarName = textField.getText();
					pst.setString(1,CarName);
					String CarType = textField_1.getText();
					pst.setString(2,CarType);
					String Source = textField_2.getText();
					pst.setString(3,Source);
					String Destination = textField_3.getText();
					pst.setString(4,Destination);

					
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
					
	                pst.setDate(5,BookDate);
					pst.setDate(6,ReturnDate);

	                long diffInMillies = Math.abs(BookDate.getTime() - ReturnDate.getTime());
	                
	                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	                textField_5.setText(String.valueOf(diff));
	                String Price = textField_4.getText();
					pst.setString(7,Price);
					
	               
	               int  TotalDays =0;
		            pst.setInt(8, TotalDays);	
										 
					
					
					pst.executeUpdate();
					
					
					
					
					
					int price = Integer.parseInt(Price);
					int Amount = TotalDays * price;
					JOptionPane.showMessageDialog(null,"You have to pay Rs "+" "+ Amount +" "+ " for car booking and booking number is "+ThreadLocalRandom.current().nextInt() );
					
					

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(178, 383, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
