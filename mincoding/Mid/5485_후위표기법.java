/*
 * [민코딩 Mid] 후위표기법
 * https://pro.mincoding.co.kr/problem-step/30/level/201/detail/5485
 */

// 숫자가 들어오면 스택(지금은 덱)에 저장
// 기호가 들어오면 LIFO로 꺼내서 두 숫자를 연산

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();

        String str = br.readLine();

        // 입력 문자열 하나씩 순회
        for(int i = 0; i < str.length(); i++){
            char now = str.charAt(i);

            // 숫자가 들어오면 스택(덱)에 저장
            if(now >= '0' && now <= '9'){
                dq.addLast(now -'0');
            }

            // 연산자가 들어오면 마지막 두 숫자를 연산
            else if(now == '+'){
                int num1 = dq.removeLast();
                int num2 = dq.removeLast();
                dq.addLast(num1 + num2);
            }
            else{
                int num1 = dq.removeLast();
                int num2 = dq.removeLast();
                dq.addLast(num2 - num1);
            }
        }

        System.out.println(dq.remove());
    }
}