/*
 * [프로그래머스 Lv.2] 롤케이크 자르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */

// n값이 최대 1,000,000이므로 for(n){for(n)}은 시간초과
// 왼쪽에서부터 토핑의 개수, 오른쪽에서부터 토핑의 개수를 구해서 비교

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;

        int[] left = new int[n];   // left[i]  : 0 ~ i 번까지의 가짓수
        int[] right = new int[n];  // right[i] : i ~ n-1 번까지의 가짓수
        boolean[] leftVisited = new boolean[10001];
        boolean[] rightVisited = new boolean[10001];

        left[0] = 1;
        leftVisited[topping[0]] = true;
        right[n - 1] = 1;
        rightVisited[topping[n - 1]] = true;

        for(int i = 1; i < n; i++){
            if(!leftVisited[topping[i]]){
                left[i] = left[i - 1] + 1;
                leftVisited[topping[i]] = true;
            }
            else{
                left[i] = left[i - 1];
            }

            int j = n - 1 - i;
            if(!rightVisited[topping[j]]){
                right[j] = right[j + 1] + 1;
                rightVisited[topping[j]] = true;
            }
            else{
                right[j] = right[j + 1];
            }
        }

        for(int i = 0; i < n - 1; i++){
            if(left[i] == right[i + 1]){
                answer += 1;
            }
        }

        return answer;
    }
}