package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
짝수 홀수 개수
문제 설명
정수가 담긴 리스트 num_list가 주어질 때, num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

제한사항
1 ≤ num_list의 길이 ≤ 100
0 ≤ num_list의 원소 ≤ 1,000
입출력 예
num_list	result
[1, 2, 3, 4, 5]	[2, 3]
[1, 3, 5, 7]	[0, 4]
입출력 예 설명
입출력 예 #1

[1, 2, 3, 4, 5]에는 짝수가 2, 4로 두 개, 홀수가 1, 3, 5로 세 개 있습니다.
입출력 예 #2

[1, 3, 5, 7]에는 짝수가 없고 홀수가 네 개 있습니다.
* */
public class CountOddsEvensTest {

    @Test
    @DisplayName(value = "")
    public void test() {
        //given
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{1, 3, 5, 7};
        int[] array3 = new int[]{2,4};
        //when

        //then
        assertEquals(Arrays.toString(new int[]{2,3}),Arrays.toString(solution(array1)));
        assertEquals(Arrays.toString(new int[]{0,4}),Arrays.toString(solution(array2)));
        assertEquals(Arrays.toString(new int[]{2,0}),Arrays.toString(solution(array3)));
        /* 스트림 기능을 활용해서... */
        assertEquals(Arrays.toString(new int[]{2,3}),Arrays.toString(solution2(array1)));
        assertEquals(Arrays.toString(new int[]{0,4}),Arrays.toString(solution2(array2)));
        assertEquals(Arrays.toString(new int[]{2,0}),Arrays.toString(solution2(array3)));
    }

    private int[] solution2(int[] numList) {

        int evenCount = (int) Arrays.stream(numList).filter(i -> i % 2 == 0).count();
        int oddCount = (int) Arrays.stream(numList).filter(i -> i % 2 == 1).count();
        return IntStream.of(evenCount, oddCount).toArray();

    }

    public int[] solution(int[] num_list) {
        int evenCount=0;
        int oddCount=0;
        for (int i = 0; i < num_list.length; i++) {
            if(num_list[i]%2==0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        int[] answer=new int[]{evenCount,oddCount};
        return answer;
    }


}
