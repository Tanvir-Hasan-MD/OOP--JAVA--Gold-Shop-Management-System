
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class Sell extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField textField_cname;
	private JTextField textField_contact;
	private JTextField textField_csname;
	private JTextField textField_address;
	private JDesktopPane desktopPane;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblWeight;
	private JLabel lblUnit;
	private JLabel lblPrice;
	private JLabel lblKarat;
	private JLabel lblSid;
	private JTextField textField_type;
	private JTextField textField_weight;
	private JTextField textField_unit;
	private JTextField textField_price;
	private JTextField textField_karat;
	private JTextField textField_sid;
	private JDesktopPane desktopPane_1;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField textSearchProducts;
	private JDesktopPane desktopPane_2;
	private JDesktopPane desktopPane_3;
	public static int billId = 1;
	int goldId;
	public static int EID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sell frame = new Sell();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JLabel label;
	/**
	 * Create the frame.
	 */
	public Sell() {
		setResizable(false);
		connection=sqliteConnection.dbConnector();
		
		try{
			String query1 = "select max(id) from Billpay";
			PreparedStatement pst1 = connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			billId = Integer.valueOf(rs1.getString(1));
			billId++;
			pst1.execute();
			pst1.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		setTitle("Sell Page");
		setBackground(new Color(204, 102, 51));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 0));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchasStation = new JLabel("Sell");
		lblPurchasStation.setForeground(new Color(255, 255, 255));
		lblPurchasStation.setIcon(new ImageIcon("Icons\\santa_s_bag.png"));
		lblPurchasStation.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblPurchasStation.setBounds(298, 0, 180, 62);
		contentPane.add(lblPurchasStation);
		
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblName.setBounds(21, 73, 54, 21);
		contentPane.add(lblName);
		
		textField_cname = new JTextField();
		textField_cname.setBounds(75, 74, 70, 20);
		contentPane.add(textField_cname);
		textField_cname.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblContact.setBounds(21, 107, 46, 14);
		contentPane.add(lblContact);
		
		textField_contact = new JTextField();
		textField_contact.setColumns(10);
		textField_contact.setBounds(75, 105, 150, 20);
		contentPane.add(textField_contact);
		
		textField_csname = new JTextField();
		textField_csname.setColumns(10);
		textField_csname.setBounds(155, 74, 70, 20);
		contentPane.add(textField_csname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAddress.setBounds(21, 143, 46, 14);
		contentPane.add(lblAddress);
		
		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(75, 141, 150, 20);
		contentPane.add(textField_address);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new TitledBorder(null, "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 50, 223, 118);
		contentPane.add(desktopPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		scrollPane.setBounds(10, 60, 223, 106);
		contentPane.add(scrollPane);
		
		lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblWeight.setBounds(21, 237, 54, 23);
		contentPane.add(lblWeight);
		
		lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblUnit.setBounds(21, 271, 54, 23);
		contentPane.add(lblUnit);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblPrice.setBounds(21, 305, 54, 17);
		contentPane.add(lblPrice);
		
		lblKarat = new JLabel("Karat");
		lblKarat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblKarat.setBounds(21, 335, 54, 17);
		contentPane.add(lblKarat);
		
		textField_weight = new JTextField();
		textField_weight.setColumns(10);
		textField_weight.setBounds(96, 238, 108, 20);
		contentPane.add(textField_weight);
		
		textField_unit = new JTextField();
		textField_unit.setColumns(10);
		textField_unit.setBounds(96, 272, 108, 20);
		contentPane.add(textField_unit);
		
		textField_price = new JTextField();
		textField_price.setColumns(10);
		textField_price.setBounds(96, 303, 108, 20);
		contentPane.add(textField_price);
		
		
		
		textField_karat = new JTextField();
		textField_karat.setColumns(10);
		textField_karat.setBounds(96, 333, 108, 20);
		contentPane.add(textField_karat);
		
		textField_type = new JTextField();
		textField_type.setBounds(96, 208, 108, 20);
		contentPane.add(textField_type);
		textField_type.setColumns(10);
		
		lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(21, 208, 54, 21);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		lblSid = new JLabel("ID");
		lblSid.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblSid.setBounds(269, 121, 54, 23);
		contentPane.add(lblSid);
		
		textField_sid = new JTextField();
		textField_sid.setBounds(290, 121, 80, 20);
		contentPane.add(textField_sid);
		textField_sid.setColumns(10);
		
		desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBorder(new TitledBorder(null, "Seller Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		desktopPane_3.setBackground(Color.LIGHT_GRAY);
		desktopPane_3.setBounds(260, 90, 150, 80);
		contentPane.add(desktopPane_3);
		
		
		
		desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new TitledBorder(null, "Gold Items", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		desktopPane_1.setBackground(Color.LIGHT_GRAY);
		desktopPane_1.setBounds(10, 185, 223, 178);
		contentPane.add(desktopPane_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(434, 144, 263, 300);
		
		
		contentPane.add(scrollPane_1);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table.getSelectedRow();
					String goldId=(table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from Gold where g_id='"+goldId+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while (rs.next())
							{
						
						textField_type.setText(rs.getString("g_type"));
						textField_weight.setText(rs.getString("g_weight"));
						textField_price.setText(rs.getString("g_price"));
						textField_karat.setText(rs.getString("g_karat"));
							}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(table);
		
		textSearchProducts = new JTextField();
		textSearchProducts.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String selection= (String)comboBox.getSelectedItem();
					String query = "select *  from Gold where "+selection+"=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textSearchProducts.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textSearchProducts.setBounds(444, 93, 119, 37);
		contentPane.add(textSearchProducts);
		textSearchProducts.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"g_id", "g_type"}));
		comboBox.setBounds(573, 93, 108, 37);
		contentPane.add(comboBox);
	
		JButton btnAddToBill = new JButton("Add To Bill");
		btnAddToBill.setBounds(255,200,160,80);
		btnAddToBill.setBackground(Color.WHITE);
		btnAddToBill.setFont(new Font("Vrinda", Font.BOLD, 13));
		btnAddToBill.setIcon(new ImageIcon("Icons\\bill-2.png"));
		btnAddToBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int row = table.getSelectedRow();
					String goldId=(table.getModel().getValueAt(row, 0)).toString();
					
					String query = "insert into Billpay (bill_id,c_name,c_sname,c_contact,c_address,g_id,g_type,g_weight,g_unit,g_price,g_karat,EID,id) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1, null);
					pst.setString(2, textField_cname.getText());
					pst.setString(3, textField_csname.getText());
					pst.setString(4, textField_contact.getText());
					pst.setString(5, textField_address.getText());
					pst.setString(6, String.valueOf(goldId));
					pst.setString(7, textField_type.getText());
					pst.setString(8, textField_weight.getText());
					pst.setString(9, textField_unit.getText());
					pst.setString(10, textField_price.getText());
					pst.setString(11, textField_karat.getText());
					pst.setString(12, textField_sid.getText());
					pst.setString(13, String.valueOf(billId));
					
					pst.execute();
					pst.close();
					
					
			
					JOptionPane.showMessageDialog(null, "BillPage Updated!");
					
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
		});
		contentPane.add(btnAddToBill);
		
		JButton btnGoToBillpage = new JButton("Go To Bill Page");
		btnGoToBillpage.addActionListener(new ActionListener() {
			Sell frame = Sell.this;
			public void actionPerformed(ActionEvent arg0) {
				try {
					EID = Integer.parseInt(String.valueOf(textField_sid.getText()));
					
				}catch (Exception e1) {
					e1.printStackTrace();
					}
				frame.dispose();
				BillPage billPage = new BillPage();
				billPage.setVisible(true);
			}
			
		});
		btnGoToBillpage.setForeground(new Color(0, 204, 0));
		btnGoToBillpage.setBackground(Color.WHITE);
		btnGoToBillpage.setFont(new Font("Vrinda", Font.BOLD, 13));
		btnGoToBillpage.setIcon(new ImageIcon("Icons\\bill.png"));
		btnGoToBillpage.setBounds(10, 367, 223, 66);
		contentPane.add(btnGoToBillpage);
		
		desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Items", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		desktopPane_2.setBackground(UIManager.getColor("Button.shadow"));
		desktopPane_2.setBounds(434, 73, 263, 66);
		contentPane.add(desktopPane_2);
		try {
			String query = "select * from Gold";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnLoadProductData = new JButton("Load Gold Items");
			btnLoadProductData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						String query = "select * from Gold";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnLoadProductData.setFont(new Font("Segoe Print", Font.BOLD, 12));
			btnLoadProductData.setBounds(562, 17, 135, 45);
			contentPane.add(btnLoadProductData);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon("Icons\\f9ab3cd3d492197df7be5a99026468db.jpg"));
			label.setBounds(0, 0, 707, 463);
			contentPane.add(label);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
