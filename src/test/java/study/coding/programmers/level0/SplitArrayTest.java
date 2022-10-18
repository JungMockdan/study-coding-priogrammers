package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* 배열 자르기
문제 설명
정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때, numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.

제한사항
0 < numbers의 길이 ≤ 100
0 ≤ numbers의 원소 ≤ 1,000
0 <num1 < num2 < numbers의 길이
입출력 예
numbers	num1	num2	result
[1, 2, 3, 4, 5]	1	3	[2, 3, 4]
[1, 3, 5]	1	2	[3, 5]
입출력 예 설명
입출력 예 #1

[1, 2, 3, 4, 5]의 1번째 인덱스 2부터 3번째 인덱스 4 까지 자른 [2, 3]을 return 합니다.
입출력 예 #2

[1, 3, 5]의 1번째 인덱스 3부터 2번째 인덱스 5까지 자른 [3, 5]를 return 합니다.*/
public class SplitArrayTest {
    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{1, 3, 5};
        //when

        //then
        assertEquals(Arrays.toString(new int[]{2, 3, 4}), Arrays.toString(solution(array1, 1, 3)));
        assertEquals(Arrays.toString(new int[]{3, 5}), Arrays.toString(solution(array2, 1, 2)));

    }

    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers,num1,num2+1);
    }


}
