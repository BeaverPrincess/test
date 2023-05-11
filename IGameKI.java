
public interface IGameKI<M> {
	IGame<M> doBestMove(IGame<M> g);
	M bestMove(IGame<M> g);
}
