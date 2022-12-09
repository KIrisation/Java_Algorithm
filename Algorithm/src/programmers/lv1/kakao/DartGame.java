package programmers.lv1.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 다트 게임 카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~
 * <p>
 * Game Star
 * <p>
 * 카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다. 갓 입사한 무지는 코딩
 * 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
 * <p>
 * 다트 게임은 총 3번의 기회로 구성된다. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다. 1 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시
 * 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
 * 아차상(#) 당첨 시 해당 점수는 마이너스된다. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고) 스타상(*)의 효과는 다른
 * 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고) 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는
 * -2배가 된다. (예제 5번 참고) Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을
 * 수도 있다. 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 * <p>
 * 3번의 기회 스타상 = 해당 점수 (1점이면 2점) 바로 전에 얻은 점수 (1점이면 2점) 으로 각 2배로 만든다. 아차상 = 해당 점수 (1점이면 -1점)
 * <p>
 * 입력 형식 "점수|보너스|[옵션]"으로 이루어진 문자열 3세트. 예) 1S2D*3T
 * <p>
 * 점수는 0에서 10 사이의 정수이다. 보너스는 S, D, T 중 하나이다. 옵선은 *이나 # 중 하나이며, 없을 수도 있다. 출력 형식 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다. 예) 37
 */

/*
    해당 문제 풀이에 고려했어야 하는 점.
 */
public class DartGame {

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution2("1S2D*3T"));
    }

    public static int solution(String dartResult) {
        List<String> scoresStrings = new ArrayList<>();
        String unitString = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c == '*' || c == '#') {
                scoresStrings.add(String.valueOf(c));

                continue;
            }

            if (c == 'S' || c == 'D' || c == 'T') {
                unitString += c;
                scoresStrings.add(unitString);
                unitString = "";

                continue;
            }

            unitString += c;
        }

        List<Integer> sumNum = new ArrayList<>();

        for (int i = 0; i < scoresStrings.size(); ++i) {
            String str = scoresStrings.get(i);
            if (str.equals("*") || str.equals("#")) {
                if (str.equals("*")) {
                    if (sumNum.size() > 1) {
                        sumNum.set(sumNum.size() - 1, sumNum.get(sumNum.size() - 1) * 2);
                        sumNum.set(sumNum.size() - 2, sumNum.get(sumNum.size() - 2) * 2);
                        continue;
                    }

                    sumNum.set(0, sumNum.get(0) * 2);
                } else {
                    sumNum.set(sumNum.size() - 1, sumNum.get(sumNum.size() - 1) * -1);
                }

            } else {
                char finalChar = str.charAt(str.length() - 1);
                int num = Integer.valueOf(str.substring(0, str.length() - 1));
                if (finalChar == 'S') {
                    sumNum.add(num);
                } else if (finalChar == 'D') {
                    sumNum.add((int) Math.pow(num, 2));
                } else if (finalChar == 'T') {
                    sumNum.add((int) Math.pow(num, 3));
                }
            }
        }

        int answer = 0;
        for (Integer integer : sumNum) {
            answer += integer;
        }

        return answer;
    }

    public static int solution2(String dartResult) {
        Stack<Integer> setScore = new Stack<>();
        String scorePeace = "";
        int sum = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) == '*') {
                if (setScore.size() > 1) { // 빼주고 넣을 때 순서 중요.
                    int finalNum = setScore.pop() * 2;
                    int prevFinalNum = setScore.pop() * 2;

                    setScore.add(prevFinalNum);
                    setScore.add(finalNum);
                } else {
                    setScore.add(setScore.pop() * 2);
                }
                continue;
            }

            if (dartResult.charAt(i) == '#') {
                setScore.add(setScore.pop() * (-1));
                continue;
            }

            if (dartResult.charAt(i) == 'S') {
                setScore.add(Integer.parseInt(scorePeace));
                scorePeace = "";
                continue;
            } else if (dartResult.charAt(i) == 'D') {
                setScore.add((int) Math.pow(Integer.parseInt(scorePeace), 2));
                scorePeace = "";
                continue;
            } else if (dartResult.charAt(i) == 'T') {
                setScore.add((int) Math.pow(Integer.parseInt(scorePeace) , 3));
                scorePeace = "";
                continue;
            }

            scorePeace += dartResult.charAt(i);
        }

        while (!setScore.isEmpty()) {
            sum += setScore.pop();
        }

        return sum;
    }
}
