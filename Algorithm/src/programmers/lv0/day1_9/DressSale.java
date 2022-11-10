package programmers.lv0.day1_9;

/**
 * 머쓱이네 옷가게는 10만 원 이상 사면 5%,
 * 30만 원 이상 사면 10%,
 * 50만 원 이상 사면 20%를 할인해줍니다.
 * 구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
 */
public class DressSale {

    public static final double BRONZE = 0.95;
    public static final double SILVER = 0.90;
    public static final double GOLD = 0.80;

    public static void main(String[] args) {
        System.out.println(solution(111_111));
    }

    public static int solution(int price) {
        if (price >= 100_000 && price < 300_000) {
            price *= BRONZE;
        } else if (price >= 300_000 && price < 500_000) {
            price *= SILVER;
        } else if (price >= 500_000) {
            price *= GOLD;
        }

        return price;
    }
}
