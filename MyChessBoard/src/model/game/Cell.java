package model.game;
import model.pieces.Piece;

public class Cell {
private Piece piece;
	public void Cell() {
		this.piece = null;
	}
	public void Cell(Piece piece) {
		this.piece = piece;
	}
	public Piece getPiece() {
		return this.piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
