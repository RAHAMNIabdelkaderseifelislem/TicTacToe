package Data;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame{
	
	Container content;
	JButton[][] board = new JButton[3][3];
	JButton exit,reset;
	int counter = 0;
	int winnercounter = 0;
	int x=1,o=2;
	int tokenpositions=0;
	Integer [][] pos = new Integer[3][3];
	Font font = new Font("Helvetica", Font.BOLD, 47);	
	public GUI() {
		
		this.setBounds(400, 100, 500, 600);
		this.setTitle("TicTac");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		content = this.getContentPane();
		content.setBackground(Color.DARK_GRAY);
		content.setForeground(Color.white);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = new JButton();
				content.add(board[i][j]);
				board[i][j].setBounds(100+i*100, 100+j*100, 100, 100);
				dark(board[i][j]);
			}
		}
		
		
		pos[0][0]=0;
		pos[0][1]=101;
		pos[0][2]=202;
		pos[1][0]=10;
		pos[1][1]=11;
		pos[1][2]=12;
		pos[2][0]=20;
		pos[2][1]=21;
		pos[2][2]=22;
		for(int i = 0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int k=i;
				int t=j;
				board[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(counter % 2 ==0) {
							board[k][t].setText("X");
							pos[k][t] = x;
							counter+=1;
						}
						else {
							board[k][t].setText("O");
							counter+=1;
							pos[k][t] = o;
						}
						board[k][t].setFont(font);
						board[k][t].setEnabled(false);
						winner();
					}
				});
			}
		}
		exit = new JButton("Exit");
		content.add(exit);
		exit.setBounds(200, 420, 100, 50);
		dark(exit);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(content, "Do you want to exit?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION)== JOptionPane.YES_NO_OPTION) {
					
					System.exit(0);
				}
			}
		});
		reset = new JButton("Reset");
		content.add(reset);
		reset.setBounds(200, 30, 100, 50);
		dark(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				visbile(false);
				new GUI();	
			}
		});
		
	}
	
	public void dark(JButton button) {
		button.setBackground(Color.black);
		button.setForeground(Color.white);
	}
	public void winner() {
		winnercounter = 0;
		String player = "";
		if((pos[0][0]==pos[0][1])&&(pos[0][0]==pos[0][2])) {
			winnercounter =2;
			if(pos[0][0]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][0]==pos[1][1])&&(pos[0][0]==pos[2][2])) {
			winnercounter =2;
			if(pos[0][0]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][0]==pos[1][0])&&(pos[0][0]==pos[2][0])) {
			winnercounter =2;
			if(pos[0][0]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[1][0]==pos[1][1])&&(pos[1][0]==pos[1][2])) {
			winnercounter =2;
			if(pos[1][0]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][1]==pos[1][1])&&(pos[0][1]==pos[2][1])) {
			winnercounter =2;
			if(pos[0][1]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[2][0]==pos[2][1])&&(pos[2][0]==pos[2][2])) {
			winnercounter =2;
			if(pos[2][0]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][2]==pos[1][2])&&(pos[0][2]==pos[2][2])) {
			winnercounter =2;
			if(pos[1][2]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][2]==pos[1][1])&&(pos[1][1]==pos[2][0])) {
			winnercounter =2;
			if(pos[1][1]==1) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if(winnercounter==2) {
			JOptionPane.showMessageDialog(null, "Player "+player+" Win.","We have a Winner" , JOptionPane.PLAIN_MESSAGE);
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					board[i][j].setEnabled(false);
				}
			}
		}
		else if(boardfull()) {
			JOptionPane.showMessageDialog(null, "Tie game.", "TIE", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public boolean boardfull() {
		tokenpositions=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if((pos[i][j]==1)||(pos[i][j]==2)) {
					tokenpositions++;
				}
			}
		}
		if(tokenpositions == 9) {
			return true;
		}
		return false;
	}
	public void visbile(boolean set) {
		this.setVisible(set);
	}
}
