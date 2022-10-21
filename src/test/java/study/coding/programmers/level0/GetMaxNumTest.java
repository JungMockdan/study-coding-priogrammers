package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*가장 큰 수 찾기
문제 설명
정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

제한사항
1 ≤ array의 길이 ≤ 100
0 ≤ array 원소 ≤ 1,000
array에 중복된 숫자는 없습니다.
입출력 예
array	result
[1, 8, 3]	[8, 1]
[9, 10, 11, 8]	[11, 2]
입출력 예 설명
입출력 예 #1

1, 8, 3 중 가장 큰 수는 8이고 인덱스 1에 있습니다.
입출력 예 #2

9, 10, 11, 8 중 가장 큰 수는 11이고 인덱스 2에 있습니다.*/
public class GetMaxNumTest {
    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] array1 = new int[]{1, 8, 3};
        int[] array2 = new int[]{9, 10, 11, 8};

        int[] result1 = new int[]{8, 1};
        int[] result2 = new int[]{11, 2};
        //when

        //then
        assertEquals(Arrays.toString(result1), Arrays.toString(solution(array1)));
        assertEquals(Arrays.toString(result2), Arrays.toString(solution3(array2)));

    }
    public int[] solution(int[] array) {
        Map<Integer, Integer> numMap = IntStream.range(0, array.length)
                .boxed()
                .collect(
                        Collectors.toMap(Function.identity(), k -> array[k])
                );


        Map.Entry<Integer, Integer> maxNumMap= numMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst().get();

        int[] answer = new int[2];

        answer[0] = maxNumMap.getValue();
        answer[1] = maxNumMap.getKey();
        return answer;
    }

    public int[] solution2(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int max = list.stream().max(Integer::compareTo).orElse(0);
        int index = list.indexOf(max);
        return new int[] {max, index};
    }

    public int[] solution3(int[] array) {
        int maxNum = Arrays.stream(array).max().getAsInt();

        IntStream intStream = IntStream.range(0, array.length).filter(i -> array[i] == maxNum);
        OptionalInt first = intStream.findFirst();
        int index = first.getAsInt();

        return new int[]{maxNum, index};
    }

}
