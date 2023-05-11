
public interface IRegularGame <M> extends IGame<M>{
	byte getRows();
	byte getCols();
	byte getPlayer1();
	byte getPlayer2();
	byte getPlayerNone();
	byte getAtPosition(byte row, byte col);
	IRegularGame<M> setAtPosition(byte row, byte col);
}
