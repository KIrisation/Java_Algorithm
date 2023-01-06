package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NormalBag2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;

    static Product2[] products;
    static int[] dp;

    public static void main(String[] args) {
        N = nextInt();
        K = nextInt();

        products = new Product2[N + 1];

        dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            products[i] = new Product2(nextInt(), nextInt());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j - products[i].getWeight() >= 0; --j) {
                dp[j] = Math.max(dp[j], dp[j - products[i].getWeight()] + products[i].getValue());
            }
        }

        System.out.println(dp[K]);
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

class Product2 {

    private final int weight;
    private final int value;

    public Product2(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}