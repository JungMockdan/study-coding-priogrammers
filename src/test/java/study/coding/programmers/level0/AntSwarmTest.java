package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*개미 군단
문제 설명
개미 군단이 사냥을 나가려고 합니다. 개미군단은 사냥감의 체력에 딱 맞는 병력을 데리고 나가려고 합니다. 장군개미는 5의 공격력을, 병정개미는 3의 공격력을 일개미는 1의 공격력을 가지고 있습니다. 예를 들어 체력 23의 여치를 사냥하려고 할 때, 일개미 23마리를 데리고 가도 되지만, 장군개미 네 마리와 병정개미 한 마리를 데리고 간다면 더 적은 병력으로 사냥할 수 있습니다. 사냥감의 체력 hp가 매개변수로 주어질 때, 사냥감의 체력에 딱 맞게 최소한의 병력을 구성하려면 몇 마리의 개미가 필요한지를 return하도록 solution 함수를 완성해주세요.
*/
/*
제한사항
hp는 자연수입니다.
0 ≤ hp ≤ 1000
입출력 예
hp	result
23	5
24	6
999	201
입출력 예 설명
입출력 예 #1

hp가 23이므로, 장군개미 네마리와 병정개미 한마리로 사냥할 수 있습니다. 따라서 5를 return합니다.
입출력 예 #2

hp가 24이므로, 장군개미 네마리 병정개미 한마리 일개미 한마리로 사냥할 수 있습니다. 따라서 6을 return합니다.
입출력 예 #3

hp가 999이므로, 장군개미 199 마리 병정개미 한마리 일개미 한마리로 사냥할 수 있습니다. 따라서 201을 return합니다.*/
public class AntSwarmTest {
    @Test
    @DisplayName(value = "test")
    public void test() {
        //given

        //when

        //then
        assertEquals(5,solution(23));
        assertEquals(6,solution(24));
        assertEquals(201,solution(999));
    }

    public int solution(int hp) {
//        장군개미는 5의 공격력을, 병정개미는 3의 공격력을 일개미는 1의 공격력
        int GN_ANT=5;
        int SLD_ANT=3;
        int ant_count=0;
        while (hp>=GN_ANT) {
            hp=hp-GN_ANT;
            ant_count++;
        }
        while (hp>=SLD_ANT) {
            hp=hp-SLD_ANT;
            ant_count++;
        }
        while (hp>0) {
            hp--;
            ant_count++;
        }

        return ant_count;
    }

    public int solution2(int hp) {
        int answer = 0;
        answer += hp / 5;
        hp %= 5;
        answer += hp / 3;
        hp %= 3;
        answer += hp;
        return answer;
    }


}
