import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RegularBoard<M> extends JPanel {
	private IRegularGame<M> game;
	final int UNIT = 170;
	private BufferedImage board, redX, blueX, redCircle, blueCircle;
	
	public RegularBoard(IRegularGame<M> game) {
		this.game = game;
		loadImages();
	}
	
	public void setGame(IRegularGame<M> g){
		game = g;
		repaint();
	}
	
	public IRegularGame<M> getGame(){
		return game;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(game.getCols()*UNIT, game.getRows()*UNIT);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(board, 0, 0, null);
		for (byte r = 0; r < game.getRows(); r++) {
			for (byte c = 0; c < game.getCols(); c++) {
				if (game.getAtPosition(r,c) != game.getPlayerNone()){
					//g.setColor(selectColor(game.getAtPosition(r,c)));
					//g.fillOval(c*UNIT,r*UNIT,UNIT,UNIT);
					g.drawImage(selectImage(game.getAtPosition(r,c)), c*UNIT , r*UNIT, null);
				}
			}
		}
	}
	
	private Color selectColor(byte p) {
		if (p == game.getPlayer1()) return Color.CYAN;
		return Color.DARK_GRAY;
	}

	private BufferedImage selectImage(byte p) {
		if (p == game.getPlayer1()) return redX;
		return blueX;
	}
	
	private void loadImages() {
		try {
			System.out.println(getClass().getResource("/Images/board.png"));
	        //System.out.println(getClass().getResource("/Images/redX.png"));
	        //System.out.println(getClass().getResource("/Images/blueX.png"));
	        //System.out.println(getClass().getResource("/Images/redCircle.png"));
	        //System.out.println(getClass().getResource("/Images/blueCircle.png"));
			board = ImageIO.read(getClass().getResourceAsStream("Images/board.png"));
			redX = ImageIO.read(getClass().getResourceAsStream("Images/redX.png"));
			blueX = ImageIO.read(getClass().getResourceAsStream("Images/blueX.png"));
			redCircle = ImageIO.read(getClass().getResourceAsStream("Images/redCircle.png"));
			blueCircle = ImageIO.read(getClass().getResourceAsStream("Images/blueCircle.png"));
		}catch(Exception e) {}
	}
}
