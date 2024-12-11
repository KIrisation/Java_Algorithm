package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PrintQueue {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int testNum, printNum, orderNum;

    public static void main(String[] args) {
        testNum = nextInt();

        while (testNum-- > 0) {

            printNum = nextInt();
            orderNum = nextInt();

            LinkedList<int[]> q = new LinkedList<>(); // Queue로 활용 할 연결리스트

            for (int i = 0; i < printNum; i++) {
                q.offer(new int[]{i, nextInt()});
            }

            int cnt = 0;

            while (!q.isEmpty()) { // 한 케이스에 대한 반복문
                int[] front = q.poll(); // 가장 첫 원소
                boolean isMax = true; // front 원소가 가장 큰 원소인지를 판단하는 변수

                // 큐에 남아있는 원소들과 중요도를 비교
                for (int i = 0; i < q.size(); i++) {

                    // 처음 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.

                    if (front[1] < q.get(i)[1]) {

                        q.offer(front);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }

                        //front원소가 가장 큰 원소가 아니였으므로, false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                //front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if (!isMax) {
                    continue;
                }

                //front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야한다.
                cnt++;

                if (front[0] == orderNum) { // 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
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
