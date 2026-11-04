/*
 * [프로그래머스 Lv.2] 뉴스 클러스터링
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int num = 0, den = 0;
        double answer;

        // 대소문자 구분 없으므로 둘 다 대문자로 변경
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 해시맵으로 각 String에서 나온 횟수까지 저장
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();

        // 해시맵 채우기
        for(int i = 0; i < str1.length() - 1; i++){
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            if(ch1 <= 'Z' && ch1 >= 'A' && ch2 <= 'Z' && ch2 >= 'A'){
                String temp = "" + ch1 + ch2;
                int count = hm1.getOrDefault(temp, 0);
                hm1.put(temp, count + 1);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++){
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            if(ch1 <= 'Z' && ch1 >= 'A' && ch2 <= 'Z' && ch2 >= 'A'){
                String temp = "" + ch1 + ch2;
                int count = hm2.getOrDefault(temp, 0);
                hm2.put(temp, count + 1);
            }
        }

        // hm1 순회
        for(String str : hm1.keySet()){
            int count1 = hm1.get(str);
            int count2 = hm2.getOrDefault(str, 0);

            // 만약 hm1에만 있고 hm2에는 없다면 분모에 추가
            if(count2 == 0){
                den += count1;
            }

            // 만약 hm2에도 있다면, 교집합(min)은 분자로, 합집합(max)는 분모로
            else{
                num += Math.min(count1, count2);
                den += Math.max(count1, count2);
            }
        }

        // hm2 순회(hm1과 hm2 모두에 있는 것은 이미 hm1 순회에서 처리했으므로 건너뜀)
        for(String str : hm2.keySet()){
            int count1 = hm1.getOrDefault(str, 0);
            int count2 = hm2.get(str);

            // hm2에만 있다면 분모에 추가
            if(count1 == 0){
                den += count2;
            }
        }

        // 정답 만들기
        if(den == 0){
            return 65536;
        }
        else{
            answer = (double) num / den;
        }

        return (int) (answer * 65536);
    }
}