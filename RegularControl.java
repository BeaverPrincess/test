import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class RegularControl<M> extends JPanel implements MouseListener{
	public RegularBoard<M> board;
	
	public RegularControl(RegularBoard<M> board){
		this.board = board;
		super.add(board);
		super.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				byte c = (byte)(e.getPoint().getX()/board.UNIT);
				byte r = (byte)(e.getPoint().getY()/board.UNIT);
				whenMousePressed(r,c);
			}
		});
	}
	
	public RegularControl(IRegularGame<M> game){
		this(new RegularBoard<M>(game));
	}
	
	

	public void whenMousePressed(byte r, byte c) {
		if (board.getGame().endedGame() || (board.getGame().getAtPosition(r,c) != board.getGame().getPlayerNone())) {
			System.out.println("Game ended!");
			return;
		}
		board.setGame(board.getGame().setAtPosition(r,c));	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
