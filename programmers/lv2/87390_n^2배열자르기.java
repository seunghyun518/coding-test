/*
 * [프로그래머스 Lv.2] n^2 배열 자르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */

// 아이디어: n이 10 ^ 7까지 올 수 있음
// -> n * n배열을 만들면 메모리 초과
// 배열을 거치지 않고 수학적으로 계산해서 answer에 넣는다

import java.util.*;

class Solution {
    public long[] solution(int n, long left, long right) {

        // answer 배열 선언(right - left = 최대 10 ^ 5이므로 int)
        long[] answer = new long[(int) (right - left + 1)];

        // answer 만들기
        for(int i = 0 ; i < right - left + 1; i++){

            // 값 채우기(행, 열 값에 따라 더 큰 값 넣기)
            if(((left + i) % n) + 1 > ((left + i) / n) + 1){
                answer[i] = ((left + i) % n) + 1;
            }
            else{
                answer[i] = ((left + i) / n) + 1;
            }
        }
        return answer;
    }
}