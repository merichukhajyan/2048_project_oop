public class Game implements Cloneable
{
    private Board gameBoard;
    public static int score = 0;
    public static int highestScore = 0;

    public Game()  // no arg
    {
        this.gameBoard = new Board();
    }

    public Board getGameBoard()
    {
        return this.gameBoard;
    }


    private void addTiles(Tile tile1, Tile tile2)
    {
        tile2.setValue(2 * tile2.getValue());
        tile1.setValue(0);
        score += tile2.getValue();
        if(score > highestScore)
        {
            highestScore = score;
        }
    }

    public void generateNewTiles()
    {
        int countZeros = 0;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if (this.gameBoard.getBoard()[i][j].getValue() == 0)
                {
                    countZeros++;
                }
            }
        }


        int count = 0;
        int[][] zeroIndexes = new int[countZeros][2];
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(this.gameBoard.getBoard()[i][j].getValue() == 0)
                {
                    zeroIndexes[count][0] = i;
                    zeroIndexes[count][1] = j;
                    count++;
                }
            }
        }
        int tileValue = 0;
        double random = Math.random();
        if(random <= 0.25)
        {
            tileValue = 4;
        }
        else
        {
            tileValue = 2;
        }
        int[] randomChosenPosition = zeroIndexes[Math.round((float)Math.random() * (countZeros-1))];

        int indexX = randomChosenPosition[0];
        int indexY = randomChosenPosition[1];
        this.gameBoard.getBoard()[indexX][indexY] = new Tile(tileValue);
    }

    public void moveRight()
    {
        boolean moved = false;
        for (int i = 0; i < 4; i++)
        {
            int prohibitedAdditionIndex = -1;
            for (int j = 2; j >= 0; j--)
            {
                if (this.gameBoard.getBoard()[i][j].getValue() != 0)
                {
                    for (int k = j; k < 3; k++)
                    {
                        if (this.gameBoard.getBoard()[i][k+1].getValue() == 0)
                        {
                            this.gameBoard.getBoard()[i][k+1] = new Tile(this.gameBoard.getBoard()[i][k]);
                            this.gameBoard.getBoard()[i][k].setValue(0);
                            moved = true;
                        }
                        else if (this.gameBoard.getBoard()[i][k].equals(this.gameBoard.getBoard()[i][k+1]) && prohibitedAdditionIndex != k && prohibitedAdditionIndex != k+1)
                        {
                            addTiles(gameBoard.getBoard()[i][k], gameBoard.getBoard()[i][k+1]);
                            moved = true;
                            prohibitedAdditionIndex = k+1;
                        }
                    }
                }
            }
        }
        if(moved) {
            generateNewTiles();
        }
    }
    public void moveLeft(){
        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            int prohibitedAdditionIndex = -1;
            for (int j = 1; j < 4; j++) {
                if (this.gameBoard.getBoard()[i][j].getValue() != 0){
                    for (int k = j; k > 0; k--) {
                        if (this.gameBoard.getBoard()[i][k-1].getValue() == 0){
                            this.gameBoard.getBoard()[i][k-1] = new Tile(this.gameBoard.getBoard()[i][k]);
                            this.gameBoard.getBoard()[i][k].setValue(0);
                            moved = true;
                        }else if (this.gameBoard.getBoard()[i][k-1].equals(gameBoard.getBoard()[i][k])  && prohibitedAdditionIndex != k && prohibitedAdditionIndex != k-1) {
                            addTiles(gameBoard.getBoard()[i][k], gameBoard.getBoard()[i][k-1]);
                            moved = true;
                            prohibitedAdditionIndex = k-1;
                        }
                    }
                }
            }
        }
        if(moved) {
            generateNewTiles();
        }
    }

    public void moveUp() {
        boolean moved = false;
        for (int j = 0; j < 4; j++) {
            int prohibitedAdditionIndex = -1;
            for (int i = 1; i < 4; i++) {
                if (this.gameBoard.getBoard()[i][j].getValue() != 0) {
                    for (int k = i; k > 0; k--) {
                        if (k - 1 >= 0) {
                            if (this.gameBoard.getBoard()[k - 1][j].getValue() == 0) {
                                this.gameBoard.getBoard()[k - 1][j] = new Tile(this.gameBoard.getBoard()[k][j]);
                                this.gameBoard.getBoard()[k][j].setValue(0);
                                moved = true;

                            } else if (this.gameBoard.getBoard()[k][j].equals(this.gameBoard.getBoard()[k - 1][j])  && prohibitedAdditionIndex != k && prohibitedAdditionIndex != k-1) {
                                addTiles(gameBoard.getBoard()[k][j], gameBoard.getBoard()[k - 1][j]);
                                moved = true;
                                prohibitedAdditionIndex = k-1;
                            }
                        }
                    }
                }
            }
        }
        if (moved) {
            generateNewTiles();
        }
    }

    public void moveDown(){
        boolean moved = false;
        for (int j = 0; j < 4; j++) {
            int prohibitedAdditionIndex = -1;
            for (int i = 2; i >=0; i--) {
                if (this.gameBoard.getBoard()[i][j].getValue() != 0){
                    for (int k = i; k < 4; k++) {
                        if(k + 1 <= 3) {
                            if (this.gameBoard.getBoard()[k+1][j].getValue() == 0){
                                this.gameBoard.getBoard()[k+1][j] = new Tile(this.gameBoard.getBoard()[k][j]);
                                this.gameBoard.getBoard()[k][j].setValue(0);
                                moved = true;

                            }else if (this.gameBoard.getBoard()[k][j].equals(this.gameBoard.getBoard()[k+1][j]) && prohibitedAdditionIndex != k && prohibitedAdditionIndex != k+1) {
                                addTiles(gameBoard.getBoard()[k][j], gameBoard.getBoard()[k+1][j]);
                                moved = true;
                                prohibitedAdditionIndex = k+1;
                            }
                        }
                    }
                }
            }
        }
        if(moved)
        {
            generateNewTiles();
        }
    }

    public boolean gameLost()
    {
        int count = 0;
        for(int k = 0; k < 4; k++) {
            for(int h = 0; h < 4; h++) {
                if(this.gameBoard.getBoard()[k][h].getValue() != 0) {
                    count++;
                }
            }
        }
        if(count < 16)
        {
            return false;
        }
        else
        {
            for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    if(this.getGameBoard().getBoard()[i][j].equals(getGameBoard().getBoard()[i][j+1])) {
                        return false;
                    }
                }
            }

            for(int j = 0; j < 4; j++)
            {
                for(int i = 0; i < 3; i++)
                {
                    if(this.getGameBoard().getBoard()[i][j].equals(getGameBoard().getBoard()[i+1][j]))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean gameWon() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(this.gameBoard.getBoard()[i][j].getValue() == 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public void newGame() {
        Tile[][] zeroMatrix = new Tile[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                zeroMatrix[i][j] = new Tile();
            }
        }
        this.gameBoard.setBoard(zeroMatrix);
        this.generateNewTiles();
        this.generateNewTiles();
        Game.score = 0;
    }

    public Game clone() {
        try {
            Game gameClone = (Game)super.clone();
            gameClone.gameBoard = new Board(this.gameBoard);
            gameClone.gameBoard.setBoard(this.gameBoard.getBoard());
            return gameClone;
        }catch(CloneNotSupportedException e){
            return  null;
        }
    }
}