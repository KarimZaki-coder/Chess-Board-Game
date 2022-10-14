package model.pieces;
import model.pieces.sidekicks.*;
import exceptions.*;
import model.game.*;
import model.pieces.heroes.*;
import model.game.Direction;



public abstract class Piece implements Movable  {
private String name;
private Player owner;
private Game game;
private int posI;
private int posJ;

public Piece(Player p, Game g , String n) {
this.game= g;
this.owner=p;
this.name= n;
}
public Game GetGame() {
	return game;
}

public String GetName() {
	return name;
}
public Player GetOwner() {
	return owner;
}
public void SetposI(int posi) {
	posI = posi;
}
public void SetposJ(int posj) {
	posJ = posj;
}
public int GetposI() {
	return posI;
}
public int GetposJ() {
	return posJ;
}

public void attack(Piece target) {
	 if(target instanceof Armored && ((Armored) target).GetArmorUp()) {
		 ((Armored) target).SetArmorUp(false);
	 }
	 else if(target instanceof SideKick) {
		 this.owner.setSideKilled(this.owner.getSideKilled()+1);
		 this.owner.deadCharacters.add(target);
		 if(this.owner.getSideKilled()%2==0){
			 this.owner.setPayLoadpos(this.owner.getPayLoadpos()+1);
		 }
		 
	 }
	 else if(this instanceof SideKick && target instanceof Hero)	{
		 this.game.RemovePiece(target);
		 target.owner.deadCharacters.add(target);
		 if(target instanceof Armored) {
			 Armored a3 = new Armored(this.owner,this.game,"ArmoredSidekick");
			 this.game.SideKickAttack(this,a3);
		 }
		 else if(target instanceof Medic) {
			 Medic m3 = new Medic(this.owner,this.game,"MedicSidekick");
			 this.game.SideKickAttack(this,m3);
		 }
		 else if(target instanceof Ranged) {
			 Ranged r3 = new Ranged(this.owner,this.game,"RangedSidekick");
			 this.game.SideKickAttack(this,r3);
		 }
		 else if(target instanceof Speedster) {
			 Speedster sp3 = new Speedster(this.owner,this.game,"SpeedsterSidekick");
			 this.game.SideKickAttack(this,sp3);
		 }
		 else if(target instanceof Super) {
			 Super s3 = new Super(this.owner,this.game,"SuperSidekick");
			 this.game.SideKickAttack(this,s3);
		 }
		 else if(target instanceof Tech) {
			 Tech t3 = new Tech(this.owner,this.game,"TechSidekick");
			 this.game.SideKickAttack(this,t3);
		 }
		 this.owner.setPayLoadpos(this.owner.getPayLoadpos()+1);
		 
		 
	 }
	 else {
		 this.game.TakePlace(this, target);
		 this.owner.setPayLoadpos(this.owner.getPayLoadpos()+1);
		 target.owner.deadCharacters.add(target);
	 }
	 this.game.checkWinner();
}

@Override
public void Move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(this.GetOwner()!= this.GetGame().GetCurrentPlayer()){
		throw new WrongTurnException("Not your fuckin turn",this);
		}
		else {
	if(r==Direction.DOWN) {
		moveDown();
	}
	else if(r==Direction.UP) {
		moveUp();
	}
	else if(r==Direction.LEFT) {
		moveLeft();
	}
	else if(r==Direction.RIGHT) {
		moveRight();
	}
	else if(r==Direction.UPLEFT) {
		moveUpLeft();
	}
	else if(r==Direction.DOWNLEFT) {
		moveDownLeft();
	}
	else if(r==Direction.UPRIGHT) {
		moveUpRight();
	}
	else if(r==Direction.DOWNRIGHT) {
		moveDownRight();
		}
	}
}

@Override
public void moveDown() throws UnallowedMovementException,OccupiedCellException {
		if(this instanceof Speedster) {
			if(this.GetposI()==6) {
				this.game.Move(this,1, this.GetposJ(),Direction.DOWN);
				}
			else if(this.GetposI()==5){
				this.game.Move(this,0, this.GetposJ(),Direction.DOWN);
			}
			else {
				this.game.Move(this, this.GetposI()+2, this.GetposJ(),Direction.DOWN);
				}
		}
		else {
			if(this.GetposI()==6) {
			this.game.Move(this,0, this.GetposJ(),Direction.DOWN);
			}
			else {
			this.game.Move(this, this.GetposI()+1, this.GetposJ(),Direction.DOWN);
		}
	}
}

@Override
public void moveDownLeft() throws UnallowedMovementException,OccupiedCellException {
		if(this instanceof Speedster) {
			this.game.Move(this, this.GetposI()+2, this.GetposJ()-2,Direction.DOWNLEFT);
		}
		else {
			this.game.Move(this, this.GetposI()+1, this.GetposJ()-1,Direction.DOWNLEFT);
		}
}

@Override
public void moveDownRight() throws UnallowedMovementException ,OccupiedCellException{
		if(this instanceof Speedster) {
			this.game.Move(this, this.GetposI()+2, this.GetposJ()+2,Direction.DOWNRIGHT);
		}
		else {
			this.game.Move(this, this.GetposI()+1, this.GetposJ()+1,Direction.DOWNRIGHT);
		}
	
}

@Override
public void moveLeft()throws OccupiedCellException, UnallowedMovementException {
	if(this instanceof Speedster) {
		if(this.GetposJ()==0) {
			this.game.Move(this,this.GetposI(), 4,Direction.LEFT);
			}
		else if(this.GetposJ()==1){
			this.game.Move(this,this.GetposI(), 5,Direction.LEFT);
		}
		else {
			this.game.Move(this, this.GetposI(), this.GetposJ()-2,Direction.LEFT);
			}
	}
	else {
		if(this.GetposJ()==0) {
			this.game.Move(this, this.GetposI(), 5,Direction.LEFT);
		}
		else {
			this.game.Move(this, this.GetposI(), this.GetposJ()-1,Direction.LEFT);
		}
		
	}
	
}

@Override
public void moveRight()throws OccupiedCellException, UnallowedMovementException {
		if(this instanceof Speedster) {
			if(this.GetposJ()==5) {
				this.game.Move(this,this.GetposI(), 1, Direction.RIGHT);
				}
			else if(this.GetposJ()==4){
				this.game.Move(this,this.GetposI(), 0,Direction.RIGHT);
			}
			else {
				this.game.Move(this, this.GetposI(), this.GetposJ()+2,Direction.RIGHT);
				}
		}
		else {
		if(this.GetposJ()==5) {
			this.game.Move(this, this.GetposI(), 0,Direction.RIGHT);
		}
	
		else{
			this.game.Move(this, this.GetposI(), this.GetposJ()+1,Direction.RIGHT);
		}
		}
	
	
}

@Override
public void moveUp() throws UnallowedMovementException,OccupiedCellException {
	if(this instanceof Speedster) {
		if(this.GetposI()==0) {
			this.game.Move(this,5, this.GetposJ(),Direction.UP);
			}
		else if(this.GetposI()==1){
			this.game.Move(this,6, this.GetposJ(),Direction.UP);
		}
		else {
			this.game.Move(this, this.GetposI()+2, this.GetposJ(),Direction.UP);
			}
	}
	else {
	
		if(this.GetposI()==0) {
			this.game.Move(this, 6, this.GetposJ(),Direction.UP);
		}
		else {
		this.game.Move(this, this.GetposI()-1, this.GetposJ(),Direction.UP);
		}
	}
}

@Override
public void moveUpLeft() throws UnallowedMovementException ,OccupiedCellException{
	if(this instanceof Speedster) {
		this.game.Move(this, this.GetposI()-2, this.GetposJ()-2,Direction.UPLEFT);
	}
	else {
	
		this.game.Move(this, this.GetposI()-1, this.GetposJ()-1,Direction.UPLEFT);
	}
}

@Override
public void moveUpRight() throws UnallowedMovementException ,OccupiedCellException{
	if(this instanceof Speedster) {
		this.game.Move(this, this.GetposI()-2, this.GetposJ()+2,Direction.UPRIGHT);
	}
	else {
	
		this.game.Move(this, this.GetposI()-1, this.GetposJ()+1,Direction.UPRIGHT);
	}
}
}



