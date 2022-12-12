package programmers.lv1.kakao;

/* 고려사항
    1. 왼손은 * 에 있다. 오른손은 # 에 있다.
        - 상하좌우 4가지 방향으로만 이동할 수 있다.
    2. 1, 4, 7은 왼손으로만 이동가능하다.
    3. 3, 6, 9는 오른손으로만 이동가능하다.
    4. 2, 5, 8, 0은 두 엄지손가락의 현재 키패드에서 가까운 엄지손가락을 사용한다.
        - 만약 거리가 같다면, 본인 손잡이 (오른손, 왼손)으로 판단하여 움직인다.
    5. 번호 배열이 주어진다. 그리고 본인 손잡이가 문자열로 주어진다.
    6. 무슨 손가락으로 해당 숫자를 눌렀는지 문자열로 기록해서 해당 기록을 반환한다.

    풀이 = 숫자를 다 누른다면 프로세스를 종료한다.
    해당 풀이에서 프로세스는 무엇인가?
    1. 번호 배열의 모든 수를 다 읽었을 때이다.
    2. 읽는 방법은 차례대로 수를 순회한다. (for each 문을 사용한다.)
    3. 차례대로 수를 순회하며 현재 손이 어느 번호에 위치 했는지 기록 되어야 한다.
    4. 해당 위치를 기준으로 2, 5, 8, 0 의 입력을 판단한다.
*/
public class PressKeypad {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int leftHandLocation = 10;
        int rightHandLocation = 12;

        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }

            if (isSimpleLeft(number)) {
                answer += "L";
                leftHandLocation = number; //4
            } else if (isSimpleRight(number)) {
                answer += "R";
                rightHandLocation = number; //3
            } else {

                int checkHandLeftLocation = 0;
                int leftDistance = 0;
                int checkHandRightLocation = 0;
                int rightDistance = 0;

                if (isSimpleLeft(leftHandLocation)) {
                    checkHandLeftLocation = leftHandLocation + 1;
                    leftDistance += 3;
                } else {
                    checkHandLeftLocation = leftHandLocation; // 이건 예전에 가운데 였다라는 체크
                }

                if (isSimpleRight(rightHandLocation)) {
                    checkHandRightLocation = rightHandLocation - 1;
                    rightDistance += 3;
                } else {
                    checkHandRightLocation = rightHandLocation; //이건 예전에 가운데 였다라는 체크
                }

                leftDistance += Math.abs(number - checkHandLeftLocation);
                rightDistance += Math.abs(number - checkHandRightLocation);

                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        rightHandLocation = number;
                        answer += "R";
                    } else {
                        leftHandLocation = number;
                        answer += "L";
                    }
                } else if (leftDistance > rightDistance) {
                    rightHandLocation = number;
                    answer += "R";
                } else {
                    leftHandLocation = number;
                    answer += "L";
                }
            }
        }

        return answer;
    }


    private static boolean isSimpleLeft(int number) {
        return number == 1 || number == 4 || number == 7 || number == 10;
    }

    private static boolean isSimpleRight(int number) {
        return number == 3 || number == 6 || number == 9 || number == 12;
    }
}
