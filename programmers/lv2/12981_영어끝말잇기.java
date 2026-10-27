/*
 * [프로그래머스 Lv.2] 영어 끝말잇기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 단어의 등장횟수를 세는 hm
        HashMap<String, Integer> hm = new HashMap<>();

        // 첫 단어 hm에 넣기
        hm.put(words[0], 1);

        // 모든 단어 돌기
        for(int i = 1; i < words.length; i++){

            // 이번 단어가 지금까지 나왔는지 체크
            int count = hm.getOrDefault(words[i], 0);

            // 지금까지 나온적이 있으면 정답 반환
            if(count != 0){
                return new int[] {(i % n) + 1, (i / n) + 1};
            }

            // 지금까지 나오진 않았지만 끝말잇기 규칙에 맞지 않으면 정답 반환
            if(words[i].charAt(0) != words[i - 1].charAt(words[i-1].length() - 1)){
                return new int[] {(i % n) + 1, (i / n) + 1};
            }

            // 둘 다 아니라면 hm에 추가하고 다음 단어로
            hm.put(words[i], count + 1);
        }

        // 끝까지 규칙을 어기지 않았다면 초기 answer값 제출
        return answer;
    }
}