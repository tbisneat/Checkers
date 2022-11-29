import java.util.Scanner;

public class Checkahs {

    public static void main (String[] args) { 
       String[][] board = setUpBoard();
       Scanner scnr = new Scanner (System.in);
      
       while (gameIsNotOver (board)) {
           printBoard (board);
           
           int[] move = getUserInput (scnr);
           
           if (isLegal(board, move)) {
               updateBoard (board, move);
           }
           else {
               System.out.println ("That is not a legal move. Try again.");
               continue;
           }
           
           makeComputerMove (board);
       }
       System.out.println ("You just got Checker'd! (GAME OVER)");
    }
   
    public static String[][] setUpBoard() {
          
       String[][] board = new String [9][9];
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[i].length; j++) {
               board[i][j] = "";
           }
       }
       
       board[8][1] = "WP";
       board[8][3] = "WP";
       board[8][5] = "WP";
       board[8][7] = "WP";
       board[7][2] = "WP";
       board[7][4] = "WP";
       board[7][6] = "WP";
       board[7][8] = "WP";
       board[6][1] = "WP";
       board[6][3] = "WP";
       board[6][5] = "WP";
       board[6][7] = "WP";
       
       board[1][2] = "BP";
       board[1][4] = "BP";
       board[1][6] = "BP";
       board[1][8] = "BP";
       board[2][1] = "BP";
       board[2][3] = "BP";
       board[2][5] = "BP";
       board[2][7] = "BP";
       board[3][2] = "BP";
       board[3][4] = "BP";
       board[3][6] = "BP";
       board[3][8] = "BP";
       
       for (int i = 0; i < 1; i++) {
           for (int j = 0; j < 9; j++) {
               System.out.print (board[i][j] + "     " ); //should numbers across the top
           }
       }   
       System.out.println ();
       
       return board;
   }   
    
   public static void printBoard (String[][] board) {
   
       boolean isWhite = true;
       String emptyBlack = "      ";
       String emptyWhite = "******";
   
       for (int i = 1; i< board.length; i++) {
           for (int j = 1; j < board[i].length; j++) {
               if (isWhite) {
                   System.out.print (emptyWhite);
               } 
               
               else {
                   System.out.print (emptyBlack);
               }
               isWhite = !isWhite;
           }   
           System.out.println ();
           
           for (int j = 1; j < board[i].length; j++) {
               if (isWhite) {
                   if (board[i][j].equals("")) {
                       System.out.print (emptyWhite);
                   }   
                   
                   else {  
                       System.out.print ("**" + board[i][j] + "**");
                   }
               } 
               
               else {
                   if (board[i][j].equals("")) {
                       System.out.print (emptyBlack);
                   } 
                   
                   else {    
                       System.out.print("  " + board[i][j] + "  ");
                   }
               }
               
               isWhite = !isWhite;
           }
           
           System.out.println();
           
           for (int j = 1; j < board[i].length; j++) {
               if (isWhite) {
                   System.out.print(emptyWhite);
               } 
               
               else {
                   System.out.print(emptyBlack);
               }
               
               isWhite = !isWhite;
           }
           
           System.out.println();
           
           isWhite = !isWhite;
       }   
   
   }

   public static boolean gameIsNotOver (String[][] board) {
       return true;
   }

   public static int[] getUserInput (Scanner s) {
       System.out.println(" Enter move (start row start column) (end row end column). ");
       
       int[] retVal = new int[4];
       for (int i = 0; i < retVal.length; i++) {
           retVal[i] = s.nextInt();
       }   
       return retVal;  
   }

   public static boolean isLegal (String[][] board, int[] move) {     
      String emptyBlack = "      ";
      boolean isLegal = true;
      while (board[move[2]][move[3]] == emptyBlack) {
          isLegal = true;
      }  
      return isLegal;   
   } 

   public static void updateBoard (String[][] board, int[] move) {    
       board[move[2]][move[3]] = board[move[0]][move[1]];
       board[move[0]][move[1]] = "";
         
   } 
 
   public static void makeComputerMove (String[][] board) {
   }  
        
}   