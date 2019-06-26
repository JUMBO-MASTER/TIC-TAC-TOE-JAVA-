package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class JForm1 extends JFrame {


	private JPanel contentPane;
	static int sGameMode;
	static String sTitle = null;
	
	URL TKic = JForm1.class.getResource("/icon.png");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JForm1 frame = new JForm1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JForm1() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TKic));
		setTitle("Tic-Tac-Toe (\u0E40\u0E01\u0E21\u0E2A\u0E4C OX)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Tic-Tac-Toe (\u0E40\u0E01\u0E21\u0E2A\u0E4C OX)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(55, 11, 344, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0E40\u0E25\u0E37\u0E2D\u0E01\u0E42\u0E2B\u0E21\u0E14 : \u0E40\u0E1E\u0E37\u0E48\u0E2D\u0E40\u0E25\u0E48\u0E19\u0E40\u0E01\u0E21\u0E2A\u0E4C OX");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(219, 58, 168, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnMode_1 = new JButton("2 Player");
		btnMode_1.setBackground(Color.PINK);
		btnMode_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMode_1.setBounds(107, 104, 216, 50);
		contentPane.add(btnMode_1);
		btnMode_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				 sGameMode = 0;
				 sTitle = "Tic-Tac-Toe (โหมดผู้เล่น 2 คน)";
				 JForm2 form2 = new JForm2();
				 form2.setVisible(true);
				 setVisible(false);
				 
			}
		});		
		
		JButton btnMode_2 = new JButton("Vs. Computer");
		btnMode_2.setBackground(new Color(0, 204, 153));
		btnMode_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMode_2.setBounds(107, 201, 216, 50);
		contentPane.add(btnMode_2);
		btnMode_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				btnMode_1.setVisible(false);
				btnMode_2.setVisible(false);
				
				setTitle("Tic-Tac-Toe (\u0E40\u0E01\u0E21\u0E2A\u0E4C OX) - \u0E40\u0E25\u0E37\u0E2D\u0E01\u0E23\u0E30\u0E14\u0E31\u0E1A\u0E04\u0E27\u0E32\u0E21\u0E22\u0E32\u0E01 Computer");
				
				JButton btnLV_1 = new JButton("Easy : \u0E23\u0E30\u0E14\u0E31\u0E1A\u0E07\u0E48\u0E32\u0E22");
				btnLV_1.setBackground(new Color(102, 204, 255));
				btnLV_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnLV_1.setBounds(108, 104, 213, 43);
				contentPane.add(btnLV_1);
				btnLV_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						 sGameMode = 1;
						 sTitle = "Tic-Tac-Toe (โหมดเล่นกับ computer ระดับง่าย)"; 
						 JForm2 form2 = new JForm2();
						 form2.setVisible(true);
						 setVisible(false);
						 
					}
				});		
				
				JButton btnLV_2 = new JButton("Normal : \u0E23\u0E30\u0E14\u0E31\u0E1A\u0E1B\u0E01\u0E15\u0E34");
				btnLV_2.setBackground(new Color(102, 204, 51));
				btnLV_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnLV_2.setBounds(108, 158, 213, 43);
				contentPane.add(btnLV_2);
				btnLV_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						 sGameMode = 2;
						 sTitle = "Tic-Tac-Toe (โหมดเล่นกับ computer ระดับปกติ)"; 
						 JForm2 form2 = new JForm2();
						 form2.setVisible(true);
						 setVisible(false);
						 
					}
				});		
				
				JButton btnLV_3 = new JButton("Hard : \u0E23\u0E30\u0E14\u0E31\u0E1A\u0E22\u0E32\u0E01");
				btnLV_3.setBackground(new Color(255, 153, 102));
				btnLV_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnLV_3.setBounds(108, 212, 213, 43);
				contentPane.add(btnLV_3);
				btnLV_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						 sGameMode = 3;
						 sTitle = "Tic-Tac-Toe (โหมดเล่นกับ computer ระดับยาก)";
						 JForm2 form2 = new JForm2();
						 form2.setVisible(true);
						 setVisible(false);
						 
					}
				});		
			}
		});		
	}
}
