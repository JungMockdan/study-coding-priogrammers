package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
삼각형의 완성조건 (1)
문제 설명
선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.

가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.

제한사항
sides의 원소는 자연수입니다.
sides의 길이는 3입니다.
1 ≤ sides의 원소 ≤ 1,000
입출력 예
sides	result
[1, 2, 3]	2
[3, 6, 2]	2
[199, 72, 222]	1
입출력 예 설명
입출력 예 #1

가장 큰 변인 3이 나머지 두 변의 합 3과 같으므로 삼각형을 완성할 수 없습니다. 따라서 2를 return합니다.
입출력 예 #2

가장 큰 변인 6이 나머지 두 변의 합 5보다 크므로 삼각형을 완성할 수 없습니다. 따라서 2를 return합니다.
입출력 예 #3

가장 큰 변인 222가 나머지 두 변의 합 271보다 작으므로 삼각형을 완성할 수 있습니다. 따라서 1을 return합니다.
* */
public class ConditionOfTriangleCompletionTest1 {

    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] array1=new int[]{1, 2, 3};
        int[] array2=new int[]{3, 6, 2};
        int[] array3=new int[]{199, 72, 222};

        //when

        //then

        assertEquals(2,solution(array2));
        assertEquals(2,solution(array1));
        assertEquals(1,solution(array3));
    }

    public int solution(int[] sides) {
        //가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합
        Arrays.sort(sides);
        boolean con1 = sides[2]<(sides[0]+sides[1]);

        return con1?1:2;
    }

}
