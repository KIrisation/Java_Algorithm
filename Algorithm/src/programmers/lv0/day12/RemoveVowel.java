package programmers.lv0.day12;

/**
 * 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
 * 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
 */
public class RemoveVowel {

    public static void main(String[] args) {
        System.out.println(solution("bus"));
        System.out.println(solution2("bus"));
    }

    public static String solution(String my_string) {
        String[] vowels = {"a", "e", "i", "o", "u"};

        for (int i = 0; i < vowels.length; i++) {
            my_string = my_string.replace(vowels[i], "");
        }

        return my_string;
    }

    public static String solution2(String my_string) {
        return my_string.replaceAll("[a,e,i,o,u]",""); // replaceAll 메서드는 첫번째 파라미터는 정규표현식을 넣는것이다.
    }

}
