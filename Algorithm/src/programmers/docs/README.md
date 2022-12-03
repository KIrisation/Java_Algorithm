# Programmers 의 알고리즘 학습하며 알게된 내용

## level 0

## StringReverse
- String 값을 이어붙일때 단순하게 변수에 + 를 사용하는것 보다 StringBuilder 의 `append()` 함수를 이용한다.
- List 의 `set()` 메서드는 요소에 값이 경우 `OutOfIndex` 런타임 에러를 발생 시킨다.
  - 위의 말을 좀 더 해석해보자면 미리 `add()` 함수를 이용해서 List 에 요소를 담아둔다.
- List 의 `add()` 메서드는 순차적으로 값을 추가하게 된다.
- Arrays 는 배열에 사용하는 클래스이다.
- Collections 는 List, Map 등등의 자료구조에서 사용하는 클래스이다.
- Collections.reverse() 도 있지만 StringBuilder 클래스도 `reverse()` 가 있다.

## RightIsoscelesTriangle
- String 의 `repeat()` 메서드는 java 11 ver 이후로 지원하는 메서드이다.
  - how to work?
  - 문자열의 반복을 위한 메서드이다.
  - Returns a string whose value is the concatenation of this string repeated count times.
    If this string is empty or count is zero then the empty string is returned.
    Params:
    count – number of times to repeat
    Returns:
    A string composed of this string repeated count times or the empty string if this string is empty or count is zero
    Throws:
    IllegalArgumentException – if the count is negative.
    Since:
    11
  - If this string is empty or count is zero then the empty string is returned.
  - 빈 문자열 값이나 count 메소드의 파라미터가 0 이들어오면 빈 문자열을 리턴한다.

## CreateMaximum

- int 배열(int[]) 을 Integer List 로 바꾸기
- 반복문으로 넣기는 생략
- <B><U>Stream 이용</U></B>
```java
  int[] arr = {1,2,3};
  List<Integer> list = Arrays.stream(arr).boxed().collect(Collect.toList());
```

---
## RemoveDuplicateCharacters

- 난 기존에 이 문제를 중복 제거를 위해 HashSet을 사용했다.
- 하지만 HashSet은 순서 보장을 해주지 않는 치명적인 단점 때문에 답을 출력할 수 없었다.
- 방안은 없을까??

### `LinkedHashSet` 이란?
- HashSet과 동일한 구조로 이루어 진다. `중복제거` 가능 함.
  - 뭐가 다르냐?
- 기존의 HashSet은 순서보장이 되지 않는다. 
  - `LinkedHashSet`은 <U>순서보장이 가능</U>하다.
- 값 추가는 `add()` 메서드를 이용한다.
- 값 삭제는 `remove(), clear()` 메서드를 이용한다.
- 대신에 하나의 값만 출력하는 메서드는 없다.
- Iterator를 사용하여 값을 출력하는 방법을 생각 해야한다.
```java
		LinkedHashSet<String> str = new LinkedHashSet<String>(); // LinkedHashSet 선언
		
		// 값 추가
		str.add("Hello1");
		str.add("World2");
		str.add("Hello3");
		str.add("World4");
		
		/* Iterator를 사용 HashSet 배열 출력 */
		Iterator iter = str.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
	}
```

### 특이한 정렬
```java
class Distance implements Comparable<Distance> {
    private int num;
    private int dist;

    public Distance(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

    public int getNum() {
        return num;
    }

    // 본인이 클 때 바꿔야한다.
    // 해당 메서드는 리턴을 양수로 할 때 바꾼다.
    @Override
    public int compareTo(Distance o) {
        if (this.dist == o.dist) {
            if (this.num > o.num) {
                return - 1;
            } else if (this.num == o.num) {
                return 0; // 0 이면 안 바꾼다.
            }

            return 1;
        }

        if (this.dist > o.dist) {
            return 1;
        }

        return this.dist - o.dist;
    }
```

## Lv.1
### 최소직사각형(MakeCard)

- 해당 문제 뼈 아픈 점
- 비교적 간단하게 풀 수 있었다.
- 메서드를 3중으로 분리하여 풀 필요 없었다.
- 내가 하고자 했던 것은 양 변 모두를 통틀어 최대 값중 가장 큰 최대 값이 필요했다.
- 그리고 양 변 모두를 통틀어 최소 값중 가장 큰 최소 값이 필요했다.
- 포커싱이 잘 못 잡혔던것을 잊지 않아야 한다. 
- 좀 더 코드를 짜기 전에 좋은 방법은 없는지에 대해 고민 해 보자.