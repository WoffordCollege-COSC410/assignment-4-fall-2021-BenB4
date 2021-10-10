package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.itextpdf.awt.geom.Dimension;

import org.apache.batik.ext.swing.GridBagConstants;


public class GuiMain extends JFrame implements ActionListener {

    private TicTacToeModel game;
    private JButton[][] gameButtons = new JButton[3][3];
    private JLabel result;


    private void updateGameButtons() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                gameButtons[i][j].setText(game.getMark(i, j));
            }
        }
    }

    private void checkWinner() {
        if (game.hasWinner()) {
			result.setText(game.getPlayerTurn() + " wins");
		} else if(game.isOver()) {
            result.setText("Tie");
        }
    }

    public void actionPerformed(ActionEvent event) {
        if (!game.isOver()) {
            if (event.getSource() == gameButtons[0][0]) {
                game.markBoard(0, 0);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[0][1]) {
                game.markBoard(0, 1);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[0][2]) {
                game.markBoard(0, 2);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[1][0]) {
                game.markBoard(1, 0);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[1][1]) {
                game.markBoard(1, 1);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[1][2]) {
                game.markBoard(1, 2);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[2][0]) {
                game.markBoard(2, 0);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[2][1]) {
                game.markBoard(2, 1);
                updateGameButtons();
                checkWinner();
            } else if (event.getSource() == gameButtons[2][2]) {
                game.markBoard(2, 2);
                updateGameButtons();
                checkWinner();
            }
        }
    }
    
    public GuiMain() {
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(grid);
        setSize(500, 500);

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        result = new JLabel(" ");
        result.setName("result");
        result.setEnabled(false);

        c.anchor = GridBagConstants.NORTH;

        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets.top = 30;
        c.insets.bottom = 5;
        c.gridx = 1;
        c.gridy = 0;

        add(result, c);

        
        game = new TicTacToeModel();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                gameButtons[i][j] = new JButton(" ");
                gameButtons[i][j].setName("location" + j + i);
                gameButtons[i][j].addActionListener(this);
            }
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                c.insets = new Insets(15, 15, 15, 15);
                if (i == 0) {
                    c.insets.left = 30;
                } else if (i == 2) {
                    c.insets.right = 30;
                }

                if (j == 0) {
                    c.insets.top = 30;
                } else if (j == 2) {
                    c.insets.bottom = 40;
                }

                c.ipadx = 50;
                c.ipady = 20;
                c.gridx = i;
                c.gridy = j+1;
                add(gameButtons[i][j], c);
            }
        }



        pack();
    }

    
	public static void main(String[] args) {
	    GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}