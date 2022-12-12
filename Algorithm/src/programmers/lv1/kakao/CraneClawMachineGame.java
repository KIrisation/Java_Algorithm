package programmers.lv1.kakao;

import java.util.Stack;

public class CraneClawMachineGame {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1}, {4,2,4,4,2},{3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4}));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (basket.isEmpty() || basket.peek() != board[i][move - 1]) {
                        basket.add(board[i][move - 1]);
                        board[i][move - 1] = 0;
                        break;
                    } else if(!basket.isEmpty() && basket.peek() == board[i][move - 1]) {
                        board[i][move - 1] = 0;
                        basket.pop();
                        answer += 2;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    /*
    moves[0]
board[1][4];
if (stack.peek != board[1][4]) {
    stack.add(board[1][4]);
} else {
    stack.pop
    answer++;
}
     */
}
