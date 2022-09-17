
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\anyone.png"));
		setTitle("Admin Panel");
		setType(Type.POPUP);
		setFont(new Font("Lucida Fax", Font.BOLD, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 488);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		JButton btnNewButton_4 = new JButton("Help");
		btnNewButton_4.setForeground(new Color(128, 0, 0));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(0, 283, 145, 35);
		btnNewButton_4.setFont(btnNewButton_4.getFont().deriveFont(btnNewButton_4.getFont().getSize() + 3f));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help help = new Help();
				help.setVisible(true);
			}
		});
		
		JLabel label1 = new JLabel("");
		label1.setIcon(new ImageIcon("Icons\\gold2.png"));
		label1.setBounds(150, 0, 412, 109);
		contentPane.add(label1);
		
	
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(155, 106, 592, 354);
		label_2.setIcon(new ImageIcon("Icons\\admin-bg2.jpg"));
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("Gold Items");
		btnNewButton.setForeground(new Color(102, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 150, 145, 35);
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getSize() + 3f));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoldList pl = new GoldList();
				pl.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Employee List");
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(0, 195, 145, 35);
		btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getSize() + 3f));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeInfo einfo = new EmployeeInfo();
				einfo.setVisible(true);
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnSellsList = new JButton("Sells List");
		btnSellsList.setForeground(new Color(128, 0, 0));
		btnSellsList.setBackground(Color.WHITE);
		btnSellsList.setBounds(0, 240, 145, 35);
		btnSellsList.setFont(btnSellsList.getFont().deriveFont(btnSellsList.getFont().getSize() + 3f));
		btnSellsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SellsList sl = new SellsList();
				sl.setVisible(true);
				
			}
		});
		contentPane.add(btnSellsList);
		
		
	
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Quit");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setBounds(0, 389, 145, 25);
		btnNewButton_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		contentPane.add(btnNewButton_5);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//frame.dispose();
					PwCngAdmin  pwcnglogin = new PwCngAdmin();
					pwcnglogin.setVisible(true);
					} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnChangePassword.setForeground(new Color(128, 0, 0));
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangePassword.setBackground(Color.WHITE);
		btnChangePassword.setBounds(0, 328, 145, 35);
		contentPane.add(btnChangePassword);
		
		
		JLabel label_3 = new JLabel("");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setIcon(new ImageIcon("Icons\\hex_green_by_sh4rk2010-d5rwvc4.jpg"));
		label_3.setBounds(0, 0, 728, 472);
		contentPane.add(label_3);
	}
}
