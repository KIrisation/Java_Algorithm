package programmers.lv2.unresolved;

public class 유사_칸토어_배열 {

    static String one = "11011";
    static String zero = "00000";
    static StringBuilder finalNumber = new StringBuilder();
    public int solution(int n, long l, long r) {

        dfs(n, l, r);
        return 0;
    }

    public void dfs(int n, long start, long end) {
        if (n < 1) {
            String[] finalNumbers = finalNumber.toString().split("");
            for (long i = start; i < end; i++) {
//                if (finalNumbers[i].equals())
            }

            return;
        }

        for (int i = 1; i < one.length(); i++) {
            if (one.charAt(i) == '1') {
                finalNumber.append(one);
            } else {
                finalNumber.append(zero);
            }

            dfs(n - 1, start, end);
        }
    }
}
