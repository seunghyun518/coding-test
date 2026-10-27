/*
 * [프로그래머스 Lv.2] 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1, idx = 0, max = 0;

        // 최댓값을 구할지 판단하는 flag
        boolean isMax = true;

        // 문제대로 작동할 큐
        Queue<int[]> q = new LinkedList<>();

        // 큐에 대기 프로세스들 넣기
        for(int i : priorities){
            q.offer(new int[] {idx++, i});
        }

        // 큐가 빌 때까지(모든 프로세스 실행)
        while(!q.isEmpty()){

            // 최댓값 구하기(가장 먼저 실행될 프로세스 찾기)
            if(isMax){
                max = 0;
                for(int[] i : q){
                    max = Math.max(max, i[1]);
                }
                isMax = false;
            }

            // 큐에서 나온 프로세스 검사
            int[] now = q.poll();
            if(now[1] != max){
                q.offer(now);
            }
            else if(now[0] == location){
                return answer;
            }
            else{
                isMax = true;
                answer++;
            }
        }

        return answer;
    }
}