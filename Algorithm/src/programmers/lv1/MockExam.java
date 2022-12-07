package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 모의고사 문제 설명 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * <p>
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * <p>
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 조건 시험은 최대 10,000 문제로 구성되어있습니다. 문제의 정답은 1, 2, 3, 4, 5중 하나입니다. 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요. 입출력
 * 예 answers	return [1,2,3,4,5]	[1] [1,3,2,4,2]	[1,2,3] 입출력 예 설명 입출력 예 #1
 * <p>
 * 수포자 1은 모든 문제를 맞혔습니다. 수포자 2는 모든 문제를 틀렸습니다. 수포자 3은 모든 문제를 틀렸습니다. 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 * <p>
 * 입출력 예 #2
 * <p>
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class MockExam {
    private static final int[] FIRST_MAN = {1, 2, 3, 4, 5};
    private static final int[] SECOND_MAN = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] THIRD_MAN = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {

    }

    public static int[] solution(int[] answers) {
        List<Man> mans = new ArrayList<>();

        int firstCorrectProblemCnt = 0;
        int secondCorrectProblemCnt = 0;
        int thirdCorrectProblemCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == FIRST_MAN[i % (FIRST_MAN.length)]) {
                firstCorrectProblemCnt++;
            }

            if (answers[i] == SECOND_MAN[i % (SECOND_MAN.length)] ) {
                secondCorrectProblemCnt++;
            }

            if (answers[i] == THIRD_MAN[i % (THIRD_MAN.length)]) {
                thirdCorrectProblemCnt++;
            }
        }

        mans.add(new Man(1, firstCorrectProblemCnt));
        mans.add(new Man(2, secondCorrectProblemCnt));
        mans.add(new Man(3, thirdCorrectProblemCnt));

        Collections.sort(mans);

        // 정답이 될 배열의 크기가 몇이 될지 알 수 없음.
        // 위의 이유로 인해 배열의 크기 지정을 위한 탐색이 필요.
        int idx = 0;
        for (int i = 1; i < mans.size(); i++) {
            if (mans.get(i - 1).getCorrectProblemCnt() != mans.get(i).getCorrectProblemCnt()) {
                idx = i - 1;
                break;
            }

            idx++;
        }

        int[] result = new int[idx + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = mans.get(i).getIdx();
        }

        return result;
    }
}

class Man implements Comparable<Man> {
    private int idx;
    private int correctProblemCnt;

    public Man(int idx, int correctProblemCnt) {
        this.idx = idx;
        this.correctProblemCnt = correctProblemCnt;
    }

    public int getIdx() {
        return idx;
    }

    public int getCorrectProblemCnt() {
        return correctProblemCnt;
    }

    @Override
    public int compareTo(Man o) {
        if (o.correctProblemCnt == this.correctProblemCnt) { // 앞 인덱스와 뒷 인덱스가 같을 경우는 앞 인덱스를 앞에 배치 해야함.
            return this.idx - o.idx;
        }

        return o.correctProblemCnt - this.correctProblemCnt;
    }
}