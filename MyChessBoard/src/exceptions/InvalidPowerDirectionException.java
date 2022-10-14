package exceptions;
import model.game.Direction;
import model.pieces.Piece;
public class InvalidPowerDirectionException extends InvalidPowerUseException {
private Direction direction;
public InvalidPowerDirectionException(Piece t,Direction d) {
	super(t);
	this.direction=d;
}
public InvalidPowerDirectionException(String s,Piece t,Direction d) {
	super(s,t);
	this.direction=d;
}
public Direction GetDirection() {
	return direction;
}
}
