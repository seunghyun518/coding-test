/*
 * [프로그래머스 Lv.2] 땅따먹기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */

// 완전 탐색(DFS) 시 n(행의 크기)가 100,000으로 시간 초과
// DP활용(각 행의 각 열로 끝나는 최대값을 저장하면서 감)
//

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];

        // 첫 번째 행 설정
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }

        // 모든 dp행을 채울거다
        for(int i = 1; i < land.length; i++){

            // dp의 각 열(최대 4)를 채울거다
            for(int j = 0; j < 4; j++){

                // 이전 최댓값
                int dpMax = 0;
                for(int k = 0; k < 4; k++){

                    // 이전 최댓값인데 같은 열은 제외
                    if(k != j && dpMax < dp[i - 1][k]){
                        dpMax = dp[i - 1][k];
                    }
                }

                // 이전 최댓값 + 이번 score
                dp[i][j] = dpMax + land[i][j];
            }
        }

        // dp의 맨 마지막 행(각 열로 끝나는 최댓값들) 중 최댓값을 정답으로 제출
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[land.length - 1][i]);
        }

        return answer;
    }
}