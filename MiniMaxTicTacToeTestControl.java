import javax.swing.JFrame;

public class MiniMaxTicTacToeTestControl extends TicTacToeTestControl{
	StrategyMinimax<Pair<Byte,Byte>> ki = new StrategyMinimax<Pair<Byte,Byte>>();
	
	public MiniMaxTicTacToeTestControl(TicTacToe ttt) {
		super(ttt);
	}
	
	MiniMaxTicTacToeTestControl(){
		this(new TicTacToe());
	}
	
	@Override
	public void whenMousePressed(byte c,byte r){
		if (board.getGame().endedGame())
			return;
		board.setGame((TicTacToe)ki.doBestMove(board.getGame()));
	}
	
	public static void main(String[] args) {
		JFrame f=new JFrame("Tic Tac Toe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MiniMaxTicTacToeTestControl());
		f.pack();
		f.setVisible(true);
	}
}
