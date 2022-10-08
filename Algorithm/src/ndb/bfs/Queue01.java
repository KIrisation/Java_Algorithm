package ndb.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐(Queue)는 대기 줄에 비유할 수 있다. 우리가 흔히 놀이공원에 입장하기 위해 줄을 설 때,
 * 먼저 온 사람이 먼저 들어가게 된다.
 * '공정한' 자료구조라고 비유된다.
 * FIFO(First In First Out) 구조 임.
 */
public class Queue01 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();
        // 먼저 들어온 원소부터 추출
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
