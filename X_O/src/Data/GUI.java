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
	JButton exit,reset,round;
	JPanel[] results = new JPanel[3];
	JLabel xwins,owins,draws;
	int xwin=0,owin=0,draw=0;
	int counter = 0;
	int winnercounter = 0;
	int x=1,o=2;
	int tokenpositions=0;
	Integer [][] pos = new Integer[3][3];
	Font font = new Font("Helvetica", Font.BOLD, 47);
	Font hisfont = new Font("Helvetica", Font.BOLD, 17);
	public GUI() {
		
		this.setBounds(400, 100, 650, 600);
		this.setTitle("TicTac");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		content = this.getContentPane();
		content.setBackground(Color.DARK_GRAY);
		content.setForeground(Color.white);
		results[0] = new JPanel();
		content.add(results[0]);
		results[0].setBounds(450, 50, 150, 80);
		xwins = new JLabel("Player X wins :"+xwin);
		results[0].setBackground(Color.DARK_GRAY);
		xwins.setForeground(Color.white);
		results[0].add(xwins);
		xwins.setBounds(0, 0, 150, 80);
		xwins.setFont(hisfont);
		results[1] = new JPanel();
		content.add(results[1]);
		results[1].setBounds(450, 150, 150, 80);
		owins = new JLabel("Player O wins :"+owin);
		results[1].setBackground(Color.DARK_GRAY);
		owins.setForeground(Color.white);
		owins.setFont(hisfont);
		results[1].add(owins);
		owins.setBounds(0, 0, 150, 80);
		results[2] = new JPanel();
		content.add(results[2]);
		results[2].setBounds(450, 250, 150, 80);
		draws = new JLabel("Draws :"+draw);
		results[2].setBackground(Color.DARK_GRAY);
		draws.setForeground(Color.white);
		results[2].add(draws);
		draws.setBounds(0, 0, 150, 80);
		draws.setFont(hisfont);
		
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
		exit = new JButton("EXIT");
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
		round = new JButton("NEXT ROUND");
		content.add(round);
		round.setEnabled(false);
		round.setBounds(450, 350, 150, 80);
		dark(round);
		round.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pos[0][0]=0;
				pos[0][1]=101;
				pos[0][2]=202;
				pos[1][0]=10;
				pos[1][1]=11;
				pos[1][2]=12;
				pos[2][0]=20;
				pos[2][1]=21;
				pos[2][2]=22;
				counter=0;
				winnercounter = 0;
				tokenpositions = 0;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						board[i][j].setText("");
						board[i][j].setEnabled(true);
						
					}
				}
			}
		});
		reset = new JButton("RESET");
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
			if(player == "X") {
				xwin++;
				xwins.setText("Player X wins : "+xwin);
			}else {
				owin++;
				owins.setText("Player O wins : "+owin);
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					board[i][j].setEnabled(false);
				}
			}
			round.setEnabled(true);
		}
		else if(boardfull()) {
			JOptionPane.showMessageDialog(null, "Tie game.", "TIE", JOptionPane.INFORMATION_MESSAGE);
			draw++;
			draws.setText("Draws : "+draw);
			round.setEnabled(true);
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
