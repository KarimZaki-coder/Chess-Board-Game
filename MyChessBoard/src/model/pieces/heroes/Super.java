package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Super extends ActivatablePowerHero   {

	public Super(Player player, Game game, String name) {
		super(player, game, name);
		
	}

	public void moveDownLeft() throws UnallowedMovementException {
	throw new UnallowedMovementException("You cant move in this direction",this,Direction.DOWNLEFT);
	}
	public void moveUpLeft() throws UnallowedMovementException{
	throw new UnallowedMovementException("You cant move in this direction",this,Direction.UPLEFT);
	}
	public void moveDownRight() throws UnallowedMovementException{
	throw new UnallowedMovementException("You cant move in this direction",this,Direction.DOWNRIGHT);
	}
	public void moveUpRight() throws UnallowedMovementException{
	throw new UnallowedMovementException("You cant move in this direction",this,Direction.UPRIGHT);
	}
	public void smash(int i , int j ) {
		
		if(this.GetGame().CheckEmpty(i, j)!=null&& this.GetOwner()!=this.GetGame().getCellat(i, j).getPiece().GetOwner() && this.GetGame().getCellat(i, j).getPiece() instanceof Armored ) {
			if(((Armored) this.GetGame().getCellat(i, j).getPiece()).GetArmorUp()) {
				((Armored) this.GetGame().getCellat(i, j).getPiece()).SetArmorUp(false);
			}
			else {
				this.GetGame().getCellat(i, j).getPiece().GetOwner().deadCharacters.add(this.GetGame().getCellat(i, j).getPiece());
				this.GetGame().RemovePiece(this.GetGame().getCellat(i, j).getPiece());
				this.GetOwner().setPayLoadpos(this.GetOwner().getPayLoadpos()+1);
			}
		
		}
		else if(this.GetGame().CheckEmpty(i, j)!=null&&this.GetOwner()!=this.GetGame().getCellat(i, j).getPiece().GetOwner()) {
			this.GetGame().getCellat(i, j).getPiece().GetOwner().deadCharacters.add(this.GetGame().getCellat(i, j).getPiece());
			this.GetGame().RemovePiece(this.GetGame().getCellat(i, j).getPiece());	
			this.GetOwner().setPayLoadpos(this.GetOwner().getPayLoadpos()+1);
		}
		}
	public void usePower(Direction d) throws WrongTurnException, PowerAlreadyUsedException, InvalidPowerDirectionException {
		if(this.GetOwner()!= this.GetGame().GetCurrentPlayer()){
			throw new WrongTurnException("Not your fuckin turn",this);
			}
	else if(this.GetPowerUsed()==false) {
			
			if(d==Direction.DOWN) {
				
				if(this.GetposI()==5) {
					this.smash(this.GetposI()+1, this.GetposJ());
					this.smash(0, this.GetposJ());
				}
				else if(this.GetposI()==6) {
					this.smash(0, this.GetposJ());
					this.smash(1, this.GetposJ());
				}
				else {
					this.smash(this.GetposI()+1, this.GetposJ());
					this.smash(this.GetposI()+2,this.GetposJ());
				}
				this.SetPowerUsed(true);
			}
			
			else if(d==Direction.UP) {
				if(this.GetposI()==1) {
					this.smash(this.GetposI()-1, this.GetposJ());
					this.smash(6, this.GetposJ());
					}
					else if(this.GetposI()==0) {
						this.smash(6, this.GetposJ());
						this.smash(5, this.GetposJ());
					}
					else {
						this.smash(this.GetposI()-1, this.GetposJ());
						this.smash(this.GetposI()-2,this.GetposJ());
					}
				this.SetPowerUsed(true);
			}
			else if(d==Direction.LEFT) {
				if(this.GetposJ()==1) {
					this.smash(this.GetposI(), this.GetposJ()-1);
					this.smash(this.GetposI(), 5);
					}
					else if(this.GetposI()==0) {
						this.smash(this.GetposI(), 5);
						this.smash(this.GetposI(), 4);
					}
					else {
						this.smash(this.GetposI(), this.GetposJ()-1);
						this.smash(this.GetposI(),this.GetposJ()-2);
					}
				this.SetPowerUsed(true);
			}
			else if(d==Direction.RIGHT) {
				if(this.GetposJ()==5) {
					this.smash(this.GetposI(), this.GetposJ()+1);
					this.smash(this.GetposI(), 0);
					}
					else if(this.GetposI()==6) {
						this.smash(this.GetposI(), 0);
						this.smash(this.GetposI(), 1);
					}
					else {
						this.smash(this.GetposI(), this.GetposJ()+1);
						this.smash(this.GetposI(),this.GetposJ()+2);
					}
				this.SetPowerUsed(true);
			}
			else if(d==Direction.DOWNLEFT || d==Direction.DOWNRIGHT || d==Direction.UPRIGHT || d==Direction.UPLEFT){
				throw new  InvalidPowerDirectionException(this,d);
			}
			
		}
		else {
			// throw powerused exception
		
			throw new PowerAlreadyUsedException(this);
		}
		
		
	}

}
