/*
 * [민코딩 High] 숫자 묶기
 * https://pro.mincoding.co.kr/problem-step/7/level/126/detail/16356
 */

// Greedy 알고리즘 양수 = 큰 수 끼리 묶기, 음수 = 작은 수 끼리 묶기
// PriorityQueue를 이용해 큰수 or 작은 수 꺼내기
// 양수 중 1이 나오면 묶지 않기
// 0이 있으면 음수 하나 지우기

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pPq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        PriorityQueue<Integer> nPq = new PriorityQueue<>();

        // 양수는 pPq로 음수는 nPq로 넣기
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            if(a > 0){
                pPq.offer(a);
            }

            else{
                nPq.offer(a);
            }
        }

        // 양수 꺼내면서 묶기
        while(pPq.size() >= 2){
            int num1 = pPq.poll();
            int num2 = pPq.poll();

            // 만약 1이 나오면 묶지 않고 더하기
            if(num1 == 1 || num2 == 1){
                answer += num1 + num2;
            }
            else{
                answer += num1 * num2;
            }
        }

        // 마지막에 1개가 남으면 묶을 수 없으므로 그냥 더하기
        if(!pPq.isEmpty()){
            answer += pPq.poll();
        }

        // 음수 꺼내면서 묶기
        while(nPq.size() >= 2){
            answer += nPq.poll() * nPq.poll();
        }

        // 마지막에 1개가 남으면 묶을 수 없으므로 그냥 더하기
        if(!nPq.isEmpty()){
            answer += nPq.poll();
        }

        System.out.println(answer);
    }
}