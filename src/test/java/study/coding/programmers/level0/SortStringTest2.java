package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*문자열 정렬하기 (2)
문제 설명
영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때, my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.

제한사항
0 < my_string 길이 < 100
입출력 예
my_string	result
"Bcad"	"abcd"
"heLLo"	"ehllo"
"Python"	"hnopty"
입출력 예 설명
입출력 예 #1

"Bcad"를 모두 소문자로 바꾸면 "bcad"이고 이를 알파벳 순으로 정렬하면 "abcd"입니다.
입출력 예 #2

"heLLo"를 모두 소문자로 바꾸면 "hello"이고 이를 알파벳 순으로 정렬하면 "ehllo"입니다.
입출력 예 #3

"Python"를 모두 소문자로 바꾸면 "python"이고 이를 알파벳 순으로 정렬하면 "hnopty"입니다.*/
public class SortStringTest2 {
    @Test
    @DisplayName(value = "test")
    public void test() {
        //given

        //when

        //then
        assertEquals("abcd",solution("Bcad"));
        assertEquals("ehllo",solution("heLLo"));
        assertEquals("hnopty",solution("Python"));
    }

    public String solution(String my_string) {
        String answer = "";
        char[] chars = my_string.toCharArray();
        int[] nums = new int[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            char c = String.valueOf(my_string.charAt(i)).toLowerCase().charAt(0);
            nums[i] = (int)c;
        }
        int[] ints = Arrays.stream(nums).sorted().boxed().mapToInt(value -> value).toArray();
        for (int i = 0; i < ints.length; i++) {
            char chr = (char) ints[i];
            answer+=String.valueOf(chr).toLowerCase();
        }
        return answer;
    }

    public String _short(String my_string) {
        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
