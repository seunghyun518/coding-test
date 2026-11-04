/*
 * [민코딩 Low] 아이스크림 아저씨
 * https://pro.mincoding.co.kr/problem-step/7/level/126/detail/12546
 */

// 아이스크림 아저씨가 팔 수 있는 최소 개수 -> 최악의 상황
// greedy하게 wi가 큰 순서대로 줄을 섰을 때, 몇 명이 사먹냐

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        // Arrays.sort(배열, 비교자)형태는 int[]는 불가능(String[], Integer[]만 가능)
        // 그래서 int[]를 내림차순으로 정렬하려면 오름차순으로 정렬 -> for문으로 뒤집기
        Arrays.sort(arr);

        int answer = 0;
        int wait = 0;

        // wi가 큰 순서대로 검사해야하므로 뒤에서부터(or 내림차순 -> 앞에서부터)
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] >= wait){
                answer++;
                wait++;
            }
        }

        System.out.println(answer);
    }
}