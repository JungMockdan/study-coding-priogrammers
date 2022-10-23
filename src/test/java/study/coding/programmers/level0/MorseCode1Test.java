package study.coding.programmers.level0;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.Assert.assertEquals;


/*모스부호 (1)
문제 설명
머쓱이는 친구에게 모스부호를 이용한 편지를 받았습니다. 그냥은 읽을 수 없어 이를 해독하는 프로그램을 만들려고 합니다. 문자열 letter가 매개변수로 주어질 때, letter를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
모스부호는 다음과 같습니다.

morse = {
    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    '-.--':'y','--..':'z'
}
제한사항
1 ≤ letter의 길이 ≤ 1,000
return값은 소문자입니다.
letter의 모스부호는 공백으로 나누어져 있습니다.
letter에 공백은 연속으로 두 개 이상 존재하지 않습니다.
해독할 수 없는 편지는 주어지지 않습니다.
편지의 시작과 끝에는 공백이 없습니다.
입출력 예
letter	result
".... . .-.. .-.. ---"	"hello"
".--. -.-- - .... --- -."	"python"
입출력 예 설명
입출력 예 #1

.... = h
. = e
.-.. = l
.-.. = l
--- = o
따라서 "hello"를 return 합니다.
입출력 예 #2

.--. = p
-.-- = y
- = t
.... = h
--- = o
-. = n
따라서 "python"을 return 합니다.
a ~ z에 해당하는 모스부호가 순서대로 담긴 배열입니다.
{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}*/
public class MorseCode1Test {

    @DisplayName(value = "테스트 설명")
    @Test
    public void test() throws Exception {
        //given

        //when

        //then
        assertEquals("hello",solution(".... . .-.. .-.. ---"));
        assertEquals("python",solution(".--. -.-- - .... --- -."));

    }


    public String solution(String letter) {
        String morseTableStr = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f','--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l','--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r','...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x','-.--':'y','--..':'z'";
        //morseTableStr = morseTableStr.replaceAll("'", "\"");
        String[] morseCodes = morseTableStr.split(",");
        Map<String, String> morseTable = new HashMap<>();
        for (int i = 0; i < morseCodes.length; i++) {
            String[] split = morseCodes[i].replaceAll("'","").split(":");
            morseTable.put(split[0],split[1]);
        }
        System.out.println("morseTableStr" + morseTable);
        String[] codes = letter.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < codes.length; i++) {
            String code = codes[i];
            String str = morseTable.get(code);
            sb.append(str);
        }
        return sb.toString();
    }

    /* ObjectMapper 외부라이브러리 사용으로 실패 */
    public String solution2(String letter) {
        String morseTableStr = "{'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',\n" +
                "                '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',\n" +
                "                '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',\n" +
                "                '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',\n" +
                "                '-.--':'y','--..':'z'}";
        morseTableStr = morseTableStr.replaceAll("'", "\"");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> morseTable = null;
        try {
            morseTable = mapper.readValue(morseTableStr, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("morseTableStr" + morseTable);
        String[] codes = letter.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < codes.length; i++) {
            String code = codes[i];
            String str = morseTable.get(code);
            sb.append(str);
        }
        return sb.toString();
    }

}
