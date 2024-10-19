package codetree.data_structured.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하세요. 명령어는 총 5가지입니다.
 * <p>
 * 명령어 :
 * <p>
 * push A: 정수 A를 스택에 넣는 연산입니다. 새로 들어온 정수는 상단부터 차례대로 스택에 쌓입니다. pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력합니다. size: 스택에 들어있는 정수의
 * 개수를 출력합니다. empty: 스택이 비어있으면 1, 아니면 0을 출력합니다. top: 스택의 가장 위에 있는 정수를 출력합니다.
 */
public class 스택_정수_명령_처리 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) {
        int N = nextInt();

        Stack<Integer> stack = new Stack<>();
        String command = null;
        for (int i = 0; i < N; i++) {
            command = next();

            switch (command) {
                case "push": {
                    stack.push(nextInt());
                    break;
                }

                case "pop": {
                    System.out.println(stack.pop());
                    break;
                }

                case "size": {
                    System.out.println(stack.size());
                    break;
                }

                case "empty": {
                    System.out.println(stack.empty() ? 1 : 0);
                    break;
                }

                case "top": {
                    System.out.println(stack.peek());
                    break;
                }
            }
        }
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
