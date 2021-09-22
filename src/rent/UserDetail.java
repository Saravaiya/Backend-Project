package rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserDetail extends JFrame {
	PreparedStatement pst;
    Connection con;
    ResultSet rs;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetail frame = new UserDetail();
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
	public UserDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserDetail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(191, 24, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CustomerId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(52, 72, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CustomerName");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(52, 104, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CustomerAddress");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(52, 143, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PhoneNo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(52, 183, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GovtId");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(52, 222, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(189, 69, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 101, 124, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 140, 124, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 180, 124, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(191, 219, 124, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "insert into UserDetails4(CustomerId,CustomerName,CustomerAddress,PhoneNo,GovtId)values ( ?,?,?,?,?)";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement(sql);
			
		
					
				
					String CustomerId = textField.getText();
					pst.setString(1,CustomerId);
					String CustomerName = textField_1.getText();
					pst.setString(2,CustomerName);
					String CustomerAddress = textField_2.getText();
					pst.setString(3,CustomerAddress);
					String PhoneNo = textField_3.getText();
					pst.setString(4,PhoneNo);
					String GovtId = textField_4.getText();
					pst.setString(5,GovtId);
					
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
		btnNewButton.setBounds(34, 259, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
             try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement("UPDATE UserDetails4 SET CustomerAddress=?,PhoneNo=? where CustomerId=?");
			
		
					
				
					String CustomerAddress = textField_2.getText();
					pst.setString(1,CustomerAddress);
					String PhoneNo = textField_3.getText();
					pst.setString(2,PhoneNo);
				
					String  CustomerId  = textField.getText();
					pst.setString(3, CustomerId);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(154, 260, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "delete from UserDetails4 where CustomerId=? ";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","root");
					pst = con.prepareStatement(sql);
					String CustomerId = textField.getText();
					pst.setString(1,CustomerId);
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(275, 260, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
