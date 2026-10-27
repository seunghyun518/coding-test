/*
 * [프로그래머스 Lv.2] N개의 최소공배수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953?language=java
 */

// arr의 최댓값의 배수만 검사한다
class Solution {
    public int solution(int[] arr) {

        // max = int[] arr의 최댓값, count = 배수
        int answer = 0, max = 0, count = 0;
        boolean isAnswer = true;

        // 최댓값 구하기
        for(int i : arr){
            max = Math.max(max, i);
        }

        // 찾을 때까지 반복
        while(true){

            // 초기화
            count += 1;
            isAnswer = true;

            // (max * count)가 공배수가 되는지 검사
            for(int i : arr){
                if((max * count) % i != 0){
                    isAnswer = false;
                    break;
                }
            }

            // 공배수라면 바로 정답 제출(앞에서부터 보기 때문에 최소)
            if(isAnswer){
                return max * count;
            }
        }
    }
}