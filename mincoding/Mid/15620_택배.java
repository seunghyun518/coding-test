/*
 * [민코딩 Mid] 택배
 * https://pro.mincoding.co.kr/problem-step/7/level/126/detail/15620
 */

// 받는 마을번호가 작은 순서대로 greedy하게 싣는다
// 실려 있는 박스의 양을 구간별로 기록한다

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken()); // 마을의 개수
        int c = Integer.parseInt(st.nextToken()); // 트럭의 용량
        int m = Integer.parseInt(br.readLine()); // 택배 박스의 종류

        // 실어져 있는 박스의 양(ex: 1 -> 2, 2 -> 3, 3 -> 4와 같이 구간별로 배열로 표시)
        int[] count = new int[n + 1];

        // 받는 마을번호순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        // pq에 넣기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {num1, num2, num3});
        }

        // pq에 있는 모든 박스 검사
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int load = now[2];

            // 실을 수 있는 최대 박스의 수 구하기
            for(int i = now[0]; i < now[1]; i++){
                load = Math.min(load, c - count[i]);
            }

            // 짐 싣기
            for(int i = now[0]; i < now[1]; i++){
                count[i] += load;
            }

            // 실은 짐은 모두 배달 완료(answer에 더하기)
            answer += load;
        }

        System.out.println(answer);
    }
}