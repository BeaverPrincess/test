import java.util.LinkedList;
import java.util.List;

public class TicTacToe extends ARegularGame<Pair<Byte,Byte>>{
	public TicTacToe() {
		super((byte)3,(byte)3);
	}
	
	public TicTacToe setAtPosition(byte row, byte col){
		return doMove(new Pair<>(row, col));
	}
	
	public List<Pair<Byte,Byte>> moves(){
		List<Pair<Byte,Byte>> result = new LinkedList<>();
		for(byte r = 0; r < getRows(); r++) {
			for(byte c = 0; c < getCols(); c++) {
				if(board[r][c] == getPlayerNone()) {
					result.add(new Pair<>(r,c));
				}
			}
		}
		return result;
	}
	
	@Override 
	public TicTacToe clone() throws CloneNotSupportedException{ 
		return (TicTacToe)super.clone();
	}
	
	@Override
	public TicTacToe doMove(Pair<Byte,Byte> m){
		try {
			TicTacToe result = clone();
			result.setPlayer(nextPlayer());
			result.board[m.first][m.second]=currentPlayer();
			result.movesDone++;
			return result;
		} catch (CloneNotSupportedException ex) {}
		return null;
	}
	
	@Override
	public boolean noMoreMove() {
		return moves().isEmpty();
	}
	
	@Override
	public boolean wins(byte p) {
		return checkRows(p) || checkCols(p) || checkDiag(p);
	}
	
	private boolean checkRows(byte p) {
		byte sum;
		for(byte r = 0; r < getRows(); r++) {
			sum = 0;
			for(byte c = 0; c< getCols(); c++) {
				if(getAtPosition(r,c) == p) sum++;
				if(sum == 3) return true;
			}
		}
		return false;
	}
	
	private boolean checkCols(byte p) {
		byte sum;
		for(byte r = 0; r < getCols(); r++) {
			sum = 0;
			for(byte c = 0; c< getRows(); c++) {
				if(getAtPosition(c,r) == p) sum++;
				if(sum == 3) return true;
			}
		}
		return false;
	}
	
	private boolean checkDiag(byte p) {
		byte sum_1 = 0, sum_2 = 0;
		for(byte i = 0; i < getRows(); i++) {
			if(getAtPosition(i,i)==p) sum_1++;
			if(sum_1 == 3) return true;
		}
		for(byte i = 0; i<getRows(); i++) {
			if(getAtPosition(i, (byte)((byte)getRows()-1-i))== p) sum_2++;
			if(sum_2 == 3) return true;
		}
		return false;
	}
	
	@Override
	public int evalState(byte player){
		if (wins(player))
			return (lastPlayer() == player) ? 10 : -10;
		return 0;
	}
}
