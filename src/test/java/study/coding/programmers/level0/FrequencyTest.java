package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencyTest {

    @Test
    @DisplayName(value = "")
    public void test() {
        //given

        int[] array1=new int[]{1, 1, 2, 3, 4, 5};
        int[] array2=new int[]{0, 2, 3, 4};
        int[] array3 = new int[]{1};
        int[] array4 = new int[]{1, 2, 3, 3, 3, 4, 99, 99, 99, 99, 99, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13};
        //when

        //then
        assertEquals(2,solution(array1,1));
        assertEquals(0,solution(array2,1));
        assertEquals(1,solution(array3,1));
        assertEquals(5,solution(array4,99));

    }

    public int solution(int[] array, int n) {
        int count = (int) Arrays.stream(array).filter(o -> o == n).count();
        return count;
    }


}
