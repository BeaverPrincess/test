import java.util.List;

public abstract class ARegularGame<M> implements IRegularGame<M>, Cloneable {
	private static byte NONE = 0;
	private static byte ONE = 1;
	private static byte TWO = 2;
	private byte player = getPlayer1();
	public byte ROWS, COLS;
	public byte board[][];  
	public byte movesDone = 0;
	public byte lastCol = -1;
	public byte lastRow = -1;
	Boolean winsLast = null;
	
	public ARegularGame(byte ROWS, byte COLS) {
		this.ROWS = ROWS;
		this.COLS = COLS;
		board = new byte[ROWS][COLS];
	}
	
	public void setPlayer(byte player) {
		this.player = player;
	}
	
	@Override
	public List<M> moves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGame<M> doMove(M m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte currentPlayer() {
		return player;
	}

	@Override
	public byte otherPlayer(byte p){
		return (p == getPlayer1()) ? getPlayer2() : getPlayer1();
		}
	
	public byte nextPlayer(){
		return otherPlayer(currentPlayer());
	}
	
	public byte lastPlayer(){
		return otherPlayer(currentPlayer());
	}

	@Override
	public boolean noMoreMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean wins() {
		if (winsLast == null) winsLast = wins(lastPlayer());
		return winsLast;
	}
	
	@Override
	public boolean endedGame() {
		// TODO Auto-generated method stub
		return noMoreMove() || wins();
	}

	@Override
	public int evalState(byte player) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getRows() {
		// TODO Auto-generated method stub
		return ROWS;
	}

	@Override
	public byte getCols() {
		// TODO Auto-generated method stub
		return COLS;
	}

	@Override
	public byte getPlayer1() {
		// TODO Auto-generated method stub
		return ONE;
	}

	@Override
	public byte getPlayer2() {
		// TODO Auto-generated method stub
		return TWO;
	}

	@Override
	public byte getPlayerNone() {
		// TODO Auto-generated method stub
		return NONE;
	}

	@Override
	public byte getAtPosition(byte row, byte col) {
		// TODO Auto-generated method stub
		return board[row][col];
	}

	@Override
	public IRegularGame<M> setAtPosition(byte row, byte col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	public ARegularGame clone() throws CloneNotSupportedException {
		ARegularGame result = (ARegularGame)super.clone();
		result.board = board.clone();
		result.winsLast = null;
		for (int i = 0; i < result.board.length; i++)
			result.board[i] = result.board[i].clone();
		return result;
	}
}
