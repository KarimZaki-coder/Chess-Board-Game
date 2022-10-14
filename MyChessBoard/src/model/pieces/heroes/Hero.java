package model.pieces.heroes;
import model.pieces.Piece;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
public abstract class Hero extends Piece{
public Hero(Player player,Game game,String name) {
	super(player,game,name);
}

}
