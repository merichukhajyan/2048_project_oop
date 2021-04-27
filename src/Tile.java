import java.awt.*;

    public class Tile {
        private int value;
        private Color color;

        public Tile(){
            this.value = 0;
            setColor();
        }

        public Tile(int value){
            this.value = value;
            setColor();
        }

        public Tile(Tile tile){
            this.value = tile.value;
            setColor();
        }

        public int getValue(){
            return this.value;
        }

        public void setValue(int value){
            this.value = value;
            setColor();
        }

        private void setColor(){
            switch (this.value){
                case 2:
                    this.color = new Color(204, 255, 255);
                case 4:
                    this.color = new Color(153, 255, 204);
                case 8:
                    this.color = new Color(10, 2, 102);
                case 16:
                    this.color = new Color(255, 178, 102);
                case 32:
                    this.color = new Color(255, 128, 0);
                case 64:
                    this.color = new Color(255, 0, 0);
                case 128:
                    this.color = new Color(178, 102, 255);
                case 256:
                    this.color = new Color(255, 51, 255);
                case 512:
                    this.color = new Color(255, 0, 127);
                case 1024:
                    this.color = new Color(160, 160, 160);
                case 2048:
                    this.color = new Color(255, 255, 0);
            }
        }

        public Color getColor(){
            return new Color(this.color.getRGB());
        }

        public boolean equals(Tile tile){
            return this.value == tile.value;
        }
    }


