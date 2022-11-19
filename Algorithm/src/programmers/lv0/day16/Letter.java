package programmers.lv0.day16;

public class Letter {

    public static void main(String[] args) {
        System.out.println(solution("happy birthday!"));
    }

    public static int solution(String message) {
        return message.split("").length * 2;
    }
}
