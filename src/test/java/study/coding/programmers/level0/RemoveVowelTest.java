package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*모음 제거
문제 설명
영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.

제한사항
my_string은 소문자와 공백으로 이루어져 있습니다.
1 ≤ my_string의 길이 ≤ 1,000
입출력 예
my_string	result
"bus"	"bs"
"nice to meet you"	"nc t mt y"
입출력 예 설명
입출력 예 #1

"bus"에서 모음 u를 제거한 "bs"를 return합니다.
입출력 예 #1

"nice to meet you"에서 모음 i, o, e, u를 모두 제거한 "nc t mt y"를 return합니다.*/
public class RemoveVowelTest {
    @Test
    @DisplayName(value = "test")
    public void test() {
        //given

        //when

        //then
        assertEquals("bs",solution("bus"));
        assertEquals("nc t mt y",solution("nice to meet you"));
    }

    public String solution(String my_string) {
        char[] chars = my_string.toCharArray();
        String answer = "";
        for (int i = 0; i < chars.length; i++) {
            String chr = new String(String.valueOf(chars[i]));
            boolean isVowel = "aeiou".contains(chr);
            if(!isVowel) {
                answer = answer+ chr;
            }
        }
        return answer;
    }
}
