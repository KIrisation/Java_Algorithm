package programmers.lv1;

import java.util.Arrays;
import java.util.EnumSet;

public class WorkoutClothes {

    public static void main(String[] args) {
        int n = 4;
        int[] lost = {2, 3};
        int[] reserve = {3, 4};

        System.out.println(solution2(n, lost, reserve));
    }

    public static int solution2(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;

                }
            }
        }
        return answer;
    }

    // 실패 코드
//    private static int findReserve(int lost, int[] reserve) {
//        return Arrays.stream(reserve)
//                     .filter(i -> i == lost)
//                     .findFirst()
//                     .orElse(0);
//    }
//
//    /**
//     * 입출력 예 n	lost	reserve	return 5	[2, 4]	[1, 3, 5]	5 5	[2, 4]	[3]	4 3	[3]	[1]	2
//     *
//     * @param n       - 학생 수
//     * @param lost    - 도난당한 학생 배열
//     * @param reserve - 여분을 가져온 학생 배열
//     * @return
//     */
//    public static int solution(int n, int[] lost, int[] reserve) {
//        int answer = n - lost.length;
//
//        Arrays.sort(lost);
//        Arrays.sort(reserve);
//
//        Map<Integer, Boolean> losts = new HashMap<>();
//        for (int lostStudent : lost) {
//            losts.put(lostStudent, false);
//        }
//
//        Map<Integer, Boolean> reserves = new HashMap<>();
//        for (int reserveStudent : reserve) {
//            reserves.put(reserveStudent, false);
//        }
//
//        for (int i = 0; i < lost.length; i++) {
//            for (int j = 0; j < reserve.length; j++) {
//                if (Boolean.TRUE.equals(reserves.get(reserve[j])) || Boolean.TRUE.equals(losts.get(lost[i]))
//                        || lost[i] == reserve[j]) {
//                    continue;
//                }
//
//                if (isReserve(lost[i], reserve[j])) {
//                    reserves.put(reserve[j], true);
//                    losts.put(lost[i], true);
//                    ++answer;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    private static boolean isReserve(int lostStudent, int reserveStudent) {
//        return lostStudent - 1 == reserveStudent || lostStudent + 1 == reserveStudent;
//    }
}
