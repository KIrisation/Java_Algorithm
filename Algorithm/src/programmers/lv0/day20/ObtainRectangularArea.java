package programmers.lv0.day20;

/**
 * 직사각형 넓이 구하기
 * <p>
 * 문제 설명 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다. 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로
 * 주어질 때, 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.
 * <p>
 * 제한사항 dots의 길이 = 4 dots의 원소의 길이 = 2 -256 < dots[i]의 원소 < 256 잘못된 입력은 주어지지 않습니다.
 * <p>
 * 입출력 예 dots	result [[1, 1], [2, 1], [2, 2], [1, 2]]	1 [[-1, -1], [1, 1], [1, -1], [-1, 1]]	4
 */
public class ObtainRectangularArea {

    public static void main(String[] args) {
        int[][] square = {{1,1}, {2,1},{2,2},{1,2}};
        int[][] square2 = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        System.out.println(solution(square));
        System.out.println(solution(square2));;
    }

    public static int solution(int[][] dots) {
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;

        int row = 0;
        int column = 0;

        for (int i = 0; i < dots.length; i++) {
            if (i + 1 == dots.length - 1) {
                break;
            }

            x1 = dots[i][0];
            y1 = dots[i][1];

            if (x1 != dots[i + 1][0]) {
                x2 = dots[i + 1][0];
                row = x2 - x1;
            }

            if (y1 != dots[i + 1][1]) {
                y2 = dots[i + 1][1];
                column = y2 - y1;

            }
        }

        return Math.abs(row * column);
    }

}
