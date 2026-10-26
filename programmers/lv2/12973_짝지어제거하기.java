/*
 * [프로그래머스 Lv.2] 짝지어 제거하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=java
 */

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> st = new Stack<>();

        // 모든 s를 스택에 넣으면서 검사
        for(int i = 0; i < s.length(); i++){

            // 스택이 비어있으면(st.peek()을 하지 않도록) 스택에 추가
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }

            // 만약 똑같은 문자가 연속으로 나온다면, 제거
            else if(st.peek() == s.charAt(i)){
                st.pop();
            }

            // 아니면 평범한 경우(추가)
            else{
                st.push(s.charAt(i));
            }
        }

        // 만약 전부 지웠다면 1을 반환하도록
        if(st.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}