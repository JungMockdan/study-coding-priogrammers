package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*문자열 정렬하기 (1)
문제 설명
문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.

제한사항
1 ≤ my_string의 길이 ≤ 100
my_string에는 숫자가 한 개 이상 포함되어 있습니다.
my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다. - - -
입출력 예
my_string	result
"hi12392"	[1, 2, 2, 3, 9]
"p2o4i8gj2"	[2, 2, 4, 8]
"abcde0"	[0]
입출력 예 설명
입출력 예 #1

"hi12392"에 있는 숫자 1, 2, 3, 9, 2를 오름차순 정렬한 [1, 2, 2, 3, 9]를 return 합니다.
입출력 예 #2

"p2o4i8gj2"에 있는 숫자 2, 4, 8, 2를 오름차순 정렬한 [2, 2, 4, 8]을 return 합니다.
입출력 예 #3

"abcde0"에 있는 숫자 0을 오름차순 정렬한 [0]을 return 합니다.*/
public class SortStringTest1 {

    @Test
    @DisplayName(value = "test")
    public void test() {
        //given
        int[] result1 = new int[]{1, 2, 2, 3, 9};
        int[] result2 = new int[]{2, 2, 4, 8};
        int[] result3 = new int[]{0};
        //when

        //then
        assertEquals(Arrays.toString(result1),Arrays.toString(solution2("hi12392")));
        assertEquals(Arrays.toString(result2),Arrays.toString(solution2("p2o4i8gj2")));
        assertEquals(Arrays.toString(result3),Arrays.toString(solution2("abcde0")));
    }
    public int[] solution(String my_string) {
        char[] chars = my_string.toCharArray();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int num = (int)chars[i];
            if(num>=48&&num<=57){
                numList.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }

        return numList.stream().sorted().mapToInt(value -> value).toArray();
    }

    //Character 클래스의 유틸함수를 이용하여 구하기.
    public int[] solution2(String my_string) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(Character.isDigit(c)){
                numList.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        int[] answer = numList.stream().sorted().mapToInt(value -> value).toArray();
        return answer;
    }

}
