package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

/*
나이 출력
문제 설명
머쓱이는 40살인 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 나이 age가 주어질 때, 2022년을 기준 출생 연도를 return 하는 solution 함수를 완성해주세요.

제한사항
0 < age ≤ 120
나이는 태어난 연도에 1살이며 1년마다 1씩 증가합니다.
입출력 예
age	result
40	1983
23	2000
입출력 예 설명
입출력 예 #1

2022년 기준 40살이므로 1983년생입니다.
입출력 예 #2

2022년 기준 23살이므로 2000년생입니다.
*/
public class PrintOutBornYearTest {

    private final int THIS_YEAR=2022;

    @Test
    @DisplayName(value = "배열평균값 테스트")
    public void test() {
        //given

        //when

        //then
        assertEquals(2022,solution(1));
        assertEquals(1983,solution(40));
        assertEquals(2000,solution(23));

    }

    public int solution(int age) {
        return THIS_YEAR-age+1;
    }
}
