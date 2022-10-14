package model.pieces.heroes;

import java.awt.Point;

import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.*;
import model.pieces.heroes.*;
import exceptions.InvalidMovementException;
import exceptions.InvalidPowerTargetException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;

public class Tech extends ActivatablePowerHero  {

	public Tech(Player player, Game game, String name) {
		super(player, game, name);
		
	}
	public void moveDown() throws UnallowedMovementException  {
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.DOWN);
	}
	public void moveUp() throws UnallowedMovementException {
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.UP);
	}
	public void moveRight() throws UnallowedMovementException {
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.RIGHT);
	}
	public void moveLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.LEFT);
	}
	public void usePower(Piece p , Point newpos) throws WrongTurnException, PowerAlreadyUsedException,InvalidPowerTargetException {
		if(this.GetOwner()!= this.GetGame().GetCurrentPlayer()){
			throw new WrongTurnException("Not your fuckin turn",this);
			}
		if(this.GetPowerUsed()==true) {
			throw new PowerAlreadyUsedException(this);
		}
		//teleport
		if(newpos != null) {
			if(this.GetOwner()==p.GetOwner()) {
				if(this.GetGame().getCellat(newpos.x, newpos.y)!= null) {
					throw new InvalidPowerTargetException("This Position is Occupied by "+ p , this, p);
				}
				else {
					this.GetGame().getCellat(newpos.x, newpos.y).setPiece(p);
					this.GetGame().RemovePiece(p);
				}
			}
			else {
				throw new InvalidPowerTargetException(p+" is an enemy piece ",this,p);
			}
		}
		else {
			// restoring friendly piece power
			if(this.GetOwner()==p.GetOwner()) {
				if(p instanceof ActivatablePowerHero) {
					if(((ActivatablePowerHero) p).GetPowerUsed()==false) {
						throw new InvalidPowerTargetException(p +" didnt use his power yet",this,p);
					}
					else {
						((ActivatablePowerHero) p).SetPowerUsed(false);
					}
				}
				if(p instanceof Armored) {
					if(((Armored) p).GetArmorUp()==true) {
						throw new InvalidPowerTargetException(p +"'s armor is still up",this,p);
					}
					else {
						((Armored) p).SetArmorUp(true);
					}
				}
			}
			// Hacking enemy Power
			else {
				if(p instanceof ActivatablePowerHero) {
					if(((ActivatablePowerHero) p).GetPowerUsed()==false) {
						((ActivatablePowerHero) p).SetPowerUsed(true);
					}
					else {
						throw new InvalidPowerTargetException(p +"'s power is alreay used",this,p);
					}
					
				}
				if(p instanceof Armored) {
					if(((Armored) p).GetArmorUp()==true) {
						((Armored) p).SetArmorUp(false);
					}
					else {
						throw new InvalidPowerTargetException(p +"'s armor is alreay down",this,p);
					}
				}
			}
		}
		
		
		
	}
}
