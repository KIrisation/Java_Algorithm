package codetree.data_structured.tree;

public class 힙만들기 {
    static int[] tree = new int[]{0, 5, 3, 6, 4, 7, 8, 9};
    public static void main(String[] args) {

    }

    static void hepify(int[] tree, int n, int i) { // n은 (배열의 마지막 인덱스)
        int largest = i;    // 최대 노드가 i번이라고 가정
        int l = i * 2;      // 왼쪽 자식 노드 번호
        int r = i * 2 + 1;  // 오른쪽 자식 노드 번호

        if(l <= n && tree[l] > tree[largest]) { // 왼쪽 자식이 크다면, 최대 번호를 수정
            largest = l;
        }

        if (r <= n && tree[r] > tree[largest]) { // 오른쪽 자식이 크다면, 최대 번호를 수정
            largest = r;
        }

        if (largest != i) {
            swap(tree[i], tree[largest]);
            hepify(tree, n, i);
        }
    }

    static void swap(int i, int largest) {
        int tmp = tree[i];
        tree[i] = tree[largest];
        tree[largest] = tmp;
    }

    static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; i--) {
            hepify(arr, n, i);
        }
    }
}
