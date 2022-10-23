package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*구슬을 나누는 경우의 수
문제 설명
머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다. 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

제한사항
1 ≤ balls ≤ 30
1 ≤ share ≤ 30
구슬을 고르는 순서는 고려하지 않습니다.
share ≤ balls
입출력 예
balls	share	result
3	2	3
5	3	10
입출력 예 설명
입출력 예 #1

서로 다른 구슬 3개 중 2개를 고르는 경우의 수는 3입니다. 스크린샷 2022-08-01 오후 4.15.55.png
입출력 예 #2

서로 다른 구슬 5개 중 3개를 고르는 경우의 수는 10입니다.
Hint
서로 다른 n개 중 m개를 뽑는 경우의 수 공식은 다음과 같습니다.

n!/(n-m)!*m!

스크린샷 2022-08-01 오후 4.37.53.png
※ 공지 - 2022년 10월 11일 제한 사항 및 테스트케이스가 수정되었습니다.*/
public class NoC_BeadsDivideTest {

    @DisplayName(value = "테스트 설명")
    @Test
    public void test() throws Exception {
        //given

        //when

        //then
        assertEquals(3, solution(3, 2));
        assertEquals(1, solution(10, 10));
        assertEquals(10, solution(5, 3));

    }

    public int solution(int n, int m) {
        if (n - m == 0) return 1;
        if (n - m < 0) return 0;
        BigInteger nMinusMFact = factorial(n - m);
        BigInteger mFact = factorial(m);
        BigInteger nFact = factorial(n);
        BigInteger multiply = nMinusMFact.multiply(mFact);
        BigInteger numberOfCase = nFact.divide(multiply);
        return numberOfCase.intValue();
    }

    /*팩토리얼이란? !로 표시
    3! = 3*2*1 = 6
    4! = 4*3*2*1 = 24
    5! = 5*4*3*2*1 = 120
    */
    public static BigInteger factorial(int n) {
        if (n <= 1) return BigInteger.valueOf(n);
        else {
            BigInteger factorial = factorial(n - 1);
            return factorial.multiply(BigInteger.valueOf(n));
        }
    }
}
