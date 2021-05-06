import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ForLoops extends JPanel
{
    int row;
    int col;
    int tileSize;
    int interTileSize;
    Tile[][] arr;

    public ForLoops(Tile[][] tiles, int tileSize, int interTileSize)
    {
        this.row = tiles.length;
        this.col = tiles[0].length;
        this.arr = tiles;
        this.tileSize = tileSize;
        this.interTileSize = interTileSize;
    }

    public void paintComponent(Graphics g) // method for drawing
    {
        g.setColor(new Color(255, 229, 204));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int w = (this.getWidth() - 3 * tileSize - (col - 1) * interTileSize) / col;
        int h = (this.getHeight() - 3 * tileSize - (row - 1) * interTileSize) / row;

        Font font = g.getFont();
        g.setFont(font.deriveFont(4f * font.getSize()));

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                g.setColor(arr[i][j].getColor()); // Color of the inner rectangle
                g.fillRect(tileSize + (j) * (w + interTileSize), tileSize + (i) * (h + interTileSize), w, h); //filling the rectangle by the color in the 35th line
                g.setColor(Color.BLACK); //Color of the border of the square
                g.drawRect(tileSize + (j) * (w + interTileSize), tileSize + (i) * (h + interTileSize), w, h);
                g.setColor(new Color(0, 0, 0));

                if (arr[i][j].getValue() != 0)
                {
                    String s =  (arr[i][j].getValue() + " ");
                    g.drawString( s,(tileSize + (j) * (w + interTileSize) + w / 2)- s.length()*12, (tileSize + (i) * (h + interTileSize) + h / 2));
                }
            }
        }
    }
}