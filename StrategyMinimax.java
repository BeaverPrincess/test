
public class StrategyMinimax<M> implements IGameKI<M> {
	int getDepth() {
		return Integer.MAX_VALUE;
	}
	
	int evalNextState(IGame<M> g, byte player, int depth){
		return minimax(g, player, depth);
	}

	private int minimax(IGame<M> g, byte player, int depth) {
		if(depth==0 || g.endedGame())
			return g.evalState(player);
		
		boolean isMax = g.currentPlayer() == player;
		int resultVal = isMax ? -1 : +1;
		
		for(M m : g.moves()){
			IGame<M> child = g.doMove(m);
			int nextVal = minimax(child,player,depth-1);
			
			if((isMax && nextVal >= resultVal) || (!isMax && nextVal <= resultVal))
				resultVal = nextVal;
		}
		
		return resultVal;
	}
	
	@Override
	public IGame<M> doBestMove(IGame<M> g){
		return g.doMove(bestMove(g));
	}
	
	@Override
	public M bestMove(IGame<M> g){
		return bestMove(g,getDepth());
	}
	
	public M bestMove(IGame<M> g,int depth){
		final byte player = g.currentPlayer();
		int val = Integer.MIN_VALUE;
		M result = null;
	
		for(M m : g.moves()) {
			IGame<M> s = g.doMove(m);
			int eval = evalNextState(s,player,depth-1);
			if(eval > val){
				val = eval;
				result = m;
			}
		}
		return result;
	}
}
