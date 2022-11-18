package programmers.lv0.day15;

public class HateEnglish {
    public static String[] english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public long solution(String numbers) {
        for (int i = 0; i < 10; ++i) {
            numbers = numbers.replace(english[i], String.valueOf(i));
        }

        return Long.parseLong(numbers);
    }

}
