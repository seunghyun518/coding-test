/*
 * [민코딩 Mid] 수학 놀이
 * https://pro.mincoding.co.kr/problem-step/7/level/126/detail/5603
 */

// 맨 끝에 1붙이기 -> 무조건 홀수
// 곱하기 2 -> 무조건 짝수
// b가 짝수라면 2로 나누기, b가 홀수라면 10으로 나누기

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // b가 a보다 클 때까지
        while(b > a){

            // b가 짝수라면 2로 나누기
            if(b % 2 == 0){
                b /= 2;
                answer++;
            }

            // b가 홀수라면 10으로 나누기
            else{
                b /= 10;
                answer++;
            }
        }

        // 만약 b가 a보다 작은데 a = b가 아니라면 a로 b를 만들 수 없음(-1)
        if(a != b){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
}