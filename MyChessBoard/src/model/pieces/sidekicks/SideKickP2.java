package model.pieces.sidekicks;

import exceptions.UnallowedMovementException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class SideKickP2 extends SideKick {

	public SideKickP2(Player p, Game g, String n) {
		super(g.GetPlayer2(), g, n);
		
	}

	public void moveUp() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.UP);
	}
	public void moveUpRight() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.UPRIGHT);
	}
	public void moveUpLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.UPLEFT);
	}	
}
