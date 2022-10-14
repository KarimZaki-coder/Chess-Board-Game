package exceptions;
import model.game.Direction;
import model.pieces.Piece;
public class OccupiedCellException extends InvalidMovementException {
public OccupiedCellException(Piece trigger,Direction d) {
	super(trigger,d);
}
public OccupiedCellException(String s,Piece trigger,Direction d) {
	super(s,trigger,d);
}


}
