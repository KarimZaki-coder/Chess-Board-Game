package exceptions;
import model.game.Direction;
import model.pieces.Piece;

public abstract class InvalidMovementException extends GameActionException {
private	Direction direction;
public InvalidMovementException(Piece trigger,Direction d) {
	super(trigger);
	this.direction=d;
}
public InvalidMovementException(String s ,Piece trigger,Direction d) {
	super(s,trigger);
	this.direction=d;
}
public Direction GetDirection() {
	return direction;
}
}
