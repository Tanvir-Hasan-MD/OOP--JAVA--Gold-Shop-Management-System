import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class BillPage extends JFrame {

	private static final JLabel textField_csname = null;
	private JPanel contentPane;
	private JTextField textField_n;
	private JTextField textField_cn;
	private JTextField textField_sn;
	private JTextField textField_ad;
	private JTable table;
	double sum = 0;
	int unit = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillPage frame = new BillPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textField_sum;
	private JLabel lblPayment;
	private JLabel lblChange;
	private JTextField textField_payment;
	private JTextField textField_change;
	
	/**
	 * Create the frame.
	 */
	public BillPage() {
		setResizable(false);
		connection=sqliteConnection.dbConnector();
		
		try{
			String query1 = "select max(id) from Billpay;";
			PreparedStatement pst1 = connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			Sell.billId = Integer.valueOf(rs1.getString(1));
			System.out.println(Sell.billId);

			pst1.execute();
			pst1.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 736, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Name");
		label.setBounds(31, 79, 54, 21);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		contentPane.add(label);
		
		textField_n = new JTextField();
		textField_n.setBounds(85, 80, 70, 20);
		textField_n.setColumns(10);
		contentPane.add(textField_n);
		
		JLabel label_1 = new JLabel("Contact");
		label_1.setBounds(31, 113, 46, 14);
		label_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		contentPane.add(label_1);
		
		textField_cn = new JTextField();
		textField_cn.setBounds(85, 111, 150, 20);
		textField_cn.setColumns(10);
		contentPane.add(textField_cn);
		
		textField_sn = new JTextField();
		textField_sn.setBounds(165, 80, 70, 20);
		textField_sn.setColumns(10);
		contentPane.add(textField_sn);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setBounds(31, 149, 46, 14);
		label_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		contentPane.add(label_2);
		
		textField_ad = new JTextField();
		textField_ad.setBounds(85, 147, 150, 20);
		textField_ad.setColumns(10);
		contentPane.add(textField_ad);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(20, 56, 223, 118);
		desktopPane.setBorder(new TitledBorder(null, "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		desktopPane.setBackground(new Color(255, 255, 0));
		contentPane.add(desktopPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 66, 223, 106);
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(387, 67, 333, 374);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setViewportView(table);
		
		try {
			String query = "select g_id 'ID', g_type 'Type', g_weight 'Weight', g_unit 'Unit' ,g_price 'Price',date 'Date' from Billpay where id='"+Sell.billId+"' ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			for(int i = 0; i<table.getRowCount();i++)
			{
				unit = Integer.parseInt(table.getValueAt(i, 3)+"");
				sum += Double.parseDouble(table.getValueAt(i, 4)+"")*unit;
			}
			
			//System.out.println("Sum"+sum);
			JLabel lblTotalrm = new JLabel("Total (RM)");
			lblTotalrm.setBounds(31, 219, 71, 14);
			contentPane.add(lblTotalrm);
			
			textField_sum = new JTextField();
			textField_sum.setBounds(112, 216, 108, 20);
			
			textField_sum.setText(String.valueOf(sum));
			
			
			query = "select c_name,c_sname, c_contact, c_address from Billpay where bill_id='"+Sell.billId+"' ";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			rs.next();
			
			textField_n.setText(rs.getString("c_name"));
			textField_cn.setText(rs.getString("c_contact"));
			textField_sn.setText(rs.getString("c_sname"));
			textField_ad.setText(rs.getString("c_address"));
			
			pst.close();
			rs.close();
			textField_sum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {					
					
				}
			});
			contentPane.add(textField_sum);
			textField_sum.setColumns(10);
			
			lblPayment = new JLabel("Payment");
			lblPayment.setBounds(31, 254, 83, 14);
			contentPane.add(lblPayment);
			
			lblChange = new JLabel("Change");
			lblChange.setBounds(31, 290, 83, 14);
			contentPane.add(lblChange);
			
			textField_change = new JTextField();
			textField_change.setBounds(112, 287, 108, 20);
			textField_change.setColumns(10);
			contentPane.add(textField_change);
			
			textField_payment = new JTextField();
			textField_payment.setBounds(112, 251, 108, 20);
			textField_payment.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					double sum = Double.valueOf(textField_sum.getText());
					sum = Double.valueOf(textField_payment.getText()) - sum;
					textField_change.setText(String.valueOf(new BigDecimal(sum).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue()));
				}
			});
			contentPane.add(textField_payment);
			textField_payment.setColumns(10);
			
			
			
			JDesktopPane desktopPane_1 = new JDesktopPane();
			desktopPane_1.setBounds(20, 190, 286, 147);
			desktopPane_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Bill Payment", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
			desktopPane_1.setBackground(new Color(210, 105, 30));
			contentPane.add(desktopPane_1);
			
			JLabel lblTk = new JLabel("RM");
			lblTk.setFont(new Font("Felix Titling", Font.PLAIN, 14));
			desktopPane_1.add(lblTk);
			
			JLabel label_3 = new JLabel("RM");
			label_3.setFont(new Font("Felix Titling", Font.PLAIN, 14));
			desktopPane_1.add(label_3);
			
			JLabel label_4 = new JLabel("RM");
			label_4.setFont(new Font("Felix Titling", Font.PLAIN, 14));
			desktopPane_1.add(label_4);
			
			JButton btnPaid = new JButton("");
			btnPaid.setBounds(20, 348, 120, 60);
			btnPaid.setIcon(new ImageIcon("Icons\\dollars.png"));
			btnPaid.addActionListener(new ActionListener() {
				BillPage frame = BillPage.this;
				public void actionPerformed(ActionEvent arg0) {
					try {
						System.out.println(Sell.EID);				
						String query1 = "select Sale from EmployeeInfo where EID='"+Sell.EID+"' ";
						PreparedStatement pst1 = connection.prepareStatement(query1);
						ResultSet rs1 = pst1.executeQuery();
						rs1.next();
						double sale = Double.parseDouble(rs1.getString(1));
						double total_sale =sale + sum;
						
						rs1.close();
						pst1.close();
						
						String query2 = "update EmployeeInfo set Sale='"+total_sale+"' where EID='"+Sell.EID+"'";
						PreparedStatement pst2 = connection.prepareStatement(query2);
						pst2.execute();
						
						pst2.close();
						for(int i = 0; i<table.getRowCount();i++)
						{
							String query3 = "select g_unit from Gold where g_id='"+String.valueOf(table.getValueAt(i, 0))+"'";
							PreparedStatement pst3 = connection.prepareStatement(query3);
							ResultSet rs2 = pst3.executeQuery();
							
							int total_unit = rs2.getInt(1);
							System.out.println(total_unit);
							
							int remaining_unit= total_unit - Integer.parseInt(String.valueOf(table.getValueAt(i, 3)));
							pst3.close();
							
							String query4 = "update Gold set g_unit='"+remaining_unit+"' where g_id='"+String.valueOf(table.getValueAt(i, 0))+"'";
							PreparedStatement pst4 = connection.prepareStatement(query4);
							pst4.execute();
							pst4.close();
						}
						
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Bill Done....!");
					frame.dispose();
					Sell sell = new Sell();
					sell.setVisible(true);
					
				}
			});
			btnPaid.setBackground(new Color(51, 204, 255));
			btnPaid.setFont(new Font("Castellar", Font.BOLD, 15));
			contentPane.add(btnPaid);
			
			JLabel lblBillPage = new JLabel("Bill Page");
			lblBillPage.setForeground(Color.WHITE);
			lblBillPage.setFont(new Font("Algerian", Font.BOLD, 15));
			lblBillPage.setBounds(355, 21, 115, 32);
			contentPane.add(lblBillPage);
			
			JLabel label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon("Icons\\dollars.png"));
			label_6.setBounds(270, 11, 93, 58);
			contentPane.add(label_6);
			
			JLabel lblPaid = new JLabel("Paid");
			lblPaid.setForeground(new Color(255, 255, 255));
			lblPaid.setFont(new Font("Forte", Font.BOLD, 25));
			lblPaid.setBounds(31, 411, 77, 21);
			contentPane.add(lblPaid);
			
			JLabel label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon("Icons\\vista_styled_hd_background_by_jcsawyer.jpg"));
			label_5.setBounds(0, 0, 720, 454);
			contentPane.add(label_5);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
