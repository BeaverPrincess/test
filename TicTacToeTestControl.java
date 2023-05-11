import javax.swing.JFrame;

public class TicTacToeTestControl extends RegularControl<Pair<Byte,Byte>>{

	public TicTacToeTestControl(TicTacToe ttt) {
		super(ttt);
	}
	/*
	public static void main(String[] args) {
		 //----------- Spiel erzeugen und drei “Steine” legen
		TicTacToe ttt = new TicTacToe();
		ttt = ttt.doMove(new Pair<>((byte)1,(byte)1));
		ttt = ttt.doMove(new Pair<>((byte)0,(byte)0));
		ttt = ttt.doMove(new Pair<>((byte)2,(byte)0));
		 //----------- grafisches Board erstellen
		RegularBoard<Pair<Byte,Byte>> board = new RegularBoard<>(ttt);
		JFrame f=new JFrame("Tic Tac Toe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new TicTacToeTestControl(new TicTacToe()));
		f.pack();
		f.setVisible(true);
	}
	*/
}
