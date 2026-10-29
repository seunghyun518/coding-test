/*
 * [프로그래머스 Lv.2] 캐시
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */

// List를 이용하여 실제 캐시 구현하기
// remove(n) -> n번째 삭제하기(캐시 사이즈를 넘어갈 때, remove(0))
// remove("asd") -> 캐시에 있을 때(hit), 삭제하고 맨 뒤로 추가(boolean값을 반환해주므로 contains를 할 필요 없음)
// add(str) -> 맨 뒤에 추가

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 실제 큐처럼 동작할 리스트
        List<String> list = new ArrayList<>();

        // 만약 캐시사이즈가 0이면 모든 입력이 miss
        if(cacheSize == 0){
            return 5 * cities.length;
        }

        // 입력값 순회
        for(int i = 0; i < cities.length; i++){

            // 만약 hit라면
            if(!list.isEmpty() && list.remove(cities[i].toUpperCase())){
                // 삭제하고(조건에서 이미 했음) 맨 뒤에 추가
                answer += 1;
                list.add(cities[i].toUpperCase());
            }

            // miss 중 cacheSize를 넘어간다면
            else if(list.size() == cacheSize){

                // 맨 앞 삭제하고 맨 뒤 추가
                answer += 5;
                list.remove(0);
                list.add(cities[i].toUpperCase());
            }

            // miss인데 캐시가 다 차지 않았을 때,
            else{

                // 삭제 없이 맨 뒤 추가
                answer += 5;
                list.add(cities[i].toUpperCase());
            }
        }

        return answer;
    }
}