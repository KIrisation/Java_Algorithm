package programmers.lv1;

/**
 * 최소직사각형 문제 설명 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 이러한 요건을
 * 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
 * <p>
 * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
 * <p>
 * 명함 번호	가로 길이	세로 길이 1	60	50 2	30	70 3	60	30 4	80	40 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든
 * 명함들을 수납할 수 있습니다. 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
 * <p>
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를
 * 완성해주세요.
 */
public class MakeCard {

    public static void main(String[] args) {
        solution(new int[][]{
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        });
    }

    public static int solution(int[][] sizes) {
        int[] ints = createMaxCard(sizes);
        int[][] ints1 = swapCard(sizes);
        int[] ints2 = createMaxCard(ints1);

        return Math.min((ints[0] * ints[1]), (ints2[0] * ints2[1]));
    }

    private static int[] createMaxCard(int[][] sizes) {
        int widthMax = sizes[0][0];
        int heightMax = sizes[0][1];

        for (int i = 1; i < sizes.length; i++) {
            if (sizes[i][0] >= widthMax) {
                widthMax = sizes[i][0];
            }

            if (sizes[i][1] >= heightMax) {
                heightMax = sizes[i][1];
            }
        }

        return new int[]{widthMax, heightMax};
    }

    private static int[][] swapCard(int[][] sizes) {
        // 너비 높이 길이 비교 후 비교 값이 크면 바꿈
        int tmp;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        return sizes;
    }

    public static int solution2(int[][] sizes) {
        int max = 0;
        int min = 0;
        for (int[] size : sizes) {
            int paramMax = Math.max(size[0], size[1]);
            int paramMin = Math.min(size[0], size[1]);

            if (paramMax > max) {
                max = paramMax;
            }

            if (paramMin > min) {
                min = paramMin;
            }
        }
        return max * min;
    }
}