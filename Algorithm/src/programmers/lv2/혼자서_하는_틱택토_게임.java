package programmers.lv2;

public class 혼자서_하는_틱택토_게임 {

    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        for (int i = 0; i < board.length; i++) {
            String[] line = board[i].split("");
            for (int j = 0; j < board[0].length(); j++) {
                if ("O".equals(line[j])) {
                    oCnt++;
                } else if("X".equals(line[j])) {
                    xCnt++;
                }
            }
        }

        if (xCnt > oCnt || oCnt > xCnt + 1) { // 두번째 O가 X보다 2개 이상 많을 때
            return 0;
        }

        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');

        if (oWin && xWin) {
            return 0;
        }

        if (oWin && oCnt != xCnt + 1) {
            return  0;
        }

        if (xWin && xCnt != oCnt) {
            return 0;
        }

        return 1;
    }

    public boolean isWin(String[] board, char checkDiagram) {

        for (int i = 0; i < 3; i++) {
            // Row check
            if (board[i].charAt(0) == checkDiagram && board[i].charAt(1) == checkDiagram && board[i].charAt(2) == checkDiagram) {
                return true;
            }

            // Column check
            if (board[0].charAt(i) == checkDiagram && board[1].charAt(i) == checkDiagram && board[2].charAt(i) == checkDiagram) {
                return true;
            }

            // left -> rigth Digonal check \
            if (board[0].charAt(0) == checkDiagram && board[1].charAt(1) == checkDiagram && board[2].charAt(2) == checkDiagram) {
                return true;
            }

            // right -> left Digonal check /
            if (board[0].charAt(2) == checkDiagram && board[1].charAt(1) == checkDiagram && board[2].charAt(0) == checkDiagram) {
                return true;
            }
        }

        return false;
    }
}
