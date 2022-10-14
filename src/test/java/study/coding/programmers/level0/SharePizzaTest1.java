package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

/*피자 나눠 먹기 (1)
문제 설명
머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.

제한사항
1 ≤ n ≤ 100
입출력 예
n	result
7	1
1	1
15	3
입출력 예 설명
입출력 예 #1

7명이 최소 한 조각씩 먹기 위해서 최소 1판이 필요합니다.
입출력 예 #2

1명은 최소 한 조각을 먹기 위해 1판이 필요합니다.
입출력 예 #3

15명이 최소 한 조각씩 먹기 위해서 최소 3판이 필요합니다.*/
public class SharePizzaTest1 {
    private int given1=1;
    private int given2=7;
    private int given3=8;
    private int given4=79;
    private int given5=55;

    @Test
    @DisplayName(value = "피자 나눠먹기 테스트")
    public void sharePizzaTest() {
        assertEquals(1,solution(given1));
        assertEquals(1,solution(given2));
        assertEquals(2,solution(given3));
        assertEquals(12,solution(given4));
        assertEquals(8,solution(given5));

    }
    public int solution(int peopleCount) {
        int pizzaCount = 1;
        if(peopleCount>7){
            if(peopleCount%7>0){
                pizzaCount = peopleCount/7+1;
            }else{
                pizzaCount = peopleCount/7;
            }
        }
        return pizzaCount;
    }
}
