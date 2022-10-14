package study.coding.programmers.level0;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

/*피자 나눠 먹기 (2)
문제 설명
머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때, n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.

제한사항
1 ≤ n ≤ 100

입출력 예
n	result
6	1
10	5
4	2
입출력 예 설명
입출력 예 #1

6명이 모두 같은 양을 먹기 위해 한 판을 시켜야 피자가 6조각으로 모두 한 조각씩 먹을 수 있습니다.
입출력 예 #2

10명이 모두 같은 양을 먹기 위해 최소 5판을 시켜야 피자가 30조각으로 모두 세 조각씩 먹을 수 있습니다.
입출력 예 #3

4명이 모두 같은 양을 먹기 위해 최소 2판을 시키면 피자가 12조각으로 모두 세 조각씩 먹을 수 있습니다.*/
public class SharePizzaTest2 {
    private int given1=1;
    private int given2=7;
    private int given3=8;
    private int given4=79;
    private int given5=55;

    @Test
    @DisplayName(value = "피자 나눠먹기 테스트")
    public void sharePizzaTest() {
        assertEquals(1,solution(given1));
        assertEquals(7,solution(given2));
        assertEquals(4,solution(given3));
        assertEquals(79,solution(given4));
        assertEquals(55,solution(given5));

    }

    public int solution(int n) {
        int gcd = getGCD(6,n);//최대공약수
        int lcm = (6 * n) / gcd;// 최소공배수 즉, 공통분모
        return lcm/6;
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}
