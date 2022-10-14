package study.coding.programmers.level0;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
    # 짝수는 싫어요
    ## 문제 설명
    정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

    ## 제한사항
    1 ≤ n ≤ 100
    ## 입출력 예
    n	result
    10	[1, 3, 5, 7, 9]
    15	[1, 3, 5, 7, 9, 11, 13, 15]
    ### 입출력 예 설명
    ### 입출력 #1

    10 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9]를 return합니다.
    ### 입출력 #1

    15 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9, 11, 13, 15]를 return합니다.
 */

public class HateEvenNumberTest {
    private int given1=1;
    private int given2=2;
    private int given3=13;
    private int given4=77;
    private int given5=100;

    @Test
    @DisplayName(value = "홀수 배열만들기")
    public void test_odd_arr() {
        int[] array1=getOddsArray(given1);
        int[] array2=getOddsArray(given2);
        int[] array3=getOddsArray(given3);
        int[] array4=getOddsArray(given4);
        int[] array5=getOddsArray(given5);
        System.out.println("short solution : "+Arrays.toString(solution(given5)));
        assertNotNull(array1);

    }

    private int[] getOddsArray(int number) {
        if(number==1) return new int[]{1};

        boolean numberIsOdd = number % 2 != 0;
        List<Integer> oddList = new ArrayList<>();
        oddList.add(1);
        for(int i=2;i<number;i++) {
            if(i%2!=0) {//홀수
                oddList.add(i);
            }
        }
        if(numberIsOdd)oddList.add(number);

        Integer[] result = oddList.toArray(new Integer[oddList.size()]);

        System.out.println("배열: "+ Arrays.toString(result));
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }


    public int[] solution(int n) {
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
}
