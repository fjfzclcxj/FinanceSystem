import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.mysql.jdbc.Connection;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transfer {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer window = new Transfer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transfer(Connection conn, int UserNo) {
		initialize(conn, UserNo);
	}
	public Transfer() {
		initialize(null, -1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Connection conn, final int UserNo) {
		// 加个判断 是否登陆 是否连接数据库
		frame = new JFrame();
		frame.setBounds(100, 100, 436, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Balance balance=new Balance(conn, UserNo);
				balance.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBalance.setBounds(66, 100, 100, 30);
		frame.getContentPane().add(btnBalance);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account account=new Account(conn, UserNo);
				account.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAccount.setBounds(242, 100, 100, 30);
		frame.getContentPane().add(btnAccount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				System.exit(0);
			}
		});
		btnExit.setBounds(262, 200, 80, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMenu.setBounds(179, 37, 54, 15);
		frame.getContentPane().add(lblMenu);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hi hi=new Hi();
				hi.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnLogOut.setBounds(168, 200, 80, 23);
		frame.getContentPane().add(btnLogOut);
	}
}
