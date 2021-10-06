package com.Pieces;

import java.util.Collection;

import com.Board.Board;
import com.Board.Move;
import com.Main.Color;

public abstract class Piece {
	
	protected final int piecePos;
	protected final Color pieceColor;
	
	Piece(final int piecePos, final Color pieceColor){
		this.pieceColor = pieceColor;
		this.piecePos = piecePos;
	}
	
	public abstract Collection<Move> calculateAllowedMoves(final Board board);
	public Color getPieceColor(){
		return this.getPieceColor();
	}

}
