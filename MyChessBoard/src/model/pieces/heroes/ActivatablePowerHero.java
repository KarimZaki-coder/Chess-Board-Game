package model.pieces.heroes;



import java.awt.Point;

import exceptions.InvalidPowerUseException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public abstract class ActivatablePowerHero extends Hero{
		
	private boolean powerUsed=false;
	
	public ActivatablePowerHero(Player player, Game game, String name) {
		super(player, game, name);
		
		
	}
	public void SetPowerUsed(boolean power) {
		this.powerUsed = power;
	}
	public boolean GetPowerUsed() {
		return powerUsed;
	}

	public void usePower(Direction d, Piece target, Point newPos) {
		
	}
}
