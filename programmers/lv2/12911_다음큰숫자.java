/*
 * [프로그래머스 Lv.2] 다음 큰 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */

class Solution {
    public int solution(int n) {
        int answer = n;

        // n의 2진수 1의 갯수 구해두기(countN)
        String stringN = Integer.toString(n, 2);
        int countN = 0;

        for(int i = 0; i < stringN.length(); i++){
            if(stringN.charAt(i) == '1'){
                countN++;
            }
        }

        // n보다 큰 수 중 2진수의 1의 갯수가 같은 수 찾기
        while(true){

            // n보다 큰 수 = answer
            answer += 1;
            String stringAnswer = Integer.toString(answer, 2);

            // answer의 2진수 1의 갯수(count)
            int count = 0;

            for(int i = 0; i < stringAnswer.length(); i++){
                if(stringAnswer.charAt(i) == '1'){
                    count++;
                }
            }
            if(count == countN){

                // 찾으면 바로 반환하면서 종료
                return answer;
            }
        }
    }
}