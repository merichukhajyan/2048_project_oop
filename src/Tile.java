import java.awt.*;

public class Tile
{
    private int value;
    private Color color;

    public Tile() // no arg constructor
    {
        this.value = 0;
        setColor();
    }

    public Tile(int value)
    {
        this.value = value;
        setColor();
    }

    public Tile(Tile tile) // copy constructor
    {
        this.value = tile.value;
        setColor();
    }
    public int getValue()
    {
        return this.value;
    }

    public void setValue(int value)
    {
        this.value = value;
        setColor();
    }

    public void setColor()
    {
        if (this.value == 0)
        {
            this.color = new Color(255,255,240);
        }
        else if (this.value == 2)
        {
            this.color = new Color(204, 255, 255);
        }
        else if (this.value == 4)
        {
            this.color = new Color(153, 255, 204);
        }
        else if (this.value == 8)
        {
            this.color = new Color(255, 204, 229);
        }
        else if (this.value == 16)
        {
            this.color = new Color(255, 204, 255);
        }
        else if (this.value == 32)
        {
            this.color = new Color(229, 204, 255);
        }
        else if (this.value == 64)
        {
            this.color = new Color(204, 229, 255);
        }
        else if (this.value == 128)
        {
            this.color = new Color(204, 204, 255);
        }
        else if (this.value == 256)
        {
            this.color = new Color(200, 255, 222);
        }
        else if (this.value == 512)
        {
            this.color = new Color(200, 228, 228);
        }
        else if (this.value == 1024)
        {
            this.color = new Color(102, 205, 170);
        }
        else if (this.value == 2048)
        {
            this.color = new Color(255, 222, 181);
        }

    }

    public Color getColor(){
        return new Color(this.color.getRGB());
    }

    public boolean equals(Object otherTile){
        if (otherTile == null)
            return false;
        else if (this.getClass() != otherTile.getClass())
            return false;
        else{
            return (this.value == ((Tile) otherTile).getValue());
        }
    }
}