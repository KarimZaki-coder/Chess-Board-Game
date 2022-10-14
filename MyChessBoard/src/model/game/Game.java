package model.game;
import model.pieces.heroes.*;

import model.pieces.sidekicks.*;
import java.util.Random;

import exceptions.OccupiedCellException;
import model.pieces.*;
import model.game.Cell;

public class Game {
private int payloadPosTarget=6;
private int boardwidth=6;
private int boardheight=7;
private Player player1;
private Player player2;
private Player currentplayer;
private Cell[][] board;
Random r = new Random();
public void Game(Player player1 , Player player2){
	this.player1 = player1;
	this.player2 = player2;
	this.currentplayer = player1;
	this.board = new Cell[boardwidth][boardheight];
}
public Player GetPlayer1() {
	return player1;
}
public Player GetPlayer2() {
	return player2;
}
public void SetCurrentPlayer(Player p) {
	this.currentplayer = p;
}
public Player GetCurrentPlayer() {
	return currentplayer;
}
public int GetPayLoadPosTarget(){
	return payloadPosTarget;
}

public void assemblePieces() {
	Armored a1 = new Armored(player1,this,"BlueArmored");
	Medic m1 = new Medic(player1,this,"BlueMedic");
	Ranged r1 = new Ranged(player1,this,"BlueRanged");
	Speedster sp1 = new Speedster(player1,this,"BlueSpeedster");
	Tech t1 =new Tech(player1,this,"BlueTech");
	Super su1 = new Super(player1,this,"BlueSuper");
	SideKickP1 SK1 = new SideKickP1(player1,this,"BlueSK");
	SideKickP1 SK2 = new SideKickP1(player1,this,"BlueSK");
	SideKickP1 SK3 = new SideKickP1(player1,this,"BlueSK");
	SideKickP1 SK4 = new SideKickP1(player1,this,"BlueSK");
	SideKickP1 SK5 = new SideKickP1(player1,this,"BlueSK");
	SideKickP1 SK6 = new SideKickP1(player1,this,"BlueSK");
	
	Piece[] Player1_SideKicks = new Piece[] {SK1,SK2,SK3,SK4,SK5,SK6};
	Piece[] Player1Pieces = new Piece[] {a1,m1,r1,sp1,t1,su1};
	Piece[] Player1Pieces1 = new Piece[6] ;
	for(int i = 0;i<6;i++) {
		Player1Pieces[i].SetposI(1);
		Player1_SideKicks[i].SetposI(2);
		Player1_SideKicks[i].SetposJ(i);
	}
	for(int j = 0 ; j<6 ; j++) {
		int number = r.nextInt(6);
		if(Player1Pieces1[number]==null) {
			Player1Pieces1[number]=Player1Pieces[j];
			Player1Pieces[j].SetposJ(number);
		}
		else {
			j--;
		}
	 
	}
		Armored a2 = new Armored(player2,this,"RedArmored");
		Medic m2 = new Medic(player2,this,"RedMedic");
		Ranged r2 = new Ranged(player2,this,"RedRanged");
		Speedster sp2 = new Speedster(player2,this,"RedSpeedster");
		Tech t2 =new Tech(player2,this,"RedTech");
		Super su2 = new Super(player2,this,"RedSuper");
		SideKickP2 SK7 = new SideKickP2(player2,this,"RedSK");
		SideKickP2 SK8 = new SideKickP2(player2,this,"RedSK");
		SideKickP2 SK9 = new SideKickP2(player2,this,"RedSK");
		SideKickP2 SK10 = new SideKickP2(player2,this,"RedSK");
		SideKickP2 SK11 = new SideKickP2(player2,this,"RedSK");
		SideKickP2 SK12 = new SideKickP2(player2,this,"RedSK");
		Piece[] Player2_SideKicks = new Piece[] {SK7,SK8,SK9,SK10,SK11,SK12};
		Piece[] Player2Pieces = new Piece[] {a2,m2,r2,sp2,t2,su2};
		Piece[] Player2Pieces1 = new Piece[6] ;
		for(int i = 0;i<6;i++) {
			Player2Pieces[i].SetposI(5);
			Player2_SideKicks[i].SetposI(4);
			Player2_SideKicks[i].SetposJ(i);
		}
		for(int x = 0 ; x<6 ; x++) {
			int num = r.nextInt(6);
			if(Player2Pieces1[num]==null) {
				Player2Pieces1[num]=Player2Pieces[x];
				Player2Pieces[x].SetposJ(num);
			}
			else {
				x--;
			}
			
		}
		for(Piece p : Player1Pieces) {
			board[p.GetposI()][p.GetposJ()].setPiece(p);;
		}
		for(Piece p : Player1_SideKicks ) {
			board[p.GetposI()][p.GetposJ()].setPiece(p);
		}
		for(Piece p : Player2Pieces) {
			board[p.GetposI()][p.GetposJ()].setPiece(p);
		}
		for(Piece p : Player2_SideKicks) {
			board[p.GetposI()][p.GetposJ()].setPiece(p);
		}
		

	}
	public Cell getCellat(int i , int j) {
		return board[i][j];
	}
	public void switchTurns() {
		if(currentplayer == player1) {
			currentplayer=player2;
		}
		else {
			currentplayer=player1;
		}
	}
	public boolean checkWinner() {
		if(currentplayer.getPayLoadpos()>=payloadPosTarget) {
			return true;
		}
		else {
			return false;
		}
	}
	public void RemovePiece(Piece p) {
		board[p.GetposI()][p.GetposJ()]=null;
	}
	public void SideKickAttack(Piece k ,Piece p ) {
		
		board[k.GetposI()][k.GetposJ()].setPiece(p);
	}
	public void TakePlace(Piece a , Piece b) {
		RemovePiece(a);
		a.SetposI(b.GetposI());
		a.SetposJ(b.GetposJ());
		RemovePiece(b);
		board[a.GetposI()][a.GetposJ()].setPiece(a);
	}
	public void Move(Piece p , int i , int j,Direction d) throws OccupiedCellException {
		if(this.board[i][j]==null && CheckEmpty(i,j).GetOwner()==p.GetOwner()) {
			throw new OccupiedCellException("A friendly piece is here" ,p,d);
		}
		else if(this.board[i][j]==null) {
			RemovePiece(p);
			board[i][j].setPiece(p);
			switchTurns();
			
		}
		else {
			p.attack(this.board[i][j].getPiece());
		}
	}
	public Piece CheckEmpty(int i , int j) {
		return board[i][j].getPiece();
	}
	public boolean IsArmored(int i,int j) {
		if(this.getCellat(i, j).getPiece() instanceof Armored) {
			return true;
		}
		else {
			return false;
		}
	}
}
 