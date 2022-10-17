package study.coding.programmers.level0;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

/*
문자열 뒤집기
문제 설명
문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ my_string의 길이 ≤ 1,000
입출력 예
my_string	return
"jaron"	"noraj"
"bread"	"daerb"
입출력 예 설명
입출력 예 #1

my_string이 "jaron"이므로 거꾸로 뒤집은 "noraj"를 return합니다.
입출력 예 #2

my_string이 "bread"이므로 거꾸로 뒤집은 "daerb"를 return합니다.
* */
public class ReverseCharTest {

    @Test
    @DisplayName(value = "문자열뒤집기")
    public void test() {
        //given

        //when

        //then
        assertEquals(	"noraj",solution("jaron"));
        assertEquals(	"daerb",solution("bread"));

    }

    public String solution(String my_string) {
        char[] chars = my_string.toCharArray();
        char[] newChars = new char[chars.length];
        int answerIdx=0;
        for (int i = newChars.length - 1; i >= 0; i--) {
            newChars[answerIdx] = chars[i];
            answerIdx++;
        }

        return String.valueOf(newChars);
    }
}
