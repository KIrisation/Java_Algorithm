package ndb.greedy;

/**
 * 음식점의 계산을 도와주는 점원이다.
 * 카운터에는 거스름돈으로 사용할 500원, 100원, 50원 10원짜리 동전이 무한으로 존재한다.
 * 손님에게 거슬러 줘야 할 돈이 N원 일때 거슬러줘야 할 동전의 최소 개수를 구하라.
 * 단 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
 */
public class Exchange {
    public static void main(String[] args) {
        int n = 1260;
        int count = 0;

        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < coinTypes.length; i++) {
            int coin = coinTypes[i];
            count += n / coin;
            n %= coin;
        }

        System.out.println(count);

    }
}
