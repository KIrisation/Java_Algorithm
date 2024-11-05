package softeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// 필요에 따라 다른 import 추가

public class 금고털이 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());
        int W = Integer.parseInt(st.nextToken()); // 최대 무게
        int N = Integer.parseInt(st.nextToken()); // 보석의 종류 수

        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken()); // 무게당 가격
            jewels.add(new Jewel(weight, price));
        }

        // 무게당 가격이 높은 순으로 정렬
        Collections.sort(jewels);

        int currentWeight = 0;
        long currentValue = 0;

        for (Jewel jewel : jewels) {
            if (currentWeight + jewel.getWeight() <= W) {
                currentWeight += jewel.getWeight();
                currentValue += (long) jewel.getWeight() * jewel.getPrice();
            } else {
                int remainingWeight = W - currentWeight;
                currentValue += (long) remainingWeight * jewel.getPrice();
                break;
            }
        }

        writer.write(String.valueOf(currentValue));
        writer.flush();
    }
}

class Jewel implements Comparable<Jewel> {

    private final int weight;
    private final int price; // 무게당 가격

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    // 무게당 가격의 내림차순으로 정렬
    @Override
    public int compareTo(Jewel o) {
        return Integer.compare(o.price, this.price);
    }
}
