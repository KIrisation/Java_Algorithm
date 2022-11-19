package programmers.lv0.day16;

public class SimilarityArrangement {

    public static void main(String[] args) {

    }

    public int solution(String[] s1, String[] s2) {
        int answer = 0;

        for (String s : s1) {
            for (String value : s2) {
                if (s.equals(value)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
