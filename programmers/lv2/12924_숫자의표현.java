/*
 * [프로그래머스 Lv.2] 숫자의 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */

class Solution {
    public int solution(int n) {
        int answer = 0;

        // 1부터 n / 2까지 검사(그 이상은 연속되는 수를 더하면 무조건 n을 넘어감)
        for(int i = 1; i <= n / 2; i++){
            int count = 0;

            // 연속되는 수 더해보기
            for(int j = i; j <= n; j++){
                count += j;

                // 만약 n을 넘어가버리면 바로 종료
                if(count > n){
                    break;
                }

                // 정답을 찾으면 바로 종료
                else if(count == n){
                    answer++;
                    break;
                }
            }
        }

        // n 자기 자신인 경우 1가지 더해주기
        return answer + 1;
    }
}