import java.util.List;

public interface IGame<M> {
	List<M> moves();	// available moves at a state
	IGame<M> doMove(M m);	// return next state (to move into)
	byte currentPlayer();	
	byte otherPlayer(byte player);
	boolean noMoreMove();	// end condition: no move left, board full
	boolean endedGame();	// end condition: a player wins
	boolean wins(byte player);
	int evalState(byte player);	// evaluate advantage of current state
	boolean wins();
}
