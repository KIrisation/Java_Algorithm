package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 12865번: 평범한 배낭
 * 현재 해당 풀이는 시간초과가 나는 경우임. 시간 복잡도를 줄이기 위해 DP를 생각 해야함.
 * DP 풀이는 NormalBag2로 풀이 할 예정
 */
public class NormalBag {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static List<Product> products;
    static int maxValue = 0;

    public static void main(String[] args) {
        N = nextInt();
        K = nextInt();

        products = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            products.add(new Product(nextInt(), nextInt()));
        }

        recursion(0, 0, 0);
        System.out.println(maxValue);
    }

    private static void recursion(int idx, int sumWeight, int sumValue) {
        maxValue = Math.max(maxValue, sumValue);

        if (idx == products.size()) {
            return;
        }


        if (sumWeight + products.get(idx).getWeight() <= K) {
            recursion(idx + 1, sumWeight + products.get(idx).getWeight(),
                    sumValue + products.get(idx).getValue());
        }

        recursion(idx + 1, sumWeight, sumValue);
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

class Product {

    private final int weight;
    private final int value;

    public Product(int weight, int value) {
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