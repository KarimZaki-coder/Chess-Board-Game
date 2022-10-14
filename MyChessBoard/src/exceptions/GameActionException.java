package exceptions;
import model.pieces.Piece;
public abstract class GameActionException extends Exception {
private Piece trigger;
public GameActionException(Piece p) {
	super();
	this.trigger = p;
	
}
public GameActionException(String s , Piece p) {
	super(s);
	this.trigger=p;
}
public Piece getTrigger() {
	return trigger;
}

}
