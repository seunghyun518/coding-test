/*
 * [프로그래머스 Lv.2] 주식가격
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */

// 스택에 담으면서 이번에 들어오는 주식가격이 스택에 있는 가격보다 작다면(가격이 떨어짐) 인덱스의 차를 정답에 기록

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<int[]> s = new Stack<>();

        // 주식가격을 순회
        for (int i = 0; i < prices.length; i++) {

            // 만약 이번에 들어온 주식가격이 스택에 기록된 가격보다 낮다면(가격이 떨어졌다)
            while (!s.isEmpty() && s.peek()[0] > prices[i]) {

                // 가격이 떨어지기까지 몇 초가 걸렸는지 기록(인덱스를 이용)
                int[] arr = s.pop();
                answer[arr[1]] = i - arr[1];
            }

            s.push(new int[]{prices[i], i});
        }

        // 아직 스택에 남아있는 정보들 = 아직 가격이 안떨어짐 -> 끝나는 시점까지 몇 초 걸렸는지 기록
        while (!s.isEmpty()) {
            int[] arr = s.pop();
            answer[arr[1]] = prices.length - arr[1] - 1;
        }

        return answer;
    }
}