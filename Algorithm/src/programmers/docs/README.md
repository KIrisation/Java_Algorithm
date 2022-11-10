# Programmers 의 알고리즘 학습하며 알게된 내용

## level 0

### StringReverse
- String 값을 이어붙일때 단순하게 변수에 + 를 사용하는것 보다 StringBuilder 의 `append()` 함수를 이용한다.
- List 의 `set()` 메서드는 요소에 값이 경우 `OutOfIndex` 런타임 에러를 발생 시킨다.
  - 위의 말을 좀 더 해석해보자면 미리 `add()` 함수를 이용해서 List 에 요소를 담아둔다.
- List 의 `add()` 메서드는 순차적으로 값을 추가하게 된다.
- Arrays 는 배열에 사용하는 클래스이다.
- Collections 는 List, Map 등등의 자료구조에서 사용하는 클래스이다.
- Collections.reverse() 도 있지만 StringBuilder 클래스도 `reverse()` 가 있다.

### RightIsoscelesTriangle
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