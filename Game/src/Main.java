import java.util.Scanner;

class Main {
    static char line1[] = {'_', '_', '_'};
    static char line2[] = {'_', '_', '_'};
    static char line3[] = {'_', '_', '_'};

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to TicTacToe game!");

        Scanner scanner = new Scanner(System.in);

        char c = 'x';

        while(!checkGameOver()) {
            System.out.println("Turn <" + c + ">");

            int position = scanner.nextInt();
            turn(c, position);

            printBoard();

            Thread.sleep(1000);

            if (c == 'x') {
                c = 'o';
            } else {
                c = 'x';
            }
        }

        System.out.println("Game over!");

    }

    public static void printBoard() {
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.print(line1[i]);
        }
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.print(line2[i]);
        }
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.print(line3[i]);
        }
        System.out.println();
    }

    public static void turn(char c, int position) {
        if (position == 1) {
            line1[0] = c;
        } else if (position == 2) {
            line1[1] = c;
        } else if (position == 3) {
            line1[2] = c;
        }

        if (position == 4) {
            line2[0] = c;
        } else if (position == 5) {
            line2[1] = c;
        } else if (position == 6) {
            line2[2] = c;
        }

        if (position == 7) {
            line3[0] = c;
        } else if (position == 8) {
            line3[1] = c;
        } else if (position == 9) {
            line3[2] = c;
        }
    }

    public static char getChar(int position) {
        if (position == 1) {
            return line1[0];
        } else if (position == 2) {
            return line1[1];
        } else if (position == 3) {
            return line1[2];
        }

        if (position == 4) {
            return line2[0];
        } else if (position == 5) {
            return line2[1];
        } else if (position == 6) {
            return line2[2];
        }

        if (position == 7) {
            return line3[0];
        } else if (position == 8) {
            return line3[1];
        } else if (position == 9) {
            return line3[2];
        }

        return '#';
    }

    public static boolean checkGameOver() {
        if (isBoardFull()) {
            return true;
        }

        boolean line1Win = checkThree(1, 2, 3);
        boolean line2Win = checkThree(4, 5, 6);
        boolean line3Win = checkThree(7, 8, 9);

        boolean col1Win = checkThree(1, 4, 7);
        boolean col2Win = checkThree(2, 5, 8);
        boolean col3Win = checkThree(3, 6, 9);

        boolean diag1Win = checkThree(1, 5, 9);
        boolean diag2Win = checkThree(3, 5, 7);

        boolean result = line1Win || line2Win || line3Win
                || col1Win || col2Win || col3Win
                || diag1Win || diag2Win;

        return result;
    }

    public static boolean isBoardFull() {
        int emptySpaceCount = 0;

        for(int i = 0; i < 3; i++) {
            if (line1[i] == '_') {
                emptySpaceCount++;
            }

            if (line2[i] == '_') {
                emptySpaceCount++;
            }

            if (line3[i] == '_') {
                emptySpaceCount++;
            }
        }

        return emptySpaceCount == 0;
    }

    public static boolean checkThree(int n1, int n2, int n3) {
        char v1 = getChar(n1);
        char v2 = getChar(n2);
        char v3 = getChar(n3);

        return (v1 != '_') && (v1 == v2) && (v2 == v3);
    }
}

