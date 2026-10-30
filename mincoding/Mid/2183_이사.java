/*
 * [민코딩 Mid] 이사
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/2183
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        boolean[] visited = new boolean[n + 1];

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {r, 0});
        visited[r] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[1] <= k){
                answer++;
            }

            for(int i : graph[now[0]]){
                if(!visited[i]){
                    q.add(new int[] {i, now[1] + 1});
                    visited[i] = true;
                }
            }
        }

        System.out.println(answer);
    }
}