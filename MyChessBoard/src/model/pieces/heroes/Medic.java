package model.pieces.heroes;


import exceptions.InvalidPowerTargetException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.*;
import model.pieces.*;


public class Medic extends ActivatablePowerHero{

	public Medic(Player player, Game game, String name) {
		super(player, game, name);
		
	}
	
	public void moveDownLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.DOWNLEFT);
	}
	public void moveUpLeft() throws UnallowedMovementException{
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.UPLEFT);
	}
	public void moveDownRight() throws UnallowedMovementException{
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.DOWNRIGHT);
	}
	public void moveUpRight() throws UnallowedMovementException{
		throw new UnallowedMovementException("You cant move in this direction",this , Direction.UPRIGHT);
	}
	public void revive(int i , int j, Piece p) {
		 
			this.GetGame().getCellat(i, j).setPiece(p);
			this.GetOwner().deadCharacters.remove(p);
		
	}
	public void usePower(Direction d , Piece p) throws WrongTurnException, PowerAlreadyUsedException,InvalidPowerTargetException {
		if(this.GetOwner()!= this.GetGame().GetCurrentPlayer()){
			throw new WrongTurnException("Not your fuckin turn",this);
			}
		else if(this.GetPowerUsed()==false) {
			if(this.GetOwner()!=p.GetOwner()) {
				throw new InvalidPowerTargetException(this,p);
			}
			else if(!this.GetOwner().deadCharacters.contains(p)){
				throw new InvalidPowerTargetException(this,p);
			}
			else {
					
					if(d==Direction.DOWN) {
						if(this.GetGame().getCellat(this.GetposI()+1, this.GetposJ())!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI()+1, this.GetposJ(), p);
						}
			
					}
					else if(d==Direction.UP) {
						if(this.GetGame().getCellat(this.GetposI()-1, this.GetposJ())!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI()-1, this.GetposJ(), p);
						}
			
					}
					else if(d==Direction.RIGHT) {
						if(this.GetGame().getCellat(this.GetposI(), this.GetposJ()+1)!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI(), this.GetposJ()+1, p);
						}
			
					}
					else if(d==Direction.LEFT) {
						if(this.GetGame().getCellat(this.GetposI(), this.GetposJ()-1)!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI(), this.GetposJ()-1, p);
						}
			
					}
					else if(d==Direction.DOWNRIGHT) {
						if(this.GetGame().getCellat(this.GetposI()+1, this.GetposJ()+1)!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI()+1, this.GetposJ()+1, p);
						}
			
					}
					else if(d==Direction.DOWNLEFT) {
						if(this.GetGame().getCellat(this.GetposI()+1, this.GetposJ()-1)!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI()+1, this.GetposJ()-1, p);
						}
			
					}
					else if(d==Direction.UPRIGHT) {
						if(this.GetGame().getCellat(this.GetposI()-1, this.GetposJ()+1)!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI()-1, this.GetposJ()+1, p);
						}
			
					}
					else if(d==Direction.UPLEFT) {
						if(this.GetGame().getCellat(this.GetposI()-1, this.GetposJ()-1)!=null) {
							throw new InvalidPowerTargetException(this,p);
						}
						else {
							this.revive(this.GetposI()-1, this.GetposJ()-1, p);
						}
					}	
			}
			this.SetPowerUsed(true);
		}
		
		else {
			throw new PowerAlreadyUsedException(this);
		}
	}

}

