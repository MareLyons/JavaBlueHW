package chessLevel1;

import java.awt.Image;
import java.util.ArrayList;

public class Rook extends Piece{

	public Rook(int turn, Image img) {
		super(turn, img);

	}

	//cycles through all possible moves and if valid, adds them to move list
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		//creates move list
		ArrayList<int[]> moves = new ArrayList<int[]>();

		//for loop to run through the possible moves, moving 0 rows and down 1 column
		for(int i = 1; i < 8; i++) {
			//checks if the move is out of bounds
			if(c+i >= 8) {
				break;
			}
			//checks if the move is to an empty space	
			if(board.getBoard()[r][c+i].isEmpty() == true) {
				//if it is adds it to the move list
				int[] move = {r,c+i};
				moves.add(move);
			}
			//checks if the move is to a space that currently holds a piece on this pieces team
			else if(board.getBoard()[r][c+i].getTeam() == board.getBoard()[r][c].getTeam()) {
				//if it does stops the loop, doesnt allow the move
				break;
			}
			//checks if the move is to a space that currently holds a piece on the other team
			else if(board.getBoard()[r][c+i].getTeam() != board.getBoard()[r][c].getTeam()) {
				//if it is adds it to the move list
				int[] move = {r,c+i};
				moves.add(move);
				break;
			}
			
		}
		//for loop to run through the possible moves, moving 0 rows and up 1 column
		for(int i = 1; i < 8; i++) {
			//checks if the move is out of bounds
			if(c-i < 0) {
				break;
			}
			//checks if the move is to an empty space	
			if(board.getBoard()[r][c-i].isEmpty() == true ) {
				//if it is adds it to the move list
				int[] move = {r,c-i};
				moves.add(move);
			}
			//checks if the move is to a space that currently holds a piece on this pieces team
			else if(board.getBoard()[r][c-i].getTeam() == board.getBoard()[r][c].getTeam()) {
				//if it does stops the loop, doesnt allow the move
				break;
			}
			//checks if the move is to a space that currently holds a piece on the other team
			else if(board.getBoard()[r][c-i].getTeam() != board.getBoard()[r][c].getTeam()) {
				//if it is adds it to the move list
				int[] move = {r,c-i};
				moves.add(move);
				break;
			}
		}
		//for loop to run through the possible moves, moving 1 row right and 0 columns
		for(int i = 1; i < 8; i++) {
			//checks if the move is out of bounds
			if(r+i >= 8) {
				break;
			}
			//checks if the move is to an empty space	
			if(board.getBoard()[r+i][c].isEmpty() == true ) {
				//if it is adds it to the move list
				int[] move = {r+i,c};
				moves.add(move);
			}
			//checks if the move is to a space that currently holds a piece on this pieces team
			else if(board.getBoard()[r+i][c].getTeam() == board.getBoard()[r][c].getTeam()) {
				//if it does stops the loop, doesnt allow the move
				break;
			}
			//checks if the move is to a space that currently holds a piece on the other team
			else if(board.getBoard()[r+i][c].getTeam() != board.getBoard()[r][c].getTeam()) {
				//if it is adds it to the move list
				int[] move = {r+i,c};
				moves.add(move);
				break;
			}
		}
		//for loop to run through the possible moves, moving 1 row left and 0 columns
		for(int i = 1; i < 8; i++) {
			//checks if the move is out of bounds
			if(r-i < 0) {
				break;
			}
			//checks if the move is to an empty space	
			if(board.getBoard()[r-i][c].isEmpty() == true ) {
				//if it is adds it to the move list
				int[] move = {r-i,c};
				moves.add(move);
			}
			//checks if the move is to a space that currently holds a piece on this pieces team
			else if(board.getBoard()[r-i][c].getTeam() == board.getBoard()[r][c].getTeam()) {
				//if it does stops the loop, doesnt allow the move
				break;
			}
			//checks if the move is to a space that currently holds a piece on the other team
			else if(board.getBoard()[r-i][c].getTeam() != board.getBoard()[r][c].getTeam()) {
				//if it is adds it to the move list
				int[] move = {r-i,c};
				moves.add(move);
				break;
			}
		}
		//returns the valid moves
		return moves;
	}

	public boolean isEmpty() {
		return false;
	}

	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		
		//gets the list of moves
		ArrayList<int[]> moves = getMoves(board,r,c);
		
		//goes through the moves
		for(int[] m: moves){
			//checks if the move could reach the king
			if(m[0] == kingr && m[1] == kingc) {
				//returns checkmate as true
				return true;
			}
		}
		//if the move cannot reach the king returns it as false
		return false;
	}

}
