/*
 * [프로그래머스 Lv.2] 모음 사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */

// 맨 처음 떠오른 풀이 수학적으로 각 자리수에 "A", "E", "I", "O", "U"에 맞춰서 answer에 더해가자
// -> 가능은 하나 헷갈림
// dfs 풀이 A -> AA -> AAA -> AAAA -> AAAAA -> 깊게 들어가고 다 들어가면 빠져나감(다음 알파벳으로) -> AAAAE
// 이 흐름이 문제에서 말하는 순회(단어사전)과 같음, 하나씩 들어가보며 word와 같으면 빠져나가기

class Solution {

    // dfs 함수에서 증가시킬 answer, 비교할 정답 문자열 str, 빠져나올 flag
    static int answer = 0;
    static String str;
    static boolean isAnswer = false;

    public int solution(String word) {
        str = word;
        // dfs 시작
        dfs("");

        return answer;
    }

    // 정답이라면 플래그를 변화해서 빠져나감
    // 아니라면 A -> E -> I -> O -> U순으로 순회하며 깊어짐
    // 문자열 길이가 6이상이면 무시
    static void dfs(String s){
        if(s.equals(str)){
            isAnswer = true;
        }

        else if(!isAnswer && s.length() < 6){
            answer++;
            dfs(s + "A");
            dfs(s + "E");
            dfs(s + "I");
            dfs(s + "O");
            dfs(s + "U");
        }
    }
}
