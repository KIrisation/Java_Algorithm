package ndb.dfs;

import java.util.Stack;

/**
 * 스택(Stack) 은 박스 쌓기에 비유할 수 있다.
 * 흔히 박스는 아래에서부터 위로 차곡차곡 쌓는다.
 * 그리고 아래에 있는 박스를 치우기 위해서는 위에 있는 박스를 먼저 내려야 한다.
 * LIFO(Last In First Out) 구조 임.
 */
public class Stack01 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop(); // 7 이 튕겨나감.
        s.push(1);
        s.push(4);
        s.pop(); // 4 가 튕겨나감.
        // 스택의 최상단 원소부터 출력
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
