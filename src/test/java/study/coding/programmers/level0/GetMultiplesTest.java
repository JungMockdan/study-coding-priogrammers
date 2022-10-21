package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*n의 배수 고르기
문제 설명
정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 10,000
1 ≤ numlist의 크기 ≤ 100
1 ≤ numlist의 원소 ≤ 100,000
입출력 예
n	numlist	result
3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
5	[1, 9, 3, 10, 13, 5]	[10, 5]
12	[2, 100, 120, 600, 12, 12]	[120, 600, 12, 12]
입출력 예 설명
입출력 예 #1

numlist에서 3의 배수만을 남긴 [6, 9, 12]를 return합니다.
입출력 예 #2

numlist에서 5의 배수만을 남긴 [10, 5]를 return합니다.
입출력 예 #3

numlist에서 12의 배수만을 남긴 [120, 600, 12, 12]를 return합니다.
*/
public class GetMultiplesTest {

    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] array1 = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] array2 = new int[]{1, 9, 3, 10, 13, 5};
        int[] array3 = new int[]{2, 100, 120, 600, 12, 12};

        int[] result1 = new int[]{6, 9, 12};
        int[] result2 = new int[]{10, 5};
        int[] result3 = new int[]{120, 600, 12, 12};
        //when

        //then
        assertEquals(Arrays.toString(result1), Arrays.toString(solution(3,array1)));
        assertEquals(Arrays.toString(result2), Arrays.toString(solution(5,array2)));
        assertEquals(Arrays.toString(result3), Arrays.toString(solution(12,array3)));

    }

    public int[] solution(int n, int[] numlist) {

        int[] answer =Arrays.stream(Arrays.stream(numlist).toArray()).filter(value -> value%n==0).toArray();
        return answer;
    }
}
