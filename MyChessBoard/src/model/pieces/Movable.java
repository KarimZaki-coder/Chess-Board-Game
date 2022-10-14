package model.pieces;
import exceptions.WrongTurnException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import model.game.Direction;

public interface Movable {
	void Move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException;
	void moveDown() throws UnallowedMovementException, OccupiedCellException;
	void moveDownLeft() throws UnallowedMovementException,OccupiedCellException;
	void moveDownRight() throws UnallowedMovementException,OccupiedCellException;
	void moveLeft()throws UnallowedMovementException,OccupiedCellException;
	void moveRight() throws UnallowedMovementException,OccupiedCellException;
	void moveUp() throws UnallowedMovementException,OccupiedCellException;
	void moveUpLeft() throws UnallowedMovementException,OccupiedCellException;
	void moveUpRight() throws UnallowedMovementException,OccupiedCellException;
}
