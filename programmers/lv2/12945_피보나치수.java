/*
 * [프로그래머스 Lv.2] 피보나치 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */

// dp 풀이(배열에 이전 값을 저장해두고 다음 계산에 사용)
class Solution {
    public int solution(int n) {
        int answer = 0;

        // 배열 선언
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        // n까지(구해야하는 값) 배열 채우기
        for(int i = 2; i <= n; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }

        return arr[n];
    }
}