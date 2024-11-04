package codetree.dp;

public class 아이템을_적절히_고르는_문제2 {

    public static void main(String[] args) {
        int jewelSize = 10;
        보석[] jewels = new 보석[jewelSize + 1];

        jewels[1] = new 보석(2, 3);
        jewels[2] = new 보석(6, 5);
        jewels[3] = new 보석(2, 4);
        jewels[4] = new 보석(3, 2);
        jewels[5] = new 보석(4, 3);
        jewels[6] = new 보석(5, 3);
        jewels[7] = new 보석(4, 2);
        jewels[8] = new 보석(6, 6);
        jewels[9] = new 보석(7, 9);
        jewels[10] = new 보석(10, 8);

        int bagSize = 20;
        int[][] dp = new int[jewelSize + 1][bagSize + 1];

        // 초기화: dp 배열의 첫 번째 행과 열을 0으로 설정
        for (int i = 0; i <= jewelSize; i++) {
            for (int j = 0; j <= bagSize; j++) {
                dp[i][j] = -1;  // 기본적으로 불가능한 상태로 설정
            }
        }
        dp[0][0] = 0;  // 초기 상태, 보석도 없고 배낭도 비어 있는 상태

        // dp 테이블 업데이트
        for (int i = 1; i <= jewelSize; i++) {
            for (int j = 0; j <= bagSize; j++) {
                // 이전 상태를 가져옴 (보석을 선택하지 않는 경우)
                dp[i][j] = dp[i - 1][j];

                // 보석을 선택할 수 있는 경우
                if (j >= jewels[i].getWeight() && dp[i - 1][j - jewels[i].getWeight()] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - jewels[i].getWeight()] + jewels[i].getPrice());
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.println("dp[" + i + "][" + j + "]" + ":" + dp[i][j]);
            }
        }
    }
}

class 보석 {
    private final int weight;
    private final int price;

    public 보석(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}