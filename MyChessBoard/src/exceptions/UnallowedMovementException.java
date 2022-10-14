package exceptions;
import model.game.Direction;
import model.pieces.Piece;
public class UnallowedMovementException extends InvalidMovementException{
public UnallowedMovementException(Piece trigger,Direction d) {
	super(trigger,d);
}
public UnallowedMovementException(String s,Piece trigger,Direction d) {
	super(s,trigger,d);
}
}
