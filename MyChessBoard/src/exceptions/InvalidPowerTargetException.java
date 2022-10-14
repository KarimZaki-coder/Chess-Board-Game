package exceptions;
import model.pieces.Piece;
public class InvalidPowerTargetException extends InvalidPowerUseException {
private Piece target;
public InvalidPowerTargetException(Piece t , Piece trgt){
	super(t);
	this.target=trgt;
	
}
public InvalidPowerTargetException(String s , Piece t,Piece trgt ) {
	super(s,t);
	this.target=trgt;
}
public Piece GetTarget() {
	return target;
}
}
