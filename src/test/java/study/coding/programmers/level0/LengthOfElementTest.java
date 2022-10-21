package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
배열 원소의 길이
문제 설명
문자열 배열 strlist가 매개변수로 주어집니다. strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ strlist 원소의 길이 ≤ 100
strlist는 알파벳 소문자, 대문자, 특수문자로 구성되어 있습니다.
입출력 예
strlist	result
["We", "are", "the", "world!"]	[2, 3, 3, 6]
["I", "Love", "Programmers."]	[1, 4, 12]
입출력 예 설명
입출력 예 #1

["We", "are", "the", "world!"]의 각 원소의 길이인 [2, 3, 3, 6]을 return합니다.
입출력 예 #2

["I", "Love", "Programmers."]의 각 원소의 길이인 [1, 4, 12]을 return합니다.
* */
public class LengthOfElementTest {

    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        String[] array1 = new String[]{"We", "are", "the", "world!"};
        String[] array2 = new String[]{"I", "Love", "Programmers."};

        int[] result1 = new int[]{2, 3, 3, 6};
        int[] result2 = new int[]{1, 4, 12};

        //when

        //then
        assertEquals(Arrays.toString(result1), Arrays.toString(solution(array1)));
        assertEquals(Arrays.toString(result2), Arrays.toString(solution(array2)));

        assertEquals(Arrays.toString(result1), Arrays.toString(solution2(array1)));
        assertEquals(Arrays.toString(result2), Arrays.toString(solution2(array2)));

    }

    public int[] solution(String[] strlist) {

        int[] answer = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {
            answer[i]=strlist[i].length();
        }
        return answer;
    }

    public int[] solution2(String[] strList) {
        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }

}
