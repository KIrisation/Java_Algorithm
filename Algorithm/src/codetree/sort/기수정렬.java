package codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 기수정렬 {
    private static int[] A = new int[Integer.MAX_VALUE];
    private static final int BUCKET_SIZE = 10;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) {
        int n = nextInt();

        for (int i = 0; i < n; i++) {
            A[i] = nextInt();
        }

        radix_sort(n);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    private static void radix_sort(int len) {
        Queue<Integer>[] bucket = new LinkedList[BUCKET_SIZE];

        for (int i = 0; i < BUCKET_SIZE; i++) {
            bucket[i] = new LinkedList<>();
        }

        //정렬할 자릿수의 크기만큼 반복함.
        //현재 배열의 가장 큰 수는 10의 자리이므로, 2번 반복하게한다.
        int m = 1;
        for (int d = 0; d < 2; d++) {
            for (int i = 0; i < len; i++) {
                bucket[(A[i] / m) % 10].add(A[i]);
            }

            for (int i = 0, j = 0; i < BUCKET_SIZE; i++) {
                while (!bucket[i].isEmpty()) {
                    A[j++] = bucket[i].poll();
                }
            }

            m *= 10;
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
