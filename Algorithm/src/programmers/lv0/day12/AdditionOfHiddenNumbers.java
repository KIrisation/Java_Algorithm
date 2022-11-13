package programmers.lv0.day12;

public class AdditionOfHiddenNumbers {

    public static void main(String[] args) {
        System.out.println(solution("aAb1B2cC34oOp"));
    }

    public static int solution(String my_string) {
        int answer = 0;

        String[] split = my_string.split("");

        for (int i = 0; i < split.length; i++) {
            if (my_string.charAt(i) >= 'A' && my_string.charAt(i) <= 'Z' || my_string.charAt(i) >= 'a' && my_string.charAt(i) <= 'z') {
                split[i] = split[i].replace(split[i], "");
            }
        }

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("")) {
                continue;
            }
            answer += Integer.parseInt(split[i]);
        }

        return answer;
    }

    public static int solution2(String my_string) {
        int answer = 0;
        String str = my_string.replaceAll("[^0-9]","");

        for(char ch : str.toCharArray()) {
            answer += Character.getNumericValue(ch);
        }

        return answer;
    }

    public static int solution3(String myString) {
        return myString.chars()
                       .mapToObj(i -> (char) i)
                       .filter(Character::isDigit)
                       .map(String::valueOf)
                       .mapToInt(Integer::valueOf)
                       .sum();
    }

}
