/*
 * [프로그래머스 Lv.2] 연속 부분 수열 합의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */

// 택배 상자의 가능한 이동 경로
// 주 컨베이어벨트 -> 보조 컨베이어벨트
// 주 컨베이어벨트 -> 트럭
// 보조 컨베이어벨트 -> 트럭
// 컨베이어벨트는 스택과 같이 동작

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        // 주 컨베이어벨트
        Stack<Integer> s1 = new Stack<>();

        // 보조 컨베이어벨트
        Stack<Integer> s2 = new Stack<>();

        // 모든 택배상자 주 컨베이어벨트에 넣기
        for(int i = order.length; i >= 1; i--){
            s1.push(i);
        }

        // order 배열을 순회할 인덱스
        int idx = 0;

        // 목표 택배상자가 주 컨베이어벨트에서 or 보조 컨베이어벨트에서 꺼낼 수 있으면 실행
        while((!s1.isEmpty() && s1.peek() <= order[idx]) || (!s2.isEmpty() && s2.peek() == order[idx])){

            // 주 컨베이어벨트에서 꺼낼 수 있을 때
            if((!s1.isEmpty() && s1.peek() <= order[idx])){

                // 목표 택배 앞의 모든 상자를 보조 컨베이어 벨트로
                while(s1.peek() != order[idx]){
                    s2.push(s1.pop());
                }

                // 목표 택배 꺼냄
                s1.pop();
                idx++;
                answer++;
            }

            // 보조 컨베이어벨트에서 꺼낼 수 있을 때
            else if((!s2.isEmpty() && s2.peek() == order[idx])){

                // 택배 꺼내기
                s2.pop();
                idx++;
                answer++;
            }
        }

        return answer;
    }
}