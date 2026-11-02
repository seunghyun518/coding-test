/*
 * [프로그래머스 Lv.2] 방문 길이
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */

// 가봤던 길임을 어떻게 표시할 것인가(HashMap<String, Integer>)
// 양방향 길이므로 반대 방향도 갔다고 처리해줘야한다

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        // 가봤던 길을 기억할 visited
        HashMap<String, Integer> hm = new HashMap<>();

        // 시작점
        int row = 5, col = 5;
        int nrow = 5, ncol = 5;

        // 모든 이동 방향 순회
        for(int i = 0; i < dirs.length(); i++){
            char move = dirs.charAt(i);
            row = nrow;
            col = ncol;

            // 맵을 벗어나지 않으면 n(ext)dir로 갔다 표시
            if(move == 'U' && row - 1 >= 0){
                nrow -= 1;
            }

            else if(move == 'D' && row + 1 <= 10){
                nrow += 1;
            }

            else if(move == 'R' && col + 1 <= 10){
                ncol += 1;
            }

            else if(move == 'L' && col - 1 >= 0){
                ncol -= 1;
            }

            // a점에서 b점으로 이동한 횟수가 0이면 answer + 1, 양방향 가봤다 처리(visited(hashmap))
            int count = hm.getOrDefault(row + "," + col + "," + nrow + "," + ncol, 0);

            if(count == 0 && (row != nrow || col != ncol)){
                hm.put(row + "," + col + "," + nrow + "," + ncol, 1);
                hm.put(nrow + "," + ncol + "," + row + "," + col, 1);
                answer += 1;
            }
        }

        return answer;
    }
}