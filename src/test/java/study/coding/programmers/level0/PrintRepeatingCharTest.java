package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
문자 반복 출력하기
문제 설명
문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.

제한사항
1 ≤ my_string 길이 ≤ 50
1 ≤ n ≤ 50
"my_string"은 영어 대소문자로 이루어져 있습니다.
입출력 예
my_string	n	result
"hello"	3	"hhheeellllllooo"
입출력 예 설명
입출력 예 #1

"hello"의 각 문자를 세 번씩 반복한 "hhheeellllllooo"를 return 합니다.
* */
public class PrintRepeatingCharTest {

    @Test
    @DisplayName(value = "")
    public void test() {
        //given

        //when


        //then
        assertEquals("hhheeellllllooo",solution("hello",3));
    }

    public String solution(String my_string, int n) {
        if(n==1) return my_string;
        char[] chars = my_string.toCharArray();
        String answer = "";
        for (char chr : chars) {
            for(int i =0;i<n;i++){
                answer+=chr;
            }
        }
        return answer;
    }

}
