package programmers.lv0.day21;

public class SafeZone {

    static int[] DX = {-1,-1,0,1,1,1,0,-1}; // 서쪽부터 시계방향
    static int[] DY = {0,1,1,1,0,-1,-1,-1}; // 서쪽부터 시계방향

    public static void main(String[] args) {
        int[][] a1 = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
        System.out.println(solution(a1));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 폭탄 위치
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) { // 폭탄 설정
                        if (i + DY[k] > board.length - 1 || i + DY[k] < 0 || j + DX[k] > board.length  - 1 || j + DX[k] < 0 ) {
                            continue;
                        }
                        // 폭탄 반경 세팅
                        if (board[i + DY[k]][j + DX[k]] == 0){
                            board[i + DY[k]][j + DX[k]] = 2;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
