package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetCDArrayTest {

    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] result1 = new int[]{1, 2, 3, 4, 6, 8, 12, 24};
        int[] result2 = new int[]{1, 29};
        //when

        //then

    }

    public int[] solution(int n) {
        List<Integer> cds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                cds.add(i);
            }
        }
        int[] answer = Arrays.stream(cds.toArray()).sorted().collect(Collectors.toList()).stream().mapToInt(i -> (int) i).toArray();

        return answer;
    }


}
