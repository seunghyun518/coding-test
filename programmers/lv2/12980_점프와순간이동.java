/*
 * [프로그래머스 Lv.2] 점프와 순간 이동
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

// 핵심 아이디어, n이 짝수이면 마지막 행동은 2배하기다(cost추가 없음)
// n이 홀수이면 마지막 행동은 +1하기이다(cost +1)
// 이걸 반복한다.

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // n이 0이 될때까지(목표에 도달할때까지 반복, n -> 0으로 가는 거꾸로 생각하기)
        while(n != 0){

            // n이 짝수이면 마지막 행동은 2배하기이다(cost추가 없음)
            if(n % 2 == 0){

                // n갱신
                n /= 2;
            }

            // n이 홀수이면 마지막 행동은 +1하기이다(cost + 1)
            else{

                // n갱신, answer + 1
                n /= 2;
                ans++;
            }
        }

        return ans;
    }
}

// 맨 처음 생각난 다익스트라 풀이
//
//import java.util.*;
//
//public class Solution{
//    public int solution(int n){
//        int ans = 0;
//
//        // cost가 더 적은걸 먼저 꺼낸다(목표가 최소 cost이기 때문에)
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//            return a[1] - b[1];
//        });
//
//        // 1 추가로 시작
//        pq.offer(new int[] {1, 1});
//
//        while(!pq.isEmpty()){
//            int[] now = pq.poll();
//            int location = now[0], cost = now[1];
//
//            // 만약 n에 도착했다면 cost 반환
//            if(location == n){
//                return cost;
//            }
//
//            // n을 넘어갔다면 더 이상 가지 않음
//            else if(location > n){
//                continue;
//            }
//
//            // 두 가지 선택지 큐에 넣기(1 더하기, 2 곱하기)
//            pq.offer(new int[] {location + 1, cost + 1});
//            pq.offer(new int[] {location * 2, cost});
//        }
//    }
//}