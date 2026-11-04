/*
 * [민코딩 Low] 버블소트 Go!
 * https://pro.mincoding.co.kr/problem-step/7/level/126/detail/12547
 */

/* 문제대로 버블소트를 구현하면 시간초과
버블 정렬을 몇 바퀴 돌아야 정렬이 끝날까
큰 수는 한 바퀴에도 여러번 뒤로 간다(바로 정렬이 된다)
작은 수는 한 바퀴에 한 번만 앞으로 이동한다
-> 왼쪽으로 가장 많이 움직여아하는 수를 찾는다
기존 입력을 (수, 인덱스)로 저장 -> 정렬 후 인덱스와 입력시 인덱스 비교
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력받을 배열(인덱스도 저장해야 하므로 2차원 배열)
        int[][] arr = new int[n][2];

        // 입력 받기
        for(int i = 0; i < n; i++){
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }

        // 정렬
        Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0];
        });

        // 정렬 후 인덱스와 정렬 전 인덱스의 차이가 가장 큰 수 찾기
        int answer = 0;
        for(int i = 0; i < n; i++){
            int temp1 = arr[i][1] - i;
            answer = Math.max(temp1, answer);
        }

        // 버블 소트 완료 후 확인으로 한 번 더 Go!가 출력되므로 answer + 1을 제출
        System.out.println(answer + 1);
    }
}