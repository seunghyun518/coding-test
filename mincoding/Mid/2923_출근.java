/*
 * [민코딩 Mid] 출근
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/2923
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 무한루프에 빠지지 않기 위해 방문했던 곳 또 방문하지 않도록 체크
        boolean[] visited = new boolean[n + 1];

        // 갈 수 있는 곳을 모아두는 큐(위치, 환승 횟수)
        Queue<int[]> q = new LinkedList<>();

        // 도로 상황을 저장할 ArrayList<Integer>를 담는 배열
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        // ArrayList 생성(초기화)
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }

        // 도로 상황 저장
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        // 화재가 발생한 곳은 이미 방문 처리(못간다)
        int t = Integer.parseInt(br.readLine());
        visited[t] = true;

        // 시작점 넣기
        q.offer(new int[] {1, 0});

        // 갈 수 있는 모든 곳 방문
        while(!q.isEmpty()){
            int[] now = q.poll();

            // 만약 목적지라면 정답 제출
            if(now[0] == n){
                System.out.println(now[1]);
                return;
            }

            // 아니라면 갈 수 있는 곳 큐에 넣고 다음 위치로
            for(int i : graph[now[0]]){
                if(!visited[i]){
                    q.offer(new int[] {i, now[1] + 1});
                    visited[i] = true;
                }
            }
        }

        // 갈 수 있는 곳을 전부 돌아도 목적지를 못찾았다면 -1출력
        System.out.println("-1");
        return;
    }
}