package programmers.lv1;

public class CalculateAmountMoneyInsufficient {

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        long totalPrice = 0;

        for (int i = 1; i <= count; i++) {
            totalPrice += price * i;
        }

        long result = money - totalPrice;

        return result > 0 ? 0 : result * -1;
    }
}
