package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*최댓값 만들기 (1)
문제 설명
정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

제한사항
0 ≤ numbers의 원소 ≤ 10,000
2 ≤ numbers의 길이 ≤ 100
입출력 예
numbers	result
[1, 2, 3, 4, 5]	20
[0, 31, 24, 10, 1, 9]	744
입출력 예 설명
입출력 예 #1

두 수의 곱중 최댓값은 4 * 5 = 20 입니다.
입출력 예 #1

두 수의 곱중 최댓값은 31 * 24 = 744 입니다.*/
public class MakeMaxNumTest1 {
    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{0, 31, 24, 10, 1, 9};
        //when

        //then
        assertEquals(20,solution(array1));
        assertEquals(744,solution(array2));

    }

    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;
        return numbers[len-1]*numbers[len-2];
    }
}
