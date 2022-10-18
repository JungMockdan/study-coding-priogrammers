package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
진료 순서 정하기
문제 설명
외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다. 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.

제한사항
중복된 원소는 없습니다.
1 ≤ emergency의 길이 ≤ 10
1 ≤ emergency의 원소 ≤ 100
입출력 예
emergency	result
[3, 76, 24]	[3, 1, 2]
[1, 2, 3, 4, 5, 6, 7]	[7, 6, 5, 4, 3, 2, 1]
[30, 10, 23, 6, 100]	[2, 4, 3, 5, 1]
입출력 예 설명
입출력 예 #1

emergency가 [3, 76, 24]이므로 응급도의 크기 순서대로 번호를 매긴 [3, 1, 2]를 return합니다.
입출력 예 #2

emergency가 [1, 2, 3, 4, 5, 6, 7]이므로 응급도의 크기 순서대로 번호를 매긴 [7, 6, 5, 4, 3, 2, 1]를 return합니다.
입출력 예 #3

emergency가 [30, 10, 23, 6, 100]이므로 응급도의 크기 순서대로 번호를 매긴 [2, 4, 3, 5, 1]를 return합니다.
*/
public class SetOrderToSeeDoctorTest {

    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] array1 = new int[]{3, 76, 24};
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] array3 = new int[]{30, 10, 23, 6, 100};

        int[] result1 = new int[]{3, 1, 2};
        int[] result2 = new int[]{7, 6, 5, 4, 3, 2, 1};
        int[] result3 = new int[]{2, 4, 3, 5, 1};

        //when

        //then
        assertEquals(Arrays.toString(result1), Arrays.toString(solution(array1)));
        assertEquals(Arrays.toString(result2), Arrays.toString(solution(array2)));
        assertEquals(Arrays.toString(result3), Arrays.toString(solution(array3)));

    }

    public int[] solution(int[] emergency) {
        Map<Integer, Integer> emergencyMap = IntStream.range(0, emergency.length)
                .boxed()
                .collect(
                        Collectors.toMap(Function.identity(), k -> emergency[k])
                );

        //숫자가 큰순으로 정렬 map의 key는 기존에 인덱스 위치, value는 value로서 -> 정렬후에는 index값을 찾아 순서값을 셋팅하는 식으로 해결했다.
        Iterator<Map.Entry<Integer, Integer>> iterator = emergencyMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .iterator();
        int[] answer = new int[emergency.length];
        int order = 1;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer idx = next.getKey();
            answer[idx] = order++;
        }
        return answer;
    }


    public int[] solution2(int[] intArray) {
        IntStream stream = Arrays.stream(intArray);
        IntStream intStream = stream
                .map(atomicInt -> {
                    Stream<Integer> sorted = stream.boxed().sorted(Comparator.reverseOrder());
                    List<Integer> collect = sorted.collect(Collectors.toList());
                    int result = collect.indexOf(atomicInt) + 1;
                    return result;
                });
        int[] ints = intStream.toArray();
        return ints;
    }


}
