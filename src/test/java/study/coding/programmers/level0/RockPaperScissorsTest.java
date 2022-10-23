package study.coding.programmers.level0;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
"2"	"0"
"205"	"052"
입출력 예 설명
입출력 예 #1

"2"는 가위이므로 바위를 나타내는 "0"을 return 합니다.
입출력 예 #2

"205"는 순서대로 가위, 바위, 보이고 이를 모두 이기려면 바위, 보, 가위를 순서대로 내야하므로 “052”를 return합니다.*/
public class RockPaperScissorsTest {
    @DisplayName(value = "테스트 설명")
    @Test
    public void test() throws Exception {
        //given

        //when

        //then
        assertEquals("0",solution("2"));
        assertEquals("052",solution("205"));


    }
    public String solution(String rsp) {
        String rock="0";
        String scissors="2";
        String paper="5";

        String[] rpsArray = rsp.split("");
        String winner="";
        for (int i = 0; i < rpsArray.length; i++) {
            String  challenger = rpsArray[i];
            switch (challenger){
                case "0":// rock
                    winner += paper;
                    break;
                case "2":// scissors
                    winner += rock;
                    break;
                case "5":// paper
                    winner += scissors;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + challenger);
            }
        }
        return winner;
    }
}
