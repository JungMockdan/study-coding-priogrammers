package study.coding.programmers.level0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 최빈값 구하기 알고리즘
 * 포인트 숫자배열에 음수를 포함한다. 전체배열을 양수로 바꾼다. 방정식처럼... 1000 을 더한 값으로 빈도를 측정한다음
 * 나온 최빈값에서 -1000을 하면 된다.
 * 그러나 나는 무식하게 풀어버렸넹.
 * */
/**
    #최빈값 구하기
    ## 문제 설명
    최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

    ## 제한사항
    0 < array의 길이 < 100
    -1000 < array의 원소 < 1000
    ### 입출력 예
    array	result
    [1, 2, 3, 3, 3, 4]	3
    [1, 1, 2, 2]	-1
    [1]	1
    ### 입출력 예 설명
    ### 입출력 예 #1

    [1, 2, 3, 3, 3, 4]에서 1은 1개 2는 1개 3은 3개 4는 1개로 최빈값은 3입니다.
    ### 입출력 예 #2

    [1, 1, 2, 2]에서 1은 2개 2는 2개로 최빈값이 1, 2입니다. 최빈값이 여러 개이므로 -1을 return 합니다.
    ### 입출력 예 #3

    [1]에는 1만 있으므로 최빈값은 1입니다.
* */
public class ModeTest {

    private int[] array1;
    private int[] array2;
    private int[] array3;
    private int[] array4;
    private int[] array5;

    @BeforeEach
    void setDefault(){
        this.array1 = new int[]{1, 2, 3, 3, 3, 4};
        this.array2 = new int[]{1,1,2,2};
        this.array3 = new int[]{1};
        this.array4 = new int[]{1, 2, 3, 3, 3, 4, 99, 99, 99, 99, 99, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13};
        this.array5 = new int[]{1, 2, 3, 3, 3, 4, 99, 99, 99, -99, -99, -13, -13, -13, -13, -13, -13, 13, 13, 13, 13, 13};
    }

    @Test
    void test(){
        Integer mode1 = getMode(array1);
        Integer mode2 = getMode(array2);
        Integer mode3 = getMode(array3);
        Integer mode4 = getMode(array4);
        Integer mode5 = getMode(array5);
        assertEquals(3,mode1);
        assertEquals(-1,mode2);
        assertEquals(1,mode3);
        assertEquals(13,mode4);
        assertEquals(-13,mode5);
    }
    public Integer getMode(int[] array){
        Integer mode=0;
        Arrays.sort(array);
        int minNum = Arrays.stream(array).min().getAsInt();
        int[] positive=null;
        int[] negative=null;
        if(minNum<0){
            int posIdx = 0;//배열을 자를 기준이 되는 index;
            for (int i=0;i<array.length;i++) {
                if(array[i]>=0){
                    posIdx = i;
                    break;
                }
            }
            if(posIdx>=0){
                negative = Arrays.copyOfRange(array, 0, posIdx);
                positive = Arrays.copyOfRange(array, posIdx, array.length);
            }else{
                negative = array;
            }
        }else{
            positive =array;
        }
        int negativeCount=0;
        int positiveCount=0;
        Map<String, Integer> negativeMode=null;
        if(negative!=null)  {
            negativeMode = calcAbsMode(negative, "-");
            negativeCount = negativeMode.get("count");
        }
        Map<String, Integer> positiveMode=null;
        if(positive!=null)  {
            positiveMode = calcAbsMode(positive, "+");
            positiveCount = positiveMode.get("count");
        }
        if(negative!=null&&positive!=null){
            int diffCount = negativeCount - positiveCount;
            if(diffCount ==0){
                mode=-1;
            }else{
                if(diffCount>0){ //최빈값은 음수
                    mode = negativeMode.get("mode");
                }else{ //최빈값은 양수
                    mode = positiveMode.get("mode");
                }
            }
        }else{
            if(negative!=null)  {
                mode = negativeMode.get("mode");
            }
            if(positive!=null)  {
                mode = positiveMode.get("mode");
            }
        }

        return mode==null?-1:mode;
    }


    public Map<String,Integer> calcAbsMode(int[] array, String sign) {
        Map<String,Integer> result = new HashMap<>();
        if(array.length==1) {
            result.put("mode",array[0]);//최빈값
            result.put("count",1);
            return result;
        }

        /** index 별로 빈도를 저장함.*/
        int maxNum;
        if(sign.equals("+")){
            maxNum = Arrays.stream(array).max().getAsInt();// 양수 빈도 배열 사이즈는 가장 큰 숫자로 함.
        }else{
            maxNum = Arrays.stream(array).min().getAsInt();// 음수 빈도 배열 사이즈는 가장 작은 숫자로 함.
        }
        int[] newArr = new int[Math.abs(maxNum) + 1];//빈도배열

        for(int i = 0 ; i< array.length ; i++){
            newArr[Math.abs(array[i])]++;
        }
        int offenMaxCount = Arrays.stream(newArr).max().getAsInt();;//가장 많은 빈도수

        int maxOftenNumCount =0;
        Integer mode=null;// 최빈값
        for (int i = 0; i < newArr.length; i++)
        {
            if (newArr[i] == offenMaxCount) {
                maxOftenNumCount++;
                mode=i;
            }
        }

        if(maxOftenNumCount>1) {
            result.put("mode",null);//최빈값
            result.put("count",offenMaxCount);
            return result;//==> -1
        }else{
            if(sign.equals("-")) mode=mode*-1;
            System.out.println("MODE : " + mode + " COUNT : " + offenMaxCount);
            result.put("mode",mode);//최빈값
            result.put("count",offenMaxCount);
            return result;
        }
    }



    @Test
    @DisplayName(value = "가장 짧은 답")
    public void shortAnswer() {
        Integer mode1 = solution(array1);
        assertEquals(3,mode1);

        Integer mode2 = solution(array2);
        assertEquals(-1,mode2);
    }
    public int solution(int[] array) {

        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(Arrays.stream(array).boxed().collect(Collectors.groupingBy(o -> o)).entrySet()).stream().sorted((t0, t1) -> Integer.compare(t1.getValue().size(), t0.getValue().size())).collect(Collectors.toList());
        return list.size() > 1 && list.get(0).getValue().size() - list.get(1).getValue().size() == 0 ? -1 : list.get(0).getKey();
    }

    public int solution2(int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : array) {
            Integer o = i;
            map.computeIfAbsent(o, k -> new ArrayList<>()).add(o);
        }


        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> integerListEntry : new ArrayList<>(map.entrySet())) {
            list.add(integerListEntry);
        }
        list.sort((t0, t1) -> Integer.compare(t1.getValue().size(), t0.getValue().size()));
        int countDiff = list.get(0).getValue().size() - list.get(1).getValue().size();//최빈값이 여러개인지 확인하기 위해.
        return list.size() > 1 && countDiff == 0 ? -1 : list.get(0).getKey();
    }

    public int solutionMyBest(int[] array) {
        int[] cnt = new int[1999];

        for (int arr : array) {
            cnt[arr + 999]++;
        }

        int maxCnt = -1;
        int maxIdx = -1;

        for (int i = 0; i < 1999; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < 1999; i++) {
            if (cnt[i] == maxCnt && i != maxIdx) {
                return -1;
            }
        }

        return maxIdx - 999;
    }
}
