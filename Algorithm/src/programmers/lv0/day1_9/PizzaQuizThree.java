package programmers.lv0.day1_9;

public class PizzaQuizThree {

    public static void main(String[] args) {
        int i = solution2(9, 93);
        System.out.println(i);
    }

    private static int solution2(int slice, int n) {
        return n / slice + 1;
    }
}
