/*
 * [프로그래머스 Lv.2] 연속 부분 수열 합의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        // 부분 수열의 합을 저장할 hm(중복 제거, set사용가능)
        HashMap<Integer, Integer> hm = new HashMap<>();

        // 0에서 부터 모든 원소에 대해 반복
        for(int i = 0; i < elements.length; i++){
            int num = 0;

            // j까지 더해감
            for(int j = 0; j < elements.length; j++){
                num += elements[(i + j) % elements.length];

                // hm에 저장 value는 사용x
                hm.put(num, 1);
            }
        }

        return hm.size();
    }
}