import java.util.*;

class TicTacToe {

static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();


    public static void main(String[] args) {
        char[][] GameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(GameBoard);

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choice (1-9):");
            int playerpos = scan.nextInt();
            while (playerPositions.contains(playerpos) || cpuPositions.contains(playerPositions)) {
                System.out.println("Position taken, Enter a different position");
            playerpos = scan.nextInt();

        }
        PlacePiece(GameBoard, playerpos , "player");

            String result = CheckWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }


                Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                System.out.println("Position taken, Enter a different position");
            cpuPos = rand.nextInt(9) + 1 ;
        }

    PlacePiece(GameBoard, cpuPos, "cpu");
            printGameBoard(GameBoard);

            result = CheckWinner();
           if(result.length() > 0) {
               System.out.println(result);
               break;

           }
       }

     }
     public static void printGameBoard(char[][] GameBoard) {
        for (char[] row : GameBoard) {
            for (char t : row) {
                System.out.print(t);
            }
            System.out.println();
        }
    }

    public static void PlacePiece(char[][] GameBoard, int pos, String user) {

        char symbol =  ' ';

        if(user.equals("player")) {
            symbol ='X';
            playerPositions.add(pos);
        }else if(user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        switch (pos) {
            case 1:
                GameBoard[0][0] = symbol;
                break;
            case 2:
                GameBoard[0][2] = symbol;
                break;
            case 3:
                GameBoard[0][4] = symbol;
                break;
            case 4:
                GameBoard[2][0] = symbol;
                break;
            case 5:
                GameBoard[2][2] = symbol;
                break;
            case 6:
                GameBoard[2][4] = symbol;
                break;
            case 7:
                GameBoard[4][0] = symbol;
                break;
            case 8:
                GameBoard[4][2] = symbol;
                break;
            case 9:
                GameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static String CheckWinner() {

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List diag1 = Arrays.asList(1,5,9);
        List diag2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(diag1);
        winning.add(diag2);

        for(List l : winning) {
            if(playerPositions.containsAll(l)) {
                return"You won!!";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins! Try again";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Tie!";
                
            }

        }


        return "";
    }
}