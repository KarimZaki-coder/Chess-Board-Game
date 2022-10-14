package model.pieces.heroes;

import java.awt.Point;

import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import exceptions.InvalidPowerDirectionException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;

public class Ranged extends ActivatablePowerHero{

	public Ranged(Player player, Game game, String name) {
		super(player, game, name);
		
	}
	public void RangedAttack(Direction d, int i,int j) throws InvalidPowerDirectionException {
		boolean EmptyPath = false;
		// ATTACKIN DOWN
		if(d==Direction.DOWN) {
			for(int k = i+1 ; k<7; k++ ) {
				if(this.GetGame().CheckEmpty(k, j).GetOwner()==this.GetOwner()) {
					EmptyPath = true;
					throw new InvalidPowerDirectionException("A Friendly Piece in the way",this,d);
				}
				else if(this.GetGame().CheckEmpty(k, j) instanceof Armored && ((Armored) this.GetGame().getCellat(k, j).getPiece()).GetArmorUp()) {
					((Armored) this.GetGame().getCellat(k, j).getPiece()).SetArmorUp(false);
					EmptyPath = true;
					break;
				}
				else if(this.GetGame().CheckEmpty(k, j)!=null) {
					this.GetGame().getCellat(k, j).getPiece().GetOwner().deadCharacters.add(this.GetGame().getCellat(k, j).getPiece());
					this.GetGame().RemovePiece(this.GetGame().getCellat(k, j).getPiece());
					this.GetOwner().setPayLoadpos(this.GetOwner().getPayLoadpos()+1);
					EmptyPath = true;
					break;
				}
			}
			if(EmptyPath==false) {
				throw new InvalidPowerDirectionException("No Pieces To Attack",this,d);
			}
		}
		// ATTACKIN UP
		else if(d==Direction.UP) {
			for(int k = i-1 ; k>=0; k-- ) {
				if(this.GetGame().CheckEmpty(k, j).GetOwner()==this.GetOwner()) {
					EmptyPath=true;
					throw new InvalidPowerDirectionException(this,d);
				}
				else if(this.GetGame().CheckEmpty(k, j) instanceof Armored && ((Armored) this.GetGame().getCellat(k, j).getPiece()).GetArmorUp()) {
					((Armored) this.GetGame().getCellat(k, j).getPiece()).SetArmorUp(false);
					EmptyPath=true;
					break;
				}
				else if(this.GetGame().CheckEmpty(k, j)!=null) {
					this.GetGame().getCellat(k, j).getPiece().GetOwner().deadCharacters.add(this.GetGame().getCellat(k, j).getPiece());
					this.GetGame().RemovePiece(this.GetGame().getCellat(k, j).getPiece());
					this.GetOwner().setPayLoadpos(this.GetOwner().getPayLoadpos()+1);
					EmptyPath=true;
					break;
				}
			}
			if(EmptyPath==false) {
				throw new InvalidPowerDirectionException("No Pieces To Attack",this,d);
			}
		}
		// ATTACKIN RIGHT
		else if(d==Direction.RIGHT) {
			for(int k = j+1 ; k<6; k++ ) {
				if(this.GetGame().CheckEmpty(i, k).GetOwner()==this.GetOwner()) {
					EmptyPath=true;
					throw new InvalidPowerDirectionException(this,d);
				}
				else if(this.GetGame().CheckEmpty(i, k) instanceof Armored && ((Armored) this.GetGame().getCellat(i, k).getPiece()).GetArmorUp()) {
					((Armored) this.GetGame().getCellat(i, k).getPiece()).SetArmorUp(false);
					EmptyPath=true;
					break;
				}
				else if(this.GetGame().CheckEmpty(i, k)!=null) {
					this.GetGame().getCellat(i, k).getPiece().GetOwner().deadCharacters.add(this.GetGame().getCellat(i, k).getPiece());
					this.GetGame().RemovePiece(this.GetGame().getCellat(i, k).getPiece());
					this.GetOwner().setPayLoadpos(this.GetOwner().getPayLoadpos()+1);
					EmptyPath=true;
					break;
				}
			}
			if(EmptyPath==false) {
				throw new InvalidPowerDirectionException("No Pieces To Attack",this,d);
			}
		}
		// ATTACKIN LEFT
		else if(d== Direction.LEFT) {
			for(int k = j-1 ; k>=0; k++ ) {
				if(this.GetGame().CheckEmpty(i, k).GetOwner()==this.GetOwner()) {
					EmptyPath=true;
					throw new InvalidPowerDirectionException(this,d);
				}
				else if(this.GetGame().CheckEmpty(i, k) instanceof Armored && ((Armored) this.GetGame().getCellat(i, k).getPiece()).GetArmorUp()) {
					((Armored) this.GetGame().getCellat(i, k).getPiece()).SetArmorUp(false);
					EmptyPath=true;
					break;
				}
				else if(this.GetGame().CheckEmpty(i, k)!=null) {
					this.GetGame().getCellat(i, k).getPiece().GetOwner().deadCharacters.add(this.GetGame().getCellat(i, k).getPiece());
					this.GetGame().RemovePiece(this.GetGame().getCellat(i, k).getPiece());
					this.GetOwner().setPayLoadpos(this.GetOwner().getPayLoadpos()+1);
					EmptyPath=true;
					break;
				}
			}
			if(EmptyPath==false) {
				throw new InvalidPowerDirectionException("No Pieces To Attack",this,d);
			}
		}
		
	}

	public void usePower(Direction d) throws  WrongTurnException, PowerAlreadyUsedException, InvalidPowerDirectionException {
		if(this.GetOwner()!= this.GetGame().GetCurrentPlayer()){
			throw new WrongTurnException("Not your fuckin turn",this);
			}
		
		
		else if(this.GetPowerUsed()==false) {
			
			 if(d==Direction.DOWNLEFT || d==Direction.DOWNRIGHT || d==Direction.UPRIGHT || d==Direction.UPLEFT) {
				throw new InvalidPowerDirectionException(this,d);
				
			}
			 else {
				
				RangedAttack(d, this.GetposI(), this.GetposJ());
				this.SetPowerUsed(true);
			 }
		}

			
		
		else {
			throw new PowerAlreadyUsedException(this);
		}
		
		
	
	}

}
