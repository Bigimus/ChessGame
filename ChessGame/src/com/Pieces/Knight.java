package com.Pieces;

import java.util.ArrayList;
import java.util.List;

import com.Board.Board;
import com.Board.BoardUtils;
import com.Board.Move;
import com.Main.Color;
import com.Main.Tile;
import com.google.common.collect.ImmutableList;

public class Knight extends Piece {

	private final static int[] POSSIBLE_MOVE_COORDS = { -17, -15, -10, -6, 6, 10, 15, 17 };

	Knight(int piecePos, Color pieceColor) {
		super(piecePos, pieceColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Move> calculateAllowedMoves(Board board) {

		int moveDestinationCoord;
		final List<Move> allowedMoves = new ArrayList<>();

		for (final int currentMove : POSSIBLE_MOVE_COORDS) {
			moveDestinationCoord = this.piecePos + currentMove;

			if (BoardUtils.isValidTileCoord(moveDestinationCoord)) {

				if (isFirstColumnExclusion(this.piecePos, currentMove)
						|| isSecondColumnExclusion(this.piecePos, currentMove)
						|| isSeventhColumnExclusion(this.piecePos, currentMove)
						|| isEighthColumnExclusion(this.piecePos, currentMove)) {
					continue;
				}

				final Tile moveDestinationTile = board.getTile(moveDestinationCoord);
				if (!moveDestinationTile.isTileOccupied()) {
					allowedMoves.add(new Move());
				} else {
					final Piece pieceAtDestination = moveDestinationTile.getPiece();
					final Color pieceColor = pieceAtDestination.getPieceColor();

					if (this.pieceColor != pieceColor) {
						allowedMoves.add(new Move());
					}
				}
			}
		}

		return ImmutableList.copyOf(allowedMoves);
	}

	private static boolean isFirstColumnExclusion(final int currentPos, final int moveOffset) {
		return BoardUtils.FIRST_COLUMN[currentPos]
				&& (moveOffset == -17 || moveOffset == -10 || moveOffset == 6 || moveOffset == 15);
	}

	private static boolean isSecondColumnExclusion(final int currentPos, final int moveOffset) {
		return BoardUtils.SECOND_COLUMN[currentPos] && (moveOffset == -10 || moveOffset == 6);
	}

	private static boolean isSeventhColumnExclusion(final int currentPos, final int moveOffset) {
		return BoardUtils.SEVENTH_COLUMN[currentPos] && (moveOffset == -6 || moveOffset == 10);
	}

	private static boolean isEighthColumnExclusion(final int currentPos, final int moveOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPos]
				&& (moveOffset == -15 || moveOffset == -6 || moveOffset == 10 || moveOffset == 17);
	}

}
