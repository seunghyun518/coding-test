/*
 * [프로그래머스 Lv.2] 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */

// 가장 큰 자리의 수를 비교해서 더 큰 수를 선택한다
// 가장 큰 자리의 수가 같다면 "" + a + b 와 "" + b + a중 더 큰 수를 선택한다
// -> 이렇게 하면 가장 큰 자리의 수를 비교할 필요도 없음
// numbers를 순회해서 다음 올 수를 선택, 남은 numbers 순회 -> 이걸 반복하면 n = 100,000이라 시간초과
// numbers를 순회하며 priority queue에 넣는다

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        // "" + a + b 와 "" + b + a를 비교하는 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            return ("" + b + a).compareTo("" + a + b);
        });

        // numbers를 순회하며 pq에 넣기
        for(int i = 0; i < numbers.length; i++){
            pq.offer(numbers[i]);
        }

        // 하니씩 빼기(우선순위가 정답을 선택해줌)
        for(int i = 0; i < numbers.length; i++){
            int a = pq.poll();
            answer += a;
        }

        // 만약 "000"이면 "0"으로 제출
        if(answer.charAt(0) == '0'){
            return "0";
        }

        return answer;
    }
}