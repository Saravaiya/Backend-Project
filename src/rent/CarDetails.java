package rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarDetails extends JFrame {
	PreparedStatement pst;
    Connection con;
    ResultSet rs;


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarDetails frame = new CarDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

		public CarDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CarDetails");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(287, 11, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CarId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(115, 74, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CarName");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(115, 120, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RegistrationNo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(115, 167, 97, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CarType");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(115, 204, 97, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CarFare");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(115, 243, 66, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CarColour");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(115, 279, 66, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("CarPaper");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(115, 315, 97, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "insert into cardetails(CarId,CarName,RegistratioNo,CarType,CarFare,CarColour,CarPaper)values ( ?,?,?,?,?,?,?)";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement(sql);
			
		
					
				
					String CarId = textField.getText();
					pst.setString(1,CarId);
					String CarName = textField_1.getText();
					pst.setString(2,CarName);
					String RegistrationNo = textField_2.getText();
					pst.setString(3,RegistrationNo);
					String CarType = textField_3.getText();
					pst.setString(4,CarType);
					String CarFare = textField_4.getText();
					pst.setString(5,CarFare);
					String CarColour = textField_5.getText();
					pst.setString(6,CarColour);
					String CarPaper = textField_6.getText();
					pst.setString(7,CarPaper);
					pst.executeUpdate();
					//if(rs.next()) {

					JOptionPane.showMessageDialog(null," inserted Sucessfully" );
					
					/*}
					else {
						JOptionPane.showMessageDialog(null," not inserted Sucessfully" );
					}*/
				}
					
					catch(SQLException  ex){
						JOptionPane.showMessageDialog(null,ex );
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(181, 366, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "delete from cardetails where CarId=? ";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement(sql);
					String CarId = textField.getText();
					pst.setString(1,CarId);
		
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null," Deleted Sucessfully" );
					
				
				}
					
					catch(SQLException  ex){
						JOptionPane.showMessageDialog(null,ex );
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(324, 366, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement("UPDATE cardetails SET CarFare=?,CarPaper=? where CarId=?");
			
		
					
				
					String CarFare = textField_4.getText();
					pst.setString(1,CarFare);
					String CarPaper = textField_6.getText();
					pst.setString(2,CarPaper);
				
					String CarId = textField.getText();
					pst.setString(3,CarId);
					pst.executeUpdate();
					
					System.out.print(pst);

					JOptionPane.showMessageDialog(null," Updated Sucessfully" );
					
				
				}
					
					catch(SQLException  ex){
						JOptionPane.showMessageDialog(null,ex );
					} catch (ClassNotFoundException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}



				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(456, 366, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(304, 71, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(304, 117, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(304, 164, 131, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(304, 201, 131, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(304, 240, 131, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(304, 276, 131, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(304, 312, 131, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}
}
