package rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;

public class BookingCar extends JFrame {
	protected static final JDateChooser dateChooser = null;
	PreparedStatement pst;
    Connection con;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingCar frame = new BookingCar();
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
	public BookingCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(254, 11, 138, 29);
		contentPane.add(lblNewLabel);
		
		JDateChooser from = new JDateChooser();
		from.setBounds(151, 210, 138, 20);
		contentPane.add(from);
		
		JDateChooser To = new JDateChooser();
		To.setBounds(151, 257, 138, 20);
		contentPane.add(To);
		
		JLabel lblNewLabel_1 = new JLabel("BookDate");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(40, 210, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ReturnDate");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(40, 263, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(151, 300, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CarName");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(40, 66, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CarType");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(40, 101, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Source");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(40, 135, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Destination");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(40, 171, 70, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TotalDays");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(40, 306, 78, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Price");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(40, 345, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 63, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 98, 138, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(151, 132, 138, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(151, 168, 138, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(151, 342, 138, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					java.util.Date utilDate=new java.util.Date();
					java.sql.Date BookDate = new java.sql.Date(utilDate.getTime());
					java.sql.Date ReturnDate = new java.sql.Date(utilDate.getTime());
					
					String sql = "insert into Booking2(CarName,CarType,Source,Destination,BookDate,ReturnDate,Price, TotalDays)values ( ?,?,?,?,?,?,?,?)";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement(sql);
					String CarName = textField_1.getText();
					pst.setString(1,CarName);
					String CarType = textField_2.getText();
					pst.setString(2,CarType);
					String Source = textField_3.getText();
					pst.setString(3,Source);
					String Destination = textField_4.getText();
					pst.setString(4,Destination);
					
					pst.setDate(5,BookDate);
					pst.setDate(6,ReturnDate);
					String Price = textField_5.getText();
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
		btnNewButton_1.setBounds(204, 403, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("diff");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
                Date BookDate = from.getDate();
                Date ReturnDate = To.getDate();

                long diffInMillies = Math.abs(BookDate.getTime() - ReturnDate.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

               textField.setText(String.valueOf(diff));

     
     
			}
		});
		btnNewButton.setBounds(40, 403, 89, 23);
		contentPane.add(btnNewButton);
	}
}
