/*
 * [프로그래머스 Lv.2] 예상 대진표
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */

// 아이디어: 각 참가자가 다음 경기에 몇번 참가자가 되는가 (n + 1) / 2
// a와 b가 경기를 한다는건 각 참가 번호가 어떻게 될 때인가
// (a + 1 == b) && (a % 2 != 0)

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        // 정렬
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        // a와 b가 이번에 경기를 하는가
        while((min % 2 == 0) || (min + 1 != max)){

            // a와 b가 이번에 경기가 아니라면 다음 라운드로 서로 진출했다 처리
            min = (min + 1) / 2;
            max = (max + 1) / 2;
            answer++;
        }

        return answer;
    }
}