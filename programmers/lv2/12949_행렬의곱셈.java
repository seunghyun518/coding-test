/*
 * [프로그래머스 Lv.2] 행렬의 곱셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */

// arr1의 열의 수 = arr2의 행의 수
// 결과물 = [arr1의 행의 수][arr2의 열의 수]

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        // arr1의 행
        for(int i = 0; i < arr1.length; i++){

            // arr2의 열 만큼 순회하며 answer를 채운다
            for(int j = 0; j < arr2[0].length; j++){

                // arr1의 열의 수(= arr2의 행의 수) 만큼 순회하며 값을 생성
                for(int k = 0; k < arr1[0].length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}