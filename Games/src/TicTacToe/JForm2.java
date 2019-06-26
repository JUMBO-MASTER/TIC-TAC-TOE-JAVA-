package TicTacToe;


import java.awt.EventQueue;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JForm2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static int GameMode = JForm1.sGameMode;
	private String Title = JForm1.sTitle;

	
   private static int[][] winCheck = new int[][]
	            {
		 {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, 
         {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
         {0, 4, 8}, {2, 4, 6}              
	            };
	            
	            
	static JButton btn[] = new JButton[9];
	private ImageIcon icO;
	private ImageIcon icOw;
	private ImageIcon icX;
	private ImageIcon icXw;	 
	
	private static int count = 0;
	private boolean win = false;
	private String whoTurn = "X";
	private String whoWin = null;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JForm2 frame = new JForm2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				

			}
		});
		
	}

	

	public JForm2() {
		

		setTitle(Title);
		setResizable(false);
		URL TKic = JForm2.class.getResource("/icon.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TKic));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 424, 298);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 3));
		
		
		icO = new ImageIcon(getClass().getResource("/O.png"));
		icOw = new ImageIcon(getClass().getResource("/O_win.png"));
		icX = new ImageIcon(getClass().getResource("/X.png"));
		icXw = new ImageIcon(getClass().getResource("/X_win.png"));
		
		for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();
            btn[i].setBackground(Color.white);
            btn[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));
            btn[i].addActionListener(this);
            getContentPane().add(btn[i]);
    		panel.add(btn[i]);
    		
        }

		JButton btnReset = new JButton();
		btnReset.setText("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBackground(new Color(0, 204, 153));
		btnReset.setBounds(117, 319, 198, 41);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				dispose();
		        JForm2 form = new JForm2();
		        form.setVisible(true);
		        count = 0;

			 
					 
			 JOptionPane.showMessageDialog(null, "Reset Successfully !!","Notice",JOptionPane.INFORMATION_MESSAGE); 
				 
			}
		});	

	}
	
	 public void actionPerformed(ActionEvent a) 
	    {
		 count++;
		 
	
		 
		 if (whoTurn == "X") {
			 
			 JButton pressedButton = (JButton)a.getSource();
			 pressedButton.setName("X");
	         pressedButton.setIcon(icX);
	         pressedButton.setDisabledIcon(icX);
	         pressedButton.setEnabled(false); 
	                  
	         whoTurn = "O";

		 } else {
			 
			 JButton pressedButton = (JButton)a.getSource();
			 pressedButton.setName("O");
	         pressedButton.setIcon(icO);
	         pressedButton.setDisabledIcon(icO);
	         pressedButton.setEnabled(false);

	         whoTurn = "X";
	 	 
		 }
		  

		 
		  for(int i=0; i<=7; i++)
          {
			  
			  if(((btn[winCheck[i][0]].getName() =="X") || (btn[winCheck[i][0]].getName() == "O")) 
					  && ((btn[winCheck[i][0]].getName() == btn[winCheck[i][1]].getName()) 
							  && (btn[winCheck[i][1]].getName() == btn[winCheck[i][2]].getName())))   {
				  
				  
				  whoWin = btn[winCheck[i][0]].getName();
				  
				  
				  for (int b = 0; b < 3; b++) {
					  
                     if (whoWin == "O") {
                        btn[winCheck[i][b]].setBackground(new Color(0, 114, 188));
	                    btn[winCheck[i][b]].setIcon(icOw);
	                    btn[winCheck[i][b]].setDisabledIcon(icOw);
                     } else {
	                    btn[winCheck[i][b]].setBackground(new Color(238, 28, 36));
	                    btn[winCheck[i][b]].setIcon(icXw);
	                    btn[winCheck[i][b]].setDisabledIcon(icXw);
                     }  
				  
				  }
				  
				  for (int c = 0; c < btn.length; c++) {
					btn[c].setEnabled(false);	
			            	
			        }
				  
                  win = true;
              }
          }
		  
		  

	if(win)
    {
		win = false;
        JOptionPane.showMessageDialog(null, whoWin + " Wins the game","Congratulations",JOptionPane.INFORMATION_MESSAGE);  
  
        
    }
    else if(count == 9 && !win)
    {
    	win = false;
        JOptionPane.showMessageDialog(null, "There is no winner.","Try Agian!!",JOptionPane.WARNING_MESSAGE);  
   
    } else {
	
	 if (GameMode != 0) {	 
		 
		 if (whoTurn == "O") {
		     int AiPick = sPick(a);
			 btn[AiPick].doClick();
		 }

	   }
	 
     }
	 
  }
	 
	 
	 public static int sPick(ActionEvent a) {
		 
		 int aiPick;
		 Integer xWin = null;
		 Integer xBlock = null;
		 Integer xPlay = null;
		 Integer xPick = null;
		 
		 ArrayList<Integer> canWin = new ArrayList<Integer>();
		 ArrayList<Integer> canBlock = new ArrayList<Integer>();
		 ArrayList<Integer> canPlay = new ArrayList<Integer>();
    	 ArrayList<Integer> vNull = new ArrayList<Integer>();
    	 

   		 for(int y=0; y < btn.length; y++) {
   			 
   			 if (btn[y].getName() == null) {
   				 
   				vNull.add(y);

   		   }
   		 }
   	 

   		for(int i=0; i<=7; i++)
        {
   			

   			if ((btn[winCheck[i][0]].getName() != "X") && (btn[winCheck[i][1]].getName() != "X") && (btn[winCheck[i][2]].getName() != "X") 
   					&& (btn[winCheck[i][0]].getName() == "O") && (btn[winCheck[i][0]].getName() == btn[winCheck[i][1]].getName())
   					|| (btn[winCheck[i][0]].getName() == "O") && (btn[winCheck[i][0]].getName() == btn[winCheck[i][2]].getName())
   					|| (btn[winCheck[i][1]].getName() == "O") && (btn[winCheck[i][1]].getName() == btn[winCheck[i][2]].getName())){
   				
   			
   				
   				  for(int b=0; b<=2; b++) {
   					
   					  if (btn[winCheck[i][b]].getName() == null) {
   						  
   						canWin.add(winCheck[i][b]);
   						  
   					  }
   				  }
              }
   			
   			
   			
   			if ((btn[winCheck[i][0]].getName() != "O") && (btn[winCheck[i][1]].getName() != "O") && (btn[winCheck[i][2]].getName() != "O") 
   					&& (btn[winCheck[i][0]].getName() == "X") && (btn[winCheck[i][0]].getName() == btn[winCheck[i][1]].getName())
   					|| (btn[winCheck[i][0]].getName() == "X") && (btn[winCheck[i][0]].getName() == btn[winCheck[i][2]].getName())
   					|| (btn[winCheck[i][1]].getName() == "X") && (btn[winCheck[i][1]].getName() == btn[winCheck[i][2]].getName())){
   				
   			
   				
   				  for(int c=0; c<=2; c++) {
   					
   					  if (btn[winCheck[i][c]].getName() == null) {
   						  
   						canBlock.add(winCheck[i][c]);
   						  
   					  }
   				  }
              }
   			
   			
   			
   			if((btn[winCheck[i][0]].getName() == "O") || (btn[winCheck[i][1]].getName() == "O") || (btn[winCheck[i][2]].getName() == "O")
   					&& (btn[winCheck[i][0]].getName() != "X") && (btn[winCheck[i][1]].getName() != "X") && (btn[winCheck[i][2]].getName() != "X")){
   				
   				
   			  for(int d=0; d<=2; d++) {
 					
					  if (btn[winCheck[i][d]].getName() == null) {
						  
						canPlay.add(winCheck[i][d]);
						  
					  }
				  }
   			  }
   			
        }
   		 
   		 
   		
           if (canWin.size() != 0) {
        	   
        	   Random r = new Random();
               int rdm= r.nextInt(canWin.size());
               xWin = canWin.get(rdm);
	
            }
   		
   		
           if (canBlock.size() != 0) {
        	   
        	   Random r = new Random();
               int rdm= r.nextInt(canBlock.size());
               xBlock = canBlock.get(rdm);
        		
           }   		
   		
   		
           if (canPlay.size() != 0) {
        	   
        	   Random r = new Random();
               int rdm= r.nextInt(canPlay.size());
               xPlay = canPlay.get(rdm);
        		
           }
           
           
           Random r = new Random();
           int rdm= r.nextInt(vNull.size());
           xPick = vNull.get(rdm);
           
   		 
         if (GameMode == 1) {
        	 
          
        	 aiPick=Integer.valueOf(xPick);
        	 
        	 
         } else if (GameMode == 2) {
        	 
      
        	 if (canWin.size() != 0) {
        		 
        	  aiPick=Integer.valueOf(xWin);
        	 
        	 } else if (canPlay.size() != 0) {
        		 
        	  aiPick=Integer.valueOf(xPlay); 
        	  
        	 } else {
        		 
        	  aiPick=Integer.valueOf(xPick);	 
        	  
        	 }
        	 
        	 
         } else {
        	 
           
        	 if (canWin.size() != 0) {
        		 
           	  aiPick=Integer.valueOf(xWin);
           	  
        	 } else if (canBlock.size() != 0) {
        		 
        	  aiPick=Integer.valueOf(xBlock);
           	 
           	 } else if (canPlay.size() != 0) {
           		 
           	  aiPick=Integer.valueOf(xPlay); 
           	  
           	 } else {
           		 
           	  aiPick=Integer.valueOf(xPick);	 
           	  
           	 }
           	 
            
         }
         
         
         
	     return aiPick;
  
	}
	 
	
	 
	 
}
