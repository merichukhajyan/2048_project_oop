public class Board {
    private Tile[][] board = new Tile[4][4];

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[i][j] = new Tile(board[i][j]);
            }
        }
    }

    public Board() {
        this.board = new Tile[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                this.board[i][j] = new Tile();
            }
        }
    }

    public Board(Tile[][] board){
        this.board = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[i][j] = new Tile(board[i][j]);
            }
        }
    }

    public Board(Board newBoard){

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[i][j] = new Tile(newBoard.board[i][j]);
            }
        }
    }

    private void addTiles(Tile tile1, Tile tile2){
        if(tile1.equals(tile2)){
            tile2.setValue(tile2.getValue() + tile1.getValue());
            tile1.setValue(0);
        }
    }

    // should be checked
    public void generateNewTiles() {
        int countZeros = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if (this.board[i][j].getValue() == 0) {
                    countZeros++;
                }
            }
        }
        int count = 0;
        //System.out.println(countZeros);
        int[][] zeroIndexes = new int[countZeros][2];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
               // System.out.println(this.board[i][j].getValue());
                if(this.board[i][j].getValue() == 0) {
                    zeroIndexes[count][0] = i;
                    zeroIndexes[count][1] = j;
                    count++;
                }
            }
        }

        int tileValue = 0;
        double random = Math.random();

        if(random <= 0.25) {
            tileValue = 4;
        }else {
            tileValue = 2;
        }
       // System.out.println(zeroIndexes.length + " " + zeroIndexes[0].length);
//System.out.println(Math.round((float)Math.random() * (countZeros-1)));
        int[] randomChosenPosition = zeroIndexes[Math.round((float)Math.random() * (countZeros-1))];

        int indexX = randomChosenPosition[0];
        int indexY = randomChosenPosition[1];
        this.board[indexX][indexY] = new Tile(tileValue);
    }

    public void moveRight(){
        boolean moved = false;
        boolean added = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (this.board[i][j].getValue() != 0){
                    for (int k = j; k < 3; k++) {
                        if (this.board[i][k+1].getValue() == 0){
                            this.board[i][k+1] = new Tile(this.board[i][k]);
                            this.board[i][k].setValue(0);
                            moved = true;
                        }else if (this.board[i][k+1].getValue() == this.board[i][k].getValue() && !added) {
                            addTiles(board[i][k], board[i][k+1]);
                            moved = true;
                            added = true;
                        }
                    }
                }
            }
        }
        if(moved) {
            generateNewTiles();
        }
        //    return new Board(this);
    }

    public void moveLeft(){
        boolean moved = false;
        boolean added = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (this.board[i][j].getValue() != 0){
                    for (int k = j; k > 0; k--) {
                        if (this.board[i][k-1].getValue() == 0){
                            this.board[i][k-1] = new Tile(this.board[i][k]);
                            this.board[i][k].setValue(0);
                            moved = true;
                        }else if (this.board[i][k-1].getValue() == this.board[i][k].getValue() && !added) {
                            addTiles(board[i][k], board[i][k-1]);
                            moved = true;
                            added = true;
                        }
                    }
                }
            }
        }
        if(moved) {
            generateNewTiles();
        }
        // return new Board(this);
    }

    public void moveUp() {
        boolean moved = false;
        boolean added = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                if (this.board[i][j].getValue() != 0) {
                    for (int k = i; k > 0; k--) {
                        if (k - 1 >= 0) {
                            if (this.board[k - 1][j].getValue() == 0) {
                                this.board[k - 1][j] = new Tile(this.board[k][j]);
                                this.board[k][j].setValue(0);
                                moved = true;

                            } else if (this.board[k][j].getValue() == this.board[k - 1][j].getValue() && !added) {
                                addTiles(board[k][j], board[k - 1][j]);
                                moved = true;
                                added = true;
                            }
                        }
                    }
                }
            }
            added = false;
        }
        if (moved) {
            generateNewTiles();
        }
    }
    /*
        public void moveDown(){
            boolean moved = false;
            boolean added = false;
            for (int j = 0; j < 4; j++) {
                for (int i = 2; i < 4; i++) {
                    if (this.board[i][j].getValue() != 0){
                        for (int k = i; k > 0; k--) {
                            if(k-1 >= 0) {
                                if (this.board[k-1][j].getValue() == 0){
                                    this.board[k-1][j] = new Tile(this.board[k][j]);
                                    this.board[k][j].setValue(0);
                                    moved = true;

                                }else if (this.board[k][j].getValue() == this.board[k-1][j].getValue() && !added) {
                                    addTiles(board[k][j], board[k-1][j]);
                                    moved = true;
                                    added = true;
                                }
                            }
                        }
                    }
                }
                added = false;
            }
            if(moved) {
                generateNewTiles();
            }

        } */
        //    return new Board(this);
    //TODO: MOVEDOWN, ERROR WHILE ADDING NUMBERS NEXT TO EACH OTHER

    }


