package codetree.dp;

// N^2의 시간복잡도를 가진 LIS 공식
public class 가장_긴_감소하는_부분수열_ver1 {


    public static void main(String[] args) {
        int[] array = {60, 65, 50, 70, 63, 55, 45, 51, 45, 48, 54, 70, 61};
        int[] dp = new int[array.length];

        int max = -1;
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) { // i = 2, j = 0 ->  60 > 50 || i = 2, j = 1 -> 65 > 50
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 1, 1 + 1
                }
            }

            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
