import java.util.Scanner;
public class Game {

    public static void main(String[] args) {
        Board a = new Board();
        a.generateNewTiles();
        a.generateNewTiles();

        for(int i = 0; i < 4; i++) {
            System.out.println(" ");
            for(int j = 0; j < 4; j++) {
                if(a.getBoard()[i][j] != null) {
                    System.out.print(a.getBoard()[i][j].getValue() + "  ");
                }else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);
        while(true) {
            String userControl = sc.next();
            if(userControl.equals("d")) {
                a.moveRight();
            }else if(userControl.equals("a")) {
                a.moveLeft();
            }else if(userControl.equals("w")) {
                a.moveUp();
            }
            else{
                System.out.println("end of the program.");
                System.exit(0);
            }

            for(int i = 0; i < 4; i++) {
                System.out.println(" ");
                for(int j = 0; j < 4; j++) {
                    if(a.getBoard()[i][j] != null) {
                        System.out.print(a.getBoard()[i][j].getValue() + "  ");
                    }else {
                        System.out.print(" * ");
                    }
                }
                System.out.println();
            }
        }
    }

}
