package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Armored extends NonActivatablePowerHero{
	private boolean armorUp = true;
	public Armored(Player player, Game game, String name) {
		super(player, game, name);
		
	}
	public void SetArmorUp(boolean b ) {
		this.armorUp = b;
	}
	public boolean GetArmorUp() {
		return armorUp;
	}
	

}
