package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*대문자와 소문자
문제 설명
문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ my_string의 길이 ≤ 1,000
my_string은 영어 대문자와 소문자로만 구성되어 있습니다.
입출력 예
my_string	result
"cccCCC"	"CCCccc"
"abCdEfghIJ"	"ABcDeFGHij"
입출력 예 설명
입출력 예 #1

소문자는 대문자로 대문자는 소문자로 바꾼 "CCCccc"를 return합니다.
입출력 예 #2

소문자는 대문자로 대문자는 소문자로 바꾼 "ABcDeFGHij"를 return합니다.*/
public class CharCaseChangeTest {
    @Test
    @DisplayName(value = "test")
    public void test() {
        //given

        //when

        //then
        assertEquals("CCCccc",solution2("cccCCC"));
        assertEquals("ABcDeFGHij",solution2("abCdEfghIJ"));
    }

    public String solution(String my_string) {
        char[] chars = my_string.toCharArray();
        String answer = "";
        for (int i = 0; i < chars.length; i++) {
            int aChar = (int) chars[i];
            String charCase = aChar - 65 < 26 ? "L" : "U";
            String str = null;
            if (charCase.equals("L")) {
                str = String.valueOf((char) (aChar + 32));
            } else {
                str = String.valueOf((char) (aChar - 32));
            }

            answer += str;
        }
        return answer;
    }

    public String solution2(String my_string) {
        char[] chars = my_string.toCharArray();
        String answer = "";
        for (int i = 0; i < chars.length; i++) {
            String str = null;
            if(Character.isLowerCase(chars[i])) {
                char c = Character.toUpperCase(chars[i]);
                str = String.valueOf(c);
            }

            if(Character.isUpperCase(chars[i])) {
                char c = Character.toLowerCase(chars[i]);
                str = String.valueOf(c);
            }

            answer += str;
        }
        return answer;
    }
}
