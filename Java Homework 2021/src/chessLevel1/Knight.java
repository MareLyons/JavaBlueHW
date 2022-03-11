package chessLevel1;

import java.awt.Image;
import java.util.ArrayList;

public class Knight extends Piece{

	public Knight(int turn, Image img) {
		super(turn, img);
	}

	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		
		//creates moves list
		ArrayList<int[]> moves = new ArrayList<int[]>();

		//creates list of possible moves for Knight (all L shaped moves)
		int[][] possibleMoves = {{r+1,c+2},{r-1, c+2}, {r+1, c-2}, {r-1, c-2},{r+2, c+1},{r+2, c-1},{r-2, c-1},{r-2,c+1}};
		//goes through all Possible moves
		for(int[] m: possibleMoves){
			//checks the move is in bounds and not moving to a space that holds a teamate of the piece
			if(m[0] < 8 && m[0] >= 0 && m[1] < 8 && m[1] >= 0 && board.getBoard()[m[0]][m[1]].getTeam() != board.getBoard()[r][c].getTeam()) {
				// if both true, adds the move to this pieces move list
				moves.add(m);	
			}	
		}
		//returns the valid moves
		return(moves);
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
