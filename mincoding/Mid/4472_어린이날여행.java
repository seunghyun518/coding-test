/*
 * [민코딩 Mid] 어린이날 여행
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/4472
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 갈 수 있는 여행지를 전부 순회할 큐(현재 위치, 사용한 기름 통)
        Queue<int[]> q = new LinkedList<>();

        // 여행지 후보 모음
        ArrayList<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 여행지에 도착했었는지 저장(최단 거리를 보장하기 위해)
        boolean[] visited = new boolean[n + 1];

        // 도로 정보를 저장할 자료구조
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }

        // 단방향 도로 자료구조에 저장
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph[num1].add(num2);
        }

        // 출발점
        q.offer(new int[] {p, 0});
        visited[p] = true;

        // 갈 수 있는 모든 여행지 순회
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[1] == k){
                answer.add(now[0]);
                continue;
            }

            for(int i: graph[now[0]]){
                if(!visited[i]){
                    q.offer(new int[] {i, now[1] + 1});
                    visited[i] = true;
                }
            }
        }

        answer.sort(null);

        // 정답 출력
        if(answer.isEmpty()){
            System.out.println("-1");
        }
        else{
            for(int i: answer){
                System.out.println(i);
            }
        }

        return;
    }
}