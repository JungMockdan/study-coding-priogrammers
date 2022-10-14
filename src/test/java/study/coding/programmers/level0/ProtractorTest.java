package study.coding.programmers.level0;

/*
각도기
문제 설명
각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다. 각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return하도록 solution 함수를 완성해주세요.

예각 : 0 < angle < 90
직각 : angle = 90
둔각 : 90 < angle < 180
평각 : angle = 180
제한사항
0 < angle ≤ 180
angle은 정수입니다.
입출력 예
angle	result
70	1
91	3
180	4
입출력 예 설명
입출력 예 #1

angle이 70이므로 예각입니다. 따라서 1을 return합니다.
입출력 예 #2

angle이 91이므로 둔각입니다. 따라서 3을 return합니다.
입출력 예 #2

angle이 180이므로 평각입니다. 따라서 4를 return합니다.*/

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class ProtractorTest {

    @Test
    @DisplayName(value = "각도판별 테스트")
    public void test() {
        //given

        //when

        //then
        assertEquals(1,solution(70));
        assertEquals(3,solution(91));
        assertEquals(4,solution(180));

    }
    public int solution(int angle) {

        if(angle==180) return Angle.FLAT.value;
        if(angle==90) return Angle.RIGHT.value;
        int answer = 0;
        if(angle-90>0){
            answer = Angle.OBTUSE.value;
        }else{
            answer = Angle.ACUTE.value;
        }

        return answer;
    }
    public enum Angle{
        ACUTE(1),  RIGHT(2), OBTUSE(3),  FLAT(4);

        private final int value;
        Angle(int i) {
            this.value = i;
        }
    }
}
