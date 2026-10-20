/*
 * [프로그래머스 Lv.2] 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

// Stirng s = str.replace("x", ""); -> "x"를 빈문자열로 변경
// String s = Integer.toString(i, 2); -> i를 String으로 변경하는데 2진수로 변경

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[] {0, 0};

        while(!s.equals("1")){
            int before = s.length();

            s = s.replace("0", "");
            int after = s.length();

            s = Integer.toString(after, 2);

            answer[1] += before - after;
            answer[0]++;
        }

        return answer;
    }
}