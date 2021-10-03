package edu.wofford;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeModelTest {
   @Test
   public void testNewBoard() {
       TicTacToeModel testBoard = new TicTacToeModel();
       boolean allBlank = true;
       for (int i=0; i<3; i++) {
           for (int j=0; j<3; j++) {
                allBlank = allBlank && (testBoard.getMark(i, j) == " ");
           }
       }
       assertTrue(allBlank);
   }


   @Test
   public void testFirstTurn() {
        TicTacToeModel testBoard = new TicTacToeModel();
        assertEquals("X", testBoard.getPlayerTurn());
   }


   @Test
   public void testMark1() {
        TicTacToeModel testBoard = new TicTacToeModel();
        testBoard.markBoard(1, 1);
        assertEquals("X", testBoard.getMark(1, 1));
   }


   @Test
   public void testMark2() {
        TicTacToeModel testBoard = new TicTacToeModel();
        testBoard.markBoard(1, 1);
        testBoard.markBoard(1, 1);
        assertEquals("X", testBoard.getMark(1, 1));
   }


   @Test
   public void testMark3() {
        TicTacToeModel testBoard = new TicTacToeModel();
        testBoard.markBoard(1, 1);
        testBoard.markBoard(1, 1);
        testBoard.markBoard(1, 2);
        assertEquals("O", testBoard.getMark(1, 2));
   }


   @Test
   public void testIsOver() {
        TicTacToeModel testBoard = new TicTacToeModel();
        testBoard.markBoard(0, 0);
        testBoard.markBoard(1, 1);
        testBoard.markBoard(0, 1);
        testBoard.markBoard(1, 2);
        testBoard.markBoard(0, 2);
        assertTrue(testBoard.isOver());
   }

   
   @Test
   public void testToString() {
        TicTacToeModel testBoard = new TicTacToeModel();
        testBoard.markBoard(0, 0);
        testBoard.markBoard(1, 1);
        testBoard.markBoard(0, 1);
        testBoard.markBoard(1, 2);
        testBoard.markBoard(0, 2);
        assertEquals("X|X|X\n-----\n |O|O\n-----\n | | ", testBoard.toString());
   }
}