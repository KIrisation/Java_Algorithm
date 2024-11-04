package codetree.dp;

public class 조건에_맞게_선택적으로_전진하는_경우 {

    static int[] array = {10, 30, 25, 40, 28, 45};
    static int[] dp = new int[array.length];

    public static void main(String[] args) {
        // 첫번째 원소부터 N번째 원소까지 dp테이블의 값을 채운다.
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            // 현재 원소의 위치에 대하여, 앞의 원소의 값을 비교하며 값을 갱신한다.
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) { // 부분 수열이 증가할 가능성이 있다면?
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp 테이블에 저장된 LIS를 바탕으로 가장 큰 값을 dp[i]의 값으로 갱신한다.
                }
            }
        }
    }
}
