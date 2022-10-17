package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class ModeTest2 {
    @Test
    @DisplayName(value = "")
    public void 테스트이름() {
        //given
        int[] array1=new int[]{1, 1, 2, 3, 4, 5};
        int[] array2=new int[]{0, 2, 3, 4};
        //when

        //then
        assertEquals(2,solution(array1,1));
        assertEquals(0,solution(array2,1));

    }



    public int solution(int[] array, int n) {
        int answer = 0;
        return answer;
    }
}
