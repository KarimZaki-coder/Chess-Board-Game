package model.game;
import model.pieces.Piece;
import java.util.*;


public class Player {
private String name;
private int payloadpos=0;
private int sideKilled=0;
public ArrayList<Piece> deadCharacters;
public Player(String name) {
	this.name=name;
	this.deadCharacters = new ArrayList<Piece>();
	}
public int getPayLoadpos() {
	return payloadpos;
}
public void setPayLoadpos(int x) {
	this.payloadpos = x;
}
public void setSideKilled(int side) {
	this.sideKilled = side;
}
public int  getSideKilled() {
	return sideKilled;
}
public String getName() {
	return this.name;
}

}
