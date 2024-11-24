package programmers.lv2.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 해당 풀이는 완전 탐색을 기반으로
 * 곡괭이의 모든 조합을 만들어서 그중 최저 비용을 탐색하기 위한 코드이다.
 *
 * 하지만 곡괭이가 최대 15개까지 올 수 있는 상황에서
 * 15! 의 값이 나올 수 있기 때문에 전체 조합을 만들어내는 완전 탐색으로 해당 문제는 풀 수 없다.
 *
 * 따라서, 해당 문제는 그리디를 이용한 풀이로 이어질 예정이다.
 */
class 광물_캐기_Fail {
    static Set<ArrayList<String>> picksCombinations = new HashSet<>();

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        String dia = "dia"; // 다이아 곡괭이
        String irn = "irn"; // 철 곡괭이
        String sto = "sto"; // 돌 곡괭이

        ArrayList<String> tools = new ArrayList<>();
        for (int i = 0; i < picks.length; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (i == 0) {
                    tools.add(dia);
                } else if(i == 1)    {
                    tools.add(irn);
                } else {
                    tools.add(sto);
                }
            }
        }

        boolean[] used = new boolean[tools.size()];
        List<String> currentTools = new ArrayList<>();

        pickCombination(tools, currentTools, used);

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < minerals.length; i++) {
            int result = 0;
            for (ArrayList<String> currentPicks : picksCombinations) {
                int pickCnt = 0;
                for (String currentPick : currentPicks) {
                    if (pickCnt == 5) {
                        pickCnt = 0;
                        continue;
                    }

                    if ("dia".equals(currentPick)) {
                        result += 1;
                    } else if ("irn".equals(currentPick)) {
                        if (minerals[i].equals("diamond")) {
                            result += 5;
                        } else {
                            result += 1;
                        }
                    } else {
                        if (minerals[i].equals("diamond")) {
                            result += 25;
                        } else if (minerals[i].equals("iron")) {
                            result += 5;
                        } else {
                            result += 1;
                        }
                    }

                    ++pickCnt;
                }
            }

            results.add(result);
        }

//        Integer min =

        return Collections.min(results);
    }

    public void pickCombination(List<String> tools, List<String> currentTools, boolean[] used) {
        if (currentTools.size() == tools.size()) {
            picksCombinations.add(new ArrayList<>(currentTools));
            return;
        }

        for (int i = 0; i < tools.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                currentTools.add(tools.get(i));
                pickCombination(tools, currentTools, used);
                currentTools.remove(currentTools.size()  - 1);
                used[i] = false;
            }
        }
    }
}