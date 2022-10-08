package ndb.dfs;

/**
 * 재귀 함수란 자기 자신을 다시 호출하는 함수를 의미한다.
 */
public class RecursiveFunction01 {
    public static void recursiveFunction() {
        System.out.println("재귀 함수를 호출합니다.");
        recursiveFunction();
    }

    public static void main(String[] args) {
        recursiveFunction();
    }
}
