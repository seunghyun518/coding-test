/*
 * [프로그래머스 Lv.2] 뒤에 있는 큰 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */

// 그냥 2중 for문으로 검사하면 입력값이 최대 1,000,000이므로 시간초과
// 시간초과가 되는 이유는 최악의 경우(내림차순으로 정렬되어 있을 경우 전부 다 돌아야함)
// 반복문으로 한 번만 순회해서 어떻게 풀 수 있을까
// stack을 이용해 아직 뒤에 있는 큰 수를 찾지 못한 친구들을 index와 함께 담아둠
// for문으로 한 번 돌면서 stack에 있는 애들만 검사하면 됨

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        // 큰 수를 찾지 못했을 때 -1로 초기화
        Arrays.fill(answer, -1);

        Stack<int[]> s = new Stack<>();

        for(int i = 0 ; i <numbers.length; i++){

            // 만약 스택에 있는 마지막 수가 이번에 들어오는 수 보다 작다면(이번에 들어오는 수가 큰 수가 됨)
            while(!s.isEmpty() && s.peek()[0] < numbers[i]){

                // 스택에서 빼버리고 이번에 들어온 수를 큰 수로 기록
                int[] arr = s.pop();
                answer[arr[1]] = numbers[i];
            }

            // 아니면 그냥 스택에 추가하고(아직 큰 수를 찾지 못한 모임) 다음 숫자로
            s.push(new int[] {numbers[i], i});
        }

        return answer;
    }
}