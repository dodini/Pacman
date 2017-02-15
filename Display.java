import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Display extends JPanel {
    private int xSize;
    private int ySize;
    private int[][] plateform;
    private int[][] gum;
    private int[] pacmanCoord;
    private int[] xGhosts;
    private int[] yGhosts;

    public Display(int x, int y, int[][] pf) {
        xSize = x;
        ySize = y;
        plateform = pf;
        pacmanCoord = new int[2];
    }

    public void setGum(int[][] gumArray) {
        gum = gumArray;
    }

    public void setGhostsCoord(int[] x, int[] y) {
        xGhosts = x;
        yGhosts = y;
    }

    public void setPacmanCoord(int x, int y) {
        pacmanCoord[0] = x;
        pacmanCoord[1] = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        for(int y = 0; y < ySize; y++) {
            for(int x = 0; x < xSize; x++) {
                if(plateform[y][x] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(getWidth()/(xSize+2)*(x+1), getHeight()/(ySize+2)*(y+1), getWidth()/(xSize+2), getHeight()/(ySize+2));
                }
                else {
                    g.setColor(Color.GRAY);
                    g.fillRect(getWidth()/(xSize+2)*(x+1), getHeight()/(ySize+2)*(y+1), getWidth()/(xSize+2), getHeight()/(ySize+2));
                }
                if(gum[y][x] == 1) {
                    //
                    g.setColor(Color.YELLOW);
                    g.fillOval(getWidth()/(xSize+2)*(x+1)+(getWidth()/(4*(xSize+2))), getHeight()/(ySize+2)*(y+1)+(getHeight()/(4*(xSize+2))), getWidth()/(xSize+2)/2, getHeight()/(ySize+2)/2);
                }
                if(x == pacmanCoord[0] && y == pacmanCoord[1]) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(getWidth()/(xSize+2)*(x+1), getHeight()/(ySize+2)*(y+1), getWidth()/(xSize+2), getHeight()/(ySize+2));
                }
                for(int i = 0; i < 4; i++) {
                    if(xGhosts[i] == x && yGhosts[i] == y) {
                        g.setColor(Color.RED);
                        g.fillOval(getWidth()/(xSize+2)*(x+1), getHeight()/(ySize+2)*(y+1), getWidth()/(xSize+2), getHeight()/(ySize+2));
                    }
                }
                if(fruitSpawned == true) {
                	g.setColor(Color.GREEN);
                	g.fillOval(getWidth()/(xSize+2)*(x+1), getHeight()/(ySize+2)*(y+1), getWidth()/(xSize+2), getHeight()/(ySize+2);
            }
        }
    }
}
