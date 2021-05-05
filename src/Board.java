public class Board {

    private Tile[][] board = new Tile[4][4];

    /**
     * According to good programming style, there is a privacy leak in this accessor,
     * but it is done intentionally as we need the same Tile[][] board to be modified constantly
     * @return
     */
    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[i][j].setValue(board[i][j].getValue());
            }
        }
    }

    public Board() //no arg constructor that sets our 4x4 matrix(Tile) with 0 values
    {
        this.board = new Tile[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                this.board[i][j] = new Tile();
            }
        }
    }

    public Board(Tile[][] board) // constructor, which takes Tile 4x4 matrix and initializes a board object with instance variable of the given value
    {
        this.board = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[i][j] = new Tile(board[i][j]);
            }
        }
    }

    public Board(Board newBoard) //copy constructor
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[i][j] = new Tile(newBoard.board[i][j]);
            }
        }
    }
}











