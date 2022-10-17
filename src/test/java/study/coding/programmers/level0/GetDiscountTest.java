package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
옷가게 할인 받기
문제 설명
머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.

제한사항
0 ≤ price ≤ 1,000,000
소수점 이하를 버린 정수를 return합니다.
입출력 예
price	result
150,000	142,500
580,000	464,000
입출력 예 설명
입출력 예 #1

150,000원에서 5%를 할인한 142,500원을 return 합니다.
입출력 예 #2

580,000원에서 20%를 할인한 464,000원을 return 합니다.
*/
public class GetDiscountTest {

    @Test
    @DisplayName(value = "")
    public void test() {
        //given

        //when

        //then
        assertEquals(10000,solution(10000));
        assertEquals(142500,solution(150000));
        assertEquals(270000,solution(300000));
        assertEquals(464000,solution(580000));
        assertEquals(297008,solution(330009));

    }

    public int solution(int price) {
        if(price<100000){
            return price;
        }else{
            double discount=0.05;
            if(price>=500000){
                discount=0.2;
            }else if(price>=300000){
                discount=0.1;
            }

            return (int) (price- (price * discount));
        }
    }
}
