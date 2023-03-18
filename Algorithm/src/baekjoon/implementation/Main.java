package baekjoon.implementation;

import java.util.*;

// 백준 4419번: 호주식 투표
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] name = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            name[i] = sc.nextLine();
        }
        int cnt = 1;
        Queue<Integer>[] score = new LinkedList[1001];
        for (int i = 0; i < 1001; i++) {
            score[i] = new LinkedList<>();
        }
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            score[cnt].add(a);
            for (int i = 1; i < n; i++) {
                int b = sc.nextInt();
                score[cnt].add(b);
            }
            cnt++;
        }
        cnt--;

        int[] v = new int[1001];
        Arrays.fill(v, 0);

        while (true) {
            for (int i = 1; i <= cnt; i++) {
                while (v[score[i].peek()] == -1) {
                    score[i].remove();
                }
                v[score[i].peek()]++;
            }
            int mx = 0, mn = 9999999;
            for (int i = 1; i <= n; i++) {
                mx = Math.max(mx, v[i]);
                if (v[i] != -1) {
                    mn = Math.min(mn, v[i]);
                }
            }

            if (mx * 2 > cnt || mx == mn) {
                for (int i = 1; i <= n; i++) {
                    if (v[i] == mx) {
                        System.out.println(name[i]);
                    }
                }
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (v[i] == mn) {
                    v[i] = -1;
                } else if (v[i] != -1) {
                    v[i] = 0;
                }
            }
        }
    }
}
