package study.coding.programmers.level0;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
점의 위치 구하기
문제 설명
사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.
스크린샷 2022-07-07 오후 3.27.04 복사본.png

x 좌표와 y 좌표가 모두 양수이면 제1사분면에 속합니다.
x 좌표가 음수, y 좌표가 양수이면 제2사분면에 속합니다.
x 좌표와 y 좌표가 모두 음수이면 제3사분면에 속합니다.
x 좌표가 양수, y 좌표가 음수이면 제4사분면에 속합니다.
x 좌표 (x, y)를 차례대로 담은 정수 배열 dot이 매개변수로 주어집니다. 좌표 dot이 사분면 중 어디에 속하는지 1, 2, 3, 4 중 하나를 return 하도록 solution 함수를 완성해주세요.

제한사항
dot의 길이 = 2
dot[0]은 x좌표를, dot[1]은 y좌표를 나타냅니다
-500 ≤ dot의 원소 ≤ 500
dot의 원소는 0이 아닙니다.
입출력 예
dot	result
[2, 4]	1
[-7, 9]	2
입출력 예 설명
입출력 예 #1

dot이 [2, 4]로 x 좌표와 y 좌표 모두 양수이므로 제 1 사분면에 속합니다. 따라서 1을 return 합니다.
입출력 예 #2

dot이 [-7, 9]로 x 좌표가 음수, y 좌표가 양수이므로 제 2 사분면에 속합니다. 따라서 2를 return 합니다.
* */
public class GetPos {

    @Test
    @DisplayName(value = "")
    public void test() throws Exception {
        //given
        int[] array1=new int[]{2, 4};
        int[] array2=new int[]{-7,9};
        int[] array3=new int[]{-7,-9};
        int[] array4=new int[]{7,-9};

        //when
        //then
        assertEquals(1,solution(array1));
        assertEquals(2,solution(array2));
        assertEquals(3,solution(array3));
        assertEquals(4,solution(array4));

    }

    public int solution(int[] dot) throws Exception {
        int x = dot[0];
        int y = dot[1];
        if(x*y==0) throw new Exception("0은 원소로 안들어와야 함.");
        int answer = 0;
        if(x>0){//1,4분면
            if(y>0){
                answer=1;
            }else{
                answer=4;
            }
        }else{//2,3분면
            if(y<0){
                answer=3;
            }else{
                answer=2;
            }
        }
        return answer;
    }

}
