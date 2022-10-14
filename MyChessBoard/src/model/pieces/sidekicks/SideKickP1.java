package model.pieces.sidekicks;

import exceptions.UnallowedMovementException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class SideKickP1 extends SideKick {

	public SideKickP1(Player p, Game g, String n) {
		super(g.GetPlayer1(), g, n);
		
	}
	public void moveDown() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.DOWN);
	}
	public void moveDownRight() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.DOWNRIGHT);
	}
	public void moveDownLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.DOWNLEFT);
	}
	

}
