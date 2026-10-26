/*
 * [프로그래머스 Lv.2] 귤 고르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */

// 오름차순 정렬
// Collections.sort(list);
// list.sort(null);
// list.sort((a, b) -> a - b);

// 내림차순 정렬
// Collections.sort(list, Collections.reverseOrder());
// list.sort((a, b) -> b - a);


import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 귤의 크기 종류를 저장할 해시맵(크기, 개수)
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i : tangerine){
            int count = hm.getOrDefault(i, 0);
            hm.put(i, count + 1);
        }

        // 귤의 개수를 내림차순으로 정렬(개수가 많은 것부터 그리디로)
        List<Integer> li = new ArrayList<>(hm.values());
        li.sort((a, b) -> b - a);

        for(int i : li){
            k -= i;
            answer++;
            if(k <= 0){
                return answer;
            }
        }

        return answer;
    }
}