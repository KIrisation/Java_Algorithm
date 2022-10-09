package ndb.dfs;

import java.util.ArrayList;

/**
 * 인접 리스트는 '연결 리스트'라는 자료구조를 이용해 구현하는데, C++ 나 자바와 같은 프로그래밍 언어에서는
 * 별도로 연결 리스트 기능을 위한 표준 라이브러리를 제공한다.
 */
public class AdjacencyList {
    // 행(Row)이 3개인 인접 리스트 표현

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(0)
             .add(new Node(1, 7));
        graph.get(0)
             .add(new Node(2, 5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(1)
             .add(new Node(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(2)
             .add(new Node(0, 5));

        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i)
                     .get(j)
                     .show();
            }
        }
    }

}
class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.println("(" + this.index + "," + this.distance + ")");
    }
}

/**
 * 인접 배열과 인접 리스트의 차이는 무엇인가?
 * 메모리 측면에서 보자면 인접 행렬 방식은 모든 관계를 저장하므로 노드 개수가 많을수록
 * 메모리가 불필요하게 낭비된다.
 * 반면에 인접 리스트 방식은 연결된 정보만을 저장하기 때문에 메모리를 효율적으로 사용한다.
 * 하지만 이와 같은 속성 때문에 인접 리스트 방식은 인접 행렬 방식에 비해 특정한 두 노드가
 * 연결되어 있는지에 대한 정보를 얻는 속도가 느리다.
 * 인접 리스트 방식에서는 연결된 데이터를 하나씩 확인해야 하기 때문이다.
 *
 * 또 다른 예시로 한 그래프에서 노드 1과 노드 7이 연결되어 있는 상황을 가정해보자.
 * 인접 행렬 방식에서는 graph[1][7]만 확인하면 된다.
 * 반면에 인접 리스트 방식에서는 노드 1에 대한 인접 리스트를 앞에서부터 차례대로 확인해야 한다.
 * 그러므로 특정한 노드와 연결된 모든 인접 노드를 순회해야 하는 경우, 인접 리스트 방식이 인접 행렬 방식에 비해 메모리 공간의 낭비가 적다.
 *
 */