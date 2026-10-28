/*
 * [프로그래머스 Lv.2] 괄호 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */

// 아이디어: 회전 -> 검사 -> 회전 -> 검사

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] c = new char[s.length()];

        // String은 변경이 어려우므로 char[]로 변경
        for(int i = 0 ; i < s.length(); i++){
            c[i] = s.charAt(i);
        }

        // 회전
        for(int i = 0; i < c.length; i++){
            char temp = c[0];
            for(int j = 0; j < c.length - 1; j++){
                c[j] = c[j + 1];
            }
            c[c.length - 1] = temp;

            // 검사(true면 answer + 1)
            if(check(c)){
                answer++;
            }
        }

        return answer;
    }

    // 검사하는 함수
    public boolean check(char[] ch){
        // 스택에 넣어가며 검사
        Stack<Character> s = new Stack<>();

        // 모든 괄호를 순회
        for(char c : ch){

            // 여는 괄호라면 스택에 넣기
            if(c == '(' || c == '{' || c == '['){
                s.push(c);
            }

            // 닫는 괄호라면 이전 값(.peek())가 한 쌍인지 확인
            // 아니라면 false 반환, 맞다면 .pop()
            else if(c == ')'){
                if(s.isEmpty() || s.peek() != '('){
                    return false;
                }
                else{
                    s.pop();
                }
            }

            else if(c == '}'){
                if(s.isEmpty() || s.peek() != '{'){
                    return false;
                }
                else{
                    s.pop();
                }
            }
            else{
                if(s.isEmpty() || s.peek() != '['){
                    return false;
                }
                else{
                    s.pop();
                }
            }
        }

        // 마지막에 스택이 비었다면(모두 짝을 찾음) true 반환
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}