/*
 * [민코딩 Mid] 결혼 정보 회사
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/3448
 */

// bfs 풀이
// union find의 find만 구현하여 풀이 가능

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i : graph[now]){
                if(i == b){
                    System.out.println("YES");
                    return;
                }
                else if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println("NO");
    }
}