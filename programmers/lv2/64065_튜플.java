/*
 * [프로그래머스 Lv.2] 튜플
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */

// 파싱 -> 처리
// String -> String[] -> "{", "}" 제거 -> String[][] -> int []

import java.util.*;

class Solution {
    public int[] solution(String s) {

        // String -> String[]
        String[] str = s.split("\\},");

        // "{", "}" 제거
        for(int i = 0; i < str.length; i++){
            str[i] = str[i].replace("}", "");
            str[i] = str[i].replace("{", "");
        }

        // String[] -> String[][]
        String[][] arr = new String[str.length][];
        for(int i = 0; i < str.length; i++){
            arr[i] = str[i].split(",");
        }

        // 길이순으로 정렬
        Arrays.sort(arr, (a, b) -> {
            return a.length - b.length;
        });

        // 해시맵을 통해 나왔던 숫자인지 검사
        HashMap<String, Integer> hm = new HashMap<>();
        int[] answer = new int[str.length];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                int count = hm.getOrDefault(arr[i][j], 0);
                // 이전에 안나왔던 새로운 값이면 정답에 추가
                if(count == 0){
                    answer[i] = Integer.parseInt(arr[i][j]);
                }

                hm.put(arr[i][j], count + 1);
            }
        }

        return answer;
    }
}