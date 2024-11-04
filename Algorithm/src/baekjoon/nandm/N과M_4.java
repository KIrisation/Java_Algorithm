package baekjoon.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M_4 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;
    public static void main(String[] args) {
        N = nextInt();
        M = nextInt();

        N과M_4recursive(new LinkedList<>(), 1);
    }

    private static void N과M_4recursive(LinkedList<Integer> outList, int someNum) {
        if (someNum > N) {
            return;
        }

        if (outList.size() == M) {
            for (Integer i : outList) {
                System.out.print(i  + " ");
            }

            System.out.println();
            return;
        }

        //뽑
        outList.add(someNum);
        N과M_4recursive(outList, someNum); // 1
        outList.removeLast(); // 1 someNum = 1


        N과M_4recursive(outList, someNum + 1); //  1 2
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
