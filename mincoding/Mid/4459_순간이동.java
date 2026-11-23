/*
 * [민코딩 Mid] 순간 이동
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/4459
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[100001];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {n, 0});

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[0] == m){
                System.out.println(now[1]);
                return;
            }

            if(now[0] + 1 < 100001 && !visited[now[0] + 1]){
                q.offer(new int[] {now[0] + 1, now[1] + 1});
                visited[now[0] + 1] = true;
            }

            if(now[0] - 1 >= 0 && !visited[now[0] - 1]){
                q.offer(new int[] {now[0] - 1, now[1] + 1});
                visited[now[0] - 1] = true;
            }

            if(now[0] * 2 < 100001 && !visited[now[0] * 2]){
                q.offer(new int[] {now[0] * 2, now[1] + 1});
                visited[now[0] * 2] = true;
            }
        }
    }
}